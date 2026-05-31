package arutyunovg4;

import arutyunovg4.pieces.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        board.setupDefaultPiecesPosition();

        BoardConsoleRenderer renderer = new BoardConsoleRenderer();
        renderer.render(board);

        Piece piece = board.getPiece(new Coordinates(File.G, 8));
        Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);
        int  a = 213;
    }
}
