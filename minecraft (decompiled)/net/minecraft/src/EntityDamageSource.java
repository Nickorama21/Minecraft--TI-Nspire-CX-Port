package net.minecraft.src;

public class EntityDamageSource extends DamageSource
{
    protected Entity damageSourceEntity;

    public EntityDamageSource(String par1Str, Entity par2Entity)
    {
        super(par1Str);
        this.damageSourceEntity = par2Entity;
    }

    public Entity getEntity()
    {
        return this.damageSourceEntity;
    }

    public String func_76360_b(EntityPlayer par1EntityPlayer)
    {
        return StatCollector.translateToLocalFormatted("death." + this.damageType, new Object[] {par1EntityPlayer.username, this.damageSourceEntity.getEntityName()});
    }

    public boolean func_76350_n()
    {
        return this.damageSourceEntity != null && this.damageSourceEntity instanceof EntityLiving && !(this.damageSourceEntity instanceof EntityPlayer);
    }
}
