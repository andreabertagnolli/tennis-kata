package ndr.brt.tennis;

public class Game {
    private int playerOne = 0;
    private int playerTwo = 0;

    public String scoring() {
        return String.format("%d - %d", playerOne, playerTwo);
    }

    public void playerOneScores() {
        playerOne += 15;
    }

    public void playerTwoScores() {
        playerTwo = 15;
    }
}
