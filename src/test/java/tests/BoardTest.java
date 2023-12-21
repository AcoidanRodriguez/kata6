package tests;

import org.junit.Test;
import software.ulpgc.kata6.Board;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {
    private static final String board_2x2_with_all_cells_alive = """
            XX
            XX
            """.trim();
    private static final String board_2x2_with_one_cell_alive = """
            ..
            .X
            """.trim();
    private static final String board_2x2_with_all_dead = """
            ..
            ..
            """.trim();
    private static final String board_2x2_with_triangle_structure = """
            XX
            X.
            """.trim();
    private static final String board_3x3_with_all_alive = """
            XXX
            XXX
            XXX
            """.trim();
    private static final String board_3x3_with_alive_cells_in_corners = """
            X.X
            ...
            X.X
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

    @Test
    public void should_return_board_2x2_with_all_dead_given_board_2x2_with_one_cell_alive() {
        String state = new Board(board_2x2_with_one_cell_alive).next().state();
        assertThat(state).isEqualTo(board_2x2_with_all_dead);
    }

    @Test
    public void should_return_board_2x2_with_all_alive_given_board_2x2_with_triangle_structure() {
        String state = new Board(board_2x2_with_triangle_structure).next().state();
        assertThat(state).isEqualTo(board_2x2_with_all_cells_alive);
    }

    @Test
    public void should_return_board_3x3_with_alive_cells_in_corners_given_board_3x3_with_all_alive() {
        String state = new Board(board_3x3_with_all_alive).next().state();
        assertThat(state).isEqualTo(board_3x3_with_alive_cells_in_corners);
    }
}
