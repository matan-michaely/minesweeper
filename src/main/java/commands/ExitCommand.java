package commands;

import minesweeper.GameModel;
import view.ConsolePrinter;

public class ExitCommand extends Command {
    @Override
    public void execute(GameModel gameModel, ConsolePrinter printer) {
        System.exit(0);
    }
}
