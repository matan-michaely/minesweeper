package model.board;

import model.cell.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {

    public static final int ROWS_MIN = 4;
    public static final int COLUMNS_MIN = 4;
    public static final int MINES = 1;

    private Cell[][] cells;
    private int mines = MINES;
    private int opened = 0;

    // define this cache inorder to get cell position.
    private final HashMap<Cell, Integer> cacheRow = new HashMap<>();
    private final HashMap<Cell, Integer> cacheColumn = new HashMap<>();

    public Board() {
        this(ROWS_MIN, COLUMNS_MIN, MINES);
    }

    public Board(int rows, int cols, int mines) {
        rows = Math.max(rows, ROWS_MIN);
        cols = Math.max(cols, COLUMNS_MIN);
        this.mines = getMines(rows * cols, mines);
        cells = BoardInitializer.build(rows, cols, mines);
        initiateCache(cells);
        opened = 0;
    }

    public int getOpened() {
        return opened;
    }

    public void incrementOpen() {
        opened++;
    }

    public int getRows() {
        return cells.length;
    }

    public int getColumns() {
        return cells[0].length;
    }

    public Cell getCell(final int row, final int col) {
        if (!inRange(row, col)) {
            throw new IndexOutOfBoundsException();
        }
        return cells[row][col];
    }

    public int getMines() {
        return this.mines;
    }

    public int getMines(final int cells, int mines) {
        if (cells > mines) {
            return mines;
        }
        throw new IllegalArgumentException("there are too many mines given");
    }

    private void initiateCache(final Cell[][] cells) {
        cacheRow.clear();
        cacheColumn.clear();

        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getColumns(); col++) {
                cacheRow.put(cells[row][col], row);
                cacheColumn.put(cells[row][col], col);
            }
        }

    }

    private boolean inRange(final int row, final int col) {
        if (row < 0 || row >= getRows() || col < 0 || col >= getColumns()) {
            return false;
        } else {
            return cells[row][col] != null;
        }
    }

    public int getNeighbourMineCount(final int row, final int col) {
        return getNeighbourMineCount(getCell(row, col));
    }

    public int getNeighbourMineCount(Cell cell) {
        int amountOfNeighbourMines = 0;
        List<Cell> neighbours = getNeighbourCells(cell);
        for (Cell neighbour : neighbours) {
            if (neighbour.isMine()) {
                amountOfNeighbourMines++;
            }
        }
        return amountOfNeighbourMines;
    }


    public List<Cell> getNeighbourCells(final Cell cell) {
        int row = cacheRow.get(cell);
        int col = cacheColumn.get(cell);
        return getNeighbourCells(row, col);

    }

    private List<Cell> getNeighbourCells(final int row, final int col) {
        List<Cell> neighbours = new ArrayList<>();
        if (inRange(row - 1, col - 1)) {
            neighbours.add(cells[row - 1][col - 1]);
        }
        if (inRange(row - 1, col)) {
            neighbours.add(cells[row - 1][col]);
        }
        if (inRange(row - 1, col + 1)) {
            neighbours.add(cells[row - 1][col + 1]);
        }
        if (inRange(row, col - 1)) {
            neighbours.add(cells[row][col - 1]);
        }
        if (inRange(row, col + 1)) {
            neighbours.add(cells[row][col + 1]);
        }
        if (inRange(row + 1, col - 1)) {
            neighbours.add(cells[row + 1][col - 1]);
        }
        if (inRange(row + 1, col)) {
            neighbours.add(cells[row + 1][col]);
        }
        if (inRange(row + 1, col + 1)) {
            neighbours.add(cells[row + 1][col + 1]);
        }
        return neighbours;
    }
}
