package ndr.brt.tennis;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameTest {

    @Test
    void at_first_players_are_each_at_zero() {
        Game game = new Game();
        assertThat(game.scoring(), is("0 - 0"));
    }
}
