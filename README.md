# SWIGGY
# Magical Arena

This project simulates a magical arena where two players fight until one of them loses all their health. Players take turns attacking and defending using dice rolls.

## How to Run

1. Compile the Java files:
   ```sh
   javac Player.java MagicalArena.java
   ```

2. Run the program:
   ```sh
   java MagicalArena
   ```

## How It Works

- Each player has health, strength, and attack attributes.
- Players take turns attacking and defending.
- The attacker rolls a die to determine the attack power.
- The defender rolls a die to determine the defense strength.
- The defender's health is reduced by the difference between the attack power and defense strength.

## Unit Tests

Unit tests are provided in the `MagicalArenaTest.java` file. To run the tests, use a testing framework like JUnit.
