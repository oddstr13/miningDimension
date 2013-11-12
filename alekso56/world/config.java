package alekso56.world;
import net.minecraftforge.common.ConfigCategory;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

public class config {
	static void loadConfig(Configuration config)
	  {
	 config.load();
	    Property dimensionProp = config.get("general", "DimensionID", 6);

	    dimensionProp.comment = "The Mining World will have this dimension ID.";
	    miningworld.dimension = dimensionProp.getInt(6);
	    Property biomeProp = config.get("general", "BiomeID", 47);
	    
	    Property frameblockid = config.get("general", "frameblockid", 5);
	    frameblockid.comment = "blockid for portalframe.";
	    miningworld.fblockid = frameblockid.getInt(5);
	    
	    Property portalc  = config.get("general", "portalcontentid", 1);
	    portalc.comment = "blockid for portal content.";
	    miningworld.IblockID = portalc.getInt(1);

	    biomeProp.comment = "The Mining Biome will have this ID.";
	    miningworld.biomeID = biomeProp.getInt(47);
	    
	    Property enableMSGProp = config.get("general", "enableTextMessageOnDimension", false);

	    enableMSGProp.comment = "Send message to player when he enters a world?";
	    miningworld.enableMSG = enableMSGProp.getBoolean(false);
	    Property sendMSGProp = config.get("general", "Message", "playah was telported");

	    sendMSGProp.comment = "The Message that will be sent.";
	    miningworld.sendMSG = sendMSGProp.getString();

	    Property spawnMonstersProp = config.get("general", "spawnMonsters", false);

	    spawnMonstersProp.comment = "If Monsters Spawn in the Mining World.";
	    miningworld.spawnMonsters = spawnMonstersProp.getBoolean(false);
	    Property spawnAnimalsProp = config.get("general", "spawnAnimals", false);

	    spawnAnimalsProp.comment = "If Animals spawn in the Mining World.";
	    miningworld.spawnAnimals = spawnAnimalsProp.getBoolean(false);

	    config.save();
	  }
}
