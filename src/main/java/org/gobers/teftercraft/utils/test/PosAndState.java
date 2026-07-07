package org.gobers.teftercraft.utils.test;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.Util;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Objects;
import java.util.stream.IntStream;

public class PosAndState {

    public static final Codec<PosAndState> CODEC;
    public static final StreamCodec<RegistryFriendlyByteBuf, PosAndState> STREAM_CODEC;

    private BlockState blockState;
    private BlockPos pos;

    public PosAndState(BlockState blockState, BlockPos pos) {
        this.pos = pos;
        this.blockState = blockState;
    }

    public BlockState getBlockState() {
        return blockState;
    }

    public BlockPos getPos() {
        return pos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PosAndState other)) return false;

        return Objects.equals(blockState, other.blockState)
                && Objects.equals(pos, other.pos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blockState, pos);
    }


    static {
         CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        BlockState.CODEC.fieldOf("state").forGetter(PosAndState::getBlockState),
                        BlockPos.CODEC.fieldOf("pos").forGetter(PosAndState::getPos)
                ).apply(instance, PosAndState::new)
        );


        STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.fromCodec(BlockState.CODEC), PosAndState::getBlockState,
                BlockPos.STREAM_CODEC, PosAndState::getPos,
                PosAndState::new
        );
    }
}
