package ndr.brt.tennis;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;

import static ndr.brt.tennis.PlayerName.One;
import static ndr.brt.tennis.PlayerName.Two;

public class Game {

    private Map<PlayerName, Player> players = new HashMap<PlayerName, Player>() {{
        put(One, new Player());
        put(Two, new Player());
    }};

    private final PlayerPredicate playerOneAdvantage =
            (one, two) -> one.atLeastForty() && two.atLeastForty() && one.getScore() > two.getScore();

    private final PlayerPredicate playerTwoAdvantage =
            (one, two) -> one.atLeastForty() && two.atLeastForty() && two.getScore() > one.getScore();

    private final PlayerPredicate playerOneWins =
            (one, two) -> one.overForty() && (two.lessThanForty() || one.getScore() > two.getScore() + 1);

    private final PlayerPredicate playerTwoWins =
            (one, two) -> two.overForty() && (one.lessThanForty() || two.getScore() > one.getScore() + 1);

    private final PlayerPredicate deuce =
            (one, two) -> two.atLeastForty() && one.atLeastForty() && two.getScore() == one.getScore();


    private Map<PlayerPredicate, String> predicates = new HashMap<PlayerPredicate, String>() {{
        put(playerOneAdvantage, "Player One ADVANTAGE");
        put(playerTwoAdvantage, "Player Two ADVANTAGE");
        put(playerOneWins, "Player One WINS");
        put(playerTwoWins, "Player Two WINS");
        put(deuce, "DEUCE");
    }};


    public String scoring() {
        return predicates.entrySet().stream()
                .filter(it -> it.getKey().test(players.get(One), players.get(Two)))
                .findAny()
                .map(Map.Entry::getValue)
                .orElseGet(() -> String.format("%d - %d", players.get(One).points(), players.get(Two).points()));
    }

    public void score(PlayerName name) {
        players.get(name).score();
    }

    private interface PlayerPredicate extends BiPredicate<Player, Player> {};

}
