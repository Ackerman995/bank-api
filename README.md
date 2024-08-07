# Прототип микросервиса для банковской системы

Этот микросервис разработан для интеграции с существующей банковской системой и предоставляет два API для работы с транзакциями и лимитами. Микросервис использует стек технологий: Java 17, Spring Boot, PostgreSQL, Hibernate, Liquibase, Gradle, Swagger, Lombok и MapStruct.

## Стек технологий

- **Java 17**: Язык программирования.
- **Spring Boot**: Основной фреймворк для создания приложения.
- **PostgreSQL**: Система управления базами данных.
- **Hibernate**: ORM для работы с базой данных.
- **Liquibase**: Инструмент для управления миграциями базы данных.
- **Gradle**: Система сборки проекта.
- **Swagger**: Инструмент для автоматической генерации документации API.
- **Lombok**: Библиотека для упрощения работы с Java-кодом.
- **MapStruct**: Инструмент для маппинга между объектами.

## Описание

Микросервис включает в себя два API:

1. **API для приема транзакций** (интеграция с банковскими сервисами).
2. **Клиентский API** для внешних запросов от клиентов, включая:
    - Получение списка транзакций, превысивших лимит.
    - Установление нового лимита.
    - Получение всех лимитов.

Приложение реализует обычную трёхслойную архитектуру:

- **Controller**: Обрабатывает HTTP-запросы и возвращает ответы.
- **Service**: Содержит бизнес-логику.
- **Repository**: Работа с базой данных (реализован на `JPA`).

Сервис также содержит `GlobalExceptionHandler`, который возвращает ошибки в формате `{"code":"CODE", "message":"message"}`.

## Требования

Перед запуском приложения убедитесь, что у вас установлены следующие компоненты:

- **JDK 17** или выше
- **Docker** и **Docker Compose** для запуска базы данных PostgreSQL (опционально, если вы не хотите устанавливать PostgreSQL локально).

## Установка и запуск

### 1. Клонирование репозитория

1. **Клонируйте репозиторий:**

   ```bash
   git clone https://github.com/Ackerman995/bank-api.git
   cd bank-api.git
