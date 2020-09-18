package model.state;

import minesweeper.Game;
import minesweeper.GameModel;

public class GameStateLost implements GameModelState {
    @Override
    public void openCell(Game context, int row, int col) {
        // method not allowed in this state !
    }
}
