package com.mraof.minestuck.world.finite;

import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.gen.ChunkProviderServer;

public class ChunkProviderLoopServer extends ChunkProviderServer
{
	
	public static final int worldSize = 16;
	
	public ChunkProviderLoopServer(WorldServer world, IChunkLoader chunkLoader, IChunkProvider chunkProvider)
	{
		super(world, chunkLoader, chunkProvider);
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
	public Chunk originalLoadChunk(int chunkX, int chunkY)
	{
		return super.originalLoadChunk(FiniteUtil.getChunk(chunkX, worldSize), FiniteUtil.getChunk(chunkY, worldSize));
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
	
	@Override
	public Chunk loadChunk(int chunkX, int chunkY, Runnable runnable)
	{
		return super.loadChunk(FiniteUtil.getChunk(chunkX, worldSize), FiniteUtil.getChunk(chunkY, worldSize), runnable);
	}
	
}
