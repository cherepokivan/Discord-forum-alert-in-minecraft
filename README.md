# ForumAlert

Paper plugin with a built-in Discord bot.

When a new topic is created in the configured Discord forum channel, the plugin sends a message to the Minecraft server chat.

## Requirements

- Paper 26.2
- Java 25
- Discord bot token
- Discord forum channel ID

## Configuration

After the first server start, edit `plugins/ForumAlert/config.yml`:

```yaml
discord:
  token: "YOUR_DISCORD_BOT_TOKEN"
  forum-channel-id: 123456789012345678

message: "[Discord] Новая заявка! {title}"
```

`{title}` is replaced with the Discord forum topic title.

## Build

Windows:

```powershell
.\gradlew.bat build
```

Linux/macOS:

```bash
./gradlew build
```

The plugin jar is created at:

```text
build/libs/ForumAlert-1.0.0.jar
```

## Русский

Плагин для Paper со встроенным Discord-ботом.

Когда в указанном Discord forum channel создаётся новая тема, плагин отправляет сообщение в чат Minecraft-сервера.

Настройте `plugins/ForumAlert/config.yml`:

```yaml
discord:
  token: "ТОКЕН_ВАШЕГО_DISCORD_БОТА"
  forum-channel-id: 123456789012345678

message: "[Discord] Новая заявка! {title}"
```

`{title}` заменяется на название созданной темы.
