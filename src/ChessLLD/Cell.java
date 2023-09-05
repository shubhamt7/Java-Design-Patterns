package ChessLLD;

import ChessLLD.pieces.Piece;

public class Cell {
    private Piece piece;

    public Cell(Piece piece) {
        this.piece = piece;
    }

    public Cell(){

    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
