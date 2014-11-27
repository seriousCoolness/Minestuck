package com.mraof.minestuck.world.gen;

import java.util.List;

import com.mraof.minestuck.util.Debug;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class ChunkProviderFlatStone implements IChunkProvider
{
	
	World world;
	
	public ChunkProviderFlatStone(World world)
	{
		this.world = world;
	}
	
	@Override
	public boolean chunkExists(int chunkX, int chunkY)
	{
		return chunkX < 16 && chunkY < 16;
	}
	
	@Override
	public Chunk provideChunk(int chunkX, int chunkY)
	{
		if(chunkX >= 16 || chunkY >= 16)
		{
			Thread.dumpStack();
			Debug.print(chunkX+";"+chunkY);
		}
		Block[] chunkBlocks = new Block[65536];
		
		for(int x = 0; x < 16; x++)
			for(int z = 0; z < 16; z++)
			{
				chunkBlocks[x << 12 | z << 8] = Blocks.bedrock;
				for(int y = 1; y < 100; y++)
					chunkBlocks[x << 12 | z << 8 | y] = Blocks.stone;
			}
		
		return new Chunk(world, chunkBlocks, chunkX, chunkY);
	}
	
	@Override
	public Chunk loadChunk(int chunkX, int chunkY)
	{
		return provideChunk(chunkX, chunkY);
	}
	
	@Override
	public void populate(IChunkProvider chunkProvider, int chunkX, int chunkY)
	{}
	
	@Override
	public boolean saveChunks(boolean flag, IProgressUpdate progessUpdate)
	{
		return true;
	}
	
	@Override
	public boolean unloadQueuedChunks()
	{
		return false;
	}
	
	@Override
	public boolean canSave()
	{
		return true;
	}
	
	@Override
	public String makeString()
	{
		return "experimentalLoopDimension";
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List getPossibleCreatures(EnumCreatureType type, int i1, int i2, int i3)
	{
		return null;
	}
	
	@Override
	public ChunkPosition func_147416_a(World world, String structure, int x, int y, int z)
	{
		return null;
	}
	
	@Override
	public int getLoadedChunkCount()
	{
		return 0;
	}
	
	@Override
	public void recreateStructures(int p_82695_1_, int p_82695_2_)
	{}
	
	@Override
	public void saveExtraData()
	{}
	
}
