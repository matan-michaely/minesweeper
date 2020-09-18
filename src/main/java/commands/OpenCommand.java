package commands;

import minesweeper.GameModel;
import view.ConsolePrinter;

public class OpenCommand extends Command{

    private int row;
    private int col;
    public OpenCommand(final int row,final int col){
        this.row = row;
        this.col = col;
    }

    @Override
    public void execute(GameModel gameModel, ConsolePrinter printer) {
        gameModel.openCell(row,col);
        // means that we keep playing
        if(!gameModel.getGameStatus().gameLost() && !gameModel.getGameStatus().gameWon()){
            System.out.println();
            printer.print();
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
