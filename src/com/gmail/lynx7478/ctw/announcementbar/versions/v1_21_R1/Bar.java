package com.gmail.lynx7478.ctw.announcementbar.versions.v1_21_R1;

import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSystemChatPacket;
import org.bukkit.craftbukkit.v1_21_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Bar implements com.gmail.lynx7478.ctw.announcementbar.Bar
{
    @Override
    public void sendToPlayer(final Player player, final String message, final float percentOfTotal)
    {
        Component actionComponent = Component.Serializer.fromJson("{\"text\":\"" + cleanMessage(message) + "\"}", null);
        ClientboundSystemChatPacket actionPacket = new ClientboundSystemChatPacket(actionComponent, true);
        ((CraftPlayer) player).getHandle().connection.sendPacket(actionPacket);
    }

    private static String cleanMessage(String message)
    {
        if (message.length() > 64)
            message = message.substring(0, 63);

        return message;
    }
}
