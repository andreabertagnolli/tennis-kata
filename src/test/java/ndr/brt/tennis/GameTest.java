package ndr.brt.tennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ndr.brt.tennis.PlayerName.One;
import static ndr.brt.tennis.PlayerName.Two;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void at_first_players_are_each_at_zero() {
        assertThat(game.scoring(), is("0 - 0"));
    }

    @Test
    void player_one_scores() {
        game.score(One);

        assertThat(game.scoring(), is("15 - 0"));
    }

    @Test
    void player_two_scores() {
        game.score(Two);

        assertThat(game.scoring(), is("0 - 15"));
    }

    @Test
    void player_one_score_two_times() {
        game.score(One);
        game.score(One);

        assertThat(game.scoring(), is("30 - 0"));
    }

    @Test
    void player_one_score_three_times() {
        game.score(One);
        game.score(One);
        game.score(One);

        assertThat(game.scoring(), is("40 - 0"));
    }

    @Test
    void player_one_wins() {
        game.score(One);
        game.score(One);
        game.score(One);
        game.score(One);

        assertThat(game.scoring(), is("Player One WINS"));
    }

    @Test
    void player_two_wins() {
        game.score(Two);
        game.score(Two);
        game.score(Two);
        game.score(Two);

        assertThat(game.scoring(), is("Player Two WINS"));
    }

    @Test
    void deuce() {
        game.score(One);
        game.score(One);
        game.score(One);
        game.score(Two);
        game.score(Two);
        game.score(Two);

        assertThat(game.scoring(), is("DEUCE"));
    }

    @Test
    void player_one_advantage() {
        game.score(One);
        game.score(One);
        game.score(One);
        game.score(Two);
        game.score(Two);
        game.score(Two);
        game.score(One);

        assertThat(game.scoring(), is("Player One ADVANTAGE"));
    }

    @Test
    void player_one_wins_after_advantage() {
        game.score(One);
        game.score(One);
        game.score(One);
        game.score(Two);
        game.score(Two);
        game.score(Two);
        game.score(One);
        game.score(One);

        assertThat(game.scoring(), is("Player One WINS"));
    }

    @Test
    void player_two_wins_after_advantage() {
        game.score(One);
        game.score(One);
        game.score(One);
        game.score(Two);
        game.score(Two);
        game.score(Two);
        game.score(One);
        game.score(Two);
        game.score(Two);
        game.score(Two);

        assertThat(game.scoring(), is("Player Two WINS"));
    }
}
