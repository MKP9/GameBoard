/** Michael Peterson
 *  11/03/2017
 *  Assn 09: TDD Tutorial Walkthrough
 *  Gameboard Player Class
 *  https://github.com/MKP9
 *  https://travis-ci.org/
 *  Create a new Java project incorporating jUnit.  Using the packet provided walk
 *  through the Test Driven Development (TDD) for a simplified game application.
 */

package player;

import cell.Cell;
import gameMaster.GameMaster;

public class Player {

    private Cell position;

    public Player() {

       position = GameMaster.instance().getGameBoard().getCell(0);
    }

    public Cell getPosition() {

        return this.position;
    }

    public void setPosition(Cell newPosition) {

        this.position = newPosition;
    }
}
