package model.board;

import model.cell.Cell;

import java.util.Random;

public final class BoardInitializer {

    private final static Random random = new Random();

    public static Cell[][] build(final int rows, final int cols, int mines) {
        mines = Math.max(0, Math.min(mines, rows * cols));

        Cell[][] board = new Cell[rows][cols];
        setBoardWithCells(board);
        setBoardWithMines(board, mines);
        return board;
    }

    public static void setBoardWithCells(final Cell[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = new Cell();
            }
        }
    }

    public static void setBoardWithMines(final Cell[][] board, int mines) {
        while (mines != 0){
            int rowRand = random.nextInt(board.length);
            int colRand = random.nextInt(board[0].length);

            if(!board[rowRand][colRand].isMine()){
                board[rowRand][colRand].setMine();
                mines--;
            }


        }

    }


}
