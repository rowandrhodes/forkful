## Forkful

A repo for a restaurant ordering app written using spring boot and kotlin. Restaurants can accept orders, upload menus, manage the order lifecycle and opening times. Customers can browse menus, order, check on order statuses and pay. Couriers can accept orders and deliver to users.

### Running the application locally

Copy the example environment file (first time only), start the database, then run the app:

```cp .env.example .env```

```make db-up```

```./gradlew bootRun```

`GET /actuator/health` returns `UP` when the app can reach the database.

### Testing the app

To test the app, run:

```./gradlew test```

### Local database

Postgres 16 with PostGIS runs in Docker, on the host port set by `DB_PORT` (5433 by default).

| Command | What it does |
| --- | --- |
| `make db-up` | Start the database and wait until it is healthy |
| `make db-down` | Stop the database and keep its data |
| `make db-reset` | Delete all local data and start with an empty database |
| `make db-clean` | Drops all the migrations, and then reruns, only to be used locally, good if you switch branches  |
| `make db-new name={name}` | Creates a new migrations file within main/resources/db/migrations, names it with the incremented version |


To open `psql` without installing it on your machine:

```docker compose exec db sh -c 'psql -U "$POSTGRES_USER" -d "$POSTGRES_DB"'```

To connect from `psql` on your machine or from a GUI client, use `localhost`, the `DB_PORT` port, and the `DB_USER`, `DB_PASSWORD` and `DB_NAME` values in `.env`.

The app connects using `DATABASE_URL`. This must be a JDBC URL, such as `jdbc:postgresql://localhost:5433/forkful`, and the credentials come from `DB_USER` and `DB_PASSWORD`.

### Linting & Formatting

This project uses spotless and ktlint, install the pre-commit hook which checks for issues by running:

```chmod +x scripts/pre-commit```

```git config core.hooksPath scripts```

to fix issues, run:

```./gradlew spotlessApply```

### Database Schema

To view the database schema, you can find it [here](docs/architecture/schema.dbml)
