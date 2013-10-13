package com.jdb100.mod.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

import com.jdb100.mod.lib.Reference;
import com.jdb100.mod.network.packet.PacketMod;
import com.jdb100.mod.network.packet.PacketTileUpdate;

public enum PacketTypeHandler 
{
	TILE(PacketTileUpdate.class);
	
	
	private Class<? extends PacketMod> clazz;
	
	PacketTypeHandler(Class<? extends PacketMod> clazz)
	{
		this.clazz = clazz;
	}
	
    public static PacketMod buildPacket(byte[] data) {

        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        int selector = bis.read();
        DataInputStream dis = new DataInputStream(bis);

        PacketMod packet = null;

        try {
            packet = values()[selector].clazz.newInstance();
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
        }

        packet.readPopulate(dis);

        return packet;
    }

    public static PacketMod buildPacket(PacketTypeHandler type) {

        PacketMod packet = null;

        try {
            packet = values()[type.ordinal()].clazz.newInstance();
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return packet;
    }

    public static Packet populatePacket(PacketMod packetMod) {

        byte[] data = packetMod.populate();

        Packet250CustomPayload packet250 = new Packet250CustomPayload();
        packet250.channel = Reference.CHANNEL_NAME;
        packet250.data = data;
        packet250.length = data.length;
        packet250.isChunkDataPacket = packetMod.isChunkDataPacket;

        return packet250;
    }
}
