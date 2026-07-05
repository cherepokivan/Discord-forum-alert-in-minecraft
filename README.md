# Discord-forum-alert-in-minecraft
# ForumAlert

---

# 🇬🇧 EN

A lightweight Paper plugin with a built-in Discord bot.

When a new topic is created in a Discord Forum Channel, the plugin instantly sends a notification to the Minecraft server chat.

## Features

- Built-in Discord bot (no separate hosting required)
- Monitors a Discord Forum Channel
- Detects newly created forum topics
- Sends a configurable message to the Minecraft chat
- Supports custom messages
- Supports `{title}` placeholder (forum topic title)
- Automatic configuration generation
- Lightweight and open source

## Requirements

- Paper 1.21.8+
- Java 25

## Installation

1. Download the latest release.
2. Put `ForumAlert.jar` into the `plugins` folder.
3. Start the server once.
4. Open:

```
plugins/ForumAlert/config.yml
```

5. Configure:

- Discord Bot Token
- Discord Forum Channel ID

6. Restart the server.

## Configuration

```yaml
discord:
  token: "YOUR_DISCORD_BOT_TOKEN"
  forum-channel-id: 123456789012345678

message:
  text: "<green>📩 New application! {title}"
```

## Placeholders

| Placeholder | Description |
|------------|-------------|
| `{title}` | Discord forum topic title |

Example:

```
📩 New application! Steve
```

or

```
📩 New application! Builder Application
```

## Building

```
./gradlew shadowJar
```

Compiled plugin:

```
build/libs/ForumAlert.jar
```

## License

MIT License

---

# 🇷🇺 RU

Лёгкий Paper-плагин со встроенным Discord-ботом.

При создании новой темы в Discord Forum Channel плагин мгновенно отправляет уведомление в чат Minecraft.

## Возможности

- Встроенный Discord-бот (не требует отдельного хостинга)
- Отслеживание Discord Forum Channel
- Обнаружение новых тем
- Настраиваемое сообщение
- Поддержка плейсхолдера `{title}` (название темы)
- Автоматическое создание конфигурации
- Лёгкий и с открытым исходным кодом

## Требования

- Paper 1.21.8+
- Java 25

## Установка

1. Скачайте последнюю версию.
2. Поместите `ForumAlert.jar` в папку `plugins`.
3. Один раз запустите сервер.
4. Откройте:

```
plugins/ForumAlert/config.yml
```

5. Укажите:

- токен Discord-бота;
- ID форум-канала.

6. Перезапустите сервер.

## Конфигурация

```yaml
discord:
  token: "ВАШ_ТОКЕН_БОТА"
  forum-channel-id: 123456789012345678

message:
  text: "<green>📩 Новая заявка! {title}"
```

## Плейсхолдеры

| Плейсхолдер | Описание |
|------------|----------|
| `{title}` | Название созданной темы в Discord |

Пример:

```
📩 Новая заявка! Steve
```

или

```
📩 Новая заявка! Заявка на проходку
```

## Сборка

```
./gradlew shadowJar
```

Готовый плагин находится в:

```
build/libs/ForumAlert.jar
```

## Лицензия

MIT License
