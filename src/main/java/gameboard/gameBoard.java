package gameboard;

import cell.Cell;
import goCell.GoCell;

import java.util.ArrayList;

public class gameBoard {

    ArrayList cells = new ArrayList();

    public gameBoard() {

        addCell(new GoCell());
    }

    public void addCell(Cell cell) {

        cells.add(cell);
    }

    public int getCellNumber() {

        return cells.size();
    }

    public Cell getCell(int index) {

        return (Cell)cells.get(index);
    }

    public int getCellIndex(Cell cell) {

        return cells.indexOf(cell);
    }
}
