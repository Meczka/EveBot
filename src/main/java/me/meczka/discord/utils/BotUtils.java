package me.meczka.discord.utils;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;

public class BotUtils    {
    public static IDiscordClient getBuiltDiscrodClient()
    {
        return new ClientBuilder().withToken("NDM4MzI4ODA0MDg4NDc5NzQ1.DcDBOA.OEeo1-0D7nnDHzs-clAxUCZtK_o").build();
    }
}
