package ndr.brt.tennis;

import java.util.function.BiPredicate;

public enum Results implements BiPredicate<Player, Player> {
    PlayerOneAdvantage(
        (one, two) -> one.atLeastForty() && two.atLeastForty() && one.getScore() > two.getScore()
    ),

    PlayerTwoAdvantage(
        (one, two) -> one.atLeastForty() && two.atLeastForty() && two.getScore() > one.getScore()
    ),

    PlayerOneWins(
        (one, two) -> one.overForty() && (two.lessThanForty() || one.getScore() > two.getScore() + 1)
    ),

    PlayerTwoWins(
        (one, two) -> two.overForty() && (one.lessThanForty() || two.getScore() > one.getScore() + 1)
    ),

    Deuce(
        (one, two) -> two.atLeastForty() && one.atLeastForty() && two.getScore() == one.getScore()
    );


    private final BiPredicate<Player, Player> predicate;

    Results(BiPredicate<Player, Player> predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean test(Player one, Player two) {
        return predicate.test(one, two);
    }
}
