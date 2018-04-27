package me.meczka.discord.main;

import com.sun.org.apache.regexp.internal.RE;
import me.meczka.discord.net.RequestSender;
import me.meczka.discord.utils.BotUtils;
import me.meczka.discord.utils.CommandHandler;
import sx.blah.discord.api.IDiscordClient;

public class Main {
    public static void main(String[] args) {
        IDiscordClient cli = BotUtils.getBuiltDiscrodClient();
        cli.getDispatcher().registerListener(new CommandHandler());
        cli.login();
    }
}
