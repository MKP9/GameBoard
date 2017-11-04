/** Michael Peterson
 *  11/03/2017
 *  Assn 09: TDD Tutorial Walkthrough
 *  Gameboard GameMaster Class
 *  https://github.com/MKP9
 *  https://travis-ci.org/
 *  Create a new Java project incorporating jUnit.  Using the packet provided walk
 *  through the Test Driven Development (TDD) for a simplified game application.
 */

package gameMasterTest;

import cell.Cell;
import gameMaster.GameMaster;
import org.junit.Test;
import player.Player;
import simpleGameBoard.SimpleGameBoard;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertSame;

/**  GameMasterTest Class will use jUnit to test for a single instance of a class,
 *   test for number of players at game initialization,  test player movements, and
 *   to test when a player reaches the end of the game board, that player cycles
 *   around the game board.
 *   @author Michael Peterson *Not original code author*
 *   @version 1.0
 */
public class GameMasterTest {

    GameMaster master;

    public void setup() {

        master = GameMaster.instance();
        master.setGameBoard(new SimpleGameBoard());
    }

    /** Test for a single instance of the GameMaster class.
     *  assertNotNull: this will assert that an object is not null.  This will test
     *                 that a single instance of the GameMaster is created.
     *  assertSame: this will assert that two objects refer to the same object.
     *              This tests that two instances of GameMaster are the same.
     */
    @Test
    public void testSingleton() {

        GameMaster instance1 = GameMaster.instance();
        assertNotNull(instance1);

        GameMaster instance2 = GameMaster.instance();
        assertNotNull(instance2);
        assertSame(instance1, instance2);
    }

    /** Test for number of players at game initialization
     *  assertEquals: assert that two objects are equal. In this case we test for
     *                number of players at game start.
     *  assertSame: this will assert that two objects refer to the same object.  This
     *              will test that all players start at 'Go' at game initialization.
     */
    @Test
    public void testPlayerIntit() {

        master.setNumberOfPlayers(6);
        assertEquals(6, master.getNumberOfPlayers());
        master = GameMaster.instance();
        master.setGameBoard(new SimpleGameBoard());
        assertEquals(6, master.getNumberOfPlayers());

        Cell go = master.getGameBoard().getCell(0);
        for(int i = 0; i < 6; i++) {

            Player player = master.getPlayer(i);
            assertSame(go, player.getPosition());
        }
    }

    /** Test for player movements matching dice roll.
     *  assertEquals: assert that two objects are equal.  This will test a
     *                for a player movements per dice roll.
     */
    @Test
    public void testMovePlayerSimple() {

        master.setNumberOfPlayers(1);
        Player player = master.getPlayer(0);
        master = GameMaster.instance();
        master.setGameBoard(new SimpleGameBoard());
        master.movePlayer(0, 2);
        assertEquals("Blue 2", player.getPosition().getName());
        master.movePlayer(0,3);
        assertEquals("Green 2", player.getPosition().getName());
    }

    /** Test when a player reaches the end of the game board, that player cycles
     *  around the game board.
     *  assertEquals: assert that two objects are equal.  This test will check if a
     *                player reaches the end of the game board on a dice roll and
     *                continues around the board into a new cycle.
     */
    @Test
    public void testMovePlayerCycle() {

        master.setNumberOfPlayers(1);
        Player player = master.getPlayer(0);
        master = GameMaster.instance();
        master.setGameBoard(new SimpleGameBoard());
        master.movePlayer(0,2);
        master.movePlayer(0,5);
        assertEquals("Blue 1", player.getPosition().getName());
    }
}
