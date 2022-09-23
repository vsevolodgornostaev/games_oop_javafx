package ru.job4j.chess.firuges.black;

import org.junit.Test;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class BishopBlackTest {

    @Test
    public void sourcePositionIsCorrect() {
        BishopBlack bishopBlackSource = new BishopBlack(Cell.B1);
        Cell source = bishopBlackSource.position();
        Cell expected = Cell.B1;
        assertThat(source, is(expected));
    }

    @Test
    public void destPositionIsCorrect() {
        BishopBlack bishopBlackSource = new BishopBlack(Cell.B1);
        Figure bishopBlackDest = bishopBlackSource.copy(Cell.D3);
        Cell dest = bishopBlackDest.position();
        Cell expected = Cell.D3;
        assertThat(dest, is(expected));
    }

    @Test
    public void wayBishopBlackFromC1toG5IsCorrect() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] way = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(way, is(expected));
    }
}