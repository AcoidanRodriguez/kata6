package tests;

import org.junit.Test;
import software.ulpgc.kata6.Board;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {
    @Test
    public void should_return_empty_board_given_empty_board() {
        String state = new Board("").next().state();
        assertThat(state).isEqualTo("");
    }
}
