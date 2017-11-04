/** Michael Peterson
 *  11/03/2017
 *  Assn 09: TDD Tutorial Walkthrough
 *  Gameboard PlayerTest Class
 *  https://github.com/MKP9
 *  https://travis-ci.org/
 *  Create a new Java project incorporating jUnit.  Using the packet provided walk
 *  through the Test Driven Development (TDD) for a simplified game application.
 */

package playerTest;

import cell.Cell;
import gameMaster.GameMaster;
import gameboard.GameBoard;
import org.junit.Test;
import player.Player;
import simpleGameBoard.SimpleGameBoard;

import static org.junit.Assert.assertSame;

/** PlayerTest Class will use jUnit testing for when a player is created, the starting
 *  position for that player is at 'Go'.
 *  assertSame: this will assert that two objects refer to the same object.
 *  @author Michael Peterson *Not original code author*
 *  @version 1.0
 */
public class PlayerTest {

    @Test
   public void testStartPosition() {

       GameBoard board = new SimpleGameBoard();
       GameMaster.instance().setGameBoard(board);
       Player player1 = new Player();
       Player player2 = new Player();
       Cell go = board.getCell(0);
       assertSame(go, player1.getPosition());
       assertSame(go, player2.getPosition());
   }
}
