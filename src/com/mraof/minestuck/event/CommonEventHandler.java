package com.mraof.minestuck.event;

import com.mraof.minestuck.world.finite.ChunkProviderLoopServer;
import com.mraof.minestuck.world.finite.WorldFiniteServer;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.world.WorldEvent;

public class CommonEventHandler
{
	
	@SubscribeEvent
	public void onWorldLoad(WorldEvent.Load event)
	{
		if(!event.world.isRemote && event.world.provider.dimensionId == 3)
		{
			WorldServer world = (WorldServer)event.world;
			WorldFiniteServer worldFinite = new WorldFiniteServer(world, MinecraftServer.getServer());
			world.theChunkProviderServer = new ChunkProviderLoopServer(world, world.theChunkProviderServer.currentChunkLoader, world.theChunkProviderServer.currentChunkProvider);
		}
		else if(event.world.isRemote && event.world.provider.dimensionId == 3)
		{
			
		}
	}
	
}
