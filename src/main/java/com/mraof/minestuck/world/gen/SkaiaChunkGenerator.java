package com.mraof.minestuck.world.gen;

import net.minecraft.world.IWorld;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.OctavesNoiseGenerator;

public class SkaiaChunkGenerator extends NoiseChunkGenerator<SkaiaGenSettings>
{
	private final OctavesNoiseGenerator depthNoise;
	
	public SkaiaChunkGenerator(IWorld worldIn, BiomeProvider biomeProviderIn, SkaiaGenSettings settings)
	{
		super(worldIn, biomeProviderIn, 4, 8, 256, settings, false);
		
		this.depthNoise = new OctavesNoiseGenerator(this.randomSeed, 15, 0);
	}
	
	@Override
	protected double[] getBiomeNoiseColumn(int columnX, int columnZ)
	{
		double depth = this.depthNoise.getValue(columnX * 200, 10.0D, columnZ * 200, 1.0D, 0.0D, true) * 65535.0D / 12000.0D + 1.0D;
		
		return new double[]{depth, 0.1};
	}
	
	/**
	 * Generated an offset/modifier to the noise density based on the y-height of the grid element and the values generated by the function above
	 * Uses the same equation as the vanilla overworld
	 */
	@Override
	protected double func_222545_a(double depth, double scale, int height)
	{
		double modifier = ((double)height - (8.5D + depth * 8.5D / 8.0D * 4.0D)) * 12.0D * 128.0D / 256.0D / scale;
		if (modifier < 0.0D)
			modifier *= 4.0D;
		
		return modifier;
	}
	
	/**
	 * The first step of noise generation is to generate a grid of doubles where each double determines the density of blocks inside that grid element
	 * This function generates the densities for a column in this grid
	 * @param noiseColumn Array to be filled with noise densities for this column
	 * @param columnX the x index of the noise column
	 * @param columnZ the z index of the noise column
	 */
	@Override
	protected void fillNoiseColumn(double[] noiseColumn, int columnX, int columnZ)
	{
		double horizontal = 684.412D;
		double vertical = 684.412D;
		double horizontal2 = 17.1103D;
		double vertical2 = 4.277575D;
		int lerpModifier = 3;
		int skyValueTarget = -10;
		this.calcNoiseColumn(noiseColumn, columnX, columnZ, horizontal, vertical, horizontal2, vertical2, lerpModifier, skyValueTarget);
	}
	
	@Override
	public int getGroundHeight()
	{
		return 64;
	}
	
	@Override
	public int getSeaLevel()
	{
		return 0;
	}
}
