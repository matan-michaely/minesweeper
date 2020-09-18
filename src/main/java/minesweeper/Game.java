package minesweeper;

import model.board.Board;
import model.cell.Cell;
import model.state.GameModelState;
import model.state.GameStateLost;
import model.state.GameStateRun;
import model.state.GameStateWon;

public class Game implements GameModel, GameStatus {

    private Board board;
    private GameModelState state;

    public Game(){
        setBoard(new Board());
    }
    @Override
    public void setBoard(final Board board) {
        this.board = board;
        state = new GameStateRun();
    }

    @Override
    public void openCell(int row, int col) {
        state.openCell(this, row, col);
    }

    @Override
    public int getNeighbourMines(int row, int col) {
        return board.getNeighbourMineCount(row, col);
    }

    public int getNeighbourMines(Cell cell) {
        return board.getNeighbourMineCount(cell);
    }


    @Override
    public Cell getCell(int row, int col) {
        return this.board.getCell(row, col);
    }

    @Override
    public GameStatus getGameStatus() {
        return this;
    }

    @Override
    public int getRowCount() {
        return this.board.getRows();
    }

    @Override
    public int getColCount() {
        return this.board.getColumns();
    }

    @Override
    public int getCountOfMines() {
        return this.board.getMines();
    }

    @Override
    public boolean gameWon() {
        return state instanceof GameStateWon;
    }

    @Override
    public boolean gameLost() {
        return state instanceof GameStateLost;
    }

    public GameModelState getState() {
        return state;
    }

    public void setState(final GameModelState state) {
        this.state = state;
    }

    // Board is needed by state pattern
    public Board getBoard() {
        return board;
    }

}
