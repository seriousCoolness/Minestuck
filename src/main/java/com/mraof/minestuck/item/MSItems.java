package com.mraof.minestuck.item;

import com.mraof.minestuck.Minestuck;
import com.mraof.minestuck.block.EnumCassetteType;
import com.mraof.minestuck.block.MSBlocks;
import com.mraof.minestuck.entity.item.CrewPosterEntity;
import com.mraof.minestuck.entity.item.MetalBoatEntity;
import com.mraof.minestuck.entity.item.SbahjPosterEntity;
import com.mraof.minestuck.fluid.MSFluids;
import com.mraof.minestuck.item.artifact.CruxiteAppleItem;
import com.mraof.minestuck.item.artifact.CruxitePotionItem;
import com.mraof.minestuck.item.block.*;
import com.mraof.minestuck.item.foods.DrinkableItem;
import com.mraof.minestuck.item.foods.HealingFoodItem;
import com.mraof.minestuck.item.foods.SurpriseEmbryoItem;
import com.mraof.minestuck.item.foods.UnknowableEggItem;
import com.mraof.minestuck.item.weapon.*;
import com.mraof.minestuck.item.weapon.aspect.*;
import com.mraof.minestuck.util.MSSoundEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nonnull;

import static com.mraof.minestuck.block.MSBlocks.*;
import static com.mraof.minestuck.player.EnumAspect.*;

/**
 * This class contains all non-ItemBlock items that minestuck adds,
 * and is responsible for initializing and registering these.
 */
@ObjectHolder(Minestuck.MOD_ID)
@Mod.EventBusSubscriber(modid = Minestuck.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MSItems
{
	
	public static final MultiblockItem CRUXTRUDER = getNull();
	public static final MultiblockItem TOTEM_LATHE = getNull();
	public static final MultiblockItem ALCHEMITER = getNull();
	public static final MultiblockItem PUNCH_DESIGNIX = getNull();
	
	//hammers
	public static final Item CLAW_HAMMER = getNull();
	public static final Item SLEDGE_HAMMER = getNull();
	public static final Item MAILBOX = getNull();
	public static final Item BLACKSMITH_HAMMER = getNull();
	public static final Item POGO_HAMMER = getNull();
	public static final Item WRINKLEFUCKER = getNull();
	public static final Item TELESCOPIC_SASSACRUSHER = getNull();
	public static final Item DEMOCRATIC_DEMOLITIONER = getNull();
	public static final Item REGI_HAMMER = getNull();
	public static final Item FEAR_NO_ANVIL = getNull();
	public static final Item MELT_MASHER = getNull();
	public static final Item ESTROGEN_EMPOWERED_EVERYTHING_ERADICATOR = getNull();
	public static final Item EEEEEEEEEEEE = getNull();
	public static final Item ZILLYHOO_HAMMER = getNull();
	public static final Item POPAMATIC_VRILLYHOO = getNull();
	public static final Item SCARLET_ZILLYHOO = getNull();
	public static final Item MWRTHWL = getNull();
	//blades
	public static final Item SORD = getNull();
	public static final Item PAPER_SWORD = getNull();
	public static final Item CACTACEAE_CUTLASS = getNull();
	public static final Item STEAK_SWORD = getNull();
	public static final Item BEEF_SWORD = getNull();
	public static final Item IRRADIATED_STEAK_SWORD = getNull();
	public static final Item MACUAHUITL = getNull();
	public static final Item FROSTY_MACUAHUITL = getNull();
	public static final Item KATANA = getNull();
	public static final Item UNBREAKABLE_KATANA = getNull();
	public static final Item ANGEL_APOCALYPSE = getNull();
	public static final Item FIRE_POKER = getNull();
	public static final Item TOO_HOT_TO_HANDLE = getNull();
	public static final Item CALEDSCRATCH = getNull();
	public static final Item CALEDFWLCH = getNull();
	public static final Item ROYAL_DERINGER = getNull();
	public static final Item CLAYMORE = getNull();
	public static final Item CUTLASS_OF_ZILLYWAIR = getNull();
	public static final Item REGISWORD = getNull();
	public static final Item CRUEL_FATE_CRUCIBLE = getNull();
	public static final Item SCARLET_RIBBITAR = getNull();
	public static final Item DOGG_MACHETE = getNull();
	public static final Item COBALT_SABRE = getNull();
	public static final Item QUANTUM_SABRE = getNull();
	public static final Item SHATTER_BEACON = getNull();
	//axes
	public static final Item BATLEACKS = getNull();
	public static final Item COPSE_CRUSHER = getNull();
	public static final Item QUENCH_CRUSHER = getNull();
	public static final Item MELONSBANE = getNull();
	public static final Item CROP_CHOP = getNull();
	public static final Item THE_LAST_STRAW = getNull();
	public static final Item BATTLEAXE = getNull();
	public static final Item CANDY_BATTLEAXE = getNull();
	public static final Item CHOCO_LOCO_WOODSPLITTER = getNull();
	public static final Item STEEL_EDGE_CANDYCUTTER = getNull();
	public static final Item BLACKSMITH_BANE = getNull();
	public static final Item REGIAXE = getNull();
	public static final Item SURPRISE_AXE = getNull();
	public static final Item SHOCK_AXE = getNull();
	public static final Item SHOCK_AXE_UNPOWERED = getNull();
	public static final Item SCRAXE = getNull();
	public static final Item LORENTZ_DISTRANSFORMATIONER = getNull();
	public static final Item PISTON_POWERED_POGO_AXEHAMMER = getNull();
	public static final Item RUBY_CROAK = getNull();
	public static final Item HEPHAESTUS_LUMBERJACK = getNull();
	public static final Item FISSION_FOCUSED_FAULT_FELLER = getNull();
	public static final Item BISECTOR = getNull();
	
	//Dice
	public static final Item DICE = getNull();
	public static final Item FLUORITE_OCTET = getNull();
	
	//misc weapons
	public static final Item CAT_CLAWS_DRAWN = getNull();
	public static final Item CAT_CLAWS_SHEATHED = getNull();
	public static final Item LIPSTICK_CHAINSAW = getNull();
	public static final Item LIPSTICK = getNull();
	public static final Item CIGARETTE_LANCE = getNull();
	public static final Item LUCERNE_HAMMER = getNull();
	public static final Item LUCERNE_HAMMER_OF_UNDYING = getNull();
	public static final Item OBSIDIAN_AXE_KNIFE = getNull();
	public static final Item FAN = getNull();
	public static final Item TYPHONIC_TRIVIALIZER = getNull();
	
	//sickles
	public static final Item SICKLE = getNull();
	public static final Item OW_THE_EDGE = getNull();
	public static final Item HEMEOREAPER = getNull();
	public static final Item THORNY_SUBJECT = getNull();
	public static final Item HOMES_SMELL_YA_LATER = getNull();
	public static final Item FUDGESICKLE = getNull();
	public static final Item REGISICKLE = getNull();
	public static final Item CLAW_SICKLE = getNull();
	public static final Item CLAW_OF_NRUBYIGLITH = getNull();
	public static final Item CANDY_SICKLE = getNull();
	//clubs
	public static final Item DEUCE_CLUB = getNull();
	public static final Item STALE_BAGUETTE = getNull();
	public static final Item GLUB_CLUB = getNull();
	public static final Item NIGHT_CLUB = getNull();
	public static final Item PRISMARINE_BASHER = getNull();
	public static final Item CLUB_ZERO = getNull();
	public static final Item POGO_CLUB = getNull();
	public static final Item METAL_BAT = getNull();
	public static final Item CLOWN_CLUB = getNull();
	public static final Item SPIKED_CLUB = getNull();
	
	public static final Item HORSE_HITCHER = getNull();
	public static final Item ACE_OF_SPADES = getNull();
	public static final Item CLUB_OF_FELONY = getNull();
	public static final Item ACE_OF_CLUBS = getNull();
	public static final Item CUESTICK = getNull();
	public static final Item ACE_OF_DIAMONDS = getNull();
	public static final Item ACE_OF_HEARTS = getNull();
	public static final Item WHITE_KINGS_SCEPTER = getNull();
	public static final Item BLACK_KINGS_SCEPTER = getNull();
	
	//canes
	public static final Item CANE = getNull();
	public static final Item VAUDEVILLE_HOOK = getNull();
	public static final Item BEAR_POKING_STICK = getNull();
	public static final Item CROWBAR = getNull();
	public static final Item UMBRELLA = getNull();
	public static final Item UPPER_CRUST_CRUST_CANE = getNull();
	public static final Item IRON_CANE = getNull();
	public static final Item SPEAR_CANE = getNull();
	public static final Item PARADISES_PORTABELLO = getNull();
	public static final Item REGI_CANE = getNull();
	public static final Item DRAGON_CANE = getNull();
	public static final Item DRAGON_CANE_UNSHEATHED = getNull();
	public static final Item POGO_CANE = getNull();
	public static final Item CANDY_CANE = getNull();
	public static final Item SHARP_CANDY_CANE = getNull();
	public static final Item PRIM_AND_PROPER_WALKING_POLE = getNull();
	public static final Item LESS_PROPER_WALKING_STICK = getNull();
	public static final Item LESS_PROPER_WALKING_STICK_SHEATHED = getNull();
	public static final Item ROCKEFELLERS_WALKING_BLADECANE = getNull();
	public static final Item ROCKEFELLERS_WALKING_BLADECANE_SHEATHED = getNull();
	
	//Spoons/forks
	public static final Item WOODEN_SPOON = getNull();
	public static final Item SILVER_SPOON = getNull();
	public static final Item NOSFERATU_SPOON = getNull();
	public static final Item CROCKER_SPOON = getNull();
	public static final Item CROCKER_FORK = getNull();
	public static final Item SKAIA_FORK = getNull();
	public static final Item FORK = getNull();
	public static final Item TUNING_FORK = getNull();
	public static final Item SPORK = getNull();
	public static final Item GOLDEN_SPORK = getNull();
	public static final Item BIDENT = getNull();
	
	//Material tools
	public static final Item EMERALD_SWORD = getNull();
	public static final Item EMERALD_AXE = getNull();
	public static final Item EMERALD_PICKAXE = getNull();
	public static final Item EMERALD_SHOVEL = getNull();
	public static final Item EMERALD_HOE = getNull();
	
	//Armor
	public static final Item PRISMARINE_HELMET = getNull();
	public static final Item PRISMARINE_CHESTPLATE = getNull();
	public static final Item PRISMARINE_LEGGINGS = getNull();
	public static final Item PRISMARINE_BOOTS = getNull();
	public static final Item IRON_LASS_GLASSES = getNull();
	public static final Item IRON_LASS_CHESTPLATE = getNull();
	public static final Item IRON_LASS_SKIRT = getNull();
	public static final Item IRON_LASS_SHOES = getNull();
	
	public static final Item PROSPIT_SHIRT = getNull();
	public static final Item PROSPIT_PANTS = getNull();
	public static final Item PROSPIT_SHOES = getNull();
	public static final Item DERSE_SHIRT = getNull();
	public static final Item DERSE_PANTS = getNull();
	public static final Item DERSE_SHOES = getNull();
	
	//Core Items
	public static final Item BOONDOLLARS = getNull();
	public static final Item RAW_CRUXITE = getNull();
	public static final Item RAW_URANIUM = getNull();
	public static final Item ENERGY_CORE = getNull();
	public static final Item CRUXITE_APPLE = getNull();
	public static final Item CRUXITE_POTION = getNull();
	public static final Item CLIENT_DISK = getNull();
	public static final Item SERVER_DISK = getNull();
	public static final Item CAPTCHA_CARD = getNull();
	public static final Item STACK_MODUS_CARD = getNull();
	public static final Item QUEUE_MODUS_CARD = getNull();
	public static final Item QUEUESTACK_MODUS_CARD = getNull();
	public static final Item TREE_MODUS_CARD = getNull();
	public static final Item HASHMAP_MODUS_CARD = getNull();
	public static final Item SET_MODUS_CARD = getNull();
	public static final Item SHUNT = getNull();
	
	//Food
	public static final Item PHLEGM_GUSHERS = getNull();
	public static final Item SORROW_GUSHERS = getNull();
	
	public static final Item BUG_ON_A_STICK = getNull();
	public static final Item CHOCOLATE_BEETLE = getNull();
	public static final Item CONE_OF_FLIES = getNull();
	public static final Item GRASSHOPPER = getNull();
	public static final Item JAR_OF_BUGS = getNull();
	public static final Item ONION = getNull();
	public static final Item SALAD = getNull();
	public static final Item DESERT_FRUIT = getNull();
	public static final Item ROCK_COOKIE = getNull();
	public static final Item FUNGAL_SPORE = getNull();
	public static final Item SPOREO = getNull();
	public static final Item MOREL_MUSHROOM = getNull();
	public static final Item FRENCH_FRY = getNull();
	public static final Item STRAWBERRY_CHUNK = getNull();
	public static final Item FOOD_CAN = getNull();
	
	public static final Item CANDY_CORN = getNull();
	public static final Item BUILD_GUSHERS = getNull();
	public static final Item AMBER_GUMMY_WORM = getNull();
	public static final Item CAULK_PRETZEL = getNull();
	public static final Item CHALK_CANDY_CIGARETTE = getNull();
	public static final Item IODINE_LICORICE = getNull();
	public static final Item SHALE_PEEP = getNull();
	public static final Item TAR_LICORICE = getNull();
	public static final Item COBALT_GUM = getNull();
	public static final Item MARBLE_JAWBREAKER = getNull();
	public static final Item MERCURY_SIXLETS = getNull();
	public static final Item QUARTZ_JELLY_BEAN = getNull();
	public static final Item SULFUR_CANDY_APPLE = getNull();
	public static final Item AMETHYST_HARD_CANDY = getNull();
	public static final Item GARNET_TWIX = getNull();
	public static final Item RUBY_LOLLIPOP = getNull();
	public static final Item RUST_GUMMY_EYE = getNull();
	public static final Item DIAMOND_MINT = getNull();
	public static final Item GOLD_CANDY_RIBBON = getNull();
	public static final Item URANIUM_GUMMY_BEAR = getNull();
	public static final Item ARTIFACT_WARHEAD = getNull();
	public static final Item ZILLIUM_SKITTLES = getNull();
	public static final Item TAB = getNull();
	public static final Item ORANGE_FAYGO = getNull();
	public static final Item CANDY_APPLE_FAYGO = getNull();
	public static final Item FAYGO_COLA = getNull();
	public static final Item COTTON_CANDY_FAYGO = getNull();
	public static final Item CREME_SODA_FAYGO = getNull();
	public static final Item GRAPE_FAYGO = getNull();
	public static final Item MOON_MIST_FAYGO = getNull();
	public static final Item PEACH_FAYGO = getNull();
	public static final Item REDPOP_FAYGO = getNull();
	public static final Item IRRADIATED_STEAK = getNull();
	public static final Item SURPRISE_EMBRYO = getNull();
	public static final Item UNKNOWABLE_EGG = getNull();
	public static final Item BREADCRUMBS = getNull();
	
	//Other Land Items
	public static final Item GOLDEN_GRASSHOPPER = getNull();
	public static final Item BUG_NET = getNull();
	public static final Item FROG = getNull();
	public static final Item CARVING_TOOL = getNull();
	public static final Item CRUMPLY_HAT = getNull();
	public static final Item STONE_EYEBALLS = getNull();
	public static final Item STONE_SLAB = getNull();
	public static /*final*/ Item SHOP_POSTER = getNull();
	
	//Buckets
	public static final Item OIL_BUCKET = getNull();
	public static final Item BLOOD_BUCKET = getNull();
	public static final Item BRAIN_JUICE_BUCKET = getNull();
	public static final Item WATER_COLORS_BUCKET = getNull();
	public static final Item ENDER_BUCKET = getNull();
	public static final Item LIGHT_WATER_BUCKET = getNull();
	public static final Item OBSIDIAN_BUCKET = getNull();
	
	//Alchemy Items
	public static final Item GRIMOIRE = getNull();
	public static final Item BATTERY = getNull();
	public static final Item BARBASOL = getNull();
	public static final Item CLOTHES_IRON = getNull();
	public static final Item INK_SQUID_PRO_QUO = getNull();
	public static final Item CUEBALL = getNull();
	public static final Item THRESH_DVD = getNull();
	public static final Item GAMEBRO_MAGAZINE = getNull();
	public static final Item GAMEGRL_MAGAZINE = getNull();
	public static final Item CREW_POSTER = getNull();
	public static final Item SBAHJ_POSTER = getNull();
	public static final Item BI_DYE = getNull();
	
	//Other
	public static final Item CAPTCHAROID_CAMERA = getNull();
	public static final Item LONG_FORGOTTEN_WARHORN = getNull();
	public static final Item BLACK_QUEENS_RING = getNull();
	public static final Item WHITE_QUEENS_RING = getNull();
	public static final Item BARBASOL_BOMB = getNull();
	public static final Item RAZOR_BLADE = getNull();
	public static final Item ICE_SHARD = getNull();
	public static final Item HORN = getNull();
	public static final Item CAKE_MIX = getNull();
	
	public static final Item SCALEMATE_APPLESCAB = getNull();
	public static final Item SCALEMATE_BERRYBREATH = getNull();
	public static final Item SCALEMATE_CINNAMONWHIFF = getNull();
	public static final Item SCALEMATE_HONEYTONGUE = getNull();
	public static final Item SCALEMATE_LEMONSNOUT = getNull();
	public static final Item SCALEMATE_PINESNOUT = getNull();
	public static final Item SCALEMATE_PUCEFOOT = getNull();
	public static final Item SCALEMATE_PUMPKINSNUFFLE = getNull();
	public static final Item SCALEMATE_PYRALSPITE = getNull();
	public static final Item SCALEMATE_WITNESS = getNull();
	
	//Incredibly Useful Items
	public static final Item URANIUM_POWERED_STICK = getNull();
	public static final Item IRON_BOAT = getNull();
	public static final Item GOLD_BOAT = getNull();
	public static final Item WOODEN_CARROT = getNull();
	
	//Music Discs
	public static final Item MUSIC_DISC_EMISSARY_OF_DANCE = getNull();
	public static final Item MUSIC_DISC_DANCE_STAB_DANCE = getNull();
	public static final Item MUSIC_DISC_RETRO_BATTLE = getNull();
	//Cassettes
	public static final Item CASSETTE_MELLOHI = getNull();
	public static final Item CASSETTE_13 = getNull();
	public static final Item CASSETTE_BLOCKS = getNull();
	public static final Item CASSETTE_CAT = getNull();
	public static final Item CASSETTE_CHIRP = getNull();
	public static final Item CASSETTE_FAR = getNull();
	public static final Item CASSETTE_MALL = getNull();
	public static final Item CASSETTE_DANCE_STAB = getNull();
	public static final Item CASSETTE_RETRO_BATTLE = getNull();
	public static final Item CASSETTE_EMISSARY = getNull();

	@Nonnull
	@SuppressWarnings("ConstantConditions")
	private static <T> T getNull()
	{
		return null;
	}
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		IForgeRegistry<Item> registry = event.getRegistry();
		
		registerItemBlock(registry, BLACK_CHESS_DIRT, MSItemGroup.MAIN);
		registerItemBlock(registry, WHITE_CHESS_DIRT, MSItemGroup.MAIN);
		registerItemBlock(registry, DARK_GRAY_CHESS_DIRT, MSItemGroup.MAIN);
		registerItemBlock(registry, LIGHT_GRAY_CHESS_DIRT, MSItemGroup.MAIN);
		registerItemBlock(registry, SKAIA_PORTAL, new Item.Properties().group(MSItemGroup.MAIN).rarity(Rarity.EPIC));
		
		registerItemBlock(registry, BLACK_CASTLE_BRICKS, MSItemGroup.MAIN);
		registerItemBlock(registry, DARK_GRAY_CASTLE_BRICKS, MSItemGroup.MAIN);
		registerItemBlock(registry, LIGHT_GRAY_CASTLE_BRICKS, MSItemGroup.MAIN);
		registerItemBlock(registry, WHITE_CASTLE_BRICKS, MSItemGroup.MAIN);
		registerItemBlock(registry, BLACK_CASTLE_BRICK_SMOOTH, MSItemGroup.MAIN);
		registerItemBlock(registry, DARK_GRAY_CASTLE_BRICK_SMOOTH, MSItemGroup.MAIN);
		registerItemBlock(registry, LIGHT_GRAY_CASTLE_BRICK_SMOOTH, MSItemGroup.MAIN);
		registerItemBlock(registry, WHITE_CASTLE_BRICK_SMOOTH, MSItemGroup.MAIN);
		registerItemBlock(registry, BLACK_CASTLE_BRICK_TRIM, MSItemGroup.MAIN);
		registerItemBlock(registry, DARK_GRAY_CASTLE_BRICK_TRIM, MSItemGroup.MAIN);
		registerItemBlock(registry, LIGHT_GRAY_CASTLE_BRICK_TRIM, MSItemGroup.MAIN);
		registerItemBlock(registry, WHITE_CASTLE_BRICK_TRIM, MSItemGroup.MAIN);
		registerItemBlock(registry, BLACK_CROWN_STAINED_GLASS, MSItemGroup.MAIN);
		registerItemBlock(registry, BLACK_PAWN_STAINED_GLASS, MSItemGroup.MAIN);
		registerItemBlock(registry, WHITE_CROWN_STAINED_GLASS, MSItemGroup.MAIN);
		registerItemBlock(registry, WHITE_PAWN_STAINED_GLASS, MSItemGroup.MAIN);
		
		registerItemBlock(registry, STONE_CRUXITE_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, NETHERRACK_CRUXITE_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, COBBLESTONE_CRUXITE_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, SANDSTONE_CRUXITE_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, RED_SANDSTONE_CRUXITE_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, END_STONE_CRUXITE_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, PINK_STONE_CRUXITE_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, STONE_URANIUM_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, NETHERRACK_URANIUM_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, COBBLESTONE_URANIUM_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, SANDSTONE_URANIUM_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, RED_SANDSTONE_URANIUM_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, END_STONE_URANIUM_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, PINK_STONE_URANIUM_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, NETHERRACK_COAL_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, PINK_STONE_COAL_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, END_STONE_IRON_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, SANDSTONE_IRON_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, RED_SANDSTONE_IRON_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, SANDSTONE_GOLD_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, RED_SANDSTONE_GOLD_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, PINK_STONE_GOLD_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, END_STONE_REDSTONE_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, STONE_QUARTZ_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, PINK_STONE_LAPIS_ORE, MSItemGroup.LANDS);
		registerItemBlock(registry, PINK_STONE_DIAMOND_ORE, MSItemGroup.LANDS);
		
		registerItemBlock(registry, CRUXITE_BLOCK, MSItemGroup.MAIN);
		registerItemBlock(registry, URANIUM_BLOCK, MSItemGroup.MAIN);
		registerItemBlock(registry, GENERIC_OBJECT, MSItemGroup.MAIN);
		
		registerItemBlock(registry, BLUE_DIRT, MSItemGroup.LANDS);
		registerItemBlock(registry, THOUGHT_DIRT, MSItemGroup.LANDS);
		registerItemBlock(registry, COARSE_STONE, MSItemGroup.LANDS);
		registerItemBlock(registry, CHISELED_COARSE_STONE, MSItemGroup.LANDS);
		registerItemBlock(registry, SHADE_BRICKS, MSItemGroup.LANDS);
		registerItemBlock(registry, SMOOTH_SHADE_STONE, MSItemGroup.LANDS);
		registerItemBlock(registry, FROST_BRICKS, MSItemGroup.LANDS);
		registerItemBlock(registry, FROST_TILE, MSItemGroup.LANDS);
		registerItemBlock(registry, CHISELED_FROST_BRICKS, MSItemGroup.LANDS);
		registerItemBlock(registry, CAST_IRON, MSItemGroup.LANDS);
		registerItemBlock(registry, CHISELED_CAST_IRON, MSItemGroup.LANDS);
		registerItemBlock(registry, MYCELIUM_BRICKS, MSItemGroup.LANDS);
		registerItemBlock(registry, BLACK_STONE, MSItemGroup.LANDS);
		registerItemBlock(registry, FLOWERY_MOSSY_COBBLESTONE, MSItemGroup.LANDS);
		registerItemBlock(registry, FLOWERY_MOSSY_STONE_BRICKS, MSItemGroup.LANDS);
		registerItemBlock(registry, COARSE_END_STONE, MSItemGroup.LANDS);
		registerItemBlock(registry, END_GRASS, MSItemGroup.LANDS);
		registerItemBlock(registry, CHALK, MSItemGroup.LANDS);
		registerItemBlock(registry, CHALK_BRICKS, MSItemGroup.LANDS);
		registerItemBlock(registry, CHISELED_CHALK_BRICKS, MSItemGroup.LANDS);
		registerItemBlock(registry, POLISHED_CHALK, MSItemGroup.LANDS);
		registerItemBlock(registry, PINK_STONE, MSItemGroup.LANDS);
		registerItemBlock(registry, PINK_STONE_BRICKS, MSItemGroup.LANDS);
		registerItemBlock(registry, CHISELED_PINK_STONE_BRICKS, MSItemGroup.LANDS);
		registerItemBlock(registry, CRACKED_PINK_STONE_BRICKS, MSItemGroup.LANDS);
		registerItemBlock(registry, MOSSY_PINK_STONE_BRICKS, MSItemGroup.LANDS);
		registerItemBlock(registry, POLISHED_PINK_STONE, MSItemGroup.LANDS);
		registerItemBlock(registry, DENSE_CLOUD, MSItemGroup.LANDS);
		registerItemBlock(registry, BRIGHT_DENSE_CLOUD, MSItemGroup.LANDS);
		registerItemBlock(registry, SUGAR_CUBE, MSItemGroup.LANDS);
		
		registerItemBlock(registry, GLOWING_LOG, MSItemGroup.LANDS);
		registerItemBlock(registry, FROST_LOG, MSItemGroup.LANDS);
		registerItemBlock(registry, RAINBOW_LOG, MSItemGroup.LANDS);
		registerItemBlock(registry, END_LOG, MSItemGroup.LANDS);
		registerItemBlock(registry, VINE_LOG, MSItemGroup.LANDS);
		registerItemBlock(registry, FLOWERY_VINE_LOG, MSItemGroup.LANDS);
		registerItemBlock(registry, DEAD_LOG, MSItemGroup.LANDS);
		registerItemBlock(registry, PETRIFIED_LOG, MSItemGroup.LANDS);
		registerItemBlock(registry, GLOWING_WOOD, MSItemGroup.LANDS);
		registerItemBlock(registry, FROST_WOOD, MSItemGroup.LANDS);
		registerItemBlock(registry, RAINBOW_WOOD, MSItemGroup.LANDS);
		registerItemBlock(registry, END_WOOD, MSItemGroup.LANDS);
		registerItemBlock(registry, VINE_WOOD, MSItemGroup.LANDS);
		registerItemBlock(registry, FLOWERY_VINE_WOOD, MSItemGroup.LANDS);
		registerItemBlock(registry, DEAD_WOOD, MSItemGroup.LANDS);
		registerItemBlock(registry, PETRIFIED_WOOD, MSItemGroup.LANDS);
		registerItemBlock(registry, GLOWING_PLANKS, MSItemGroup.LANDS);
		registerItemBlock(registry, FROST_PLANKS, MSItemGroup.LANDS);
		registerItemBlock(registry, RAINBOW_PLANKS, MSItemGroup.LANDS);
		registerItemBlock(registry, END_PLANKS, MSItemGroup.LANDS);
		registerItemBlock(registry, DEAD_PLANKS, MSItemGroup.LANDS);
		registerItemBlock(registry, TREATED_PLANKS, MSItemGroup.LANDS);
		registerItemBlock(registry, FROST_LEAVES, MSItemGroup.LANDS);
		registerItemBlock(registry, RAINBOW_LEAVES, MSItemGroup.LANDS);
		registerItemBlock(registry, END_LEAVES, MSItemGroup.LANDS);
		registerItemBlock(registry, RAINBOW_SAPLING, MSItemGroup.LANDS);
		registerItemBlock(registry, END_SAPLING, MSItemGroup.LANDS);
		
		registerItemBlock(registry, BLOOD_ASPECT_LOG);
		registerItemBlock(registry, BREATH_ASPECT_LOG);
		registerItemBlock(registry, DOOM_ASPECT_LOG);
		registerItemBlock(registry, HEART_ASPECT_LOG);
		registerItemBlock(registry, HOPE_ASPECT_LOG);
		registerItemBlock(registry, LIFE_ASPECT_LOG);
		registerItemBlock(registry, LIGHT_ASPECT_LOG);
		registerItemBlock(registry, MIND_ASPECT_LOG);
		registerItemBlock(registry, RAGE_ASPECT_LOG);
		registerItemBlock(registry, SPACE_ASPECT_LOG);
		registerItemBlock(registry, TIME_ASPECT_LOG);
		registerItemBlock(registry, VOID_ASPECT_LOG);
		registerItemBlock(registry, BLOOD_ASPECT_PLANKS);
		registerItemBlock(registry, BREATH_ASPECT_PLANKS);
		registerItemBlock(registry, DOOM_ASPECT_PLANKS);
		registerItemBlock(registry, HEART_ASPECT_PLANKS);
		registerItemBlock(registry, HOPE_ASPECT_PLANKS);
		registerItemBlock(registry, LIFE_ASPECT_PLANKS);
		registerItemBlock(registry, LIGHT_ASPECT_PLANKS);
		registerItemBlock(registry, MIND_ASPECT_PLANKS);
		registerItemBlock(registry, RAGE_ASPECT_PLANKS);
		registerItemBlock(registry, SPACE_ASPECT_PLANKS);
		registerItemBlock(registry, TIME_ASPECT_PLANKS);
		registerItemBlock(registry, VOID_ASPECT_PLANKS);
		registerItemBlock(registry, BLOOD_ASPECT_LEAVES);
		registerItemBlock(registry, BREATH_ASPECT_LEAVES);
		registerItemBlock(registry, DOOM_ASPECT_LEAVES);
		registerItemBlock(registry, HEART_ASPECT_LEAVES);
		registerItemBlock(registry, HOPE_ASPECT_LEAVES);
		registerItemBlock(registry, LIFE_ASPECT_LEAVES);
		registerItemBlock(registry, LIGHT_ASPECT_LEAVES);
		registerItemBlock(registry, MIND_ASPECT_LEAVES);
		registerItemBlock(registry, RAGE_ASPECT_LEAVES);
		registerItemBlock(registry, SPACE_ASPECT_LEAVES);
		registerItemBlock(registry, TIME_ASPECT_LEAVES);
		registerItemBlock(registry, VOID_ASPECT_LEAVES);
		registerItemBlock(registry, BLOOD_ASPECT_SAPLING, new Item.Properties().rarity(Rarity.UNCOMMON));
		registerItemBlock(registry, BREATH_ASPECT_SAPLING, new Item.Properties().rarity(Rarity.UNCOMMON));
		registerItemBlock(registry, DOOM_ASPECT_SAPLING, new Item.Properties().rarity(Rarity.UNCOMMON));
		registerItemBlock(registry, HEART_ASPECT_SAPLING, new Item.Properties().rarity(Rarity.UNCOMMON));
		registerItemBlock(registry, HOPE_ASPECT_SAPLING, new Item.Properties().rarity(Rarity.UNCOMMON));
		registerItemBlock(registry, LIFE_ASPECT_SAPLING, new Item.Properties().rarity(Rarity.UNCOMMON));
		registerItemBlock(registry, LIGHT_ASPECT_SAPLING, new Item.Properties().rarity(Rarity.UNCOMMON));
		registerItemBlock(registry, MIND_ASPECT_SAPLING, new Item.Properties().rarity(Rarity.UNCOMMON));
		registerItemBlock(registry, RAGE_ASPECT_SAPLING, new Item.Properties().rarity(Rarity.UNCOMMON));
		registerItemBlock(registry, SPACE_ASPECT_SAPLING, new Item.Properties().rarity(Rarity.UNCOMMON));
		registerItemBlock(registry, TIME_ASPECT_SAPLING, new Item.Properties().rarity(Rarity.UNCOMMON));
		registerItemBlock(registry, VOID_ASPECT_SAPLING, new Item.Properties().rarity(Rarity.UNCOMMON));
		
		registerItemBlock(registry, GLOWING_MUSHROOM, MSItemGroup.LANDS);
		registerItemBlock(registry, DESERT_BUSH, MSItemGroup.LANDS);
		registerItemBlock(registry, BLOOMING_CACTUS, MSItemGroup.LANDS);
		registerItemBlock(registry, PETRIFIED_GRASS, MSItemGroup.LANDS);
		registerItemBlock(registry, PETRIFIED_POPPY, MSItemGroup.LANDS);
		registerItemBlock(registry, STRAWBERRY, MSItemGroup.LANDS);
		
		registerItemBlock(registry, GLOWY_GOOP, MSItemGroup.LANDS);
		registerItemBlock(registry, COAGULATED_BLOOD, MSItemGroup.LANDS);
		registerItemBlock(registry, VEIN);
		registerItemBlock(registry, VEIN_CORNER);
		registerItemBlock(registry, INVERTED_VEIN_CORNER);
		
		registerItemBlock(registry, COARSE_STONE_STAIRS, MSItemGroup.LANDS);
		registerItemBlock(registry, SHADE_BRICK_STAIRS, MSItemGroup.LANDS);
		registerItemBlock(registry, FROST_BRICK_STAIRS, MSItemGroup.LANDS);
		registerItemBlock(registry, CAST_IRON_STAIRS, MSItemGroup.LANDS);
		registerItemBlock(registry, MYCELIUM_BRICK_STAIRS, MSItemGroup.LANDS);
		registerItemBlock(registry, CHALK_STAIRS, MSItemGroup.LANDS);
		registerItemBlock(registry, CHALK_BRICK_STAIRS, MSItemGroup.LANDS);
		registerItemBlock(registry, PINK_STONE_BRICK_STAIRS, MSItemGroup.LANDS);
		registerItemBlock(registry, RAINBOW_PLANKS_STAIRS, MSItemGroup.LANDS);
		registerItemBlock(registry, END_PLANKS_STAIRS, MSItemGroup.LANDS);
		registerItemBlock(registry, DEAD_PLANKS_STAIRS, MSItemGroup.LANDS);
		registerItemBlock(registry, TREATED_PLANKS_STAIRS, MSItemGroup.LANDS);
		registerItemBlock(registry, CHALK_SLAB, MSItemGroup.LANDS);
		registerItemBlock(registry, CHALK_BRICK_SLAB, MSItemGroup.LANDS);
		registerItemBlock(registry, PINK_STONE_BRICK_SLAB, MSItemGroup.LANDS);
		registerItemBlock(registry, RAINBOW_PLANKS_SLAB, MSItemGroup.LANDS);
		registerItemBlock(registry, END_PLANKS_SLAB, MSItemGroup.LANDS);
		registerItemBlock(registry, DEAD_PLANKS_SLAB, MSItemGroup.LANDS);
		registerItemBlock(registry, TREATED_PLANKS_SLAB, MSItemGroup.LANDS);
		
		registry.register(new CruxtruderItem(MSBlocks.CRUXTRUDER, new Item.Properties().group(MSItemGroup.MAIN)).setRegistryName("cruxtruder"));
		registerItemBlock(registry, CRUXTRUDER_LID, MSItemGroup.MAIN);
		registry.register(new MultiblockItem(MSBlocks.TOTEM_LATHE, new Item.Properties().group(MSItemGroup.MAIN)).setRegistryName("totem_lathe"));
		registry.register(new MultiblockItem(MSBlocks.ALCHEMITER, new Item.Properties().group(MSItemGroup.MAIN)).setRegistryName("alchemiter"));
		registry.register(new MultiblockItem(MSBlocks.PUNCH_DESIGNIX, new Item.Properties().group(MSItemGroup.MAIN)).setRegistryName("punch_designix"));
		registerItemBlock(registry, new MiniCruxtruderItem(MINI_CRUXTRUDER, new Item.Properties().group(MSItemGroup.MAIN)));
		registerItemBlock(registry, MINI_TOTEM_LATHE, MSItemGroup.MAIN);
		registerItemBlock(registry, MINI_ALCHEMITER, MSItemGroup.MAIN);
		registerItemBlock(registry, MINI_PUNCH_DESIGNIX, MSItemGroup.MAIN);
		registerItemBlock(registry, HOLOPAD, MSItemGroup.MAIN);
		
		registerItemBlock(registry, COMPUTER, MSItemGroup.MAIN);
		registerItemBlock(registry, LAPTOP, MSItemGroup.MAIN);
		registerItemBlock(registry, CROCKERTOP, MSItemGroup.MAIN);
		registerItemBlock(registry, HUBTOP, MSItemGroup.MAIN);
		registerItemBlock(registry, LUNCHTOP, MSItemGroup.MAIN);
		registerItemBlock(registry, OLD_COMPUTER, MSItemGroup.MAIN);
		registerItemBlock(registry, new TransportalizerItem(TRANSPORTALIZER, new Item.Properties().group(MSItemGroup.MAIN)));
		registerItemBlock(registry, new SendificatorBlockItem(SENDIFICATOR, new Item.Properties().group(MSItemGroup.MAIN).maxStackSize(1)));
		registerItemBlock(registry, GRIST_WIDGET, new Item.Properties().group(MSItemGroup.MAIN).rarity(Rarity.UNCOMMON));
		registerItemBlock(registry, URANIUM_COOKER, MSItemGroup.MAIN);
		
		registerItemBlock(registry, new DowelItem(CRUXITE_DOWEL, new Item.Properties().group(MSItemGroup.MAIN)));
		
		registerItemBlock(registry, GOLD_SEEDS, MSItemGroup.MAIN);
		registerItemBlock(registry, WOODEN_CACTUS, MSItemGroup.MAIN);
		
		registerItemBlock(registry, new BlockItem(APPLE_CAKE, new Item.Properties().group(MSItemGroup.MAIN).maxStackSize(1)));
		registerItemBlock(registry, new BlockItem(BLUE_CAKE, new Item.Properties().group(MSItemGroup.MAIN).maxStackSize(1)));
		registerItemBlock(registry, new BlockItem(COLD_CAKE, new Item.Properties().group(MSItemGroup.MAIN).maxStackSize(1)));
		registerItemBlock(registry, new BlockItem(RED_CAKE, new Item.Properties().group(MSItemGroup.MAIN).maxStackSize(1)));
		registerItemBlock(registry, new BlockItem(HOT_CAKE, new Item.Properties().group(MSItemGroup.MAIN).maxStackSize(1)));
		registerItemBlock(registry, new BlockItem(REVERSE_CAKE, new Item.Properties().group(MSItemGroup.MAIN).maxStackSize(1)));
		registerItemBlock(registry, new BlockItem(FUCHSIA_CAKE, new Item.Properties().group(MSItemGroup.MAIN).maxStackSize(1)));
		registerItemBlock(registry, new BlockItem(NEGATIVE_CAKE, new Item.Properties().group(MSItemGroup.MAIN).maxStackSize(1)));
		
		registerItemBlock(registry, PRIMED_TNT, MSItemGroup.MAIN);
		registerItemBlock(registry, UNSTABLE_TNT, MSItemGroup.MAIN);
		registerItemBlock(registry, INSTANT_TNT, MSItemGroup.MAIN);
		registerItemBlock(registry, WOODEN_EXPLOSIVE_BUTTON, MSItemGroup.MAIN);
		registerItemBlock(registry, STONE_EXPLOSIVE_BUTTON, MSItemGroup.MAIN);
		
		registerItemBlock(registry, BLENDER, MSItemGroup.MAIN);
		registerItemBlock(registry, CHESSBOARD, MSItemGroup.MAIN);
		registerItemBlock(registry, MINI_FROG_STATUE, MSItemGroup.MAIN);
		registerItemBlock(registry, CASSETTE_PLAYER, MSItemGroup.MAIN);
		
		registerItemBlock(registry, GLOWYSTONE_DUST, MSItemGroup.MAIN);
		
		//hammers
		registry.register(new WeaponItem(ItemTier.IRON, 2, -2.4F, 1.0F, MSItemTypes.HAMMER_TOOL, new Item.Properties().defaultMaxDamage(131).group(MSItemGroup.WEAPONS)).setRegistryName("claw_hammer"));
		registry.register(new WeaponItem(ItemTier.IRON, 4, -2.8F, 4.0F, MSItemTypes.HAMMER_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("sledge_hammer"));
		registry.register(new WeaponItem(ItemTier.WOOD, 4, -2.8F, 1.0F, MSItemTypes.MISC_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("mailbox"));
		registry.register(new WeaponItem(ItemTier.IRON, 5, -2.8F, 3.5F, MSItemTypes.HAMMER_TOOL, new Item.Properties().defaultMaxDamage(450).group(MSItemGroup.WEAPONS)).setRegistryName("blacksmith_hammer"));
		registry.register(new PogoWeaponItem(MSItemTypes.POGO_TIER, 5, -2.8F, 2.0F, 0.7, MSItemTypes.HAMMER_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("pogo_hammer"));
		registry.register(new PogoWeaponItem(MSItemTypes.POGO_TIER, 7, -2.8F, 2.0F, 0.4, MSItemTypes.HAMMER_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("wrinklefucker"));
		registry.register(new WeaponItem(MSItemTypes.BOOK_TIER, 8, -2.9F, 5.0F, MSItemTypes.HAMMER_TOOL, new Item.Properties().defaultMaxDamage(1024).group(MSItemGroup.WEAPONS)).setRegistryName("telescopic_sassacrusher"));
		registry.register(new WeaponItem(ItemTier.IRON, 4, -2.8F, 1.0F, MSItemTypes.HAMMER_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("democratic_demolitioner"));
		registry.register(new WeaponItem(MSItemTypes.REGI_TIER, 3, -2.4F, 8.0F, MSItemTypes.HAMMER_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("regi_hammer"));
		registry.register(new SlownessAOEWeaponItem(MSItemTypes.RUBY_TIER, 6, -2.8F, 7.0F, new EffectInstance(Effects.SLOWNESS, 100, 4), TIME, MSItemTypes.HAMMER_TOOL, new Item.Properties().defaultMaxDamage(4096).group(MSItemGroup.WEAPONS)).setRegistryName("fear_no_anvil"));
		registry.register(new FireWeaponItem(MSItemTypes.RUBY_TIER, 6, -2.8F, 12.0F, 25,  MSItemTypes.HAMMER_TOOL, new Item.Properties().defaultMaxDamage(1413).group(MSItemGroup.WEAPONS)).setRegistryName("melt_masher"));
		registry.register(new PogoFarmineItem(MSItemTypes.RUBY_TIER, 5, -2.8F, 9.0F, Integer.MAX_VALUE, 200, 0.7, MSItemTypes.MULTI_TOOL,  new Item.Properties().defaultMaxDamage(6114).group(MSItemGroup.WEAPONS)).setRegistryName("estrogen_empowered_everything_eradicator"));
		registry.register(new SbahjEEEEItem(MSItemTypes.RUBY_TIER, 5, -2.8F, 9.1F, 0.2,  MSItemTypes.HAMMER_TOOL, new Item.Properties().defaultMaxDamage(6114).group(MSItemGroup.WEAPONS)).setRegistryName("eeeeeeeeeeee"));
		registry.register(new WeaponItem(MSItemTypes.ZILLYHOO_TIER, 6, -2.8F, 15.0F,  MSItemTypes.HAMMER_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS).rarity(Rarity.RARE)).setRegistryName("zillyhoo_hammer"));
		registry.register(new RandomWeaponItem(MSItemTypes.ZILLYHOO_TIER, 3, -2.8F, 15.0F,  MSItemTypes.HAMMER_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("popamatic_vrillyhoo"));
		registry.register(new FireWeaponItem(MSItemTypes.RUBY_TIER, 6, -2.8F, 4.0F, 50,  MSItemTypes.HAMMER_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("scarlet_zillyhoo"));
		registry.register(new WeaponItem(MSItemTypes.RUBY_TIER, 7, -2.8F, 4.0F,  MSItemTypes.HAMMER_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("mwrthwl"));
		
		//blades
		registry.register(new SordItem(MSItemTypes.SBAHJ_TIER, 3, -2.4F, 1.0F,  MSItemTypes.SWORD_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("sord"));
		registry.register(new WeaponItem(MSItemTypes.PAPER_TIER, 2, -2.4F, 3.0F, MSItemTypes.SWORD_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("paper_sword"));
		registry.register(new WeaponItem(MSItemTypes.CACTUS_TIER, 3, -2.4F, 15.0F, MSItemTypes.SWORD_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("cactaceae_cutlass"));	//The sword harvestTool is only used against webs, hence the high efficiency.
		registry.register(new ConsumableWeaponItem(MSItemTypes.MEAT_TIER, 4, -2.4F, 5.0F, 8, 1F, MSItemTypes.SWORD_TOOL, new Item.Properties().defaultMaxDamage(250).group(MSItemGroup.WEAPONS)).setRegistryName("steak_sword"));
		registry.register(new ConsumableWeaponItem(MSItemTypes.MEAT_TIER, 2, -2.4F, 5.0F, 3, 0.8F, 75, MSItemTypes.SWORD_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("beef_sword"));
		registry.register(new ConsumableWeaponItem(MSItemTypes.MEAT_TIER, 2, -2.4F, 5.0F, 4, 0.4F, 25, MSItemTypes.SWORD_TOOL, new Item.Properties().defaultMaxDamage(150).group(MSItemGroup.WEAPONS)).setPotionEffect(new EffectInstance(Effects.WITHER, 100, 1), 0.9F).setRegistryName("irradiated_steak_sword"));
		registry.register(new WeaponItem(MSItemTypes.PRISMARINE_TIER, 3, -2.4F, 1.0F, MSItemTypes.SWORD_TOOL, new Item.Properties().defaultMaxDamage(100).group(MSItemGroup.WEAPONS)).setRegistryName("macuahuitl"));
		registry.register(new FrozenWeaponItem(MSItemTypes.ICE_TIER, 6, -2.4F, 1.0F, MSItemTypes.SWORD_TOOL, new Item.Properties().defaultMaxDamage(200).group(MSItemGroup.WEAPONS)).setRegistryName("frosty_macuahuitl"));
		registry.register(new WeaponItem(ItemTier.IRON, 3, -2.4F, 15.0F, MSItemTypes.SWORD_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("katana"));
		registry.register(new WeaponItem(MSItemTypes.RUBY_TIER, 3, -2.4F, 15.0F, MSItemTypes.SWORD_TOOL, new Item.Properties().defaultMaxDamage(-1).group(MSItemGroup.WEAPONS)).setRegistryName("unbreakable_katana"));	//Actually unbreakable
		registry.register(new AspectBasedEffectWeaponItem(ItemTier.IRON, 5, -2.4F, 15.0F, HOPE, () -> new EffectInstance(Effects.RESISTANCE, 60, 2), MSItemTypes.SWORD_TOOL, new Item.Properties().defaultMaxDamage(2048).group(MSItemGroup.WEAPONS)).setRegistryName("angel_apocalypse"));
		registry.register(new FireWeaponItem(ItemTier.IRON, 4, -2.4F, 15.0F,  30, MSItemTypes.SWORD_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("fire_poker"));
		registry.register(new FireWeaponItem(ItemTier.IRON, 3, -2.4F, 15.0F, 10, MSItemTypes.SWORD_TOOL, new Item.Properties().defaultMaxDamage(350).group(MSItemGroup.WEAPONS)).setRegistryName("too_hot_to_handle"));
		registry.register(new WeaponItem(MSItemTypes.RUBY_TIER, 2, -2.4F, 15.0F, MSItemTypes.SWORD_TOOL, new Item.Properties().defaultMaxDamage(1561).group(MSItemGroup.WEAPONS)).setRegistryName("caledscratch"));
		registry.register(new WeaponItem(MSItemTypes.RUBY_TIER, 2, -2.4F, 15.0F, MSItemTypes.SWORD_TOOL, new Item.Properties().defaultMaxDamage(1025).group(MSItemGroup.WEAPONS)).setRegistryName("caledfwlch"));
		registry.register(new WeaponItem(MSItemTypes.RUBY_TIER, 3, -2.4F, 15.0F, MSItemTypes.SWORD_TOOL, new Item.Properties().defaultMaxDamage(1561).group(MSItemGroup.WEAPONS)).setRegistryName("royal_deringer"));
		registry.register(new WeaponItem(ItemTier.IRON, 5, -2.6F, 15.0F, MSItemTypes.SWORD_TOOL, new Item.Properties().defaultMaxDamage(600).group(MSItemGroup.WEAPONS)).setRegistryName("claymore"));
		registry.register(new WeaponItem(MSItemTypes.ZILLYHOO_TIER, 3, -2.4F, 15.0F, MSItemTypes.SWORD_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS).rarity(Rarity.RARE)).setRegistryName("cutlass_of_zillywair"));
		registry.register(new WeaponItem(MSItemTypes.REGI_TIER, 3, -2.4F, 15.0F, MSItemTypes.SWORD_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("regisword"));
		registry.register(new WeaponItem(MSItemTypes.RUBY_TIER, 4, -2.4F, 15.0F, MSItemTypes.SWORD_TOOL, new Item.Properties().defaultMaxDamage(4096).group(MSItemGroup.WEAPONS)).setRegistryName("cruel_fate_crucible"));
		registry.register(new WeaponItem(MSItemTypes.RUBY_TIER, 3, -2.4F, 15.0F, MSItemTypes.SWORD_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("scarlet_ribbitar"));
		registry.register(new WeaponItem(MSItemTypes.RUBY_TIER, 1, -2.4F, 15.0F, MSItemTypes.SWORD_TOOL, new Item.Properties().defaultMaxDamage(1000).group(MSItemGroup.WEAPONS)).setRegistryName("dogg_machete"));
		registry.register(new FireWeaponItem(ItemTier.GOLD, 7, -2.4F, 15.0F, 30, MSItemTypes.SWORD_TOOL, new Item.Properties().defaultMaxDamage(300).group(MSItemGroup.WEAPONS)).setRegistryName("cobalt_sabre"));
		registry.register(new PotionWeaponItem(MSItemTypes.URANIUM_TIER, 4, -2.4F, 15.0F, new EffectInstance(Effects.WITHER, 100, 1), MSItemTypes.SWORD_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("quantum_sabre"));
		registry.register(new WeaponItem(MSItemTypes.RUBY_TIER, 6, -2.4F, 15.0F, MSItemTypes.SWORD_TOOL, new Item.Properties().defaultMaxDamage(1850).group(MSItemGroup.WEAPONS)).setRegistryName("shatter_beacon"));
		
		//axes
		registry.register(new SordItem(MSItemTypes.SBAHJ_TIER, 5, -3.5F, 1.0F, MSItemTypes.AXE_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("batleacks"));
		registry.register(new FarmineItem(ItemTier.STONE, 5, -3.0F, 6.0F, Integer.MAX_VALUE, 20, MSItemTypes.AXE_TOOL, new Item.Properties().defaultMaxDamage(400).group(MSItemGroup.WEAPONS)).setRegistryName("copse_crusher"));
		registry.register(new ConsumableWeaponItem(MSItemTypes.FRUIT_TIER, 7, -3.0F, 2.0F, 6, 0.6F, 75, MSItemTypes.AXE_TOOL, new Item.Properties().defaultMaxDamage(500).group(MSItemGroup.WEAPONS)).setRegistryName("quench_crusher"));
		registry.register(new MelonWeaponItem(MSItemTypes.FRUIT_TIER, 8, -3.0F, 3.0F, true,0.6F, 20, () -> Items.MELON_SLICE, () -> Blocks.MELON, MSItemTypes.AXE_TOOL, new Item.Properties().defaultMaxDamage(400).group(MSItemGroup.WEAPONS)).setRegistryName("melonsbane"));
		registry.register(new DoubleHarvestWeaponItem(ItemTier.STONE, 6, -3.0F, 3.0F, MSItemTypes.AXE_TOOL, new Item.Properties().defaultMaxDamage(800).group(MSItemGroup.WEAPONS)).setRegistryName("crop_chop"));
		registry.register(new DoubleHarvestWeaponItem(ItemTier.STONE, 8, -3.0F, 3.0F, MSItemTypes.AXE_TOOL, new Item.Properties().defaultMaxDamage(950).group(MSItemGroup.WEAPONS)).setRegistryName("the_last_straw"));
		registry.register(new WeaponItem(ItemTier.IRON, 8, -3.0F, 3.0F, MSItemTypes.AXE_TOOL, new Item.Properties().defaultMaxDamage(600).group(MSItemGroup.WEAPONS)).setRegistryName("battleaxe"));
		registry.register(new CandyWeaponItem(MSItemTypes.CANDY_TIER, 9, -3.0F, 2.0F, MSItemTypes.AXE_TOOL, new Item.Properties().defaultMaxDamage(111).group(MSItemGroup.WEAPONS)).setRegistryName("candy_battleaxe"));
		registry.register(new ConsumableWeaponItem(MSItemTypes.CANDY_TIER, 10, -3.0F, 2.0F, 8, 0.4F, MSItemTypes.AXE_TOOL, new Item.Properties().defaultMaxDamage(350).group(MSItemGroup.WEAPONS)).setRegistryName("choco_loco_woodsplitter"));
		registry.register(new CandyWeaponItem(ItemTier.IRON, 9, -3.0F, 3.0F, MSItemTypes.AXE_TOOL, new Item.Properties().defaultMaxDamage(800).group(MSItemGroup.WEAPONS)).setRegistryName("steel_edge_candycutter"));
		registry.register(new WeaponItem(ItemTier.STONE, 8, -3.0F, 6.0F, MSItemTypes.AXE_TOOL, new Item.Properties().defaultMaxDamage(413).group(MSItemGroup.WEAPONS)).setRegistryName("blacksmith_bane"));
		registry.register(new WeaponItem(MSItemTypes.REGI_TIER, 7, -3.0F, 6.0F, MSItemTypes.AXE_TOOL, new Item.Properties().defaultMaxDamage(600).group(MSItemGroup.WEAPONS)).setRegistryName("regiaxe"));
		registry.register(new KundlerSurpriseWeaponItem(ItemTier.IRON, 8, -3.0F, 6.0F, MSItemTypes.AXE_TOOL, new Item.Properties().defaultMaxDamage(600).group(MSItemGroup.WEAPONS)).setRegistryName("surprise_axe"));
		registry.register(new ElectricWeaponItem(ItemTier.IRON, 9, -3.0F, 6.0F, true, () -> SHOCK_AXE_UNPOWERED, MSItemTypes.AXE_TOOL, new Item.Properties().defaultMaxDamage(800).group(MSItemGroup.WEAPONS)).setRegistryName("shock_axe"));
		registry.register(new DualWeaponItem(ItemTier.IRON, 9, -3.0F, 6.0F, () -> SHOCK_AXE, MSItemTypes.AXE_TOOL, new Item.Properties().defaultMaxDamage(800)).setRegistryName("shock_axe_unpowered"));
		registry.register(new WeaponItem(ItemTier.IRON, 8, -3.0F, 7.0F, MSItemTypes.AXE_TOOL, new Item.Properties().defaultMaxDamage(500).group(MSItemGroup.WEAPONS)).setRegistryName("scraxe"));
		registry.register(new TeleportingWeaponItem(ItemTier.IRON, 6, -3.0F, 7.0F, MSItemTypes.AXE_TOOL, new Item.Properties().defaultMaxDamage(2048).group(MSItemGroup.WEAPONS)).setRegistryName("lorentz_distransformationer"));
		registry.register(new PogoFarmineItem(MSItemTypes.POGO_TIER, 6, -3.0F, 2.0F, Integer.MAX_VALUE, 50, 0.6, MSItemTypes.AXE_HAMMER_TOOL, new Item.Properties().defaultMaxDamage(800).group(MSItemGroup.WEAPONS)).setRegistryName("piston_powered_pogo_axehammer"));
		registry.register(new WeaponItem(MSItemTypes.RUBY_TIER, 7, -3.0F, 8.0F, MSItemTypes.AXE_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("ruby_croak"));
		registry.register(new FireWeaponItem(MSItemTypes.RUBY_TIER, 7, -3.0F, 9.0F, 30, MSItemTypes.AXE_TOOL, new Item.Properties().defaultMaxDamage(3000).group(MSItemGroup.WEAPONS)).setRegistryName("hephaestus_lumberjack"));
		registry.register(new PogoFarmineItem(MSItemTypes.URANIUM_TIER, 7, -3.0F, 5.0F, Integer.MAX_VALUE, 100, 0.7, MSItemTypes.AXE_HAMMER_TOOL, new Item.Properties().defaultMaxDamage(2048).group(MSItemGroup.WEAPONS)).setRegistryName("fission_focused_fault_feller"));
		registry.register(new WeaponItem(ItemTier.IRON, 9, -3.2F, 5.0F, MSItemTypes.AXE_TOOL, new Item.Properties().defaultMaxDamage(600).group(MSItemGroup.WEAPONS)).setRegistryName("bisector"));
		
		//Dice
		registry.register(new WeaponItem(ItemTier.STONE, 5, -3.0F, 1.0F, MSItemTypes.NONE, new Item.Properties().defaultMaxDamage(500).group(MSItemGroup.WEAPONS)).setRegistryName("dice"));
		registry.register(new WeaponItem(ItemTier.DIAMOND, 12, -3.0F, 1.0F, MSItemTypes.NONE, new Item.Properties().defaultMaxDamage(4096).group(MSItemGroup.WEAPONS)).setRegistryName("fluorite_octet"));
		//misc weapons
		registry.register(new DualWeaponItem(ItemTier.IRON, 2, -1.5F, 10.0F, () -> MSItems.CAT_CLAWS_SHEATHED, MSItemTypes.CLAWS_TOOL, new Item.Properties().defaultMaxDamage(500).group(MSItemGroup.WEAPONS)).setRegistryName("cat_claws_drawn"));
		registry.register(new DualWeaponItem(ItemTier.IRON, -1, -1.0F, 10.0F, () -> MSItems.CAT_CLAWS_DRAWN, MSItemTypes.NONE, new Item.Properties().defaultMaxDamage(500)).setRegistryName("cat_claws_sheathed"));
		
		registry.register(new DualWeaponItem(ItemTier.IRON, 2, -1.5F, 10.0F, () -> MSItems.LIPSTICK, MSItemTypes.AXE_TOOL, new Item.Properties().defaultMaxDamage(250).group(MSItemGroup.WEAPONS)).setRegistryName("lipstick_chainsaw"));
		registry.register(new DualWeaponItem(ItemTier.WOOD, -1, -0.5F, 10.0F, () -> MSItems.LIPSTICK_CHAINSAW, MSItemTypes.NONE, new Item.Properties().defaultMaxDamage(250).group(MSItemGroup.WEAPONS)).setRegistryName("lipstick"));
		
		registry.register(new WeaponItem(ItemTier.STONE, 4, -2.8F, 2.0F, MSItemTypes.MISC_TOOL, new Item.Properties().maxDamage(450).group(MSItemGroup.WEAPONS)).setRegistryName("cigarette_lance"));
		
		registry.register(new WeaponItem(ItemTier.IRON, 3, -2.5F, 1.0F, MSItemTypes.MISC_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("lucerne_hammer"));
		registry.register(new WeaponItem(ItemTier.IRON, 4, -2.5F, 1.0F, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(2048).group(MSItemGroup.WEAPONS)).setRegistryName("lucerne_hammer_of_undying"));
		
		registry.register(new WeaponItem(MSItemTypes.PRISMARINE_TIER, 2, -2.0F, 1.5F, MSItemTypes.MISC_TOOL, new Item.Properties().maxDamage(100).group(MSItemGroup.WEAPONS)).setRegistryName("obsidian_axe_knife"));
		
		registry.register(new KnockbackWeaponItem(ItemTier.WOOD, 1, -1.0F, 1.5F, MSItemTypes.MISC_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("fan"));
		registry.register(new LevitationAOEWeaponItem(MSItemTypes.RUBY_TIER, 2, -1.0F, 1.5F, BREATH, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(4096).rarity(Rarity.RARE).group(MSItemGroup.WEAPONS)).setRegistryName("typhonic_trivializer"));
		
		//sickles
		registry.register(new WeaponItem(ItemTier.IRON, 2, -2.4F, 1.5F, MSItemTypes.SICKLE_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("sickle"));
		registry.register(new SordItem(MSItemTypes.SBAHJ_TIER, 3, -2.4F, 1.0F, MSItemTypes.SICKLE_TOOL, new Item.Properties().defaultMaxDamage(25).group(MSItemGroup.WEAPONS)).setRegistryName("ow_the_edge"));
		registry.register(new WeaponItem(MSItemTypes.CACTUS_TIER, 4, -2.4F, 1.0F, MSItemTypes.SICKLE_TOOL, new Item.Properties().defaultMaxDamage(300).group(MSItemGroup.WEAPONS)).setRegistryName("thorny_subject"));
		registry.register(new WeaponItem(ItemTier.IRON, 4, -2.4F, 3.0F, MSItemTypes.SICKLE_TOOL, new Item.Properties().defaultMaxDamage(400).group(MSItemGroup.WEAPONS)).setRegistryName("homes_smell_ya_later"));
		registry.register(new WeaponItem(ItemTier.IRON, 5, -2.4F, 1.0F, MSItemTypes.SICKLE_TOOL, new Item.Properties().defaultMaxDamage(550).group(MSItemGroup.WEAPONS)).setRegistryName("hemeoreaper"));
		registry.register(new ConsumableWeaponItem(MSItemTypes.CANDY_TIER, 5, -2.4F, 1.0F, 7, 0.6F, MSItemTypes.SICKLE_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("fudgesickle"));
		registry.register(new WeaponItem(MSItemTypes.REGI_TIER, 3, -2.4F, 4.0F, MSItemTypes.SICKLE_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("regisickle"));
		registry.register(new WeaponItem(MSItemTypes.RUBY_TIER, 4, -2.4F, 4.0F, MSItemTypes.SICKLE_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("claw_sickle"));
		registry.register(new HorrorterrorWeaponItem(MSItemTypes.HORRORTERROR_TIER, 6, -2.4F, 4.0F, MSItemTypes.SICKLE_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("claw_of_nrubyiglith"));
		registry.register(new CandyWeaponItem(MSItemTypes.CANDY_TIER, 6, -2.4F, 2.5F, MSItemTypes.SICKLE_TOOL, new Item.Properties().defaultMaxDamage(96).group(MSItemGroup.WEAPONS)).setRegistryName("candy_sickle"));
		
		//clubs
		registry.register(new WeaponItem(ItemTier.WOOD, 3, -2.2F, 2.0F, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(1024).group(MSItemGroup.WEAPONS)).setRegistryName("deuce_club"));
		registry.register(new BaguetteWeaponItem(MSItemTypes.BAGUETTE_TIER, 3, -2.2F, 2.0F, 3, 0.2F, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(50).group(MSItemGroup.WEAPONS)).setRegistryName("stale_baguette"));
		registry.register(new NoisyWeaponItem(MSItemTypes.MEAT_TIER, 4, -2.2F, 2.0F, () -> SoundEvents.ENTITY_GUARDIAN_FLOP, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(750).group(MSItemGroup.WEAPONS)).setRegistryName("glub_club"));
		registry.register(new WeaponItem(MSItemTypes.REGI_TIER, 1, -2.2F, 2.0F, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(600).group(MSItemGroup.WEAPONS)).setRegistryName("night_club"));
		registry.register(new WeaponItem(MSItemTypes.PRISMARINE_TIER, 3, -2.2F, 2.0F, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(500).group(MSItemGroup.WEAPONS)).setRegistryName("prismarine_basher"));
		registry.register(new FrozenWeaponItem(MSItemTypes.ICE_TIER, 5, -2.2F, 2.0F, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(250).group(MSItemGroup.WEAPONS)).setRegistryName("club_zero"));
		registry.register(new PogoWeaponItem(MSItemTypes.POGO_TIER, 2, -2.2F, 2.0F, 0.5, MSItemTypes.MISC_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("pogo_club"));
		registry.register(new WeaponItem(ItemTier.IRON, 3, -2.2F, 2.0F, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(750).group(MSItemGroup.WEAPONS)).setRegistryName("metal_bat"));
		registry.register(new AspectBasedEffectWeaponItem(ItemTier.IRON, 3, -2.2F, 2.0F, RAGE, () -> new EffectInstance(Effects.STRENGTH, 60, 1), MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(2048).group(MSItemGroup.WEAPONS)).setRegistryName("clown_club"));
		registry.register(new WeaponItem(ItemTier.WOOD, 5, -2.2F, 2.0F, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(500).group(MSItemGroup.WEAPONS)).setRegistryName("spiked_club"));
		
		registry.register(new DualWeaponItem(ItemTier.IRON, 4, -2.0F, 2.0F, () -> MSItems.ACE_OF_SPADES, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(500).group(MSItemGroup.WEAPONS)).setRegistryName("horse_hitcher"));
		registry.register(new DualWeaponItem(MSItemTypes.PAPER_TIER, 0, -1.8F, 0.0F, () -> MSItems.HORSE_HITCHER, MSItemTypes.NONE, new Item.Properties().defaultMaxDamage(500).group(MSItemGroup.WEAPONS)).setRegistryName("ace_of_spades"));
		registry.register(new DualWeaponItem(ItemTier.IRON, 5, -2.0F, 2.0F, () -> MSItems.ACE_OF_CLUBS, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(500).group(MSItemGroup.WEAPONS).group(MSItemGroup.WEAPONS)).setRegistryName("club_of_felony"));
		registry.register(new DualWeaponItem(MSItemTypes.PAPER_TIER, 0, -1.8F, 0.0F, () -> MSItems.CLUB_OF_FELONY, MSItemTypes.NONE, new Item.Properties().defaultMaxDamage(500).group(MSItemGroup.WEAPONS)).setRegistryName("ace_of_clubs"));
		registry.register(new DualWeaponItem(ItemTier.IRON, 5, -2.0F, 2.0F, () -> MSItems.ACE_OF_DIAMONDS, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(500).group(MSItemGroup.WEAPONS)).setRegistryName("cuestick"));
		registry.register(new DualWeaponItem(MSItemTypes.PAPER_TIER, 0, -1.8F, 0.0F, () -> MSItems.CUESTICK, MSItemTypes.NONE, new Item.Properties().defaultMaxDamage(500).group(MSItemGroup.WEAPONS)).setRegistryName("ace_of_diamonds"));
		registry.register(new Item(new Item.Properties().defaultMaxDamage(500)).setRegistryName("ace_of_hearts"));
		registry.register(new WeaponItem(MSItemTypes.REGI_TIER, 4, -2.2F, 4.0F, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(2048).group(MSItemGroup.WEAPONS)).setRegistryName("white_kings_scepter"));
		registry.register(new WeaponItem(MSItemTypes.REGI_TIER, 4, -2.2F, 4.0F, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(2048).group(MSItemGroup.WEAPONS)).setRegistryName("black_kings_scepter"));
		
		
		//canes
		registry.register(new WeaponItem(ItemTier.WOOD, 2, -2.0F, 1.0F, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(100).group(MSItemGroup.WEAPONS)).setRegistryName("cane"));
		registry.register(new WeaponItem(ItemTier.WOOD, 2, -2.0F, 1.0F, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(150).group(MSItemGroup.WEAPONS)).setRegistryName("vaudeville_hook"));
		registry.register(new GivePotionEffectWeaponItem(ItemTier.WOOD, 3, -2.0F, 1.0F, false, () -> Effects.STRENGTH, 140, 1, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(150).group(MSItemGroup.WEAPONS)).setRegistryName("bear_poking_stick"));
		registry.register(new NoisyWeaponItem(ItemTier.IRON, 2, -2.2F, 1.0F, () -> SoundEvents.BLOCK_ANVIL_PLACE, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(-1).group(MSItemGroup.WEAPONS)).setRegistryName("crowbar"));
		registry.register(new PassiveAspectBasedEffectWeaponItem(ItemTier.WOOD, 2, -2.0F, 1.0F, BREATH, () -> new EffectInstance(Effects.SLOW_FALLING, 2, 2), MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(350).group(MSItemGroup.WEAPONS)).setRegistryName("umbrella"));
		registry.register(new BaguetteWeaponItem(MSItemTypes.BAGUETTE_TIER, 3, -2.0F, 2.0F, 4, 0.5F, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(249).group(MSItemGroup.WEAPONS)).setRegistryName("upper_crust_crust_cane"));
		registry.register(new WeaponItem(ItemTier.IRON, 2, -2.0F, 1.0F, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(450).group(MSItemGroup.WEAPONS)).setRegistryName("iron_cane"));
		registry.register(new WeaponItem(ItemTier.IRON, 3, -2.0F, 1.0F, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(300).group(MSItemGroup.WEAPONS)).setRegistryName("spear_cane"));
		registry.register(new WeaponItem(MSItemTypes.CANDY_TIER, 3, -2.0F, 1.0F, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(175).group(MSItemGroup.WEAPONS)).setRegistryName("paradises_portabello"));
		registry.register(new WeaponItem(MSItemTypes.REGI_TIER, 3, -2.0F, 1.0F, MSItemTypes.MISC_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("regi_cane"));
		registry.register(new PogoWeaponItem(MSItemTypes.POGO_TIER, 2, -2.0F, 1.0F, 0.6, MSItemTypes.MISC_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("pogo_cane"));
		registry.register(new CandyCaneWeaponItem(MSItemTypes.CANDY_TIER, 3, -2.0F, 1.0F, 2, 0.3F, MSItemTypes.MISC_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS).defaultMaxDamage(200)).setRegistryName("candy_cane"));
		registry.register(new CandyWeaponItem(MSItemTypes.CANDY_TIER, 5, -2.0F, 1.0F, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(150).group(MSItemGroup.WEAPONS)).setRegistryName("sharp_candy_cane"));
		
		registry.register(new WeaponItem(ItemTier.WOOD, 3, -2.0F, 1.0F, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(175).group(MSItemGroup.WEAPONS)).setRegistryName("prim_and_proper_walking_pole"));
		registry.register(new DualWeaponItem(ItemTier.IRON, 2, -2.0F, 1.0F, () -> MSItems.LESS_PROPER_WALKING_STICK_SHEATHED, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(600).group(MSItemGroup.WEAPONS)).setRegistryName("less_proper_walking_stick"));
		registry.register(new DualWeaponItem(ItemTier.WOOD, 3, -2.0F, 1.0F, () -> MSItems.LESS_PROPER_WALKING_STICK, MSItemTypes.NONE, new Item.Properties().defaultMaxDamage(600)).setRegistryName("less_proper_walking_stick_sheathed"));
		registry.register(new DualWeaponItem(ItemTier.IRON, 3, -2.0F, 1.0F, () -> MSItems.ROCKEFELLERS_WALKING_BLADECANE_SHEATHED, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(800).group(MSItemGroup.WEAPONS)).setRegistryName("rockefellers_walking_bladecane"));
		registry.register(new DualWeaponItem(ItemTier.WOOD, 4, -2.0F, 1.0F, () -> MSItems.ROCKEFELLERS_WALKING_BLADECANE, MSItemTypes.NONE, new Item.Properties().defaultMaxDamage(800)).setRegistryName("rockefellers_walking_bladecane_sheathed"));
		registry.register(new DualWeaponItem(ItemTier.WOOD, 6, -2.0F, 1.0F, () -> MSItems.DRAGON_CANE_UNSHEATHED, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(550).group(MSItemGroup.WEAPONS)).setRegistryName("dragon_cane"));
		registry.register(new DualWeaponItem(MSItemTypes.RUBY_TIER, 3, -2.0F, 1.0F, () -> MSItems.DRAGON_CANE, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(550)).setRegistryName("dragon_cane_unsheathed"));
		
		//Spoons/forks
		registry.register(new WeaponItem(ItemTier.WOOD, 2, -2.2F, 1.0F, MSItemTypes.SHOVEL_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("wooden_spoon"));
		registry.register(new WeaponItem(ItemTier.IRON, 1, -2.2F, 1.0F, MSItemTypes.SHOVEL_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("silver_spoon"));
		registry.register(new AspectBasedEffectWeaponItem(ItemTier.IRON, 1, -2.2F, 1.0F, LIFE, () -> new EffectInstance(Effects.SATURATION, 1, 2), MSItemTypes.SHOVEL_TOOL, new Item.Properties().defaultMaxDamage(2048).group(MSItemGroup.WEAPONS)).setRegistryName("nosferatu_spoon"));
		registry.register(new DualWeaponItem(MSItemTypes.RUBY_TIER, 0, -2.2F, 1.0F, () -> MSItems.CROCKER_FORK, MSItemTypes.SHOVEL_TOOL, new Item.Properties().defaultMaxDamage(512).group(MSItemGroup.WEAPONS)).setRegistryName("crocker_spoon"));
		registry.register(new DualWeaponItem(MSItemTypes.RUBY_TIER, 2, -2.6F, 1.0F, () -> MSItems.CROCKER_SPOON, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(512)).setRegistryName("crocker_fork"));
		registry.register(new WeaponItem(MSItemTypes.REGI_TIER, 5, -2.2F, 1.0F, MSItemTypes.MISC_TOOL, new Item.Properties().defaultMaxDamage(2048).group(MSItemGroup.WEAPONS)).setRegistryName("skaia_fork"));
		registry.register(new WeaponItem(ItemTier.STONE, 3, -2.2F, 1.0F, MSItemTypes.MISC_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("fork"));
		registry.register(new NoisyWeaponItem(ItemTier.IRON, 3, -2.2F, 1.0F, () -> SoundEvents.BLOCK_NOTE_BLOCK_CHIME, MSItemTypes.MISC_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("tuning_fork"));
		registry.register(new WeaponItem(ItemTier.STONE, 4, -2.3F, 1.0F, MSItemTypes.SHOVEL_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("spork"));
		registry.register(new WeaponItem(ItemTier.GOLD, 5, -2.3F, 1.0F, MSItemTypes.SHOVEL_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("golden_spork"));
		registry.register(new WeaponItem(ItemTier.IRON, 7, -2.9F, 1.0F, MSItemTypes.MISC_TOOL, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("bident"));

		registry.register(new SwordItem(MSItemTypes.EMERALD_TIER, 3, -2.4F, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("emerald_sword"));
		registry.register(new AxeItem(MSItemTypes.EMERALD_TIER, 5, -3.0F, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("emerald_axe"));
		registry.register(new PickaxeItem(MSItemTypes.EMERALD_TIER, 1 , -2.8F, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("emerald_pickaxe"));
		registry.register(new ShovelItem(MSItemTypes.EMERALD_TIER, 1.5F, -3.0F, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("emerald_shovel"));
		registry.register(new HoeItem(MSItemTypes.EMERALD_TIER, 0.0F, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("emerald_hoe"));
		
		//armor
		registry.register(new ArmorItem(MSItemTypes.PRISMARINE_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("prismarine_helmet"));
		registry.register(new ArmorItem(MSItemTypes.PRISMARINE_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("prismarine_chestplate"));
		registry.register(new ArmorItem(MSItemTypes.PRISMARINE_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("prismarine_leggings"));
		registry.register(new ArmorItem(MSItemTypes.PRISMARINE_ARMOR, EquipmentSlotType.FEET, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("prismarine_boots"));
		registry.register(new ArmorItem(MSItemTypes.IRON_LASS_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("iron_lass_glasses"));
		registry.register(new ArmorItem(MSItemTypes.IRON_LASS_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("iron_lass_chestplate"));
		registry.register(new ArmorItem(MSItemTypes.IRON_LASS_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("iron_lass_skirt"));
		registry.register(new ArmorItem(MSItemTypes.IRON_LASS_ARMOR, EquipmentSlotType.FEET, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("iron_lass_shoes"));
		
		registry.register(new ArmorItem(MSItemTypes.PROSPIT_PAJAMAS, EquipmentSlotType.CHEST, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("prospit_shirt"));
		registry.register(new ArmorItem(MSItemTypes.PROSPIT_PAJAMAS, EquipmentSlotType.LEGS, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("prospit_pants"));
		registry.register(new ArmorItem(MSItemTypes.PROSPIT_PAJAMAS, EquipmentSlotType.FEET, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("prospit_shoes"));
		registry.register(new ArmorItem(MSItemTypes.DERSE_PAJAMAS, EquipmentSlotType.CHEST, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("derse_shirt"));
		registry.register(new ArmorItem(MSItemTypes.DERSE_PAJAMAS, EquipmentSlotType.LEGS, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("derse_pants"));
		registry.register(new ArmorItem(MSItemTypes.DERSE_PAJAMAS, EquipmentSlotType.FEET, new Item.Properties().group(MSItemGroup.WEAPONS)).setRegistryName("derse_shoes"));
		
		//core items
		registry.register(new BoondollarsItem(new Item.Properties().maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("boondollars"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN)).setRegistryName("raw_cruxite"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN)).setRegistryName("raw_uranium"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN)).setRegistryName("energy_core"));
		//have to fix Cruxite artifact classes
		
		registry.register(new CruxiteAppleItem(new Item.Properties().maxStackSize(1).group(MSItemGroup.MAIN).rarity(Rarity.UNCOMMON)).setRegistryName("cruxite_apple"));
		registry.register(new CruxitePotionItem(new Item.Properties().maxStackSize(1).group(MSItemGroup.MAIN).rarity(Rarity.UNCOMMON)).setRegistryName("cruxite_potion"));
		
		registry.register(new Item(new Item.Properties().maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("client_disk"));
		registry.register(new Item(new Item.Properties().maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("server_disk"));
		registry.register(new CaptchaCardItem(new Item.Properties().group(MSItemGroup.MAIN)).setRegistryName("captcha_card"));
		registry.register(new Item(new Item.Properties().maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("stack_modus_card"));
		registry.register(new Item(new Item.Properties().maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("queue_modus_card"));
		registry.register(new Item(new Item.Properties().maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("queuestack_modus_card"));
		registry.register(new Item(new Item.Properties().maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("tree_modus_card"));
		registry.register(new Item(new Item.Properties().maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("hashmap_modus_card"));
		registry.register(new Item(new Item.Properties().maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("set_modus_card"));
		registry.register(new ShuntItem(new Item.Properties().maxStackSize(1)).setRegistryName("shunt"));
		
		//food
		registry.register(new HealingFoodItem(4F, new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.PHLEGM_GUSHERS)).setRegistryName("phlegm_gushers"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.SORROW_GUSHERS)).setRegistryName("sorrow_gushers"));
		
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.BUG_ON_A_STICK)).setRegistryName("bug_on_a_stick"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.LANDS).food(MSFoods.CHOCOLATE_BEETLE)).setRegistryName("chocolate_beetle"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.LANDS).food(MSFoods.CONE_OF_FLIES)).setRegistryName("cone_of_flies"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.LANDS).food(MSFoods.GRASSHOPPER)).setRegistryName("grasshopper"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.LANDS).food(MSFoods.JAR_OF_BUGS)).setRegistryName("jar_of_bugs"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.LANDS).food(MSFoods.ONION)).setRegistryName("onion"));
		registry.register(new SoupItem(new Item.Properties().group(MSItemGroup.LANDS).food(MSFoods.SALAD).maxStackSize(1)).setRegistryName("salad"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.LANDS).food(MSFoods.DESERT_FRUIT)).setRegistryName("desert_fruit"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.LANDS)).setRegistryName("rock_cookie"));	//Not actually food, but let's pretend it is
		registry.register(new Item(new Item.Properties().group(MSItemGroup.LANDS).food(MSFoods.WOODEN_CARROT)).setRegistryName("wooden_carrot"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.LANDS).food(MSFoods.FUNGAL_SPORE)).setRegistryName("fungal_spore"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.LANDS).food(MSFoods.SPOREO)).setRegistryName("sporeo"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.LANDS).food(MSFoods.MOREL_MUSHROOM)).setRegistryName("morel_mushroom"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.LANDS).food(MSFoods.FRENCH_FRY)).setRegistryName("french_fry"));
		registry.register(new BlockNamedItem(STRAWBERRY_STEM, new Item.Properties().group(MSItemGroup.LANDS).food(MSFoods.STRAWBERRY_CHUNK)).setRegistryName("strawberry_chunk"));
		registry.register(new Item(new Item.Properties().maxStackSize(16).group(MSItemGroup.MAIN).food(MSFoods.FOOD_CAN)).setRegistryName("food_can"));
		
		
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.CANDY_CORN)).setRegistryName("candy_corn"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.BUILD_GUSHERS)).setRegistryName("build_gushers"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.AMBER_GUMMY_WORM)).setRegistryName("amber_gummy_worm"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.CAULK_PRETZEL)).setRegistryName("caulk_pretzel"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.CHALK_CANDY_CIGARETTE)).setRegistryName("chalk_candy_cigarette"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.IODINE_LICORICE)).setRegistryName("iodine_licorice"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.SHALE_PEEP)).setRegistryName("shale_peep"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.TAR_LICORICE)).setRegistryName("tar_licorice"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.COBALT_GUM)).setRegistryName("cobalt_gum"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.MARBLE_JAWBREAKER)).setRegistryName("marble_jawbreaker"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.MERCURY_SIXLETS)).setRegistryName("mercury_sixlets"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.QUARTZ_JELLY_BEAN)).setRegistryName("quartz_jelly_bean"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.SULFUR_CANDY_APPLE)).setRegistryName("sulfur_candy_apple"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.AMETHYST_HARD_CANDY)).setRegistryName("amethyst_hard_candy"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.GARNET_TWIX)).setRegistryName("garnet_twix"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.RUBY_LOLLIPOP)).setRegistryName("ruby_lollipop"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.RUST_GUMMY_EYE)).setRegistryName("rust_gummy_eye"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.DIAMOND_MINT)).setRegistryName("diamond_mint"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.GOLD_CANDY_RIBBON)).setRegistryName("gold_candy_ribbon"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.URANIUM_GUMMY_BEAR)).setRegistryName("uranium_gummy_bear"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.ARTIFACT_WARHEAD).rarity(Rarity.UNCOMMON)).setRegistryName("artifact_warhead"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.ZILLIUM_SKITTLES).rarity(Rarity.UNCOMMON)).setRegistryName("zillium_skittles"));
		registry.register(new DrinkableItem(new Item.Properties().maxStackSize(16).group(MSItemGroup.MAIN).food(MSFoods.TAB)).setRegistryName("tab"));
		registry.register(new DrinkableItem(new Item.Properties().maxStackSize(16).group(MSItemGroup.MAIN).food(MSFoods.FAYGO)).setRegistryName("orange_faygo"));
		registry.register(new DrinkableItem(new Item.Properties().maxStackSize(16).group(MSItemGroup.MAIN).food(MSFoods.FAYGO_CANDY_APPLE)).setRegistryName("candy_apple_faygo"));
		registry.register(new DrinkableItem(new Item.Properties().maxStackSize(16).group(MSItemGroup.MAIN).food(MSFoods.FAYGO_COLA)).setRegistryName("faygo_cola"));
		registry.register(new DrinkableItem(new Item.Properties().maxStackSize(16).group(MSItemGroup.MAIN).food(MSFoods.FAYGO_COTTON_CANDY)).setRegistryName("cotton_candy_faygo"));
		registry.register(new DrinkableItem(new Item.Properties().maxStackSize(16).group(MSItemGroup.MAIN).food(MSFoods.FAYGO_CREME)).setRegistryName("creme_soda_faygo"));
		registry.register(new DrinkableItem(new Item.Properties().maxStackSize(16).group(MSItemGroup.MAIN).food(MSFoods.FAYGO_GRAPE)).setRegistryName("grape_faygo"));
		registry.register(new DrinkableItem(new Item.Properties().maxStackSize(16).group(MSItemGroup.MAIN).food(MSFoods.FAYGO_MOON_MIST)).setRegistryName("moon_mist_faygo"));
		registry.register(new DrinkableItem(new Item.Properties().maxStackSize(16).group(MSItemGroup.MAIN).food(MSFoods.FAYGO_PEACH)).setRegistryName("peach_faygo"));
		registry.register(new DrinkableItem(new Item.Properties().maxStackSize(16).group(MSItemGroup.MAIN).food(MSFoods.FAYGO_REDPOP)).setRegistryName("redpop_faygo"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.IRRADIATED_STEAK)).setRegistryName("irradiated_steak"));
		registry.register(new SurpriseEmbryoItem(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.SURPRISE_EMBRYO)).setRegistryName("surprise_embryo"));
		registry.register(new UnknowableEggItem(new Item.Properties().maxStackSize(16).group(MSItemGroup.MAIN).food(MSFoods.UNKNOWABLE_EGG)).setRegistryName("unknowable_egg"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).food(MSFoods.BREADCRUMBS)).setRegistryName("breadcrumbs"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.LANDS)).setRegistryName("golden_grasshopper"));
		registry.register(new BugNetItem(new Item.Properties().defaultMaxDamage(64).group(MSItemGroup.LANDS)).setRegistryName("bug_net"));
		registry.register(new FrogItem(new Item.Properties().maxStackSize(1).group(MSItemGroup.LANDS)).setRegistryName("frog"));
		registry.register(new Item(new Item.Properties().maxStackSize(1).group(MSItemGroup.LANDS)).setRegistryName("carving_tool"));
		registry.register(new Item(new Item.Properties().maxStackSize(1).group(MSItemGroup.LANDS)).setRegistryName("crumply_hat"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.LANDS)).setRegistryName("stone_eyeballs"));
		registry.register(new StoneTabletItem(new Item.Properties().group(MSItemGroup.LANDS)).setRegistryName("stone_slab"));
		//registry.register(new HangingItem((world, pos, facing, stack) -> new EntityShopPoster(world, pos, facing, stack, 0), new Item.Properties().maxStackSize(1).group(ModItemGroup.LANDS)).setRegistryName("shop_poster"));
		
		registry.register(new BucketItem(MSFluids.OIL, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("oil_bucket"));
		registry.register(new BucketItem(MSFluids.BLOOD, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("blood_bucket"));
		registry.register(new BucketItem(MSFluids.BRAIN_JUICE, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("brain_juice_bucket"));
		registry.register(new BucketItem(MSFluids.WATER_COLORS, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("water_colors_bucket"));
		registry.register(new BucketItem(MSFluids.ENDER, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("ender_bucket"));
		registry.register(new BucketItem(MSFluids.LIGHT_WATER, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("light_water_bucket"));
		registry.register(new ObsidianBucketItem(new Item.Properties().maxStackSize(1).containerItem(Items.BUCKET).group(MSItemGroup.MAIN)).setRegistryName("obsidian_bucket"));
		registry.register(new CaptcharoidCameraItem(new Item.Properties().defaultMaxDamage(64).group(MSItemGroup.MAIN)).setRegistryName("captcharoid_camera"));
		registry.register(new GrimoireItem(new Item.Properties().maxStackSize(1).group(MSItemGroup.MAIN).rarity(Rarity.UNCOMMON)).setRegistryName("grimoire"));
		registry.register(new LongForgottenWarhornItem(new Item.Properties().defaultMaxDamage(100).group(MSItemGroup.MAIN).rarity(Rarity.UNCOMMON)).setRegistryName("long_forgotten_warhorn"));
		registry.register(new Item(new Item.Properties().maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("black_queens_ring"));
		registry.register(new Item(new Item.Properties().maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("white_queens_ring"));
		registry.register(new BarbasolBombItem(new Item.Properties().maxStackSize(16).group(MSItemGroup.MAIN)).setRegistryName("barbasol_bomb"));
		registry.register(new RazorBladeItem(new Item.Properties().group(MSItemGroup.MAIN)).setRegistryName("razor_blade"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN)).setRegistryName("ice_shard"));
		registry.register(new SoundItem(() -> MSSoundEvents.ITEM_HORN_USE, new Item.Properties().group(MSItemGroup.MAIN)).setRegistryName("horn"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN)).setRegistryName("cake_mix"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN)).setRegistryName("battery"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN)).setRegistryName("barbasol"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN)).setRegistryName("clothes_iron"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN)).setRegistryName("ink_squid_pro_quo"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN)).setRegistryName("cueball"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN).maxStackSize(1)).setRegistryName("uranium_powered_stick"));
		registry.register(new ScalemateItem(new Item.Properties().group(MSItemGroup.MAIN)).setRegistryName("scalemate_applescab"));
		registry.register(new ScalemateItem(new Item.Properties()).setRegistryName("scalemate_berrybreath"));
		registry.register(new ScalemateItem(new Item.Properties()).setRegistryName("scalemate_cinnamonwhiff"));
		registry.register(new ScalemateItem(new Item.Properties()).setRegistryName("scalemate_honeytongue"));
		registry.register(new ScalemateItem(new Item.Properties()).setRegistryName("scalemate_lemonsnout"));
		registry.register(new ScalemateItem(new Item.Properties()).setRegistryName("scalemate_pinesnout"));
		registry.register(new ScalemateItem(new Item.Properties()).setRegistryName("scalemate_pucefoot"));
		registry.register(new ScalemateItem(new Item.Properties()).setRegistryName("scalemate_pumpkinsnuffle"));
		registry.register(new ScalemateItem(new Item.Properties()).setRegistryName("scalemate_pyralspite"));
		registry.register(new ScalemateItem(new Item.Properties()).setRegistryName("scalemate_witness"));
		registry.register(new CustomBoatItem((stack, world, x, y, z) -> new MetalBoatEntity(world, x, y, z, MetalBoatEntity.Type.IRON), new Item.Properties().group(MSItemGroup.MAIN).maxStackSize(1)).setRegistryName("iron_boat"));
		registry.register(new CustomBoatItem((stack, world, x, y, z) -> new MetalBoatEntity(world, x, y, z, MetalBoatEntity.Type.GOLD), new Item.Properties().group(MSItemGroup.MAIN).maxStackSize(1)).setRegistryName("gold_boat"));
		registry.register(new Item(new Item.Properties().maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("thresh_dvd"));
		registry.register(new Item(new Item.Properties().maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("gamebro_magazine"));
		registry.register(new Item(new Item.Properties().maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("gamegrl_magazine"));
		registry.register(new HangingItem((world, pos, facing, stack) -> new CrewPosterEntity(world, pos, facing), new Item.Properties().maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("crew_poster"));
		registry.register(new HangingItem((world, pos, facing, stack) -> new SbahjPosterEntity(world, pos, facing), new Item.Properties().maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("sbahj_poster"));
		registry.register(new Item(new Item.Properties().group(MSItemGroup.MAIN)).setRegistryName("bi_dye"));
		
		//Music disks
		registry.register(new MusicDiscItem(1, () -> MSSoundEvents.MUSIC_DISC_EMISSARY_OF_DANCE, new Item.Properties().rarity(Rarity.RARE).maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("music_disc_emissary_of_dance"));
		registry.register(new MusicDiscItem(2, () -> MSSoundEvents.MUSIC_DISC_DANCE_STAB_DANCE, new Item.Properties().rarity(Rarity.RARE).maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("music_disc_dance_stab_dance"));
		registry.register(new MusicDiscItem(3, () -> MSSoundEvents.MUSIC_DISC_RETRO_BATTLE_THEME, new Item.Properties().rarity(Rarity.RARE).maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("music_disc_retro_battle"));
		//Cassettes
		registry.register(new CassetteItem(1, () -> SoundEvents.MUSIC_DISC_13, EnumCassetteType.THIRTEEN, new Item.Properties().rarity(Rarity.RARE).maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("cassette_13"));
		registry.register(new CassetteItem(2, () -> SoundEvents.MUSIC_DISC_CAT, EnumCassetteType.CAT, new Item.Properties().rarity(Rarity.RARE).maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("cassette_cat"));
		registry.register(new CassetteItem(3, () -> SoundEvents.MUSIC_DISC_BLOCKS, EnumCassetteType.BLOCKS, new Item.Properties().rarity(Rarity.RARE).maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("cassette_blocks"));
		registry.register(new CassetteItem(4, () -> SoundEvents.MUSIC_DISC_CHIRP, EnumCassetteType.CHIRP, new Item.Properties().rarity(Rarity.RARE).maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("cassette_chirp"));
		registry.register(new CassetteItem(5, () -> SoundEvents.MUSIC_DISC_FAR, EnumCassetteType.FAR, new Item.Properties().rarity(Rarity.RARE).maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("cassette_far"));
		registry.register(new CassetteItem(6, () -> SoundEvents.MUSIC_DISC_MALL, EnumCassetteType.MALL, new Item.Properties().rarity(Rarity.RARE).maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("cassette_mall"));
		registry.register(new CassetteItem(7, () -> SoundEvents.MUSIC_DISC_MELLOHI, EnumCassetteType.MELLOHI, new Item.Properties().rarity(Rarity.RARE).maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("cassette_mellohi"));
		registry.register(new CassetteItem(1, () -> MSSoundEvents.MUSIC_DISC_EMISSARY_OF_DANCE, EnumCassetteType.EMISSARY_OF_DANCE, new Item.Properties().rarity(Rarity.RARE).maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("cassette_emissary"));
		registry.register(new CassetteItem(2, () -> MSSoundEvents.MUSIC_DISC_DANCE_STAB_DANCE, EnumCassetteType.DANCE_STAB_DANCE, new Item.Properties().rarity(Rarity.RARE).maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("cassette_dance_stab"));
		registry.register(new CassetteItem(3, () -> MSSoundEvents.MUSIC_DISC_RETRO_BATTLE_THEME, EnumCassetteType.RETRO_BATTLE_THEME, new Item.Properties().rarity(Rarity.RARE).maxStackSize(1).group(MSItemGroup.MAIN)).setRegistryName("cassette_retro_battle"));
		
	}
	
	private static Item registerItemBlock(IForgeRegistry<Item> registry, Block block)
	{
		return registerItemBlock(registry, new BlockItem(block, new Item.Properties()));
	}
	
	private static Item registerItemBlock(IForgeRegistry<Item> registry, Block block, ItemGroup group)
	{
		return registerItemBlock(registry, new BlockItem(block, new Item.Properties().group(group)));
	}
	
	private static Item registerItemBlock(IForgeRegistry<Item> registry, Block block, Item.Properties properties)
	{
		return registerItemBlock(registry, new BlockItem(block, properties));
	}
	
	private static Item registerItemBlock(IForgeRegistry<Item> registry, BlockItem item)
	{
		if(item.getBlock().getRegistryName() == null)
			throw new IllegalArgumentException(String.format("The provided itemblock %s has a block without a registry name!", item.getBlock()));
		registry.register(item.setRegistryName(item.getBlock().getRegistryName()));
		return item;
	}
}