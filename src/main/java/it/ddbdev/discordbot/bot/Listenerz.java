package it.ddbdev.discordbot.bot;

import net.dv8tion.jda.api.events.channel.ChannelCreateEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Listenerz extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (!event.getAuthor().isBot()){
            String messageSent = event.getMessage().getContentRaw();
            if (messageSent.equals("!ping"))
                event.getChannel().sendMessage("Pong!").queue();

            if (messageSent.equals("!create"))
                System.out.println(event.getGuild().getCategories());

        }
    }

    @Override
    public void onChannelCreate(@NotNull ChannelCreateEvent event){
        System.out.println(event.getChannel());
    }

}
