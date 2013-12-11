package alekso56.world;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

public class config
{
    static void loadConfig(Configuration config)
    {
        config.load();
        
        /* Dimmension ID */
        Property dimensionProp = config.get("general", "DimensionID", 6);
        dimensionProp.comment  = "The Mining World will have this dimension ID.";
        miningworld.dimension  = dimensionProp.getInt(6);

        /* Biome ID */
        Property biomeProp  = config.get("general", "BiomeID", 47);
        biomeProp.comment   = "The Mining Biome will have this ID.";
        miningworld.biomeID = biomeProp.getInt(47);

        /* Spawn monsters?*/
        Property spawnMonstersProp = config.get("general", "spawnMonsters", false);
        spawnMonstersProp.comment  = "If Monsters Spawn in the Mining World.";
        miningworld.spawnMonsters  = spawnMonstersProp.getBoolean(false);

        /* Spawn animals? */
        Property spawnAnimalsProp = config.get("general", "spawnAnimals", false);
        spawnAnimalsProp.comment  = "If Animals spawn in the Mining World.";
        miningworld.spawnAnimals  = spawnAnimalsProp.getBoolean(false);
        
        config.save();
    }
}
