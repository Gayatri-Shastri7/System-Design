# TicTacToe Game Documentation

## Table of Contents
- [Requirements](#requirements)
- [Functional Requirements](#functional-requirements)
- [Non-Functional Requirements](#non-functional-requirements)
- [Scalability Considerations](#scalability-considerations)
- [UML Diagram](#uml-diagram)
- [Code Structure](#code-structure)
- [Future Enhancements](#future-enhancements)

## Requirements

### 1. Functional Requirements:
- **Players**: The game will have two players.
- **Board**: The game should consist of a 3x3 grid (board).
- **Moves**: Players take turns making moves on the grid.
- **Game Status**: Track the current status of the game (IN_PROGRESS, WIN, DRAW).
- **Winning Conditions**: A player wins when they place 3 of their pieces in a row (either horizontally, vertically, or diagonally).
- **Game End**: The game ends when one player wins or the board is full with no winner, resulting in a draw.

### 2. Non-Functional Requirements:
- **Usability**: The game should be easy to play with clear instructions and feedback.
- **Performance**: The game should handle multiple rounds without performance degradation.
- **Security**: The game should not allow invalid moves (e.g., making a move on an already occupied cell).
- **Error Handling**: Provide appropriate error messages for invalid moves, game restart requests, etc.
- **Platform Support**: The game should run on any Java-supported environment.

---

## Functional Requirements

- **Start New Game**: Allow players to initialize a new game by specifying their names.
- **Make a Move**: Players take turns to choose a cell in the 3x3 grid and place their mark.
- **Display Board**: Display the game board after each move.
- **Check Winner**: After every move, check if there is a winner or if the game is a draw.
- **End Game**: Announce the winner or a draw at the end of the game and offer a restart.

---

## Non-Functional Requirements

- **Extensibility**: The system should allow future enhancements, such as:
  - Adding AI functionality for single-player mode.
  - Supporting larger grid sizes (e.g., 4x4 or 5x5).
  
- **Performance**: The game should run efficiently even with multiple rounds. The current grid size (3x3) allows for constant-time operations.

- **Testability**: The game should be easily testable with unit tests for each method, especially the core logic like winning conditions and making moves.

- **Modularity**: The design should be modular, separating concerns like game logic, UI, and player handling to allow future updates or changes.

---

## Scalability Considerations

### How to Make the Game More Scalable:

1. **Larger Boards**:
   - Currently, the game supports a 3x3 grid, but the system can be made scalable to support larger grids (e.g., 4x4, 5x5, nxn).

2. **AI Player**:
   - To allow single-player mode, an AI player, multiplayer can be introduced.
   - Implement a Minimax algorithm to allow the system to play against a human.
     [Link](https://github.com/Gayatri-Shastri7/TicTacToe) 

3. **Multiplayer**:
   - Future versions of the game could support online multiplayer, where players from different devices can play in real-time.
   - This would require the integration of a server-client model using websockets or other communication protocols.

4. **Game Replay**:
   - The game can be made scalable by adding a feature to allow players to replay the game, store the history of moves, or even resume games from where they left off.

5. **User Interface**:
   - While the current game is a console-based implementation, a web or mobile application interface could be introduced for better user interaction.

---

## Code Structure

1. **Main Class (`TicTacToe`)**:
   - Contains the main entry point and initializes the game.

2. **Game Class**:
   - Responsible for managing the game's flow, like making moves, checking for a winner, and handling game status.

3. **Board Class**:
   - Manages the 3x3 grid and provides methods to make moves, display the board, and check for a winner.

4. **Player Class**:
   - Represents a player in the game with properties like name and piece (X or O).

5. **Piece Enum**:
   - Defines the possible game pieces (`X`, `O`).

---

## Future Enhancements

- **AI Implementation**: Add an AI for single-player mode using the Minimax algorithm.
- **Multiplayer Support**: Support online multiplayer by integrating with server-side technology.
- **Enhanced UI**: Develop a graphical user interface (GUI) using frameworks like JavaFX or Swing, or implement a web version using technologies like React and Spring Boot.
- **Game Replay**: Implement functionality for saving and replaying games.
- **Multiple Board Sizes**: Support boards of different sizes (e.g., 4x4, 5x5).

---
