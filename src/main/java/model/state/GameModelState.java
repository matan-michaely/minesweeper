package model.state;

import minesweeper.Game;
import minesweeper.GameModel;

public interface GameModelState {

    void openCell(Game context, int row, int col);
}
