package com.gmail.lynx7478.ctw.announcementbar.versions.v1_21_R1;


import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Bar implements com.gmail.lynx7478.ctw.announcementbar.Bar
{

	@Override
	public void sendToPlayer(Player player, String message, float percentOfTotal) 
	{
		player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(cleanMessage(message)));
	}
    /* @Override
    public void sendToPlayer(final Player player, final String message, final float percentOfTotal)
    {
        Component actionComponent = Component.Serializer.fromJson("{\"text\":\"" + cleanMessage(message) + "\"}", null);
        ClientboundSystemChatPacket actionPacket = new ClientboundSystemChatPacket(actionComponent, true);
        ((CraftPlayer) player).getHandle().connection.sendPacket(actionPacket);
    }*/

    private static String cleanMessage(String message)
    {
        if (message.length() > 64)
            message = message.substring(0, 63);

        return message;
    }
}
