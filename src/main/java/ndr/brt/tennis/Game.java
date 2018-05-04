package ndr.brt.tennis;

import static ndr.brt.tennis.Score.LOVE;

public class Game {
    private Score playerOne = LOVE;
    private Score playerTwo = LOVE;

    public String scoring() {
        return String.format("%d - %d", playerOne.points(), playerTwo.points());
    }

    public void playerOneScores() {
        int ordinal = playerOne.ordinal();
        ordinal++;
        playerOne = Score.values()[ordinal];
    }

    public void playerTwoScores() {
        int ordinal = playerTwo.ordinal();
        ordinal++;
        playerTwo = Score.values()[ordinal];
    }
}
