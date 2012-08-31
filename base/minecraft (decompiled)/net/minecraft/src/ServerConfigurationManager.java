package net.minecraft.src;

import java.io.File;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public abstract class ServerConfigurationManager
{
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd \'at\' HH:mm:ss z");
    public static final Logger myLogger = Logger.getLogger("Minecraft");

    /** Reference to the MinecraftServer object. */
    private final MinecraftServer mcServer;

    /** A list of player entities that exist on this server. */
    public final List playerEntityList = new ArrayList();
    private final BanList bannedPlayers = new BanList(new File("banned-players.txt"));
    private final BanList bannedIPs = new BanList(new File("banned-ips.txt"));

    /** A set containing the OPs. */
    private Set ops = new HashSet();
    private Set whiteListIPs = new HashSet();
    private IPlayerFileData field_72412_k;

    /**
     * Server setting to only allow OPs and whitelisted players to join the server.
     */
    private boolean whiteListEnforced;

    /** The maximum number of players that can be connected at a time. */
    protected int maxPlayers;
    protected int viewDistance;
    private EnumGameType gameType;

    /** True if all players are allowed to use commands (cheats). */
    private boolean commandsAllowedForAll;
    private int field_72408_o = 0;

    public ServerConfigurationManager(MinecraftServer par1MinecraftServer)
    {
        this.mcServer = par1MinecraftServer;
        this.bannedPlayers.setListActive(false);
        this.bannedIPs.setListActive(false);
        this.maxPlayers = 8;
    }

    public void initializeConnectionToPlayer(NetworkManager par1NetworkManager, EntityPlayerMP par2EntityPlayerMP)
    {
        this.func_72380_a(par2EntityPlayerMP);
        par2EntityPlayerMP.setWorld(this.mcServer.worldServerForDimension(par2EntityPlayerMP.dimension));
        par2EntityPlayerMP.theItemInWorldManager.setWorld((WorldServer)par2EntityPlayerMP.worldObj);
        String var3 = "local";

        if (par1NetworkManager.getSocketAddress() != null)
        {
            var3 = par1NetworkManager.getSocketAddress().toString();
        }

        myLogger.info(par2EntityPlayerMP.username + "[" + var3 + "] logged in with entity id " + par2EntityPlayerMP.entityId + " at (" + par2EntityPlayerMP.posX + ", " + par2EntityPlayerMP.posY + ", " + par2EntityPlayerMP.posZ + ")");
        WorldServer var4 = this.mcServer.worldServerForDimension(par2EntityPlayerMP.dimension);
        ChunkCoordinates var5 = var4.getSpawnPoint();
        this.func_72381_a(par2EntityPlayerMP, (EntityPlayerMP)null, var4);
        NetServerHandler var6 = new NetServerHandler(this.mcServer, par1NetworkManager, par2EntityPlayerMP);
        var6.sendPacketToPlayer(new Packet1Login(par2EntityPlayerMP.entityId, var4.getWorldInfo().getTerrainType(), par2EntityPlayerMP.theItemInWorldManager.getGameType(), var4.getWorldInfo().isHardcoreModeEnabled(), var4.provider.worldType, var4.difficultySetting, var4.getHeight(), this.getMaxPlayers()));
        var6.sendPacketToPlayer(new Packet6SpawnPosition(var5.posX, var5.posY, var5.posZ));
        var6.sendPacketToPlayer(new Packet202PlayerAbilities(par2EntityPlayerMP.capabilities));
        this.sendTimeAndRainingToPlayer(par2EntityPlayerMP, var4);
        this.sendPacketToAllPlayers(new Packet3Chat("\u00a7e" + par2EntityPlayerMP.username + " joined the game."));
        this.func_72377_c(par2EntityPlayerMP);
        var6.setPlayerLocation(par2EntityPlayerMP.posX, par2EntityPlayerMP.posY, par2EntityPlayerMP.posZ, par2EntityPlayerMP.rotationYaw, par2EntityPlayerMP.rotationPitch);
        this.mcServer.getNetworkThread().func_71745_a(var6);
        var6.sendPacketToPlayer(new Packet4UpdateTime(var4.getWorldTime()));

        if (this.mcServer.getTexturePack().length() > 0)
        {
            par2EntityPlayerMP.requestTexturePackLoad(this.mcServer.getTexturePack(), this.mcServer.textureFlag());
        }

        Iterator var7 = par2EntityPlayerMP.getActivePotionEffects().iterator();

        while (var7.hasNext())
        {
            PotionEffect var8 = (PotionEffect)var7.next();
            var6.sendPacketToPlayer(new Packet41EntityEffect(par2EntityPlayerMP.entityId, var8));
        }

        par2EntityPlayerMP.addSelfToInternalCraftingInventory();
    }

    public void func_72364_a(WorldServer[] par1ArrayOfWorldServer)
    {
        this.field_72412_k = par1ArrayOfWorldServer[0].getSaveHandler().getSaveHandler();
    }

    public void func_72375_a(EntityPlayerMP par1EntityPlayerMP, WorldServer par2WorldServer)
    {
        WorldServer var3 = par1EntityPlayerMP.getServerForPlayer();

        if (par2WorldServer != null)
        {
            par2WorldServer.getPlayerManager().func_72695_c(par1EntityPlayerMP);
        }

        var3.getPlayerManager().func_72683_a(par1EntityPlayerMP);
        var3.theChunkProviderServer.loadChunk((int)par1EntityPlayerMP.posX >> 4, (int)par1EntityPlayerMP.posZ >> 4);
    }

    public int getEntityViewDistance()
    {
        return PlayerManager.func_72686_a(this.getViewDistance());
    }

    public void func_72380_a(EntityPlayerMP par1EntityPlayerMP)
    {
        NBTTagCompound var2 = this.mcServer.theWorldServer[0].getWorldInfo().getPlayerNBTTagCompound();

        if (par1EntityPlayerMP.getCommandSenderName().equals(this.mcServer.getServerOwner()) && var2 != null)
        {
            par1EntityPlayerMP.readFromNBT(var2);
        }
        else
        {
            this.field_72412_k.readPlayerData(par1EntityPlayerMP);
        }
    }

    /**
     * also stores the NBTTags if this is an intergratedPlayerList
     */
    protected void writePlayerData(EntityPlayerMP par1EntityPlayerMP)
    {
        this.field_72412_k.writePlayerData(par1EntityPlayerMP);
    }

    public void func_72377_c(EntityPlayerMP par1EntityPlayerMP)
    {
        this.sendPacketToAllPlayers(new Packet201PlayerInfo(par1EntityPlayerMP.username, true, 1000));
        this.playerEntityList.add(par1EntityPlayerMP);
        WorldServer var2 = this.mcServer.worldServerForDimension(par1EntityPlayerMP.dimension);

        while (!var2.getCollidingBoundingBoxes(par1EntityPlayerMP, par1EntityPlayerMP.boundingBox).isEmpty())
        {
            par1EntityPlayerMP.setPosition(par1EntityPlayerMP.posX, par1EntityPlayerMP.posY + 1.0D, par1EntityPlayerMP.posZ);
        }

        var2.spawnEntityInWorld(par1EntityPlayerMP);
        this.func_72375_a(par1EntityPlayerMP, (WorldServer)null);
        Iterator var3 = this.playerEntityList.iterator();

        while (var3.hasNext())
        {
            EntityPlayerMP var4 = (EntityPlayerMP)var3.next();
            par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet201PlayerInfo(var4.username, true, var4.field_71138_i));
        }
    }

    public void func_72358_d(EntityPlayerMP par1EntityPlayerMP)
    {
        par1EntityPlayerMP.getServerForPlayer().getPlayerManager().func_72685_d(par1EntityPlayerMP);
    }

    public void func_72367_e(EntityPlayerMP par1EntityPlayerMP)
    {
        this.writePlayerData(par1EntityPlayerMP);
        WorldServer var2 = par1EntityPlayerMP.getServerForPlayer();
        var2.setEntityDead(par1EntityPlayerMP);
        var2.getPlayerManager().func_72695_c(par1EntityPlayerMP);
        this.playerEntityList.remove(par1EntityPlayerMP);
        this.sendPacketToAllPlayers(new Packet201PlayerInfo(par1EntityPlayerMP.username, false, 9999));
    }

    /**
     * checks ban-lists, then white-lists, then space for the server. Returns null on success, or an error message
     */
    public String allowUserToConnect(SocketAddress par1SocketAddress, String par2Str)
    {
        if (this.bannedPlayers.isBanned(par2Str))
        {
            BanEntry var6 = (BanEntry)this.bannedPlayers.getBannedList().get(par2Str);
            String var7 = "You are banned from this server!\nReason: " + var6.getBanReason();

            if (var6.getBanEndDate() != null)
            {
                var7 = var7 + "\nYour ban will be removed on " + dateFormat.format(var6.getBanEndDate());
            }

            return var7;
        }
        else if (!this.isAllowedToLogin(par2Str))
        {
            return "You are not white-listed on this server!";
        }
        else
        {
            String var3 = par1SocketAddress.toString();
            var3 = var3.substring(var3.indexOf("/") + 1);
            var3 = var3.substring(0, var3.indexOf(":"));

            if (this.bannedIPs.isBanned(var3))
            {
                BanEntry var4 = (BanEntry)this.bannedIPs.getBannedList().get(var3);
                String var5 = "Your IP address is banned from this server!\nReason: " + var4.getBanReason();

                if (var4.getBanEndDate() != null)
                {
                    var5 = var5 + "\nYour ban will be removed on " + dateFormat.format(var4.getBanEndDate());
                }

                return var5;
            }
            else
            {
                return this.playerEntityList.size() >= this.maxPlayers ? "The server is full!" : null;
            }
        }
    }

    /**
     * also checks for multiple logins
     */
    public EntityPlayerMP createPlayerForUser(String par1Str)
    {
        ArrayList var2 = new ArrayList();
        Iterator var3 = this.playerEntityList.iterator();
        EntityPlayerMP var4;

        while (var3.hasNext())
        {
            var4 = (EntityPlayerMP)var3.next();

            if (var4.username.equalsIgnoreCase(par1Str))
            {
                var2.add(var4);
            }
        }

        var3 = var2.iterator();

        while (var3.hasNext())
        {
            var4 = (EntityPlayerMP)var3.next();
            var4.serverForThisPlayer.kickPlayerFromServer("You logged in from another location");
        }

        Object var5;

        if (this.mcServer.isDemo())
        {
            var5 = new DemoWorldManager(this.mcServer.worldServerForDimension(0));
        }
        else
        {
            var5 = new ItemInWorldManager(this.mcServer.worldServerForDimension(0));
        }

        return new EntityPlayerMP(this.mcServer, this.mcServer.worldServerForDimension(0), par1Str, (ItemInWorldManager)var5);
    }

    /**
     * creates and returns a respawned player based on the provided PlayerEntity. Args are the PlayerEntityMP to
     * respawn, an INT for the dimension to respawn into (usually 0), and a boolean value that is true if the player
     * beat the game rather than dying
     */
    public EntityPlayerMP respawnPlayer(EntityPlayerMP par1EntityPlayerMP, int par2, boolean par3)
    {
        par1EntityPlayerMP.getServerForPlayer().getEntityTracker().removeAllTrackingPlayers(par1EntityPlayerMP);
        par1EntityPlayerMP.getServerForPlayer().getEntityTracker().removeEntityFromAllTrackingPlayers(par1EntityPlayerMP);
        par1EntityPlayerMP.getServerForPlayer().getPlayerManager().func_72695_c(par1EntityPlayerMP);
        this.playerEntityList.remove(par1EntityPlayerMP);
        this.mcServer.worldServerForDimension(par1EntityPlayerMP.dimension).removeEntity(par1EntityPlayerMP);
        ChunkCoordinates var4 = par1EntityPlayerMP.getSpawnChunk();
        par1EntityPlayerMP.dimension = par2;
        Object var5;

        if (this.mcServer.isDemo())
        {
            var5 = new DemoWorldManager(this.mcServer.worldServerForDimension(par1EntityPlayerMP.dimension));
        }
        else
        {
            var5 = new ItemInWorldManager(this.mcServer.worldServerForDimension(par1EntityPlayerMP.dimension));
        }

        EntityPlayerMP var6 = new EntityPlayerMP(this.mcServer, this.mcServer.worldServerForDimension(par1EntityPlayerMP.dimension), par1EntityPlayerMP.username, (ItemInWorldManager)var5);
        var6.clonePlayer(par1EntityPlayerMP, par3);
        var6.entityId = par1EntityPlayerMP.entityId;
        var6.serverForThisPlayer = par1EntityPlayerMP.serverForThisPlayer;
        WorldServer var7 = this.mcServer.worldServerForDimension(par1EntityPlayerMP.dimension);
        this.func_72381_a(var6, par1EntityPlayerMP, var7);
        ChunkCoordinates var8;

        if (var4 != null)
        {
            var8 = EntityPlayer.verifyRespawnCoordinates(this.mcServer.worldServerForDimension(par1EntityPlayerMP.dimension), var4);

            if (var8 != null)
            {
                var6.setLocationAndAngles((double)((float)var8.posX + 0.5F), (double)((float)var8.posY + 0.1F), (double)((float)var8.posZ + 0.5F), 0.0F, 0.0F);
                var6.setSpawnChunk(var4);
            }
            else
            {
                var6.serverForThisPlayer.sendPacketToPlayer(new Packet70GameEvent(0, 0));
            }
        }

        var7.theChunkProviderServer.loadChunk((int)var6.posX >> 4, (int)var6.posZ >> 4);

        while (!var7.getCollidingBoundingBoxes(var6, var6.boundingBox).isEmpty())
        {
            var6.setPosition(var6.posX, var6.posY + 1.0D, var6.posZ);
        }

        var6.serverForThisPlayer.sendPacketToPlayer(new Packet9Respawn(var6.dimension, (byte)var6.worldObj.difficultySetting, var6.worldObj.getWorldInfo().getTerrainType(), var6.worldObj.getHeight(), var6.theItemInWorldManager.getGameType()));
        var8 = var7.getSpawnPoint();
        var6.serverForThisPlayer.setPlayerLocation(var6.posX, var6.posY, var6.posZ, var6.rotationYaw, var6.rotationPitch);
        var6.serverForThisPlayer.sendPacketToPlayer(new Packet6SpawnPosition(var8.posX, var8.posY, var8.posZ));
        this.sendTimeAndRainingToPlayer(var6, var7);
        var7.getPlayerManager().func_72683_a(var6);
        var7.spawnEntityInWorld(var6);
        this.playerEntityList.add(var6);
        var6.addSelfToInternalCraftingInventory();
        return var6;
    }

    public void transferPlayerToDimension(EntityPlayerMP par1EntityPlayerMP, int par2)
    {
        int var3 = par1EntityPlayerMP.dimension;
        WorldServer var4 = this.mcServer.worldServerForDimension(par1EntityPlayerMP.dimension);
        par1EntityPlayerMP.dimension = par2;
        WorldServer var5 = this.mcServer.worldServerForDimension(par1EntityPlayerMP.dimension);
        par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet9Respawn(par1EntityPlayerMP.dimension, (byte)par1EntityPlayerMP.worldObj.difficultySetting, var5.getWorldInfo().getTerrainType(), var5.getHeight(), par1EntityPlayerMP.theItemInWorldManager.getGameType()));
        var4.removeEntity(par1EntityPlayerMP);
        par1EntityPlayerMP.isDead = false;
        double var6 = par1EntityPlayerMP.posX;
        double var8 = par1EntityPlayerMP.posZ;
        double var10 = 8.0D;

        if (par1EntityPlayerMP.dimension == -1)
        {
            var6 /= var10;
            var8 /= var10;
            par1EntityPlayerMP.setLocationAndAngles(var6, par1EntityPlayerMP.posY, var8, par1EntityPlayerMP.rotationYaw, par1EntityPlayerMP.rotationPitch);

            if (par1EntityPlayerMP.isEntityAlive())
            {
                var4.updateEntityWithOptionalForce(par1EntityPlayerMP, false);
            }
        }
        else if (par1EntityPlayerMP.dimension == 0)
        {
            var6 *= var10;
            var8 *= var10;
            par1EntityPlayerMP.setLocationAndAngles(var6, par1EntityPlayerMP.posY, var8, par1EntityPlayerMP.rotationYaw, par1EntityPlayerMP.rotationPitch);

            if (par1EntityPlayerMP.isEntityAlive())
            {
                var4.updateEntityWithOptionalForce(par1EntityPlayerMP, false);
            }
        }
        else
        {
            ChunkCoordinates var12 = var5.getEntrancePortalLocation();
            var6 = (double)var12.posX;
            par1EntityPlayerMP.posY = (double)var12.posY;
            var8 = (double)var12.posZ;
            par1EntityPlayerMP.setLocationAndAngles(var6, par1EntityPlayerMP.posY, var8, 90.0F, 0.0F);

            if (par1EntityPlayerMP.isEntityAlive())
            {
                var4.updateEntityWithOptionalForce(par1EntityPlayerMP, false);
            }
        }

        if (var3 != 1)
        {
            var6 = (double)MathHelper.clamp_int((int)var6, -29999872, 29999872);
            var8 = (double)MathHelper.clamp_int((int)var8, -29999872, 29999872);

            if (par1EntityPlayerMP.isEntityAlive())
            {
                var5.spawnEntityInWorld(par1EntityPlayerMP);
                par1EntityPlayerMP.setLocationAndAngles(var6, par1EntityPlayerMP.posY, var8, par1EntityPlayerMP.rotationYaw, par1EntityPlayerMP.rotationPitch);
                var5.updateEntityWithOptionalForce(par1EntityPlayerMP, false);
                (new Teleporter()).placeInPortal(var5, par1EntityPlayerMP);
            }
        }

        par1EntityPlayerMP.setWorld(var5);
        this.func_72375_a(par1EntityPlayerMP, var4);
        par1EntityPlayerMP.serverForThisPlayer.setPlayerLocation(par1EntityPlayerMP.posX, par1EntityPlayerMP.posY, par1EntityPlayerMP.posZ, par1EntityPlayerMP.rotationYaw, par1EntityPlayerMP.rotationPitch);
        par1EntityPlayerMP.theItemInWorldManager.setWorld(var5);
        this.sendTimeAndRainingToPlayer(par1EntityPlayerMP, var5);
        this.syncPlayerInventory(par1EntityPlayerMP);
        Iterator var14 = par1EntityPlayerMP.getActivePotionEffects().iterator();

        while (var14.hasNext())
        {
            PotionEffect var13 = (PotionEffect)var14.next();
            par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet41EntityEffect(par1EntityPlayerMP.entityId, var13));
        }
    }

    /**
     * sends 1 player per tick, but only sends a player once every 600 ticks
     */
    public void sendPlayerInfoToAllPlayers()
    {
        if (++this.field_72408_o > 600)
        {
            this.field_72408_o = 0;
        }

        if (this.field_72408_o < this.playerEntityList.size())
        {
            EntityPlayerMP var1 = (EntityPlayerMP)this.playerEntityList.get(this.field_72408_o);
            this.sendPacketToAllPlayers(new Packet201PlayerInfo(var1.username, true, var1.field_71138_i));
        }
    }

    public void sendPacketToAllPlayers(Packet par1Packet)
    {
        for (int var2 = 0; var2 < this.playerEntityList.size(); ++var2)
        {
            ((EntityPlayerMP)this.playerEntityList.get(var2)).serverForThisPlayer.sendPacketToPlayer(par1Packet);
        }
    }

    public void sendPacketToAllPlayersInDimension(Packet par1Packet, int par2)
    {
        Iterator var3 = this.playerEntityList.iterator();

        while (var3.hasNext())
        {
            EntityPlayerMP var4 = (EntityPlayerMP)var3.next();

            if (var4.dimension == par2)
            {
                var4.serverForThisPlayer.sendPacketToPlayer(par1Packet);
            }
        }
    }

    public String func_72398_c()
    {
        String var1 = "";

        for (int var2 = 0; var2 < this.playerEntityList.size(); ++var2)
        {
            if (var2 > 0)
            {
                var1 = var1 + ", ";
            }

            var1 = var1 + ((EntityPlayerMP)this.playerEntityList.get(var2)).username;
        }

        return var1;
    }

    public String[] getAllUsernames()
    {
        String[] var1 = new String[this.playerEntityList.size()];

        for (int var2 = 0; var2 < this.playerEntityList.size(); ++var2)
        {
            var1[var2] = ((EntityPlayerMP)this.playerEntityList.get(var2)).username;
        }

        return var1;
    }

    public BanList getBannedPlayers()
    {
        return this.bannedPlayers;
    }

    public BanList getBannedIPs()
    {
        return this.bannedIPs;
    }

    /**
     * This adds a username to the ops list, then saves the op list
     */
    public void addOp(String par1Str)
    {
        this.ops.add(par1Str.toLowerCase());
    }

    /**
     * This removes a username from the ops list, then saves the op list
     */
    public void removeOp(String par1Str)
    {
        this.ops.remove(par1Str.toLowerCase());
    }

    /**
     * Determine if the player is allowed to connect based on current server settings.
     */
    public boolean isAllowedToLogin(String par1Str)
    {
        par1Str = par1Str.trim().toLowerCase();
        return !this.whiteListEnforced || this.ops.contains(par1Str) || this.whiteListIPs.contains(par1Str);
    }

    public boolean areCommandsAllowed(String par1Str)
    {
        return this.ops.contains(par1Str.trim().toLowerCase()) || this.mcServer.isSinglePlayer() && this.mcServer.theWorldServer[0].getWorldInfo().areCommandsAllowed() && this.mcServer.getServerOwner().equalsIgnoreCase(par1Str) || this.commandsAllowedForAll;
    }

    public EntityPlayerMP getPlayerForUsername(String par1Str)
    {
        Iterator var2 = this.playerEntityList.iterator();
        EntityPlayerMP var3;

        do
        {
            if (!var2.hasNext())
            {
                return null;
            }

            var3 = (EntityPlayerMP)var2.next();
        }
        while (!var3.username.equalsIgnoreCase(par1Str));

        return var3;
    }

    /**
     * params: x,y,z,d,dimension. The packet is sent to all players within d distance of x,y,z (d^2<x^2+y^2+z^2)
     */
    public void sendToAllNear(double par1, double par3, double par5, double par7, int par9, Packet par10Packet)
    {
        this.sendToAllNearExcept((EntityPlayer)null, par1, par3, par5, par7, par9, par10Packet);
    }

    /**
     * params: srcPlayer,x,y,z,d,dimension. The packet is not sent to the srcPlayer, but all other players where
     * dx*dx+dy*dy+dz*dz<d*d
     */
    public void sendToAllNearExcept(EntityPlayer par1EntityPlayer, double par2, double par4, double par6, double par8, int par10, Packet par11Packet)
    {
        Iterator var12 = this.playerEntityList.iterator();

        while (var12.hasNext())
        {
            EntityPlayerMP var13 = (EntityPlayerMP)var12.next();

            if (var13 != par1EntityPlayer && var13.dimension == par10)
            {
                double var14 = par2 - var13.posX;
                double var16 = par4 - var13.posY;
                double var18 = par6 - var13.posZ;

                if (var14 * var14 + var16 * var16 + var18 * var18 < par8 * par8)
                {
                    var13.serverForThisPlayer.sendPacketToPlayer(par11Packet);
                }
            }
        }
    }

    public void saveAllPlayerData()
    {
        Iterator var1 = this.playerEntityList.iterator();

        while (var1.hasNext())
        {
            EntityPlayerMP var2 = (EntityPlayerMP)var1.next();
            this.writePlayerData(var2);
        }
    }

    /**
     * Add the specified player to the white list.
     */
    public void addToWhiteList(String par1Str)
    {
        this.whiteListIPs.add(par1Str);
    }

    /**
     * Remove the specified player from the whitelist.
     */
    public void removeFromWhitelist(String par1Str)
    {
        this.whiteListIPs.remove(par1Str);
    }

    public Set getIPWhiteList()
    {
        return this.whiteListIPs;
    }

    public Set getNamesWhiteList()
    {
        return this.ops;
    }

    /**
     * Either does nothing, or calls readWhiteList.
     */
    public void loadWhiteList() {}

    public void sendTimeAndRainingToPlayer(EntityPlayerMP par1EntityPlayerMP, WorldServer par2WorldServer)
    {
        par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet4UpdateTime(par2WorldServer.getWorldTime()));

        if (par2WorldServer.isRaining())
        {
            par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet70GameEvent(1, 0));
        }
    }

    /**
     * sends the players inventory to himself
     */
    public void syncPlayerInventory(EntityPlayerMP par1EntityPlayerMP)
    {
        par1EntityPlayerMP.sendContainerToPlayer(par1EntityPlayerMP.inventorySlots);
        par1EntityPlayerMP.setPlayerHealthUpdated();
    }

    public int getPlayerListSize()
    {
        return this.playerEntityList.size();
    }

    public int getMaxPlayers()
    {
        return this.maxPlayers;
    }

    /**
     * returns a list of usernames for which playerData is available
     */
    public String[] getAvailablePlayerDat()
    {
        return this.mcServer.theWorldServer[0].getSaveHandler().getSaveHandler().getAvailablePlayerDat();
    }

    public boolean isWhiteListEnabled()
    {
        return this.whiteListEnforced;
    }

    public void setWhiteListEnabled(boolean par1)
    {
        this.whiteListEnforced = par1;
    }

    public List getPlayerList(String par1Str)
    {
        ArrayList var2 = new ArrayList();
        Iterator var3 = this.playerEntityList.iterator();

        while (var3.hasNext())
        {
            EntityPlayerMP var4 = (EntityPlayerMP)var3.next();

            if (var4.func_71114_r().equals(par1Str))
            {
                var2.add(var4);
            }
        }

        return var2;
    }

    /**
     * Gets the View Distance.
     */
    public int getViewDistance()
    {
        return this.viewDistance;
    }

    public MinecraftServer getServerInstance()
    {
        return this.mcServer;
    }

    /**
     * gets the tags created in the last writePlayerData call
     */
    public NBTTagCompound getTagsFromLastWrite()
    {
        return null;
    }

    public void setGameType(EnumGameType par1EnumGameType)
    {
        this.gameType = par1EnumGameType;
    }

    private void func_72381_a(EntityPlayerMP par1EntityPlayerMP, EntityPlayerMP par2EntityPlayerMP, World par3World)
    {
        if (par2EntityPlayerMP != null)
        {
            par1EntityPlayerMP.theItemInWorldManager.setGameType(par2EntityPlayerMP.theItemInWorldManager.getGameType());
        }
        else if (this.gameType != null)
        {
            par1EntityPlayerMP.theItemInWorldManager.setGameType(this.gameType);
        }

        par1EntityPlayerMP.theItemInWorldManager.initializeGameType(par3World.getWorldInfo().getGameType());
    }

    /**
     * Sets whether all players are allowed to use commands (cheats) on the server.
     */
    public void setCommandsAllowedForAll(boolean par1)
    {
        this.commandsAllowedForAll = par1;
    }

    /**
     * kicks everyone with the "Server closed"
     */
    public void removeAllPlayers()
    {
        while (!this.playerEntityList.isEmpty())
        {
            ((EntityPlayerMP)this.playerEntityList.get(0)).serverForThisPlayer.kickPlayerFromServer("Server closed");
        }
    }
}
