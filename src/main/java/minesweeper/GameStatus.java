package minesweeper;

public interface GameStatus {
    int getRowCount();
    int getColCount();
    int getCountOfMines();

    boolean gameWon();
    boolean gameLost();
}
