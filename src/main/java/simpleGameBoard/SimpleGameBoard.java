package simpleGameBoard;

import cell.Cell;
import gameboard.gameBoard;
import propertyCell.PropertyCell;

public class SimpleGameBoard extends gameBoard {

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
