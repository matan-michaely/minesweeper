package minesweeper;

import model.board.Board;
import model.cell.CellOperations;

public interface GameModel {

    void setBoard(Board board);
    void openCell(int row,int col);
    int getNeighbourMines(int row, int col);
    CellOperations getCell(int row,int col);
    GameStatus getGameStatus();
}
