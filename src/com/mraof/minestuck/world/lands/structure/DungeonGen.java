package com.mraof.minestuck.world.lands.structure;

import java.util.Random;

import com.mraof.minestuck.world.lands.gen.ChunkProviderLands;
import com.mraof.minestuck.world.lands.structure.LandStructureHandler.StructureEntry;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureStart;

public class DungeonGen extends MapGenStructure
{
	private final ChunkProviderLands chunkProvider;
	private final LandStructureHandler handler;
	
	public DungeonGen(ChunkProviderLands chunkProvider, LandStructureHandler handler)
	{
		this.worldObj = chunkProvider.landWorld;
		this.handler = handler;
		this.chunkProvider = chunkProvider;
	}
	
	public boolean isInsideDungeon(BlockPos pos)
	{
		this.initializeStructureData(this.worldObj);
		StructureStart structure = this.getStructureAt(pos);
		return structure != null && (structure instanceof ImpDungeonStart);
	}
	
	public boolean isDungeonNearby(int chunkX, int chunkZ)
	{
		for(int x = chunkX - 1; x <= chunkX + 1; x++)
			for(int z = chunkZ - 1; z <= chunkZ + 1; z++)
				if(structureMap.containsKey(ChunkPos.chunkXZ2Int(x, z)))
					return true;
		return false;
	}
	
	private static final int MAX_DUNGEON_DISTANCE = 15;
	private static final int MIN_STRUCTURE_DISTANCE = 4;
	
	@Override
	protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ)	//This works very much like the scattered features in the overworld
	{
		int x = chunkX;
		int z = chunkZ;
		
		if (x < 0)
			x -= this.MAX_DUNGEON_DISTANCE - 1;
		if (z < 0)
			z -= this.MAX_DUNGEON_DISTANCE - 1;
		
		x /= this.MAX_DUNGEON_DISTANCE;
		z /= this.MAX_DUNGEON_DISTANCE;
		Random random = this.worldObj.setRandomSeed(x, z, 59273643^worldObj.provider.getDimension());
		x *= this.MAX_DUNGEON_DISTANCE;
		z *= this.MAX_DUNGEON_DISTANCE;
		x += random.nextInt(this.MAX_DUNGEON_DISTANCE - this.MIN_STRUCTURE_DISTANCE);
		z += random.nextInt(this.MAX_DUNGEON_DISTANCE - this.MIN_STRUCTURE_DISTANCE);
		
		if (chunkX == x && chunkZ == z)
		{
			Random entryRand = worldObj.setRandomSeed(chunkX , chunkZ, 34527185^worldObj.provider.getDimension());
			Biome biome = this.worldObj.getBiomeProvider().getBiomeGenerator(new BlockPos(new BlockPos(chunkX*16 + 8, 0, chunkZ*16 + 8)));
			StructureEntry entry = handler.getRandomDungeon(entryRand);
			
			return !chunkProvider.isBBInSpawn(new StructureBoundingBox(chunkX*16 - 16, chunkZ*16 - 16, chunkX*16 + 32, chunkZ*16 + 32))	//This chunk and the chunks around it.
					&& (entry.biomes.isEmpty() || entry.biomes.contains(biome));
		}
		
		return false;
	}
	
	@Override
	public String getStructureName()
	{
		return "LandDungeon";
	}
	
	@Override
	protected StructureStart getStructureStart(int chunkX, int chunkZ)
	{
		Random rand = worldObj.setRandomSeed(chunkX , chunkZ, 34527185^worldObj.provider.getDimension());
		
		return handler.getRandomDungeon(rand).createInstance(chunkProvider, worldObj, rand, chunkX, chunkZ);
	}
}