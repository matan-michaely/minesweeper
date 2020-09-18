package minesweeper;

import view.Console;

class Minesweeper {

    public static void main(String[] args) {
        GameModel gameModel = new Game();
        Console console = new Console(gameModel);
        console.start();
    }
}
