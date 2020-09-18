package model.cell;

public class Cell implements CellOperations {

    private boolean isOpened;
    private boolean isMine;


    public Cell() {
        isOpened = false;
        isMine = false;
    }

    public boolean isOpen() {
        return isOpened;
    }

    public boolean isMine() {
        return isMine;
    }


    public void open() {
        if (isOpened) {
            throw new IllegalStateException("cell is already visited");
        }
        isOpened = true;
    }

    public void setMine() {
        isMine = true;
    }

}
