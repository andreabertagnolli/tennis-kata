package ndr.brt.tennis;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;

import static ndr.brt.tennis.PlayerName.One;
import static ndr.brt.tennis.PlayerName.Two;
import static ndr.brt.tennis.Results.*;

public class Game {

    private Map<PlayerName, Player> players = new HashMap<PlayerName, Player>() {{
        put(One, new Player());
        put(Two, new Player());
    }};

    private Map<Results, String> results = new HashMap<Results, String>() {{
        put(PlayerOneAdvantage, "Player One ADVANTAGE");
        put(PlayerTwoAdvantage, "Player Two ADVANTAGE");
        put(PlayerOneWins, "Player One WINS");
        put(PlayerTwoWins, "Player Two WINS");
        put(Deuce, "DEUCE");
    }};


    public String scoring() {
        return results.entrySet().stream()
                .filter(it -> it.getKey().test(players.get(One), players.get(Two)))
                .findAny()
                .map(Map.Entry::getValue)
                .orElseGet(() -> String.format("%d - %d", players.get(One).points(), players.get(Two).points()));
    }

    public void score(PlayerName name) {
        players.get(name).score();
    }

}
