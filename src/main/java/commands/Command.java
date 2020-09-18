package commands;

import minesweeper.GameModel;
import view.ConsolePrinter;

public abstract class Command {
    public abstract void execute(GameModel gameModel, ConsolePrinter printer);
}
