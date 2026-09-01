# Cards
 
A simple Java implementation of the card game **Crazy Eights**.
 
## Overview
 
This project models the core building blocks of a standard card game — cards, decks, hands, and players — and uses them to implement a playable version of Crazy Eights.
 
## Project Structure
 
```
src/
├── Card.java             # Represents a single playing card
├── CardCollection.java   # Base/shared logic for groups of cards
├── Deck.java             # The deck of cards (shuffle, draw, etc.)
├── Hand.java             # A player's hand of cards
├── Player.java           # Represents a player in the game
├── Eights.java           # Crazy Eights game logic and rules
└── Test.java             # Entry point used to compile and run the game
```
 
## Requirements
 
- Java Development Kit (JDK) 8 or later
## How to Run
 
Clone the repository and compile the source files:
 
```bash
git clone https://github.com/MiguelLima-dev/Cards.git
cd Cards/src
javac *.java
java Test
```
 
This compiles all classes and runs the game via `Test.java`.
 
## Classes
 
| Class | Responsibility |
|---|---|
| `Card` | Represents an individual card (rank/suit) |
| `CardCollection` | Shared behavior for any group of cards |
| `Deck` | Manages the full deck: shuffling and dealing |
| `Hand` | Tracks the cards held by a player |
| `Player` | Represents a participant in the game |
| `Eights` | Implements the rules and flow of Crazy Eights |
| `Test` | Runs the game from the command line |
