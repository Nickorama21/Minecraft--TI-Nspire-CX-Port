package net.minecraft.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MapGenStronghold extends MapGenStructure
{
    private BiomeGenBase[] allowedBiomeGenBases;

    /**
     * is spawned false and set true once the defined BiomeGenBases were compared with the present ones
     */
    private boolean ranBiomeCheck;
    private ChunkCoordIntPair[] structureCoords;

    public MapGenStronghold()
    {
        this.allowedBiomeGenBases = new BiomeGenBase[] {BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.extremeHills, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.icePlains, BiomeGenBase.iceMountains, BiomeGenBase.desertHills, BiomeGenBase.forestHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.jungle, BiomeGenBase.jungleHills};
        this.structureCoords = new ChunkCoordIntPair[3];
    }

    protected boolean canSpawnStructureAtCoords(int par1, int par2)
    {
        if (!this.ranBiomeCheck)
        {
            Random var3 = new Random();
            var3.setSeed(this.worldObj.getSeed());
            double var4 = var3.nextDouble() * Math.PI * 2.0D;

            for (int var6 = 0; var6 < this.structureCoords.length; ++var6)
            {
                double var7 = (1.25D + var3.nextDouble()) * 32.0D;
                int var9 = (int)Math.round(Math.cos(var4) * var7);
                int var10 = (int)Math.round(Math.sin(var4) * var7);
                ArrayList var11 = new ArrayList();
                Collections.addAll(var11, this.allowedBiomeGenBases);
                ChunkPosition var12 = this.worldObj.getWorldChunkManager().findBiomePosition((var9 << 4) + 8, (var10 << 4) + 8, 112, var11, var3);

                if (var12 != null)
                {
                    var9 = var12.x >> 4;
                    var10 = var12.z >> 4;
                }
                else
                {
                    System.out.println("Placed stronghold in INVALID biome at (" + var9 + ", " + var10 + ")");
                }

                this.structureCoords[var6] = new ChunkCoordIntPair(var9, var10);
                var4 += (Math.PI * 2D) / (double)this.structureCoords.length;
            }

            this.ranBiomeCheck = true;
        }

        ChunkCoordIntPair[] var13 = this.structureCoords;
        int var14 = var13.length;

        for (int var5 = 0; var5 < var14; ++var5)
        {
            ChunkCoordIntPair var15 = var13[var5];

            if (par1 == var15.chunkXPos && par2 == var15.chunkZPos)
            {
                System.out.println(par1 + ", " + par2);
                return true;
            }
        }

        return false;
    }

    protected List func_75052_o_()
    {
        ArrayList var1 = new ArrayList();
        ChunkCoordIntPair[] var2 = this.structureCoords;
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            ChunkCoordIntPair var5 = var2[var4];

            if (var5 != null)
            {
                var1.add(var5.getChunkPosition(64));
            }
        }

        return var1;
    }

    protected StructureStart getStructureStart(int par1, int par2)
    {
        StructureStrongholdStart var3;

        for (var3 = new StructureStrongholdStart(this.worldObj, this.rand, par1, par2); var3.getComponents().isEmpty() || ((ComponentStrongholdStairs2)var3.getComponents().get(0)).portalRoom == null; var3 = new StructureStrongholdStart(this.worldObj, this.rand, par1, par2))
        {
            ;
        }

        return var3;
    }
}
