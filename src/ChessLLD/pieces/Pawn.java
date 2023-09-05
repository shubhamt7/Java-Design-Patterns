package ChessLLD.pieces;

import ChessLLD.Board;
import ChessLLD.Color;
import ChessLLD.Position;

public class Pawn extends Piece {

    public Pawn(Color color, Position currentPosition) {
        super(color, currentPosition, "P");
    }

    public boolean isValidMove(Board board, Position position){
        int destRow = position.getRowNo();
        int destCol = position.getColNo();
        int currRow = currentPosition.getRowNo();
        int currCol = currentPosition.getColNo();

        if(color == Color.WHITE){
            if(destRow == currRow - 1){
                Piece destPiece = board.getPiece(position);
                if(destCol == currCol - 1 || destCol == currCol + 1){
                    return (destPiece != null && destPiece.getColor() == Color.BLACK);
                }else if(destCol == currCol){
                    return destPiece == null;
                }
            }
        }else{
            if(destRow == currRow + 1){
                System.out.println(destRow + " " + currRow);
                Piece destPiece = board.getPiece(position);
                if(destCol == currCol - 1 || destCol == currCol + 1){
                    return (destPiece != null && destPiece.getColor() == Color.WHITE);
                }else if(destCol == currCol){
                    return destPiece == null;
                }
            }
        }

        return false;
    }
}
