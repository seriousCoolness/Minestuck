package com.mraof.minestuck.world.finite;

public class FiniteUtil
{
	
	public static int getChunk(int coord, int size)
	{
		while(coord >= size)
			coord -= size*2;
		while(coord < -size)
			coord += size*2;
		return coord;
	}
	
	public static double getEntity(double coord, int size)
	{
		while(coord >= size << 4)
			coord -= (size << 4)*2;
		while(coord < -(size << 4))
			coord += (size << 4)*2;
		return coord;
	}
	
}
