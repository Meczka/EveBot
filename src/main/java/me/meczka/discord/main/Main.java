package me.meczka.discord.main;

import me.meczka.discord.utils.BotUtils;
import sx.blah.discord.api.IDiscordClient;

public class Main {
    public static void main(String[] args)
    {
        IDiscordClient  cli = BotUtils.getBuiltDiscrodClient();
        cli.login();
    }
}
