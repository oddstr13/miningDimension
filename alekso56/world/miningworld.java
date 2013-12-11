package alekso56.world;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerSelector;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerAboutToStartEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = "alekso56's miningworld", name = "alekso56's miningworld", version = "1.2")
@NetworkMod(clientSideRequired = false, serverSideRequired = true)
public class miningworld
{
    @Mod.Instance("alekso56's miningworld")
    public static miningworld instancez;
    public static int dimension;
    public static int biomeID;
    public static boolean spawnMonsters;
    public static boolean spawnAnimals;
    public static BiomeGenMining miningBiome;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        config.loadConfig(new Configuration(event.getSuggestedConfigurationFile()));
    }
    
    @Mod.EventHandler
    @SideOnly(Side.CLIENT)
    public void clientcrap(FMLInitializationEvent event){
    	 DimensionManager.registerProviderType(dimension, Worldmining.class, false);
    	 miningBiome = new BiomeGenMining(biomeID);
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new portalactivator());
        miningBiome = new BiomeGenMining(biomeID);

        if (DimensionManager.isDimensionRegistered(dimension))
        {
            System.out.println("Failed to register the Mining Dimension with the ID " + dimension + ". Please pick another one!");
        }

        DimensionManager.registerProviderType(dimension, Worldmining.class, false);
        DimensionManager.registerDimension(dimension, dimension);
        FMLInterModComms.sendMessage("BuildCraft|Energy", "oil-gen-exclude", miningBiome.biomeID + "");
        BiomeManager.addStrongholdBiome(miningBiome);
        BiomeDictionary.registerBiomeType(miningBiome, new BiomeDictionary.Type[] { BiomeDictionary.Type.MOUNTAIN });
        miningBiome.clearMonsters();
        //System.out.println("Loaded.");
        //System.out.println("Dimension registered with ID: " + dimension + ".");
    }
    public static  WorldType superCustom            = null;
    static double  SeaLevelScale                    =    0.5D;
    static int     CPGNoiseGen1Octaves              =   16;
    static int     CPGNoiseGen2Octaves              =   16;
    static int     CPGNoiseGen3Octaves              =    8;
    static int     CPGNoiseGen4Octaves              =    4;
    static int     CPGNoiseGen5Octaves              =   10;
    static int     CPGNoiseGen6Octaves              =   16;
    static int     CPGMobSpawnerNoiseOctaves        =    8;
    static double  CPGGenTerrainYFactor             =    0.125D;
    static double  CPGGenTerrainXZFactor1           =    0.25D;
    static double  CPGGenTerrainXZFactor2           =    0.25D;
    static double  CPGGenTerrainSolidCutoff         =    0.0D;
    static byte    CPGGenTerrainDefaultFillID       = (byte) Block.stone.blockID;
    static byte    CPGGenTerrainSeaLevelFillID      = (byte) Block.waterStill.blockID;
    static double  CPGReplaceStoneNoiseScale        =    0.03125D;
    static double  CPGReplaceStoneNoiseDivisor      =    3D;
    static double  CPGReplaceStoneNoiseAdd          =    3D;
    static double  CPGReplaceStoneNoiseRandScale    =    0.25D;
    static int     CPGReplaceBedrockChance          =    5;
    static byte    CPGReplaceBedrockID              = (byte) Block.bedrock.blockID;
    static int     CPGBedrockMode                   =    0;
    static int     CPGReplaceColumnSkipID           = (byte) Block.stone.blockID;
    static byte    CPGReplaceDefaultFillID          = (byte) Block.stone.blockID;
    static float   CPGReplaceIceTempCutoff          =    0.15F;
    static boolean CPGReplaceIceTempCompareLess     = true;
    static byte    CPGReplaceIceID                  = (byte) Block.ice.blockID;
    static byte    CPGReplaceWaterID                = (byte) Block.waterStill.blockID;
    static int     CPGReplaceSandFillID             = Block.sand.blockID;
    static int     CPGReplaceSandSupportRollChance  =    4;
    static byte    CPGReplaceSandSupportID          = (byte) Block.sandStone.blockID;
    static long    CPGProvideXSeedMult              = 0x4f9939f508L;
    static long    CPGProvideZSeedMult              = 0x1ef1565bd5L;
    static double  CPGInitNoiseXZMajorScale         =  684.41200000000003D;
    static double  CPGInitNoiseYMajorScale          =  684.41200000000003D;
    static double  CPGInitNoiseXMidScale            =  200D;
    static double  CPGInitNoiseZMidScale            =  200D;
    static double  CPGInitNoiseYMidScale            =    0.5D;
    static double  CPGInitNoiseXSlopeDiv            =   80D;
    static double  CPGInitNoiseZSlopeDiv            =   80D;
    static double  CPGInitNoiseYSlopeDiv            =  160D;
    static double  CPGInitNoiseSlopeDenom           =   10D;
    static double  CPGInitNoiseSlopeAdd             =    1.0D;
    static double  CPGInitNoiseSlopeScale           =    0.5D;
    static double  CPGInitNoiseXLowerScale          =    1.0D;
    static double  CPGInitNoiseYLowerScale          =    1.0D;
    static double  CPGInitNoiseZLowerScale          =    1.0D;
    static double  CPGInitNoiseXUpperScale          =    1.0D;
    static double  CPGInitNoiseYUpperScale          =    1.0D;
    static double  CPGInitNoiseZUpperScale          =    1.0D;
    static double  CPGInitNoiseLowerDenom           =  512D;
    static double  CPGInitNoiseUpperDenom           =  512D;
    static float   CPGInitNoiseBiomeNumerator       =   10F;
    static float   CPGInitNoiseBiomeAdd             =    0.2F;
    static float   CPGInitNoiseBiomeMinHeightBump   =    2.0F;
    static float   CPGInitNoiseBiomeInterpFactor    =    2F;
    static float   CPGInitNoiseF2Scale              =    4F;
    static float   CPGInitNoiseF2Sub                =    1.0F;
    static float   CPGInitNoiseF2Denom              =    8F;
    static double  CPGInitNoiseD2ReverseFactor      =    0.29999999999999999D;
    static double  CPGInitNoiseD2Scale              =    1D;
    static double  CPGInitNoiseD2Subtract           =    2D;
    static double  CPGInitNoiseD2PreClampScale      =    2D;
    static double  CPGInitNoiseD2PostClampScale     =    2.7999999999999998D;
    static double  CPGInitNoiseD2NonClampScale      =    8D;
    static double  CPGInitNoiseD2FinalScale         =    2D;
    static double  CPGInitNoiseD3HeightFactor       =   16D;
    static double  CPGInitNoiseD3BlockScale         =    4D;
    static double  CPGInitNoiseD7ClampFactor        =    4D;
    static double  CPGInitNoiseD7HeightScale        =   12D;
    static double  CPGInitNoiseD7HeightTotal        =  128D;
    static float   CPGInitNoiseSolidFloorFactor     =    0.1F;
    static float   CPGInitNoiseMidDenom             = 8000F;
    static double  CPGInitNoiseHeightLimitDenom     =    3D;
    static double  CPGInitNoiseHeightLimitRoundoff  =  -10D;
    static int     CPGPopulateLakeChance            =    5;
    static int     CPGPopulateLakeYMin              =    0;
    static int     CPGPopulateLakeYRange            =  256;
    static int     CPGPopulateLakeID                = Block.waterStill.blockID;
    static int     CPGPopulateLavaChance            =   15;
    static int     CPGPopulateLavaYMin              =    0;
    static int     CPGPopulateLavaYRange            =  256;
    static int     CPGPopulateAboveGroundLavaChance =   10;
    static int     CPGPopulateLavaID                = Block.lavaStill.blockID;
    static int     CPGPopulateDungeonCount          =    8;
    static int     CPGPopulateDungeonYMin           =    0;
    static int     CPGPopulateDungeonYRange         =  256;
}
