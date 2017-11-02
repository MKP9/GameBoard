package gameMaster;

import cell.Cell;
import player.Player;

import java.util.ArrayList;

public class GameMaster {

    private static GameMaster singleton;
    private gameboard.gameBoard gameBoard;
    private ArrayList players;

    public static GameMaster instance() {

        if(singleton == null) {

            singleton = new GameMaster();
        }
        return singleton;
    }

    public void setGameBoard(gameboard.gameBoard board) {

        this.gameBoard = board;
    }

    public gameboard.gameBoard getGameBoard() {

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
