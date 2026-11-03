## Forkful

A repo for a restaurant ordering app

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