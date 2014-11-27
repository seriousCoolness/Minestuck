package com.mraof.minestuck.world.finite;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.profiler.Profiler;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldFiniteClient extends WorldClient
{
	
	protected ChunkProviderFiniteClient chunkProviderFinite;
	protected NetHandlerPlayClient sendQueue;
	
	public WorldFiniteClient(WorldClient prevWorld)
	{
		super(Minecraft.getMinecraft().getNetHandler(), new WorldSettings(prevWorld.getWorldInfo()), prevWorld.provider.dimensionId, prevWorld.difficultySetting, Minecraft.getMinecraft().mcProfiler);
		sendQueue = Minecraft.getMinecraft().getNetHandler();
	}
	
	@Override
	protected IChunkProvider createChunkProvider()
	{
		chunkProviderFinite = new ChunkProviderFiniteClient(this);
		return chunkProviderFinite;
	}
	
	@Override
	public void updateEntities()
	{
		for(Entity entity : (List<Entity>)loadedEntityList)
		{
			entity.posX = FiniteUtil.getEntity(entity.posX, WorldFiniteServer.size);
			entity.posZ = FiniteUtil.getEntity(entity.posZ, WorldFiniteServer.size);
		}
		super.updateEntities();
	}
	
	@Override
	public void tick()
	{
		this.updateWeather();
		this.func_82738_a(this.getTotalWorldTime() + 1L);
		
		if (this.getGameRules().getGameRuleBooleanValue("doDaylightCycle"))
		{
			this.setWorldTime(this.getWorldTime() + 1L);
		}
		
		this.theProfiler.startSection("reEntryProcessing");
		
		for (int i = 0; i < 10 && !this.entitySpawnQueue.isEmpty(); ++i)
		{
			Entity entity = (Entity)this.entitySpawnQueue.iterator().next();
			this.entitySpawnQueue.remove(entity);
			
			if (!this.loadedEntityList.contains(entity))
			{
				this.spawnEntityInWorld(entity);
			}
		}
		
		this.theProfiler.endStartSection("connection");
		this.sendQueue.onNetworkTick();
		this.theProfiler.endStartSection("chunkCache");
		this.chunkProviderFinite.unloadQueuedChunks();
		this.theProfiler.endStartSection("blocks");
		this.func_147456_g();
		this.theProfiler.endSection();
	}
	
}
