package ndr.brt.tennis;

import static ndr.brt.tennis.Score.FORTY;

public class Player {

    private Score score = Score.LOVE;

    public void score() {
        score = Score.values()[score.ordinal() + 1];
    }

    public int points() {
        return score.points();
    }

    public boolean isForty() {
        return score == FORTY;
    }
}
