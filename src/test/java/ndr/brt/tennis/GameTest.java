package ndr.brt.tennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        game.playerOneScores();

        assertThat(game.scoring(), is("15 - 0"));
    }

    @Test
    void player_two_scores() {
        game.playerTwoScores();

        assertThat(game.scoring(), is("0 - 15"));
    }

    @Test
    void player_one_score_two_times() {
        game.playerOneScores();
        game.playerOneScores();

        assertThat(game.scoring(), is("30 - 0"));
    }

    @Test
    void player_one_score_three_times() {
        game.playerOneScores();
        game.playerOneScores();
        game.playerOneScores();

        assertThat(game.scoring(), is("40 - 0"));
    }

    @Test
    void player_one_wins() {
        game.playerOneScores();
        game.playerOneScores();
        game.playerOneScores();
        game.playerOneScores();

        assertThat(game.scoring(), is("Player One WINS"));
    }
}
