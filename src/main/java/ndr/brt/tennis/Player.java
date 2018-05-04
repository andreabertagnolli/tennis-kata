package ndr.brt.tennis;

public class Player {

    private Score score = Score.LOVE;

    public void score() {
        score = Score.values()[score.ordinal() + 1];
    }

    public int points() {
        return score.points();
    }
}
