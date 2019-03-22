package com.mraof.minestuck.network.skaianet;

import com.mraof.minestuck.util.IdentifierHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.MathHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores information related to the land belonging to the related connection
 * More things related to post-entry will be moved here with the update to mc1.13
 */
public class LandData
{
	private Map<IdentifierHandler.PlayerIdentifier, Integer> consortReputation = new HashMap<>();
	public int landDimId;
	
	void saveToNBT(NBTTagCompound nbt)
	{
		nbt.setInteger("clientLand", landDimId);
		
		NBTTagList list = new NBTTagList();
		for(Map.Entry<IdentifierHandler.PlayerIdentifier, Integer> entry : consortReputation.entrySet())
		{
			NBTTagCompound tag = new NBTTagCompound();
			entry.getKey().saveToNBT(tag, "player");
			tag.setInteger("rep", entry.getValue());
			list.appendTag(tag);
		}
		nbt.setTag("landPlayerList", list);
	}
	
	void loadFromNBT(NBTTagCompound nbt)
	{
		landDimId = nbt.getInteger("clientLand");
		
		NBTTagList list = nbt.getTagList("landPlayerList", 10);
		for(int i = 0; i < list.tagCount(); i++)
		{
			NBTTagCompound tag = list.getCompoundTagAt(i);
			IdentifierHandler.PlayerIdentifier player = IdentifierHandler.load(tag, "player");
			int rep = tag.getInteger("rep");
			consortReputation.put(player, rep);
		}
	}
	
	public int getReputation(IdentifierHandler.PlayerIdentifier player)
	{
		if(!consortReputation.containsKey(player))
			consortReputation.put(player, 0);
		return consortReputation.get(player);
	}
	
	public void addReputation(IdentifierHandler.PlayerIdentifier player, int rep)
	{
		int newRep = getReputation(player) + rep;
		newRep = MathHelper.clamp(newRep, -1000, 1000);
		consortReputation.put(player, newRep);
	}
}