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

Цель проекта — реализовать кэширование данных с использованием **Redis** и сравнить скорость получения данных из **MySQL** и **Redis**.

В приложении реализовано:

- получение данных из MySQL;
- преобразование объектов в модель для хранения в Redis;
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





# 🏗 Архитектура проекта

Проект построен по классической многослойной архитектуре:

- **DAO** — работа с базой данных;
- **Service** — бизнес-логика и преобразование данных;
- **Domain** — JPA-сущности;
- **Redis** — модели объектов, сохраняемых в Redis;
- **App** — точка входа в приложение.

---

# 📦 Описание пакетов

| Пакет | Назначение |
|--------|------------|
| **app** | Точка входа в приложение. Запуск проекта и выполнение основных сценариев работы. |
| **config** | Конфигурация Hibernate, Redis, подключение к базе данных и настройка приложения. |
| **dao** | Слой доступа к данным (DAO). Выполнение запросов к MySQL через Hibernate. |
| **domain** | JPA-сущности, отображающие таблицы базы данных (`City`, `Country`, `CountryLanguage`). |
| **redis** | Модели данных, используемые для хранения информации в Redis. |
| **service** | Бизнес-логика приложения: преобразование данных, запись в Redis, чтение данных и сравнение производительности. |
| **util** | Вспомогательные классы и утилиты проекта. |

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

# 📊 Пример результата

```text
Из MySQL считано городов: 4079
В Redis сохранено городов: 4079
-------------------------------------
Redis : 7 ms
MySQL : 32 ms
-------------------------------------
```



---

<div align="center">

### JavaRush Module 4 Final Project

⭐ Hibernate • MySQL • Redis • Docker • Java 17 ⭐

</div>