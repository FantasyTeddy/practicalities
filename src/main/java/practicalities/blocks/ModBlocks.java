package practicalities.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import practicalities.ConfigMan;
import practicalities.machine.playerinterface.BlockPlayerInterface;
import practicalities.machine.polaritynegator.BlockPolarityNegator;
import practicalities.machine.shippingcrate.BlockShippingCrate;
import practicalities.machine.vampiricgenerator.BlockVampiricGenerator;

public class ModBlocks {
	public static Block shippingCrate;
	public static Block stoneWall;
	public static Block vampiricGenerator;
	public static Block polarityNegator;
	public static Block playerInterface;
	
	public static void init() {
		
		stoneWall = new BlockDecor(Material.rock, "stonewall", 1, Block.soundTypeStone);
		vampiricGenerator = new BlockVampiricGenerator();
		polarityNegator = new BlockPolarityNegator();
		playerInterface = new BlockPlayerInterface();
		
		if(ConfigMan.enableShippingCrate)
			shippingCrate = new BlockShippingCrate();
		
		if(ConfigMan.enableVampiricGenerator)
			vampiricGenerator = new BlockVampiricGenerator();
		
		if(ConfigMan.enableMagnet)
			polarityNegator = new BlockPolarityNegator();
	}
}
