package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.FigureNotFoundException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.matchers.JUnitMatchers.containsString;

public class BishopBlackTest {

    @Test
    public void sourcePositionIsCorrect () {
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

    @Test
    public void freeWayOfBishopBlackFromC1ToG5() throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new KingBlack(Cell.G4));
        logic.move(Cell.C1, Cell.G5);
    }

    @Test
    public void freeWayOfBishopBlackFromG5ToC1() throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.G5));
        logic.add(new KingBlack(Cell.G4));
        logic.move(Cell.G5, Cell.C1);
    }

    @Test
    public void freeWayOfBishopBlackFromE1ToA5() throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.E1));
        logic.add(new KingBlack(Cell.B3));
        logic.move(Cell.E1, Cell.A5);
    }

    @Test
    public void freeWayOfBishopBlackFromA5ToE1() throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A5));
        logic.add(new KingBlack(Cell.B3));
        logic.move(Cell.A5, Cell.E1);
    }

    @Test
    public void otherFigureOnTheWayOfBishopBlackFromC1ToG5() throws OccupiedCellException, FigureNotFoundException {
        boolean occupiedCellException = false;
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new KingBlack(Cell.D2));
        try {
            logic.move(Cell.C1, Cell.G5);
        } catch (OccupiedCellException ex) {
            occupiedCellException = true;
        }
        assertTrue(occupiedCellException);
    }

    @Test
    public void otherFigureOnTheWayOfBishopBlackFromG5ToC1() throws OccupiedCellException, FigureNotFoundException {
        boolean occupiedCellException = false;
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.G5));
        logic.add(new KingBlack(Cell.D2));
        try {
            logic.move(Cell.G5, Cell.C1);
        } catch (OccupiedCellException ex) {
            occupiedCellException = true;
        }
        assertTrue(occupiedCellException);
    }

    @Test
    public void otherFigureOnTheWayOfBishopBlackFromE1ToA5() throws OccupiedCellException, FigureNotFoundException {
        boolean occupiedCellException = false;
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.E1));
        logic.add(new KingBlack(Cell.B4));
        try {
            logic.move(Cell.E1, Cell.A5);
        } catch (OccupiedCellException ex) {
            occupiedCellException = true;
        }
        assertTrue(occupiedCellException);
    }


    @Test
    public void otherFigureOnTheWayOfBishopBlackFromA5ToE1() throws OccupiedCellException, FigureNotFoundException {
        boolean occupiedCellException = false;
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A5));
        logic.add(new KingBlack(Cell.B4));
        try {
            logic.move(Cell.A5, Cell.E1);
        } catch (OccupiedCellException ex) {
            occupiedCellException = true;
        }
        assertTrue(occupiedCellException);
    }
}