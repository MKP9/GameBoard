package gameBoardTest;

import cell.Cell;
import gameboard.gameBoard;
import goCell.GoCell;
import org.junit.Test;
import simpleGameBoard.SimpleGameBoard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;


public class GameboardTest {

    @Test
    public void testAddCell() {

        gameBoard gameBoard = new gameBoard();
        assertEquals(1, gameBoard.getCellNumber());
        Cell cell = new Cell();
        gameBoard.addCell(cell);
        assertEquals(2, gameBoard.getCellNumber());
    }

    @Test
    public void testFirstCell() {

        gameBoard gameBoard = new gameBoard();
        Cell firstCell = gameBoard.getCell(0);
        assertSame(GoCell.class, firstCell.getClass());
    }

    @Test
    public void testGetCellIndex() {

        gameBoard gameBoard = new SimpleGameBoard();
        Cell blue2 = gameBoard.getCell(2);
        int index = gameBoard.getCellIndex(blue2);
        assertEquals(2, index);
        Cell notExist = new Cell();
        index = gameBoard.getCellIndex(notExist);
        assertEquals(-1, index);
    }
}
