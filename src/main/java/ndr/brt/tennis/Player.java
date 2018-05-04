package ndr.brt.tennis;

import static ndr.brt.tennis.Score.FORTY;
import static ndr.brt.tennis.Score.LOVE;

class Player {
    private int score = 0;

    public void score() {
        score++;
    }

    public int points() {
        return Score.values()[score].points();
    }

    public boolean overForty() {
        return score > FORTY.ordinal();
    }

    public boolean atLeastForty() {
        return score >= FORTY.ordinal();
    }

    public int getScore() {
        return score;
    }

    public boolean lessThanForty() {
        return score < FORTY.ordinal();
    }
}
