package ndr.brt.tennis;

public enum Score {
    LOVE(0),
    FIFTEEN(15),
    THIRTY(30),
    FORTY(40);

    private final int points;

    Score(int points) {
        this.points = points;
    }

    public int points() {
        return points;
    }
}
