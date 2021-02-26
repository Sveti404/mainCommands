package io.github.sveti404.mainCommands;


import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

import java.util.Random;

public class chunkGenerator extends ChunkGenerator {

    @Override
    public ChunkData generateChunkData(World world, Random random, int x, int z, BiomeGrid biome) {
        return createChunkData(world);
    }
}
