package net.minecraft.src;

public class ModelBlaze extends ModelBase
{
    private ModelRenderer[] field_78106_a = new ModelRenderer[12];
    private ModelRenderer field_78105_b;

    public ModelBlaze()
    {
        for (int var1 = 0; var1 < this.field_78106_a.length; ++var1)
        {
            this.field_78106_a[var1] = new ModelRenderer(this, 0, 16);
            this.field_78106_a[var1].addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
        }

        this.field_78105_b = new ModelRenderer(this, 0, 0);
        this.field_78105_b.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
    }

    public int func_78104_a()
    {
        return 8;
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7);
        this.field_78105_b.render(par7);
        ModelRenderer[] var8 = this.field_78106_a;
        int var9 = var8.length;

        for (int var10 = 0; var10 < var9; ++var10)
        {
            ModelRenderer var11 = var8[var10];
            var11.render(par7);
        }
    }

    /**
     * Sets the models various rotation angles.
     */
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6)
    {
        float var7 = par3 * (float)Math.PI * -0.1F;
        int var8;

        for (var8 = 0; var8 < 4; ++var8)
        {
            this.field_78106_a[var8].rotationPointY = -2.0F + MathHelper.cos(((float)(var8 * 2) + par3) * 0.25F);
            this.field_78106_a[var8].rotationPointX = MathHelper.cos(var7) * 9.0F;
            this.field_78106_a[var8].rotationPointZ = MathHelper.sin(var7) * 9.0F;
            ++var7;
        }

        var7 = ((float)Math.PI / 4F) + par3 * (float)Math.PI * 0.03F;

        for (var8 = 4; var8 < 8; ++var8)
        {
            this.field_78106_a[var8].rotationPointY = 2.0F + MathHelper.cos(((float)(var8 * 2) + par3) * 0.25F);
            this.field_78106_a[var8].rotationPointX = MathHelper.cos(var7) * 7.0F;
            this.field_78106_a[var8].rotationPointZ = MathHelper.sin(var7) * 7.0F;
            ++var7;
        }

        var7 = 0.47123894F + par3 * (float)Math.PI * -0.05F;

        for (var8 = 8; var8 < 12; ++var8)
        {
            this.field_78106_a[var8].rotationPointY = 11.0F + MathHelper.cos(((float)var8 * 1.5F + par3) * 0.5F);
            this.field_78106_a[var8].rotationPointX = MathHelper.cos(var7) * 5.0F;
            this.field_78106_a[var8].rotationPointZ = MathHelper.sin(var7) * 5.0F;
            ++var7;
        }

        this.field_78105_b.rotateAngleY = par4 / (180F / (float)Math.PI);
        this.field_78105_b.rotateAngleX = par5 / (180F / (float)Math.PI);
    }
}
