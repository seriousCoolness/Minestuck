package com.mraof.minestuck.world.finite;

import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class ChunkProviderFiniteClient extends ChunkProviderClient
{
	
	public static int worldSize = 16;
	
	public ChunkProviderFiniteClient(World world)
	{
		super(world);
	}
	
	@Override
	public Chunk loadChunk(int chunkX, int chunkY)
	{
		return super.loadChunk(FiniteUtil.getChunk(chunkX, worldSize), FiniteUtil.getChunk(chunkY, worldSize));
	}
	
	@Override
	public boolean chunkExists(int chunkX, int chunkY)
	{
		return super.chunkExists(FiniteUtil.getChunk(chunkX, worldSize), FiniteUtil.getChunk(chunkY, worldSize));
	}
	
	@Override
	public Chunk provideChunk(int chunkX, int chunkY)
	{
		return super.provideChunk(FiniteUtil.getChunk(chunkX, worldSize), FiniteUtil.getChunk(chunkY, worldSize));
	}
	
	@Override
	public void populate(IChunkProvider provider, int chunkX, int chunkY)
	{
		super.populate(provider, FiniteUtil.getChunk(chunkX, worldSize), FiniteUtil.getChunk(chunkY, worldSize));
	}
	
}
