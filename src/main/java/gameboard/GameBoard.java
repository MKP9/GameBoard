/** Michael Peterson
 *  11/03/2017
 *  Assn 09: TDD Tutorial Walkthrough
 *  Gameboard GameBoard Class
 *  https://github.com/MKP9
 *  https://travis-ci.org/
 *  Create a new Java project incorporating jUnit.  Using the packet provided walk
 *  through the Test Driven Development (TDD) for a simplified game application.
 */

package gameboard;

import cell.Cell;
import goCell.GoCell;

import java.util.ArrayList;

public class GameBoard {

    ArrayList cells = new ArrayList();

    public GameBoard() {

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
