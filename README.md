# Cards

A Java implementation of the card game **Crazy Eights**, built from the "Extending Classes" chapter of [*Think Java*](https://greenteapress.com/thinkjava/) by Allen Downey and Chris Mayfield.

## Overview

This project builds up a small object-oriented card-game framework — cards, decks, and collections of cards — and uses it to implement Crazy Eights, a game where players take turns discarding cards that match the rank or suit of the previous card (or play an eight as a wildcard). The first player to get rid of all their cards wins.

## How to Play

- Each player is dealt a hand of cards, and one card is turned face up to start the discard pile. The rest form the draw pile.
- On each turn, a player plays a card matching the rank or suit of the top discard, or plays an eight (wild).
- If a player has no valid card, they draw from the draw pile until they get one.
- If the draw pile runs out, the discard pile (except the top card) is reshuffled to form a new draw pile.
- The first player to empty their hand wins.

## Project Structure

```
src/
├── Card.java             # A single playing card (rank and suit)
├── CardCollection.java   # Base class for any group of cards (deck, hand, pile)
├── Deck.java             # A full 52-card deck; extends CardCollection
├── Hand.java             # A player's hand or a pile of cards; extends CardCollection
├── Player.java           # A player and their hand
├── Eights.java           # Crazy Eights game logic (deals, turns, rules)
└── Test.java             # Entry point that starts a game
```

`Deck` and `Hand` both extend `CardCollection`, so shared behavior (like adding or dealing cards) lives in one place, while each subclass adds what's specific to it — a full ordered deck versus a growing/shrinking hand or pile.

## Requirements

- Java Development Kit (JDK) 8 or later

## How to Run

```bash
git clone https://github.com/MiguelLima-dev/Cards.git
cd Cards/src
javac *.java
java Test player1 player2
```

This compiles all classes and starts a game via `Test.java`.

## Credits

This project follows the design and exercises from **Chapter 14, "Extending Classes,"** in *Think Java: How to Think Like a Computer Scientist* by Allen B. Downey and Chris Mayfield. The book and its reference code are freely available at [greenteapress.com/thinkjava](https://greenteapress.com/thinkjava/).
