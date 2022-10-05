package it.ddbdev.discordbot.bot.configuration;

import it.ddbdev.discordbot.bot.Listenerz;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class BotConfiguration {

    @Value("${app.discord.token}")
    private String token;

    @Bean
    protected void connect() {

        try {
            JDA bot = JDABuilder.createDefault(token)
                    .setActivity(Activity.watching("you"))
                    .addEventListeners(new Listenerz())
                    .setEventPassthrough(true)
                    .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                    .build();

        }
        catch ( Exception exception ) {
            log.error( "Be sure to use a valid bot token!", exception );
        }

    }


}
