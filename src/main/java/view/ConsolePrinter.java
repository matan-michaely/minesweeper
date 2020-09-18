package view;

import minesweeper.GameModel;
import minesweeper.GameStatus;
import model.cell.CellOperations;

public final class ConsolePrinter {

    private static final String NOT_VISITED = " · ";
    private static final String IS_EMPTY = " - ";

    private final GameModel gameModel;
    private final GameStatus gameStatus;


    public ConsolePrinter(final GameModel gameModel) {
        this.gameModel = gameModel;
        this.gameStatus = gameModel.getGameStatus();
    }


    public void print() {
        for (int row = 0; row < gameStatus.getRowCount(); row++) {
            for (int col = 0; col < gameStatus.getColCount(); col++) {
                System.out.print(getChar(row, col));
            }
            System.out.println();
        }
        System.out.println();
    }

    private String getChar(final int row, final int col) {
        CellOperations cell = gameModel.getCell(row, col);

        if (!cell.isOpen()) {
            return NOT_VISITED;
        }

        int neighbourCount = gameModel.getNeighbourMines(row, col);

        if (neighbourCount == 0) {
            return IS_EMPTY;
        } else {
            return " " + neighbourCount + " ";
        }
    }

}
