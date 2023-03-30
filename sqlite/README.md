# SQLite JDBC

## Структура модуля

### `example/` 

Содержит запросы на SQL

- `create.sql` - создание таблиц
- `init.sql` - заполнение таблиц данными
- `delete.sql` - удаление всех записей из таблиц
- `drop.sql` - удаление таблиц

### `scripts/` 

Содержит скрипт `run_queries.sh` для выполнения запросов из `example/`
в заданом файле БД

```bash
./scripts/run_queries.sh <command=create|init|delete|drop> <database filename>
```

### `src/` 

Содержит исходный код примеров взаимодействия с базой данных с использованием
драйвера *sqlite-jdbc*

## Инициализация БД

Создание таблиц

```bash
./scripts/run_queries.sh create jdbc_database.db
```

Заполнение данными

```bash
./scripts/run_queries.sh init jdbc_database.db
```

Также можно создать таблицы и заполнить их, пользуясь
утилитой `sqlite3`

```bash
sqlite3 jdbc_database.db
```

И вводим нужные запросы

## Запуск примера

```bash
./gradlew :sqlite:run
```
