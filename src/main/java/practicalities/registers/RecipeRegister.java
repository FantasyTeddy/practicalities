package practicalities.registers;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import practicalities.ConfigMan;

public final class RecipeRegister {

	// vanilla resources
	String ingotIron = "ingotIron";
	String ingotGold = "ingotGold";
	String nuggetGold = "nuggetGold";
	ItemStack redstone = new ItemStack(Items.redstone);
	ItemStack lapis = new ItemStack(Items.dye, 1, 4);
	String diamond = "gemDiamond";

	// vanilla items
	ItemStack enderpearl = new ItemStack(Items.ender_pearl);
	ItemStack netherStar = new ItemStack(Items.nether_star);
	ItemStack paper = new ItemStack(Items.paper);
	ItemStack leather = new ItemStack(Items.leather);
	ItemStack potato = new ItemStack(Items.potato);
	ItemStack blazeRod = new ItemStack(Items.blaze_rod);
	ItemStack magmaCream = new ItemStack(Items.magma_cream);
	String stick = "stickWood";

	// vanilla blocks

	// craftingPieces
	ItemStack machineCore = ItemRegister.craftingPieces.getSubItem("machineCore");
	ItemStack machinePlate = ItemRegister.craftingPieces.getSubItem("machinePlate");
	ItemStack imbuedCore = ItemRegister.craftingPieces.getSubItem("imbuedCore");
	ItemStack imbuedRod = ItemRegister.craftingPieces.getSubItem("imbuedRod");
	ItemStack magneticNorth = ItemRegister.craftingPieces.getSubItem("magneticNorth");
	ItemStack magneticSouth = ItemRegister.craftingPieces.getSubItem("magneticSouth");
	


	public void init() {
		shapedRecipes();
		shapelessRecipes();
	}

	private void shapedRecipes() {
		addShapedOreRecipe(true, machineCore, 
				"i i",
				"geg",
				"i i", 
				'i', ingotIron,'g',nuggetGold,'e',enderpearl);
		
		addShapedOreRecipe(true, machinePlate,
				"i i",
				" m ",
				"i i",
				'i', ingotIron, 'm', machinePlate);
		
		addShapedOreRecipe(ConfigMan.enableImbuedItems, imbuedCore,
				"nnn",
				"nmn",
				"nnn",
				'n', netherStar, 'm', machineCore);
		
		addShapedOreRecipe(ConfigMan.enableImbuedItems, imbuedRod,
				"c",
				"c",
				"c",
				'c', imbuedCore);
		
		addShapedOreRecipe(ConfigMan.enableImbuedItems, ItemRegister.imbuedSword,
				"c",
				"c",
				"i",
				'c', imbuedCore, 'i', imbuedRod);
		
		addShapedOreRecipe(ConfigMan.enableImbuedItems, ItemRegister.imbuedTool,
				"ccc",
				"cic",
				" i ", 'c', imbuedCore, 'i', imbuedRod);
		
		addShapedOreRecipe(ConfigMan.enableMagnet, magneticNorth, 
				"  r",
				" i ",
				"i  ",
				'r', redstone,'i',lapis);
		
		addShapedOreRecipe(ConfigMan.enableMagnet, magneticSouth, 
				"  l",
				" i ",
				"i  ",
				'l', lapis,'i',lapis);
		
		addShapedOreRecipe(ConfigMan.enableMagnet, ItemRegister.magnet, 
				"s n",
				"e e",
				" m ",
				's', magneticSouth, 'n', magneticNorth,'e',enderpearl,'m',machineCore);
		
		addShapedOreRecipe(true, ItemRegister.practicalGuide, 
				"ppp",
				"pop",
				"ppp",
				'p', paper,'o',potato);
		
		addShapedOreRecipe(ConfigMan.enableMatterTransporter, ItemRegister.matterTransporter,
				"e e",
				" d ",
				" s ", 'e',enderpearl, 'd',diamond, 's', stick);
		
		addShapedOreRecipe(ConfigMan.enableSitisStick,ItemRegister.sitisStick,
				" d ",
				"cbc",
				" b ", 'd',diamond, 'c', magmaCream, 'b', blazeRod);
		
		addShapedOreRecipe(ConfigMan.enableVoidBucket, ItemRegister.voidBucket,
				"iei",
				" i ", 'i',ingotIron,'e',enderpearl);
	
		
	}

	private void shapelessRecipes() {
		

	}

	// below methods snagged from CoFHLib because it isn't compiled for 1.8.8

	public static void addShapelessRecipe(boolean condition, ItemStack out, Object... recipe) {
		if (condition)
			GameRegistry.addShapelessRecipe(out, recipe);
	}

	public static void addShapelessRecipe(boolean condition, Item out, Object... recipe) {

		addShapelessRecipe(condition, new ItemStack(out), recipe);
	}

	public static void addShapelessRecipe(boolean condition, Block out, Object... recipe) {

		addShapelessRecipe(condition, new ItemStack(out), recipe);
	}

	public static void addShapedOreRecipe(boolean condition, ItemStack out, Object... recipe) {
		if (condition)
			GameRegistry.addRecipe(new ShapedOreRecipe(out, recipe));
	}

	public static void addShapedOreRecipe(boolean condition, Item out, Object... recipe) {
		if (condition)
			GameRegistry.addRecipe(new ShapedOreRecipe(out, recipe));
	}

	public static void addShapedOreRecipe(boolean condition, Block out, Object... recipe) {
		if (condition)
			GameRegistry.addRecipe(new ShapedOreRecipe(out, recipe));
	}
}
