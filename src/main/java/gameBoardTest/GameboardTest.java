/** Michael Peterson
 *  11/03/2017
 *  Assn 09: TDD Tutorial Walkthrough
 *  Gameboard
 *  https://github.com/MKP9
 *  https://travis-ci.org/
 *  Create a new Java project incorporating jUnit.  Using the packet provided walk
 *  through the Test Driven Development (TDD) for a simplified game application.
 */

package gameBoardTest;

import cell.Cell;
import gameboard.GameBoard;
import goCell.GoCell;
import org.junit.Test;
import simpleGameBoard.SimpleGameBoard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**  GameboardTest Class will use jUnit to test if a game board is initialized
 *   with the first cell, that the first cell is the 'Go' cell.
 *   @author Michael Peterson *Not original code author*
 *   @version 1.0
 */
public class GameboardTest {

    /** This will test when a game board is initialized, a cell is created.
     *  assertEquals: assert that two objects are equal.
     */
    @Test
    public void testAddCell() {

        GameBoard gameBoard = new GameBoard();
        assertEquals(1, gameBoard.getCellNumber());
        Cell cell = new Cell();
        gameBoard.addCell(cell);
        assertEquals(2, gameBoard.getCellNumber());
    }

    /** This will test when a game board is initialized, a cell is created and
     *  that cell is the 'Go' cell.
     *  assertSame: this will assert that two objects refer to the same object.
     */
    @Test
    public void testFirstCell() {

        GameBoard gameBoard = new GameBoard();
        Cell firstCell = gameBoard.getCell(0);
        assertSame(GoCell.class, firstCell.getClass());
    }

    /** This will the game board cells are the correct cells initialized when
     *  the game board is created.  If a cell is found, the index is returned.
     *  If a cell is not found, '-1' is returned.
     *  assertEquals: assert that two objects are equal.
     */
    @Test
    public void testGetCellIndex() {

        GameBoard gameBoard = new SimpleGameBoard();
        Cell blue2 = gameBoard.getCell(2);
        int index = gameBoard.getCellIndex(blue2);
        assertEquals(2, index);
        Cell notExist = new Cell();
        index = gameBoard.getCellIndex(notExist);
        assertEquals(-1, index);
    }
}
