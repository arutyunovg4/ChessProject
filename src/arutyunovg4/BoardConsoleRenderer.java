package arutyunovg4;

import arutyunovg4.pieces.Piece;

public class BoardConsoleRenderer {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";
    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";
    public static final String ANSI_HIGHLIGHTED_SQUARE_BACKGROUND = "\u001B[45m";

    public void render(Board board) {
        for (int rank = 8; rank >= 1; rank--) {
            StringBuilder line = new StringBuilder();
            for (File file : File.values()) {
                Coordinates coordinates = new Coordinates(file, rank);
                if (board.isSquareEmpty(coordinates)) {
                    line.append(getSpriteForEmptySquare(coordinates));
                }else{
                    line.append(getPieceSprite(board.getPiece(coordinates)));
                }
            }
            line.append(ANSI_RESET);
            System.out.println(line);
        }
    }
    private String getPieceSprite(Piece piece) {
        String sprite = getAsciiSymbol(piece);
        return colorizeSprite(" " + sprite + " ", piece.color, Board.isSquareDark(piece.coordinates));
    }

    private String getAsciiSymbol(Piece piece) {
        char symbol;
        switch(piece.getClass().getSimpleName()){
            case "Pawn":   symbol = 'P'; break;
            case "Knight": symbol = 'N'; break;
            case "Bishop": symbol = 'B'; break;
            case "Rook":   symbol = 'R'; break;
            case "Queen":  symbol = 'Q'; break;
            case "King":   symbol = 'K'; break;
            default:       symbol = '?';
        }

        if (piece.color == Color.BLACK) {
            symbol = Character.toLowerCase(symbol);
        }
        return String.valueOf(symbol);
    }

    private String colorizeSprite(String sprite, Color pieceColor, boolean isSquareDark) {
        String result = sprite;
        if (pieceColor == Color.WHITE) {
            result = ANSI_WHITE_PIECE_COLOR + result;
        } else {
            result = ANSI_BLACK_PIECE_COLOR + result;
        }
        if (isSquareDark) {
            result = ANSI_BLACK_SQUARE_BACKGROUND + result;
        } else {
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;
        }
        return result;
    }

    private String getSpriteForEmptySquare(Coordinates coordinates) {
        return colorizeSprite("   ", Color.WHITE, Board.isSquareDark(coordinates));
    }
}
