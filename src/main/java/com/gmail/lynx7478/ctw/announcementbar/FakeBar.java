package com.gmail.lynx7478.ctw.announcementbar;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

import com.gmail.lynx7478.ctw.utils.VersionUtils;

class FakeBar implements Bar
{
    //This bar should tell the player that the server is using an unsuported version, but also send the phase message
    private Map<UUID,Long> timers;
    public FakeBar()
    {
        timers = new HashMap<>();
    }

    @Override
    public void sendToPlayer(final Player player, final String message, final float percentOfTotal)
    {
        Long l = timers.get(player.getUniqueId());
        if(l == null || System.currentTimeMillis() >= l.longValue())
        {
        	String version = VersionUtils.getVersion();
            player.sendMessage("This server is using an unsupported version for the phase bar!" + " Version: " + version +  ".");
            player.sendMessage("Please contact Rai and give the name of the version displayed above.");
            player.sendMessage(message);
            timers.put(player.getUniqueId(),System.currentTimeMillis()+(20*1000)); //Send them the message every 20 seconds
        }
    }
}
