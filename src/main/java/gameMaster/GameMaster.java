/** Michael Peterson
 *  11/03/2017
 *  Assn 09: TDD Tutorial Walkthrough
 *  Gameboard GameMaster Class
 *  https://github.com/MKP9
 *  https://travis-ci.org/
 *  Create a new Java project incorporating jUnit.  Using the packet provided walk
 *  through the Test Driven Development (TDD) for a simplified game application.
 */

package gameMaster;

import cell.Cell;
import gameboard.GameBoard;
import player.Player;

import java.util.ArrayList;

public class GameMaster {

    private static GameMaster singleton;
    private GameBoard gameBoard;
    private ArrayList players;

    public static GameMaster instance() {

        if(singleton == null) {

            singleton = new GameMaster();
        }
        return singleton;
    }

    public void setGameBoard(GameBoard board) {

        this.gameBoard = board;
    }

    public GameBoard getGameBoard() {

        return this.gameBoard;
    }

    public void setNumberOfPlayers(int number) {

        players = new ArrayList(number);
        for(int i = 0; i < number; i++) {

            Player player = new Player();
            players.add(player);
        }
    }

    public int getNumberOfPlayers() {

        return players.size();
    }

    public Player getPlayer(int index) {

        return (Player)players.get(index);
    }

    public void movePlayer(int playerIndex, int diceRoll) {

        Player player = getPlayer(playerIndex);
        Cell playerPosition = player.getPosition();
        int oldIndex = gameBoard.getCellIndex(playerPosition);
        int newIndex = (oldIndex + diceRoll) % gameBoard.getCellNumber();
        Cell newPosition = gameBoard.getCell(newIndex);
        player.setPosition(newPosition);
    }
}
