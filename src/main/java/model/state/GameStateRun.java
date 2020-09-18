package model.state;

import minesweeper.Game;
import model.board.Board;
import model.cell.Cell;


import java.util.LinkedList;
import java.util.List;

public class GameStateRun implements GameModelState {

    @Override
    public void openCell(final Game game, final int row, final int col) {
        Cell cell = game.getCell(row, col);
        if (cell.isMine()) {
            game.setState(new GameStateLost());
            return;
        }

        if (cell.isOpen() || game.getNeighbourMines(cell) == 0) {
            openCellBFS(game, cell);
        } else {
            cell.open();
            game.getBoard().incrementOpen();
        }

        if (gameIsWon(game)) {
            game.setState(new GameStateWon());
        }
    }


    private void openCellBFS(final Game game, final Cell cell){
        LinkedList<Cell> cells  = new LinkedList<>();
        cells.add(cell);
        cell.open();
        game.getBoard().incrementOpen();
        while (cells.size() > 0){
            Cell currentCell = cells.poll();
            List<Cell> neighbours = game.getBoard().getNeighbourCells(currentCell);
            for (Cell neighbour : neighbours) {
                if(!neighbour.isOpen() && !neighbour.isMine()){
                    neighbour.open();
                    game.getBoard().incrementOpen();
                    if(game.getNeighbourMines(neighbour) == 0)
                        cells.add(neighbour);
                }
            }
        }
    }

    private boolean gameIsWon(final Game game) {
        final Board board = game.getBoard();
        return (board.getRows() * board.getColumns()) - board.getMines() == board.getOpened();
    }

}
