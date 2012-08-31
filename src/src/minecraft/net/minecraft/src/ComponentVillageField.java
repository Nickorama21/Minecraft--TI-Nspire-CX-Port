package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class ComponentVillageField extends ComponentVillage
{
    private int averageGroundLevel = -1;

    public ComponentVillageField(ComponentVillageStartPiece par1ComponentVillageStartPiece, int par2, Random par3Random, StructureBoundingBox par4StructureBoundingBox, int par5)
    {
        super(par1ComponentVillageStartPiece, par2);
        this.coordBaseMode = par5;
        this.boundingBox = par4StructureBoundingBox;
    }

    public static ComponentVillageField func_74900_a(ComponentVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        StructureBoundingBox var8 = StructureBoundingBox.getComponentToAddBoundingBox(par3, par4, par5, 0, 0, 0, 13, 4, 9, par6);
        return canVillageGoDeeper(var8) && StructureComponent.findIntersecting(par1List, var8) == null ? new ComponentVillageField(par0ComponentVillageStartPiece, par7, par2Random, var8, par6) : null;
    }

    /**
     * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at
     * the end, it adds Fences...
     */
    public boolean addComponentParts(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox)
    {
        if (this.averageGroundLevel < 0)
        {
            this.averageGroundLevel = this.getAverageGroundLevel(par1World, par3StructureBoundingBox);

            if (this.averageGroundLevel < 0)
            {
                return true;
            }

            this.boundingBox.offset(0, this.averageGroundLevel - this.boundingBox.maxY + 4 - 1, 0);
        }

        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 1, 0, 12, 4, 8, 0, 0, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 0, 1, 2, 0, 7, Block.tilledField.blockID, Block.tilledField.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 4, 0, 1, 5, 0, 7, Block.tilledField.blockID, Block.tilledField.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 7, 0, 1, 8, 0, 7, Block.tilledField.blockID, Block.tilledField.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 10, 0, 1, 11, 0, 7, Block.tilledField.blockID, Block.tilledField.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 0, 0, 0, 0, 8, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 6, 0, 0, 6, 0, 8, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 12, 0, 0, 12, 0, 8, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 0, 0, 11, 0, 0, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 0, 8, 11, 0, 8, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 3, 0, 1, 3, 0, 7, Block.waterMoving.blockID, Block.waterMoving.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 9, 0, 1, 9, 0, 7, Block.waterMoving.blockID, Block.waterMoving.blockID, false);
        int var4;

        for (var4 = 1; var4 <= 7; ++var4)
        {
            this.placeBlockAtCurrentPosition(par1World, Block.crops.blockID, MathHelper.getRandomIntegerInRange(par2Random, 2, 7), 1, 1, var4, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.crops.blockID, MathHelper.getRandomIntegerInRange(par2Random, 2, 7), 2, 1, var4, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.crops.blockID, MathHelper.getRandomIntegerInRange(par2Random, 2, 7), 4, 1, var4, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.crops.blockID, MathHelper.getRandomIntegerInRange(par2Random, 2, 7), 5, 1, var4, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.crops.blockID, MathHelper.getRandomIntegerInRange(par2Random, 2, 7), 7, 1, var4, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.crops.blockID, MathHelper.getRandomIntegerInRange(par2Random, 2, 7), 8, 1, var4, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.crops.blockID, MathHelper.getRandomIntegerInRange(par2Random, 2, 7), 10, 1, var4, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.crops.blockID, MathHelper.getRandomIntegerInRange(par2Random, 2, 7), 11, 1, var4, par3StructureBoundingBox);
        }

        for (var4 = 0; var4 < 9; ++var4)
        {
            for (int var5 = 0; var5 < 13; ++var5)
            {
                this.clearCurrentPositionBlocksUpwards(par1World, var5, 4, var4, par3StructureBoundingBox);
                this.fillCurrentPositionBlocksDownwards(par1World, Block.dirt.blockID, 0, var5, -1, var4, par3StructureBoundingBox);
            }
        }

        return true;
    }
}
