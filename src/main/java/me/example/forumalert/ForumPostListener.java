package me.example.forumalert;

import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.events.channel.ChannelCreateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public final class ForumPostListener extends ListenerAdapter {

    private final ForumAlertPlugin plugin;
    private final long forumChannelId;

    public ForumPostListener(ForumAlertPlugin plugin, long forumChannelId) {
        this.plugin = plugin;
        this.forumChannelId = forumChannelId;
    }

    @Override
    public void onChannelCreate(@NotNull ChannelCreateEvent event) {
        if (event.getChannelType() != ChannelType.GUILD_PUBLIC_THREAD) {
            return;
        }

        if (!(event.getChannel() instanceof ThreadChannel thread)) {
            return;
        }

        if (thread.getParentChannel() == null || thread.getParentChannel().getIdLong() != forumChannelId) {
            return;
        }

        plugin.announceNewApplication(thread.getName());
    }
}
