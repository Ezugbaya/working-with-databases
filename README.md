<div align="center">

# 📚 Working with Databases

### Финальный проект 4 модуля JavaRush

Изучение работы с **MySQL**, **Hibernate**, **Redis** и **Docker** на языке **Java**.

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Hibernate](https://img.shields.io/badge/Hibernate-5.6-green?style=for-the-badge&logo=hibernate)
![MySQL](https://img.shields.io/badge/MySQL-8-blue?style=for-the-badge&logo=mysql)
![Redis](https://img.shields.io/badge/Redis-Latest-red?style=for-the-badge&logo=redis)
![Docker](https://img.shields.io/badge/Docker-Latest-2496ED?style=for-the-badge&logo=docker)
![Maven](https://img.shields.io/badge/Maven-3-C71A36?style=for-the-badge&logo=apachemaven)

</div>

---

# 📖 Описание проекта

Цель проекта — показать, как можно повысить скорость получения часто используемых данных с помощью кэширования в **Redis**.

В приложении реализовано:

- получение данных из MySQL;
- преобразование объектов в модель кэширования;
- сохранение данных в Redis;
- получение данных из Redis;
- сравнение производительности MySQL и Redis.

---

# 🛠 Используемые технологии

| Технология | Назначение |
|------------|------------|
| Java 17 | Основной язык разработки |
| Maven | Управление зависимостями |
| Hibernate ORM | Работа с базой данных |
| MySQL | Реляционная база данных |
| Redis | In-memory кэш |
| Jackson | Сериализация объектов |
| Lettuce | Java-клиент Redis |
| Docker | Запуск MySQL и Redis |
| P6Spy | Логирование SQL-запросов |

---

# 📂 Структура проекта

```text
working-with-databases
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.javarush
│   │   │
│   │   │       ├── app
│   │   │       │     └── Main.java
│   │   │       │
│   │   │       ├── config
│   │   │       │
│   │   │       ├── dao
│   │   │       │
│   │   │       ├── domain
│   │   │       │
│   │   │       ├── redis
│   │   │       │
│   │   │       ├── service
│   │   │       │
│   │   │       └── util
│   │   │
│   │   └── resources
│   │
│   └── test
│
├── pom.xml
└── README.md
```

### Описание пакетов

| Пакет       | Назначение |
|-------------|------------|
| **app**     | Точка входа в приложение. Запуск проекта и выполнение основных сценариев работы. |
| **config**  | Конфигурация Hibernate, Redis, подключение к базе данных и настройка приложения. |
| **dao**     | Слой доступа к данным (Data Access Object). Выполнение запросов к MySQL через Hibernate. |
| **domain**  | JPA-сущности, отображающие таблицы базы данных (`City`, `Country`, `CountryLanguage` и др.). |
| **redis**   | Классы моделей, используемые для хранения данных в Redis после преобразования из JPA-сущностей. |
| **service** | Бизнес-логика приложения: преобразование данных, запись в Redis, чтение данных, сравнение производительности. |
| **util**    | Вспомогательные классы, утилиты и общие методы, используемые в разных частях проекта. |
```

---

# ⚙ Возможности проекта

- ✔ Подключение к MySQL через Hibernate
- ✔ Получение данных из базы данных
- ✔ Оптимизация SQL-запросов
- ✔ Преобразование объектов в модель Redis
- ✔ Сохранение объектов в Redis
- ✔ Получение данных из Redis
- ✔ Сравнение скорости работы MySQL и Redis

---

# 🚀 Запуск проекта

### 1. Запустить Docker

### 2. Создать контейнер MySQL

### 3. Импортировать базу данных `world`

### 4. Запустить контейнер Redis

### 5. Собрать проект

```bash
mvn clean install
```

### 6. Запустить приложение

---

# 📈 Что изучается в проекте

- Hibernate ORM
- Entity Mapping
- DAO
- Redis Cache
- Docker
- Jackson
- Lettuce
- Оптимизация запросов
- Работа с большими объемами данных



<div align="center">

**JavaRush Module 4 Final Project**

</div>