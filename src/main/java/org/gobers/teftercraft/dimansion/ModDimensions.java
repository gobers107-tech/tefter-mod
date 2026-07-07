package org.gobers.teftercraft.dimansion;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import org.gobers.teftercraft.TefterCarft;

import java.util.List;

public class ModDimensions {
    public static final ResourceKey<LevelStem> EXAMPLE_KEY = ResourceKey.create(
            Registries.LEVEL_STEM, Identifier.fromNamespaceAndPath(TefterCarft.MODID, "example_dimension"));

    public static void bootstrap(BootstrapContext<LevelStem> context) {
        var biomes = context.lookup(Registries.BIOME);
        var dimensionTypes = context.lookup(Registries.DIMENSION_TYPE);
        var noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator singleBiomeGenerator = new NoiseBasedChunkGenerator(
                new FixedBiomeSource(biomes.getOrThrow(Biomes.CHERRY_GROVE)),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.AMPLIFIED));

        NoiseBasedChunkGenerator multiBiomeGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(
                                Pair.of(Climate.parameters(0f, 0f, 0f, 0f, 0f, 0f, 0f), biomes.getOrThrow(Biomes.FOREST)),
                                Pair.of(Climate.parameters(0f, 0.1f, 0f, 0f, 0f, 0f, 0f), biomes.getOrThrow(Biomes.BIRCH_FOREST)),
                                Pair.of(Climate.parameters(0.1f, 0.1f, 0f, 0f, 0f, 0f, 0f), biomes.getOrThrow(Biomes.CHERRY_GROVE)),
                                Pair.of(Climate.parameters(0.1f, 0.25f, 0f, 0f, 0f, 0f, 0f), biomes.getOrThrow(Biomes.BEACH)),
                                Pair.of(Climate.parameters(0.1f, 0.3f, -0.05f, 0f, 0f, 0f, 0f), biomes.getOrThrow(Biomes.DEEP_LUKEWARM_OCEAN))
                        ))),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.FLOATING_ISLANDS));

        context.register(EXAMPLE_KEY, new LevelStem(dimensionTypes.getOrThrow(ModDimensionTypes.EXAMPLE_TYPE), multiBiomeGenerator));
    }
}

