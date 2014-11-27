package com.mraof.minestuck.world.finite;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.profiler.Profiler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldServerMulti;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.storage.ISaveHandler;

public class WorldFiniteServer extends WorldServerMulti
{
	
	protected static int size = 16;
	
	public WorldFiniteServer(WorldServer old, MinecraftServer server)
	{	//This might be a bad idea, but it'll be worth it if I somehow succeed.
		super(server, old.getSaveHandler(), old.getWorldInfo().getWorldName(), old.provider.dimensionId, createSettings(old), server.worldServers[0], server.theProfiler);
		this.theChunkProviderServer = new ChunkProviderLoopServer(this, theChunkProviderServer.currentChunkLoader, theChunkProviderServer.currentChunkProvider);
		this.chunkProvider = theChunkProviderServer;
	}
	
	private static WorldSettings createSettings(WorldServer old)
	{
		WorldSettings settings = new WorldSettings(old.getWorldInfo());
		return settings;
	}
	
	@Override
	public void updateEntities()
	{
		for(Entity entity : (List<Entity>)loadedEntityList)
		{
			entity.posX = FiniteUtil.getEntity(entity.posX, size);
			entity.posZ = FiniteUtil.getEntity(entity.posZ, size);
		}
		super.updateEntities();
	}
	
}
