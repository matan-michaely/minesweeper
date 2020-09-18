package view;

import commands.Command;
import commands.CommandFactory;
import minesweeper.GameStatus;
import minesweeper.GameModel;
import model.board.Board;

import java.util.Scanner;

public final class Console {

    private final GameModel gameModel;
    private final GameStatus gameStatus;
    private final Scanner keyboard;
    private final ConsolePrinter printer;

    private int rows;
    private int cols;
    private int mines;

    public Console(final GameModel gameModel) {
        this.gameModel = gameModel;
        this.gameStatus = gameModel.getGameStatus();
        this.printer = new ConsolePrinter(gameModel);
        this.keyboard = new Scanner(System.in);
    }

    public void start() {
        setup();
        performClick();
    }

    private void setup() {
        System.out.print("Enter count of rows (>" + (Board.ROWS_MIN - 1) + "): ");
        this.rows = getInt(Board.ROWS_MIN);
        System.out.print("Enter count of columns (>" + (Board.COLUMNS_MIN - 1) + "): ");
        this.cols = getInt(Board.COLUMNS_MIN);
        System.out.print("Enter count of mines (>" + (Board.MINES-1) + "): ");
        this.mines = getInt(Board.MINES);
        this.gameModel.setBoard(new Board(this.rows, this.cols, this.mines));
        this.printer.print();
    }

    private int getInt(final int min) {
        int value = min - 1;
        while (value < min) {
            String input = keyboard.nextLine();
            try {
                value = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid number");
            }

        }
        return value;
    }

    private void performClick() {
        Command command;
        boolean active = true;
        while (active) {
            command = getCommand();
            command.execute(gameModel, printer);

            if (gameStatus.gameWon()) {
                active = false;
                System.out.println("You have won !!!");
            } else if (gameStatus.gameLost()) {
                active = false;
                System.out.println("You have lost !!!");
            }
        }
        this.printer.print();
    }

    private Command getCommand() {
        System.out.print("Command: ");
        String input = keyboard.nextLine();
        return CommandFactory.getCommand(input, rows, cols);
    }

}
