package net.minecraft.src;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EntityTrackerEntry
{
    public Entity myEntity;
    public int BlocksDistanceThreshold;

    /** check for sync when ticks % updateFrequency==0 */
    public int updateFrequency;
    public int lastScaledXPosition;
    public int lastScaledYPosition;
    public int lastScaledZPosition;
    public int lastYaw;
    public int lastPitch;
    public int lastHeadMotion;
    public double motionX;
    public double motionY;
    public double motionZ;
    public int ticks = 0;
    private double posX;
    private double posY;
    private double posZ;

    /** set to true on first sendLocationToClients */
    private boolean isDataInitialized = false;
    private boolean trackMotion;

    /**
     * every 400 ticks a  full teleport packet is sent, rather than just a "move me +x" command, so that position
     * remains fully synced.
     */
    private int ticksSinceLastForcedTeleport = 0;
    private Entity ridingEntity;
    public boolean field_73133_n = false;
    public Set field_73134_o = new HashSet();

    public EntityTrackerEntry(Entity par1Entity, int par2, int par3, boolean par4)
    {
        this.myEntity = par1Entity;
        this.BlocksDistanceThreshold = par2;
        this.updateFrequency = par3;
        this.trackMotion = par4;
        this.lastScaledXPosition = MathHelper.floor_double(par1Entity.posX * 32.0D);
        this.lastScaledYPosition = MathHelper.floor_double(par1Entity.posY * 32.0D);
        this.lastScaledZPosition = MathHelper.floor_double(par1Entity.posZ * 32.0D);
        this.lastYaw = MathHelper.floor_float(par1Entity.rotationYaw * 256.0F / 360.0F);
        this.lastPitch = MathHelper.floor_float(par1Entity.rotationPitch * 256.0F / 360.0F);
        this.lastHeadMotion = MathHelper.floor_float(par1Entity.func_70079_am() * 256.0F / 360.0F);
    }

    public boolean equals(Object par1Obj)
    {
        return par1Obj instanceof EntityTrackerEntry ? ((EntityTrackerEntry)par1Obj).myEntity.entityId == this.myEntity.entityId : false;
    }

    public int hashCode()
    {
        return this.myEntity.entityId;
    }

    /**
     * also sends velocity, rotation, and riding info.
     */
    public void sendLocationToAllClients(List par1List)
    {
        this.field_73133_n = false;

        if (!this.isDataInitialized || this.myEntity.getDistanceSq(this.posX, this.posY, this.posZ) > 16.0D)
        {
            this.posX = this.myEntity.posX;
            this.posY = this.myEntity.posY;
            this.posZ = this.myEntity.posZ;
            this.isDataInitialized = true;
            this.field_73133_n = true;
            this.sendEventsToPlayers(par1List);
        }

        if (this.ridingEntity != this.myEntity.ridingEntity)
        {
            this.ridingEntity = this.myEntity.ridingEntity;
            this.sendPacketToAllTrackingPlayers(new Packet39AttachEntity(this.myEntity, this.myEntity.ridingEntity));
        }

        if (this.myEntity.ridingEntity == null)
        {
            ++this.ticksSinceLastForcedTeleport;

            if (this.ticks++ % this.updateFrequency == 0 || this.myEntity.isAirBorne)
            {
                int var2 = this.myEntity.myEntitySize.multiplyBy32AndRound(this.myEntity.posX);
                int var3 = MathHelper.floor_double(this.myEntity.posY * 32.0D);
                int var4 = this.myEntity.myEntitySize.multiplyBy32AndRound(this.myEntity.posZ);
                int var5 = MathHelper.floor_float(this.myEntity.rotationYaw * 256.0F / 360.0F);
                int var6 = MathHelper.floor_float(this.myEntity.rotationPitch * 256.0F / 360.0F);
                int var7 = var2 - this.lastScaledXPosition;
                int var8 = var3 - this.lastScaledYPosition;
                int var9 = var4 - this.lastScaledZPosition;
                Object var10 = null;
                boolean var11 = Math.abs(var7) >= 4 || Math.abs(var8) >= 4 || Math.abs(var9) >= 4;
                boolean var12 = Math.abs(var5 - this.lastYaw) >= 4 || Math.abs(var6 - this.lastPitch) >= 4;

                if (var7 >= -128 && var7 < 128 && var8 >= -128 && var8 < 128 && var9 >= -128 && var9 < 128 && this.ticksSinceLastForcedTeleport <= 400)
                {
                    if (var11 && var12)
                    {
                        var10 = new Packet33RelEntityMoveLook(this.myEntity.entityId, (byte)var7, (byte)var8, (byte)var9, (byte)var5, (byte)var6);
                    }
                    else if (var11)
                    {
                        var10 = new Packet31RelEntityMove(this.myEntity.entityId, (byte)var7, (byte)var8, (byte)var9);
                    }
                    else if (var12)
                    {
                        var10 = new Packet32EntityLook(this.myEntity.entityId, (byte)var5, (byte)var6);
                    }
                }
                else
                {
                    this.ticksSinceLastForcedTeleport = 0;
                    var10 = new Packet34EntityTeleport(this.myEntity.entityId, var2, var3, var4, (byte)var5, (byte)var6);
                }

                if (this.trackMotion)
                {
                    double var13 = this.myEntity.motionX - this.motionX;
                    double var15 = this.myEntity.motionY - this.motionY;
                    double var17 = this.myEntity.motionZ - this.motionZ;
                    double var19 = 0.02D;
                    double var21 = var13 * var13 + var15 * var15 + var17 * var17;

                    if (var21 > var19 * var19 || var21 > 0.0D && this.myEntity.motionX == 0.0D && this.myEntity.motionY == 0.0D && this.myEntity.motionZ == 0.0D)
                    {
                        this.motionX = this.myEntity.motionX;
                        this.motionY = this.myEntity.motionY;
                        this.motionZ = this.myEntity.motionZ;
                        this.sendPacketToAllTrackingPlayers(new Packet28EntityVelocity(this.myEntity.entityId, this.motionX, this.motionY, this.motionZ));
                    }
                }

                if (var10 != null)
                {
                    this.sendPacketToAllTrackingPlayers((Packet)var10);
                }

                DataWatcher var23 = this.myEntity.getDataWatcher();

                if (var23.hasChanges())
                {
                    this.sendPacketToAllAssociatedPlayers(new Packet40EntityMetadata(this.myEntity.entityId, var23));
                }

                int var14 = MathHelper.floor_float(this.myEntity.func_70079_am() * 256.0F / 360.0F);

                if (Math.abs(var14 - this.lastHeadMotion) >= 4)
                {
                    this.sendPacketToAllTrackingPlayers(new Packet35EntityHeadRotation(this.myEntity.entityId, (byte)var14));
                    this.lastHeadMotion = var14;
                }

                if (var11)
                {
                    this.lastScaledXPosition = var2;
                    this.lastScaledYPosition = var3;
                    this.lastScaledZPosition = var4;
                }

                if (var12)
                {
                    this.lastYaw = var5;
                    this.lastPitch = var6;
                }
            }

            this.myEntity.isAirBorne = false;
        }

        if (this.myEntity.velocityChanged)
        {
            this.sendPacketToAllAssociatedPlayers(new Packet28EntityVelocity(this.myEntity));
            this.myEntity.velocityChanged = false;
        }
    }

    /**
     * if this is a player, then it is not informed
     */
    public void sendPacketToAllTrackingPlayers(Packet par1Packet)
    {
        Iterator var2 = this.field_73134_o.iterator();

        while (var2.hasNext())
        {
            EntityPlayerMP var3 = (EntityPlayerMP)var2.next();
            var3.serverForThisPlayer.sendPacketToPlayer(par1Packet);
        }
    }

    /**
     * if this is a player, then it recieves the message also
     */
    public void sendPacketToAllAssociatedPlayers(Packet par1Packet)
    {
        this.sendPacketToAllTrackingPlayers(par1Packet);

        if (this.myEntity instanceof EntityPlayerMP)
        {
            ((EntityPlayerMP)this.myEntity).serverForThisPlayer.sendPacketToPlayer(par1Packet);
        }
    }

    public void informAllAssociatedPlayersOfItemDestruction()
    {
        Iterator var1 = this.field_73134_o.iterator();

        while (var1.hasNext())
        {
            EntityPlayerMP var2 = (EntityPlayerMP)var1.next();
            var2.destroyedItemsNetCache.add(Integer.valueOf(this.myEntity.entityId));
        }
    }

    public void removeFromWatchingList(EntityPlayerMP par1EntityPlayerMP)
    {
        if (this.field_73134_o.contains(par1EntityPlayerMP))
        {
            this.field_73134_o.remove(par1EntityPlayerMP);
        }
    }

    /**
     * if the player is more than the distance threshold (typically 64) then the player is removed instead
     */
    public void tryStartWachingThis(EntityPlayerMP par1EntityPlayerMP)
    {
        if (par1EntityPlayerMP != this.myEntity)
        {
            double var2 = par1EntityPlayerMP.posX - (double)(this.lastScaledXPosition / 32);
            double var4 = par1EntityPlayerMP.posZ - (double)(this.lastScaledZPosition / 32);

            if (var2 >= (double)(-this.BlocksDistanceThreshold) && var2 <= (double)this.BlocksDistanceThreshold && var4 >= (double)(-this.BlocksDistanceThreshold) && var4 <= (double)this.BlocksDistanceThreshold)
            {
                if (!this.field_73134_o.contains(par1EntityPlayerMP) && this.isPlayerWatchingThisChunk(par1EntityPlayerMP))
                {
                    this.field_73134_o.add(par1EntityPlayerMP);
                    Packet var6 = this.getPacketForThisEntity();
                    par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(var6);
                    this.motionX = this.myEntity.motionX;
                    this.motionY = this.myEntity.motionY;
                    this.motionZ = this.myEntity.motionZ;

                    if (this.trackMotion && !(var6 instanceof Packet24MobSpawn))
                    {
                        par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet28EntityVelocity(this.myEntity.entityId, this.myEntity.motionX, this.myEntity.motionY, this.myEntity.motionZ));
                    }

                    if (this.myEntity.ridingEntity != null)
                    {
                        par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet39AttachEntity(this.myEntity, this.myEntity.ridingEntity));
                    }

                    ItemStack[] var7 = this.myEntity.getLastActiveItems();

                    if (var7 != null)
                    {
                        for (int var8 = 0; var8 < var7.length; ++var8)
                        {
                            par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet5PlayerInventory(this.myEntity.entityId, var8, var7[var8]));
                        }
                    }

                    if (this.myEntity instanceof EntityPlayer)
                    {
                        EntityPlayer var11 = (EntityPlayer)this.myEntity;

                        if (var11.isPlayerSleeping())
                        {
                            par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet17Sleep(this.myEntity, 0, MathHelper.floor_double(this.myEntity.posX), MathHelper.floor_double(this.myEntity.posY), MathHelper.floor_double(this.myEntity.posZ)));
                        }
                    }

                    if (this.myEntity instanceof EntityLiving)
                    {
                        EntityLiving var12 = (EntityLiving)this.myEntity;
                        Iterator var9 = var12.getActivePotionEffects().iterator();

                        while (var9.hasNext())
                        {
                            PotionEffect var10 = (PotionEffect)var9.next();
                            par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet41EntityEffect(this.myEntity.entityId, var10));
                        }
                    }
                }
            }
            else if (this.field_73134_o.contains(par1EntityPlayerMP))
            {
                this.field_73134_o.remove(par1EntityPlayerMP);
                par1EntityPlayerMP.destroyedItemsNetCache.add(Integer.valueOf(this.myEntity.entityId));
            }
        }
    }

    private boolean isPlayerWatchingThisChunk(EntityPlayerMP par1EntityPlayerMP)
    {
        return par1EntityPlayerMP.getServerForPlayer().getPlayerManager().isPlayerWatchingChunk(par1EntityPlayerMP, this.myEntity.chunkCoordX, this.myEntity.chunkCoordZ);
    }

    public void sendEventsToPlayers(List par1List)
    {
        Iterator var2 = par1List.iterator();

        while (var2.hasNext())
        {
            EntityPlayer var3 = (EntityPlayer)var2.next();
            this.tryStartWachingThis((EntityPlayerMP)var3);
        }
    }

    private Packet getPacketForThisEntity()
    {
        if (this.myEntity.isDead)
        {
            System.out.println("Fetching addPacket for removed entity");
        }

        if (this.myEntity instanceof EntityItem)
        {
            EntityItem var8 = (EntityItem)this.myEntity;
            Packet21PickupSpawn var9 = new Packet21PickupSpawn(var8);
            var8.posX = (double)var9.xPosition / 32.0D;
            var8.posY = (double)var9.yPosition / 32.0D;
            var8.posZ = (double)var9.zPosition / 32.0D;
            return var9;
        }
        else if (this.myEntity instanceof EntityPlayerMP)
        {
            return new Packet20NamedEntitySpawn((EntityPlayer)this.myEntity);
        }
        else
        {
            if (this.myEntity instanceof EntityMinecart)
            {
                EntityMinecart var1 = (EntityMinecart)this.myEntity;

                if (var1.minecartType == 0)
                {
                    return new Packet23VehicleSpawn(this.myEntity, 10);
                }

                if (var1.minecartType == 1)
                {
                    return new Packet23VehicleSpawn(this.myEntity, 11);
                }

                if (var1.minecartType == 2)
                {
                    return new Packet23VehicleSpawn(this.myEntity, 12);
                }
            }

            if (this.myEntity instanceof EntityBoat)
            {
                return new Packet23VehicleSpawn(this.myEntity, 1);
            }
            else if (!(this.myEntity instanceof IAnimals) && !(this.myEntity instanceof EntityDragon))
            {
                if (this.myEntity instanceof EntityFishHook)
                {
                    EntityPlayer var7 = ((EntityFishHook)this.myEntity).angler;
                    return new Packet23VehicleSpawn(this.myEntity, 90, var7 != null ? var7.entityId : this.myEntity.entityId);
                }
                else if (this.myEntity instanceof EntityArrow)
                {
                    Entity var6 = ((EntityArrow)this.myEntity).shootingEntity;
                    return new Packet23VehicleSpawn(this.myEntity, 60, var6 != null ? var6.entityId : this.myEntity.entityId);
                }
                else if (this.myEntity instanceof EntitySnowball)
                {
                    return new Packet23VehicleSpawn(this.myEntity, 61);
                }
                else if (this.myEntity instanceof EntityPotion)
                {
                    return new Packet23VehicleSpawn(this.myEntity, 73, ((EntityPotion)this.myEntity).getPotionDamage());
                }
                else if (this.myEntity instanceof EntityExpBottle)
                {
                    return new Packet23VehicleSpawn(this.myEntity, 75);
                }
                else if (this.myEntity instanceof EntityEnderPearl)
                {
                    return new Packet23VehicleSpawn(this.myEntity, 65);
                }
                else if (this.myEntity instanceof EntityEnderEye)
                {
                    return new Packet23VehicleSpawn(this.myEntity, 72);
                }
                else
                {
                    Packet23VehicleSpawn var2;

                    if (this.myEntity instanceof EntitySmallFireball)
                    {
                        EntitySmallFireball var5 = (EntitySmallFireball)this.myEntity;
                        var2 = null;

                        if (var5.shootingEntity != null)
                        {
                            var2 = new Packet23VehicleSpawn(this.myEntity, 64, var5.shootingEntity.entityId);
                        }
                        else
                        {
                            var2 = new Packet23VehicleSpawn(this.myEntity, 64, 0);
                        }

                        var2.speedX = (int)(var5.accelerationX * 8000.0D);
                        var2.speedY = (int)(var5.accelerationY * 8000.0D);
                        var2.speedZ = (int)(var5.accelerationZ * 8000.0D);
                        return var2;
                    }
                    else if (this.myEntity instanceof EntityFireball)
                    {
                        EntityFireball var4 = (EntityFireball)this.myEntity;
                        var2 = null;

                        if (var4.shootingEntity != null)
                        {
                            var2 = new Packet23VehicleSpawn(this.myEntity, 63, ((EntityFireball)this.myEntity).shootingEntity.entityId);
                        }
                        else
                        {
                            var2 = new Packet23VehicleSpawn(this.myEntity, 63, 0);
                        }

                        var2.speedX = (int)(var4.accelerationX * 8000.0D);
                        var2.speedY = (int)(var4.accelerationY * 8000.0D);
                        var2.speedZ = (int)(var4.accelerationZ * 8000.0D);
                        return var2;
                    }
                    else if (this.myEntity instanceof EntityEgg)
                    {
                        return new Packet23VehicleSpawn(this.myEntity, 62);
                    }
                    else if (this.myEntity instanceof EntityTNTPrimed)
                    {
                        return new Packet23VehicleSpawn(this.myEntity, 50);
                    }
                    else if (this.myEntity instanceof EntityEnderCrystal)
                    {
                        return new Packet23VehicleSpawn(this.myEntity, 51);
                    }
                    else if (this.myEntity instanceof EntityFallingSand)
                    {
                        EntityFallingSand var3 = (EntityFallingSand)this.myEntity;
                        return new Packet23VehicleSpawn(this.myEntity, 70, var3.blockID | var3.field_70285_b << 16);
                    }
                    else if (this.myEntity instanceof EntityPainting)
                    {
                        return new Packet25EntityPainting((EntityPainting)this.myEntity);
                    }
                    else if (this.myEntity instanceof EntityXPOrb)
                    {
                        return new Packet26EntityExpOrb((EntityXPOrb)this.myEntity);
                    }
                    else
                    {
                        throw new IllegalArgumentException("Don\'t know how to add " + this.myEntity.getClass() + "!");
                    }
                }
            }
            else
            {
                this.lastHeadMotion = MathHelper.floor_float(this.myEntity.func_70079_am() * 256.0F / 360.0F);
                return new Packet24MobSpawn((EntityLiving)this.myEntity);
            }
        }
    }

    public void removePlayerFromTracker(EntityPlayerMP par1EntityPlayerMP)
    {
        if (this.field_73134_o.contains(par1EntityPlayerMP))
        {
            this.field_73134_o.remove(par1EntityPlayerMP);
            par1EntityPlayerMP.destroyedItemsNetCache.add(Integer.valueOf(this.myEntity.entityId));
        }
    }
}
