package arutyunovg4;

import java.util.HashMap;

public class Board {
    HashMap<Coordinates, Piece> pieces = new HashMap<>();

    public void setPiece (Piece piece, Coordinates coordinates){
        piece.coordinates = coordinates;
        pieces.put(coordinates, piece);
    }

}
