# Sta-Meow
### Inventory app for OOP project

## Business Type
    Stationary

## Project Structure
```
PROJECT_ROOT/
|   README.md
|
+---.github
|   \---workflows
|           maven.yml
|
+---res
|   +---credentials
|   |       IMPORTANT.json
|   |
|   \---fxml
|           adminstameow.fxml
|           main.fxml
|           userstameow.fxml
|
\---src
    \---com
        \---sta
            |   AdminStaMeowController.java
            |   LogInController.java
            |   Main.java
            |   UserStaMeowController.java
            |
            +---item
            |       Item.java
            |
            \---utilities
                    Utilities.java


```

## Compass?
1. Resources(.fxml, .png) > `res`, Create a new folder to segregate types.
2. Classes > `src/ com.sta`, create new package if needed