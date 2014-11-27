package com.mraof.minestuck.world.finite;

import com.mraof.minestuck.world.gen.ChunkProviderFlatStone;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderLoopExperiment extends WorldProvider
{
	
	ChunkProviderFlatStone provider;
	
	@Override
	public IChunkProvider createChunkGenerator()
	{
		if(provider == null)
			provider = new ChunkProviderFlatStone(this.worldObj);
		return provider;
	}
	
	@Override
	protected void registerWorldChunkManager()
	{
		super.registerWorldChunkManager();
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.sky, 0.5F);
	}
	
	@Override
	public boolean canCoordinateBeSpawn(int x, int y)
	{
		return false;
	}
	
	@Override
	public String getDimensionName()
	{
		return "Experimental Looping Dimension";
	}
	
}
