package net.tropicraft.world.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class WorldGenTallFlower extends TCGenBase {

	private int FLOWER_TRIES = 12;
	
    private Block plantBlock;
    private int plantBottomMeta;
    private int plantTopMeta;
    
    public WorldGenTallFlower(World world, Random rand, Block plantBlock, int plantBottomMeta, int plantTopMeta) {
    	super(world, rand);
    	this.plantBlock = plantBlock;
    	this.plantBottomMeta = plantBottomMeta;
    	this.plantTopMeta = plantTopMeta;
    }

    @Override
    public boolean generate(int i, int j, int k) {
        for(int l = 0; l < FLOWER_TRIES; l++) {
            int i1 = (i + rand.nextInt(8)) - rand.nextInt(8);
            int j1 = (j + rand.nextInt(3)) - rand.nextInt(3);
            int k1 = (k + rand.nextInt(8)) - rand.nextInt(8);
            if (worldObj.isAirBlock(i1, j1, k1) && worldObj.isAirBlock(i1, j1 + 1, k1) &&
                    plantBlock.canBlockStay(worldObj, i1, j1, k1)) {
                worldObj.setBlock(i1, j1, k1, plantBlock, plantBottomMeta, blockGenNotifyFlag);
                worldObj.setBlock(i1, j1 + 1, k1, plantBlock, plantTopMeta, blockGenNotifyFlag);
            }
        }

        return true;
    }
}
