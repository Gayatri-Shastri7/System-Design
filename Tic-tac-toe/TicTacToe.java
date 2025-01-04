public class TicTacToe {

    public enum Piece {
        X("X"), O("O");

        private final String symbol;

        Piece(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }

    static class Player {
        private String name;
        private Piece piece;

        public Player(String name, Piece piece) {
            this.name = name;
            this.piece = piece;
        }

        public String getName() {
            return name;
        }

        public Piece getPiece() {
            return piece;
        }
    }

    static class Cell {
        private Piece piece;

        public Cell() {
            this.piece = null; 
        }

        public boolean isEmpty() {
            return piece == null;
        }

        public void setPiece(Piece piece) {
            this.piece = piece;
        }

        public Piece getPiece() {
            return piece;
        }
    }

    static class Board {
        private Cell[][] cells;

        public Board() {
            cells = new Cell[3][3];
            initializeBoard();
        }

        private void initializeBoard() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cells[i][j] = new Cell();
                }
            }
        }

        public void displayBoard() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    Piece piece = cells[i][j].getPiece();
                    System.out.print(piece == null ? "_" : piece.getSymbol());
                    if (j < 2) System.out.print(" | ");
                }
                System.out.println();
                if (i < 2) System.out.println("---------");
            }
        }

        public boolean makeMove(int row, int col, Piece piece) {
            if (row < 0 || row >= 3 || col < 0 || col >= 3 || !cells[row][col].isEmpty()) {
                return false; // Invalid move
            }
            cells[row][col].setPiece(piece);
            return true;
        }

        public boolean checkWinner(Piece piece) {
            // Check rows, columns, and diagonals
            for (int i = 0; i < 3; i++) {
                if (cells[i][0].getPiece() == piece && cells[i][1].getPiece() == piece && cells[i][2].getPiece() == piece) {
                    return true;
                }
                if (cells[0][i].getPiece() == piece && cells[1][i].getPiece() == piece && cells[2][i].getPiece() == piece) {
                    return true;
                }
            }
            if (cells[0][0].getPiece() == piece && cells[1][1].getPiece() == piece && cells[2][2].getPiece() == piece) {
                return true;
            }
            if (cells[0][2].getPiece() == piece && cells[1][1].getPiece() == piece && cells[2][0].getPiece() == piece) {
                return true;
            }
            return false;
        }

        public boolean isDraw() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (cells[i][j].isEmpty()) {
                        return false; 
                    }
                }
            }
            return true; 
        }
    }

    enum GameStatus {
        IN_PROGRESS, PLAYER_1_WINS, PLAYER_2_WINS, DRAW
    }

    static class Game {
        private Board board;
        private Player player1;
        private Player player2;
        private Player currentPlayer;
        private GameStatus status;

        public Game() {
            this.board = new Board();
            this.status = GameStatus.IN_PROGRESS;
        }

        public void initializeGame(String player1Name, String player2Name) {
            player1 = new Player(player1Name, Piece.X);
            player2 = new Player(player2Name, Piece.O);
            currentPlayer = player1;
        }

        public void play(int row, int col) {
            if (status != GameStatus.IN_PROGRESS) {
                System.out.println("Game Over! Start a new game.");
                return;
            }

            if (!board.makeMove(row, col, currentPlayer.getPiece())) {
                System.out.println("Invalid move. Try again.");
                return;
            }

            board.displayBoard();

            if (board.checkWinner(currentPlayer.getPiece())) {
                status = currentPlayer == player1 ? GameStatus.PLAYER_1_WINS : GameStatus.PLAYER_2_WINS;
                System.out.println("Player " + currentPlayer.getName() + " wins!");
            } else if (board.isDraw()) {
                status = GameStatus.DRAW;
                System.out.println("The game is a draw.");
            } else {
                currentPlayer = currentPlayer == player1 ? player2 : player1;
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.initializeGame("Player 1", "Player 2");

        // Simulate some moves
        game.play(0, 0); // Player 1 (X)
        game.play(0, 1); // Player 2 (O)
        game.play(1, 0); // Player 1 (X)
        game.play(1, 1); // Player 2 (O)
        game.play(2, 0); // Player 1 (X) wins
    }
}
