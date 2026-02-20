# Tic-Tac-Toe

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=flat-square)

A classic two-player Tic-Tac-Toe game built in Java. Players take turns placing X and O on a 3x3 grid via the console, with automatic win detection, draw detection, and replay support.

## Overview

This console-based Tic-Tac-Toe game allows two players to compete on a numbered 3x3 board. Players select positions 1--9 corresponding to board cells, and the game validates inputs, checks for occupied positions, and detects wins across rows, columns, and diagonals. After each game, players are prompted to play again or quit.

## Features

- **Two-Player Gameplay** -- Players alternate turns as X and O
- **Numbered Board** -- Positions 1--9 map to the grid for intuitive input
- **Input Validation** -- Rejects out-of-range positions and already-occupied cells
- **Win Detection** -- Checks all rows, columns, and diagonals for three-in-a-row
- **Draw Detection** -- Declares a draw when all nine positions are filled with no winner
- **Replay Support** -- Option to play another game without restarting the program
- **Board Display** -- Visual board is printed to the console after each move

## Prerequisites

- **Java JDK** 8 or higher

## Getting Started

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/danielcregg/tic-tac-toe.git
   cd tic-tac-toe
   ```

### Usage

**Compile and run from the command line:**

```bash
javac -d bin src/ie/gmit/game/Main.java
java -cp bin ie.gmit.game.Main
```

Follow the on-screen prompts to select positions (1--9) on the board. The game will display the updated board after each move and announce the winner or a draw.

## Tech Stack

- **Language:** Java
- **I/O:** `java.util.Scanner` for console input

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
