package me.example.forumalert;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ForumAlertPlugin extends JavaPlugin {

    private volatile JDA jda;
    private String botToken;
    private long forumChannelId;
    private String messageTemplate;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadSettings();

        if (botToken.isBlank() || "PASTE_BOT_TOKEN_HERE".equals(botToken)) {
            getLogger().severe("Set discord.token in config.yml first.");
            return;
        }

        if (forumChannelId == 0L) {
            getLogger().severe("Set discord.forum-channel-id in config.yml first.");
            return;
        }

        Thread botThread = new Thread(this::startDiscordBot, "forum-alert-discord");
        botThread.setDaemon(true);
        botThread.start();
    }

    @Override
    public void onDisable() {
        JDA current = this.jda;
        if (current != null) {
            current.shutdownNow();
            this.jda = null;
        }
    }

    private void loadSettings() {
        this.botToken = getConfig().getString("discord.token", "");
        this.forumChannelId = getConfig().getLong("discord.forum-channel-id");
        this.messageTemplate = getConfig().getString("message", "[Discord] Новая заявка!");
    }

    private void startDiscordBot() {
        try {
            JDABuilder builder = JDABuilder.createDefault(botToken)
                    .setActivity(Activity.playing("forum alerts"))
                    .addEventListeners(new ForumPostListener(this, forumChannelId));

            this.jda = builder.build();
            this.jda.awaitReady();

            getLogger().info("Discord bot is ready as " + this.jda.getSelfUser().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            getLogger().severe("Discord bot startup was interrupted.");
        } catch (Exception e) {
            getLogger().severe("Failed to start Discord bot: " + e.getMessage());
            e.printStackTrace();
        }
    }

    void announceNewApplication(String threadName) {
        String text = messageTemplate.replace("{title}", threadName);

        Bukkit.getScheduler().runTask(this, () -> {
            Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage(text));
            Bukkit.getConsoleSender().sendMessage(text);
        });
    }
}
