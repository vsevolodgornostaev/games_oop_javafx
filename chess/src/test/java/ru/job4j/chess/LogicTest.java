package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KingBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveFromC1toH6ThenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new KingBlack(Cell.D2));
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("The board is occupied.");
    }

    @Test
    public void whenMoveFromH6toC1ThenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.H6));
        logic.add(new KingBlack(Cell.E3));
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.move(Cell.H6, Cell.C1);
        });
        assertThat(exception.getMessage()).isEqualTo("The board is occupied.");
    }

    @Test
    public void whenMoveFromG1toA7ThenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.G1));
        logic.add(new KingBlack(Cell.D4));
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.move(Cell.G1, Cell.A7);
        });
        assertThat(exception.getMessage()).isEqualTo("The board is occupied.");
    }

    @Test
    public void whenMoveFromA7toG1ThenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A7));
        logic.add(new KingBlack(Cell.B6));
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.move(Cell.A7, Cell.G1);
        });
        assertThat(exception.getMessage()).isEqualTo("The board is occupied.");
    }

    @Test
    public void whenMoveFromE3toD3ThenImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Cell position = Cell.E3;
        Cell dest = Cell.D3;
        logic.add(new BishopBlack(position));
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(position, dest);
        });
        assertThat(exception.getMessage()).isEqualTo(String.format("Could not way by diagonal from %s to %s", position, dest));
    }

    @Test
    public void whenMoveFromE3toE4ThenImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Cell position = Cell.E3;
        Cell dest = Cell.E4;
        logic.add(new BishopBlack(position));
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(position, dest);
        });
        assertThat(exception.getMessage()).isEqualTo(String.format("Could not way by diagonal from %s to %s", position, dest));
    }

    @Test
    public void whenMoveFromE3toF3ThenImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Cell position = Cell.E3;
        Cell dest = Cell.F3;
        logic.add(new BishopBlack(position));
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(position, dest);
        });
        assertThat(exception.getMessage()).isEqualTo(String.format("Could not way by diagonal from %s to %s", position, dest));
    }

    @Test
    public void whenMoveFromE3toE2ThenImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Cell position = Cell.E3;
        Cell dest = Cell.E2;
        logic.add(new BishopBlack(position));
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(position, dest);
        });
        assertThat(exception.getMessage()).isEqualTo(String.format("Could not way by diagonal from %s to %s", position, dest));
    }

    @Test
    public void whenMoveFromE3toD5ThenImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Cell position = Cell.E3;
        Cell dest = Cell.D5;
        logic.add(new BishopBlack(position));
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(position, dest);
        });
        assertThat(exception.getMessage()).isEqualTo(String.format("Could not way by diagonal from %s to %s", position, dest));
    }

    @Test
    public void whenMoveFromE3toF5ThenImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Cell position = Cell.E3;
        Cell dest = Cell.F5;
        logic.add(new BishopBlack(position));
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(position, dest);
        });
        assertThat(exception.getMessage()).isEqualTo(String.format("Could not way by diagonal from %s to %s", position, dest));
    }

    @Test
    public void whenMoveFromE3toD1ThenImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Cell position = Cell.E3;
        Cell dest = Cell.D1;
        logic.add(new BishopBlack(position));
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(position, dest);
        });
        assertThat(exception.getMessage()).isEqualTo(String.format("Could not way by diagonal from %s to %s", position, dest));
    }

    @Test
    public void whenMoveFromE3toF1ThenImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Cell position = Cell.E3;
        Cell dest = Cell.F1;
        logic.add(new BishopBlack(position));
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(position, dest);
        });
        assertThat(exception.getMessage()).isEqualTo(String.format("Could not way by diagonal from %s to %s", position, dest));
    }
}