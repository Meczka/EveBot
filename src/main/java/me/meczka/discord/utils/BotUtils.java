package me.meczka.discord.utils;

import me.meczka.discord.net.RequestSender;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.RequestBuffer;

public class BotUtils    {
    public static final String BOT_PREFIX= "!";
    public static IDiscordClient getBuiltDiscrodClient()
    {
        return new ClientBuilder().withToken("NDM4MzI4ODA0MDg4NDc5NzQ1.DcDBOA.OEeo1-0D7nnDHzs-clAxUCZtK_o").build();
    }
    public static void sendMessage(final IChannel channel, final String message)
    {
        RequestBuffer.request(() -> {
            try{
                channel.sendMessage(message);
            }catch (DiscordException e)
            {
                System.err.println("Message could not be sent with error: ");
                e.printStackTrace();
            }
        });
    }
}
