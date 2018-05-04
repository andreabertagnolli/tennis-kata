package ndr.brt.tennis;

public class Game {
    private Player playerOne = new Player();
    private Player playerTwo = new Player();
    private String winner;

    public String scoring() {
        if (winner != null) {
            return winner;
        }
        else {
            return String.format("%d - %d", playerOne.points(), playerTwo.points());
        }
    }

    public void playerOneScores() {
        if (playerOne.isForty()) {
            winner = "Player One WINS";
        }
        else {
            playerOne.score();
        }
    }

    public void playerTwoScores() {
        if (playerTwo.isForty()) {
            winner = "Player Two WINS";
        }
        else {
            playerTwo.score();
        }
    }
}
