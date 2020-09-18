package commands;

import minesweeper.GameModel;
import view.ConsolePrinter;

public class InvalidCommand extends Command {
    @Override
    public void execute(GameModel gameModel, ConsolePrinter printer) {
        // can't work because this command is invalid.
    }
}
