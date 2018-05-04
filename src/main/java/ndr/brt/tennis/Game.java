package ndr.brt.tennis;

public class Game {
    private String playerOne = "0";
    private String playerTwo = "0";

    public String scoring() {
        return String.format("%s - %s", playerOne, playerTwo);
    }

    public void playerOneScores() {
        playerOne = "15";
    }

    public void playerTwoScores() {
        playerTwo = "15";
    }
}
