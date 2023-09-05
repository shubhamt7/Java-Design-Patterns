package ChessLLD.pieces;

import ChessLLD.Board;
import ChessLLD.Color;
import ChessLLD.Position;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    public King(Color color, Position currentPosition) {
        super(color, currentPosition, "K");
    }

    public boolean isValidMove(Board board, Position position){
        return getPermissiblePositions(board, currentPosition).contains(position);
    }

    public List<Position> getPermissiblePositions(Board board, Position p){
        ArrayList<Position> permissiblePositions = new ArrayList<>();

        int r = p.getRowNo();
        int c = p.getColNo();

        for(int ri = -1; ri <= 1; ri++){
            for(int ci = -1; ci <= 1; ci++){
                if(ri != 0 && ci != 0){
                    Position pos = new Position(r + ri, c + ci);
                    if(board.insideBounds(pos)){
                        Piece piece = board.getPiece(pos);
                        if(piece == null || piece.getColor() != color)
                            permissiblePositions.add(pos);
                    }
                }
            }
        }

        return permissiblePositions;
    }
}
