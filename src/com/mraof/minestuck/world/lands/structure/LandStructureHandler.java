package com.mraof.minestuck.world.lands.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.mraof.minestuck.block.BlockGate;
import com.mraof.minestuck.block.MinestuckBlocks;
import com.mraof.minestuck.util.Debug;
import com.mraof.minestuck.world.biome.BiomeMinestuck;
import com.mraof.minestuck.world.lands.gen.ChunkProviderLands;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureStart;

public class LandStructureHandler extends MapGenStructure
{
	
	public final static List<StructureEntry> genericBuildings = new ArrayList<StructureEntry>();
	public final static List<StructureEntry> genericDungeons = new ArrayList<StructureEntry>();
	public final List<StructureEntry> buildings = new ArrayList<StructureEntry>();
	public final List<StructureEntry> dungeons = new ArrayList<StructureEntry>();
	private int dungeonWeight;
	private int buildingWeight;
	private double buildingProbability;
	
	private final DungeonGen dungeonGen;
	
	private final ChunkProviderLands chunkProvider;
	
	public static void registerStructures()
	{
		genericBuildings.add(new StructureEntry(SmallRuinStart.class, 3, BiomeMinestuck.mediumNormal));
		genericDungeons.add(new StructureEntry(ImpDungeonStart.class, 1, BiomeMinestuck.mediumNormal, BiomeMinestuck.mediumRough));
		MapGenStructureIO.registerStructure(SmallRuinStart.class, "MinestuckSmallRuin");
		MapGenStructureIO.registerStructureComponent(SmallRuinStart.SmallRuin.class, "MinestuckSmallRuinCompo");
		MapGenStructureIO.registerStructure(ImpDungeonStart.class, "MinestuckImpDungeon");
		MapGenStructureIO.registerStructureComponent(ImpDungeonStart.EntryComponent.class, "MinestuckIDEntry");
		ImpDungeonComponents.registerComponents();
	}
	
	public boolean isInsideDungeon(BlockPos pos)
	{
		return dungeonGen.isInsideDungeon(pos);
	}
	
	public LandStructureHandler(ChunkProviderLands chunkProvider)
	{
		this.worldObj = chunkProvider.landWorld;
		
		buildings.addAll(genericBuildings);
		dungeons.addAll(genericDungeons);
		this.chunkProvider = chunkProvider;
		
		chunkProvider.aspect1.modifyStructureList(this);
		
		dungeonGen = new DungeonGen(chunkProvider, this);
	}
	
	private static final int MAX_NODE_DISTANCE = 9;
	private static final int MIN_NODE_DISTANCE = 3;
	
	@Override
	protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ)
	{
		
		Random random = this.worldObj.setRandomSeed(chunkX, chunkZ, 65738339^worldObj.provider.getDimension());
		
		if(random.nextDouble() < 0.2 && !buildingAt(chunkX - 1, chunkZ + 1) && !buildingAt(chunkX, chunkZ + 1)
				 && !buildingAt(chunkX + 1, chunkZ + 1) && !buildingAt(chunkX + 1, chunkZ))
		{
			
		}
		
		Biome biome = this.worldObj.getBiomeProvider().getBiomeGenerator(new BlockPos(new BlockPos(chunkX*16 + 8, 0, chunkZ*16 + 8)));
		StructureEntry entry = getRandomDungeon(entryRand);
		
		
		return !chunkProvider.isBBInSpawn(new StructureBoundingBox(chunkX*16 - 16, chunkZ*16 - 16, chunkX*16 + 32, chunkZ*16 + 32))	//This chunk and the chunks around it.
				&& (entry.biomes.isEmpty() || entry.biomes.contains(biome));
		
		return false;
	}
	
	private boolean buildingAt(int chunkX, int chunkZ)
	{
		Random random = this.worldObj.setRandomSeed(chunkX, chunkZ, 65738339^worldObj.provider.getDimension());
		return random.nextDouble() < 0.2;
	}
	
	@Override
	public String getStructureName()
	{
		return "LandFeature";
	}
	
	@Override
	protected StructureStart getStructureStart(int chunkX, int chunkZ)
	{
		Random rand = worldObj.setRandomSeed(chunkX , chunkZ, 34527185^worldObj.provider.getDimension());
		
		return getRandomBuilding(rand).createInstance(chunkProvider, worldObj, rand, chunkX, chunkZ);
	}
	
	@Override
	public void generate(World worldIn, int x, int z, ChunkPrimer primer)
	{
		dungeonGen.generate(worldIn, x, z, primer);
		super.generate(worldIn, x, z, primer);
	}
	
	@Override
	public synchronized boolean generateStructure(World worldIn, Random randomIn, ChunkPos chunkCoord)
	{
		dungeonGen.generateStructure(worldIn, randomIn, chunkCoord);
		return super.generateStructure(worldIn, randomIn, chunkCoord);
	}
	
	private StructureEntry getRandomBuilding(Random random)
	{
		return WeightedRandom.getRandomItem(rand, buildings, buildingWeight);
	}
	
	protected StructureEntry getRandomDungeon(Random random)
	{
		if(dungeonWeight == 0)
			dungeonWeight = WeightedRandom.getTotalWeight(dungeons);
		
		return WeightedRandom.getRandomItem(rand, dungeons, dungeonWeight);
	}
	
	public static class StructureEntry extends WeightedRandom.Item
	{
		public final Class<? extends StructureStart> structureStart;
		public final Set<Biome> biomes;
		public final int amount;
		
		public StructureEntry(Class<? extends StructureStart> structure, int weight, Biome... biomes)
		{
			this(structure, weight, 0, biomes);
		}
		
		public StructureEntry(Class<? extends StructureStart> structure, int weight, int amount, Biome... biomes)
		{
			super(weight);
			this.structureStart = structure;
			this.biomes = new HashSet<Biome>(Arrays.asList(biomes));
			this.amount = amount;
		}
		
		public StructureStart createInstance(ChunkProviderLands chunkProvider, World world, Random rand, int chunkX, int chunkZ)
		{
			try
			{
				return structureStart.getConstructor(ChunkProviderLands.class, World.class, Random.class, int.class, int.class).newInstance(chunkProvider, world, rand, chunkX, chunkZ);
			}
			catch(Exception e)
			{
				Debug.error("Failed to create structure for "+structureStart.getName());
				throw new IllegalStateException(e);	//The best exception I can think about right now.
			}
		}
	}
	
	public void placeReturnNodes(World world, Random rand, ChunkPos coords, BlockPos decoratorPos)
	{
		int x = coords.chunkXPos;
		int z = coords.chunkZPos;
		
		if (x < 0)
			x -= this.MAX_NODE_DISTANCE - 1;
		if (z < 0)
			z -= this.MAX_NODE_DISTANCE - 1;
		
		x /= this.MAX_NODE_DISTANCE;
		z /= this.MAX_NODE_DISTANCE;
		Random random = world.setRandomSeed(x, z, 32698602^world.provider.getDimension());
		x *= this.MAX_NODE_DISTANCE;
		z *= this.MAX_NODE_DISTANCE;
		x += random.nextInt(this.MAX_NODE_DISTANCE - this.MIN_NODE_DISTANCE);
		z += random.nextInt(this.MAX_NODE_DISTANCE - this.MIN_NODE_DISTANCE);
		
		if(coords.chunkXPos == x && coords.chunkZPos == z)
		{
			BlockPos nodePos;
			if(decoratorPos == null)
			{
				int xPos = x*16 + 8 + random.nextInt(16);
				int zPos = z*16 + 8 + random.nextInt(16);
				int maxY = 0;
				for(int i = 0; i < 4; i++)
				{
					BlockPos pos = world.getTopSolidOrLiquidBlock(new BlockPos(xPos + (i % 2), 0, zPos + i/2));
					IBlockState block = world.getBlockState(pos);
					if(block.getMaterial().isLiquid() || world.getBiomeForCoordsBody(pos) == BiomeMinestuck.mediumOcean)
						return;
					if(pos.getY() > maxY)
						maxY = pos.getY();
				}
				for(int i = 0; i < 4; i++)
				{
					BlockPos pos = new BlockPos(xPos + (i % 2), maxY, zPos + i/2);
					if(world.getBlockState(pos).getBlock().isLeaves(world.getBlockState(pos), world, pos))
						return;
				}
				nodePos = new BlockPos(xPos, maxY, zPos);
			}
			else
			{
				nodePos = decoratorPos;
				Debug.debug("Spawning special node at: "+nodePos);
				}
			
			for(int i = 0; i < 4; i++)
			{
				BlockPos pos = nodePos.add(i % 2, 0, i/2);
				if(i == 3)
				{
					world.setBlockState(pos, MinestuckBlocks.returnNode.getDefaultState().cycleProperty(BlockGate.isMainComponent), 2);
					//Do something with the tile entity?
				} else world.setBlockState(pos, MinestuckBlocks.returnNode.getDefaultState(), 2);
			}
		}
	}
	
}
