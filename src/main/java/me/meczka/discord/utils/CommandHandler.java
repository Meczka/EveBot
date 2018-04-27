package me.meczka.discord.utils;

import me.meczka.discord.main.Renderer;
import me.meczka.discord.net.RequestSender;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Patryk on 27.04.2018.
 */
public class CommandHandler {
    @EventSubscriber
    public void onMessageRecived(MessageReceivedEvent event)
    {
        String[] argArray =  event.getMessage().getContent().split(" ");
        if(argArray.length==0) {
            return;
        }
        if(!argArray[0].startsWith(BotUtils.BOT_PREFIX)) {
            return;
        }
        String commandString = argArray[0].substring(1);
        List<String> argsList = new ArrayList<>(Arrays.asList(argArray));
        argsList.remove(0);
        switch (commandString)
        {
            case "item":
            {
                String message;
                int id = Renderer.getIdFromName(argsList.get(0));
                String description = Renderer.getTypeAttributesFromID(id).getString("description");
                message=description;
                BotUtils.sendMessage(event.getChannel(),message);
                break;
            }
        }
    }

}
