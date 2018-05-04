package ndr.brt.tennis;

import java.util.HashMap;
import java.util.Map;

import static ndr.brt.tennis.PlayerName.One;
import static ndr.brt.tennis.PlayerName.Two;
import static ndr.brt.tennis.Results.*;

public class Game {

    private Map<PlayerName, Player> players = Map.of(
            One, new Player(),
            Two, new Player()
    );

    private Map<Results, String> results = Map.of(
        PlayerOneAdvantage, "Player One ADVANTAGE",
        PlayerTwoAdvantage, "Player Two ADVANTAGE",
        PlayerOneWins, "Player One WINS",
        PlayerTwoWins, "Player Two WINS",
        Deuce, "DEUCE"
    );

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
