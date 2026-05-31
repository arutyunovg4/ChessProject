package arutyunovg4.pieces;

import arutyunovg4.Color;
import arutyunovg4.Coordinates;

import java.util.Set;

public class Pawn extends Piece{
    public Pawn(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return null;
    }
}
