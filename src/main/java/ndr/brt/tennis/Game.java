package ndr.brt.tennis;

public class Game {
    private String playerOne = "0";

    public String scoring() {
        return playerOne + " - 0";
    }

    public void playerOneScores() {
        playerOne = "15";
    }
}
