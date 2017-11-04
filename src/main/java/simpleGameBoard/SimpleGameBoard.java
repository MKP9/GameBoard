/** Michael Peterson
 *  11/03/2017
 *  Assn 09: TDD Tutorial Walkthrough
 *  Gameboard SimpleGameBoard Class
 *  https://github.com/MKP9
 *  https://travis-ci.org/
 *  Create a new Java project incorporating jUnit.  Using the packet provided walk
 *  through the Test Driven Development (TDD) for a simplified game application.
 */

package simpleGameBoard;

import cell.Cell;
import gameboard.GameBoard;
import propertyCell.PropertyCell;

public class SimpleGameBoard extends GameBoard {

    public SimpleGameBoard() {

        super();
        Cell blue1 = new PropertyCell();
        Cell blue2 = new PropertyCell();

        blue1.setName("Blue 1");
        blue2.setName("Blue 2");

        addCell(blue1);
        addCell(blue2);

    }
}
