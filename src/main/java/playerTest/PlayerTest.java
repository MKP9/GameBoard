package playerTest;

import cell.Cell;
import gameMaster.GameMaster;
import gameboard.gameBoard;
import org.junit.Test;
import player.Player;
import simpleGameBoard.SimpleGameBoard;

import static org.junit.Assert.assertSame;

public class PlayerTest {

    @Test
   public void testStartPosition() {

       gameBoard board = new SimpleGameBoard();
       GameMaster.instance().setGameBoard(board);
       Player player1 = new Player();
       Player player2 = new Player();
       Cell go = board.getCell(0);
       assertSame(go, player1.getPosition());
       assertSame(go, player2.getPosition());
   }
}
