package model.state;

import minesweeper.Game;

public class GameStateWon implements GameModelState {
    @Override
    public void openCell(Game context, int row, int col) {
        // method not allowed in this state !
    }
}
