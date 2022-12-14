package org.hostile.rogue.packet.outbound;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import lombok.Getter;
import org.hostile.rogue.packet.WrappedPacket;
import org.hostile.rogue.util.json.JsonChain;

@Getter
public class WrappedPacketPlayOutEntityVelocity extends WrappedPacket {

    private final int entityId;

    private final int velocityX;
    private final int velocityY;
    private final int velocityZ;

    public WrappedPacketPlayOutEntityVelocity(PacketContainer packetContainer) {
        StructureModifier<Integer> integers = packetContainer.getIntegers();

        this.entityId = integers.read(0);
        this.velocityX = integers.read(1);
        this.velocityY = integers.read(2);
        this.velocityZ = integers.read(3);
    }

    @Override
    public JsonChain serialize() {
        return new JsonChain()
                .addProperty("entityId", entityId)
                .addProperty("velocityX", velocityX)
                .addProperty("velocityY", velocityY)
                .addProperty("velocityZ", velocityZ);
    }

    @Override
    public String getName() {
        return "out_entity_velocity";
    }
}
