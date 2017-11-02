package gameMasterTest;

import cell.Cell;
import gameMaster.GameMaster;
import org.junit.Test;
import player.Player;
import simpleGameBoard.SimpleGameBoard;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertSame;

public class GameMasterTest {

    GameMaster master;

    public void setup() {

        master = GameMaster.instance();
        master.setGameBoard(new SimpleGameBoard());
    }

    @Test
    public void testSingleton() {

        GameMaster instance1 = GameMaster.instance();
        assertNotNull(instance1);

        GameMaster instance2 = GameMaster.instance();
        assertNotNull(instance2);
        assertSame(instance1, instance2);

    }

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
