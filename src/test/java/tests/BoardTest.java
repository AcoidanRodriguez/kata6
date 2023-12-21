package tests;

import org.junit.Test;
import software.ulpgc.kata6.Board;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {
    private static final String board_2x2_with_all_cells_alive = """
            XX
            XX
            """.trim();

    @Test
    public void should_return_empty_board_given_empty_board() {
        String state = new Board("").next().state();
        assertThat(state).isEqualTo("");
    }

    @Test
    public void should_return_board_1x1_with_a_dead_cell_given_board_1x1_with_a_dead_cell() {
        String state = new Board(".").next().state();
        assertThat(state).isEqualTo(".");
    }

    @Test
    public void should_return_board_1x1_with_a_dead_cell_given_board_1x1_with_an_alive_cell() {
        String state = new Board("X").next().state();
        assertThat(state).isEqualTo(".");
    }

    @Test
    public void should_return_board_2x2_with_all_alive_given_board_2x2_with_all_alive() {
        String state = new Board(board_2x2_with_all_cells_alive).next().state();
        assertThat(state).isEqualTo(board_2x2_with_all_cells_alive);
    }
}
