## Forkful

A repo for a restaurant ordering app written using spring boot and kotlin. Restaurants can accept orders, upload menus, manage the order lifecycle and opening times. Customers can browse menus, order, check on order statuses and pay. Couriers can accept orders and deliver to users.

### Running the application locally

To run the project locally run:

```./gradlew bootRun```

### Testing the app

To test the app, run:

```./gradlew test```

### Linting & Formatting

This project uses spotless and ktlint, install the pre-commit hook which checks for issues by running:

```chmod +x scripts/pre-commit```

```git config core.hooksPath scripts```

to fix issues, run:

```./gradlew spotlessApply```

### Database Schema

To view the database schema, you can find it [here](docs/architecture/schema.dbml)