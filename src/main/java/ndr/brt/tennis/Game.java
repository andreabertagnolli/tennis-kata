package ndr.brt.tennis;

public class Game {
    private Player playerOne = new Player();
    private Player playerTwo = new Player();

    public String scoring() {
        return String.format("%d - %d", playerOne.points(), playerTwo.points());
    }

    public void playerOneScores() {
        playerOne.score();
    }

    public void playerTwoScores() {
        playerTwo.score();
    }

    public Player playerOne() {
        return playerOne;
    }

    public Player playerTwo() {
        return playerTwo;
    }
}
