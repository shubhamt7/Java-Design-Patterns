package ChessLLD.pieces;

import ChessLLD.Board;
import ChessLLD.Color;
import ChessLLD.Position;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    public Knight(Color color, Position currentPosition) {
        super(color, currentPosition, "H");
    }

    public boolean isValidMove(Board board, Position position){
        return getPermissiblePositions(board, currentPosition).contains(position);
    }

    public List<Position> getPermissiblePositions(Board board, Position p){
        ArrayList<Position> permissiblePositions = new ArrayList<>();

        int r = p.getRowNo();
        int c = p.getColNo();

        for(int ri = -2 ; ri <= 2; ri++){
            for(int ci = -2; ci <= 2; ci++){
                if(ri == 0 || ci == 0 || Math.abs(ri) == Math.abs(ci))
                    continue;
                else{
                    Position pos = new Position(r + ri, c + ci);
                    if(board.insideBounds(pos)){
                        Piece piece = board.getPiece(pos);
                        if(piece == null || piece.getColor() != color)
                            permissiblePositions.add(pos);
                    }
                }
            }
        }

//        Position p1 = new Position(r - 1, c - 2);
//        if(board.insideBounds(p1))
//            permissiblePositions.add(p1);
//
//        Position p2 = new Position(r + 1, c - 2);
//        if(board.insideBounds(p2))
//            permissiblePositions.add(p2);
//
//        Position p3 = new Position(r - 1, c + 2);
//        if(board.insideBounds(p3))
//            permissiblePositions.add(p3);
//
//        Position p4 = new Position(r + 1, c + 2);
//        if(board.insideBounds(p4))
//            permissiblePositions.add(p4);
//
//        Position p5 = new Position(r - 2, c - 1);
//        if(board.insideBounds(p5))
//            permissiblePositions.add(p5);
//
//        Position p6 = new Position(r - 2, c + 1);
//        if(board.insideBounds(p6))
//            permissiblePositions.add(p6);
//
//        Position p7 = new Position(r + 2, c - 1);
//        if(board.insideBounds(p7))
//            permissiblePositions.add(p7);
//
//        Position p8 = new Position(r + 2, c + 1);
//        if(board.insideBounds(p8))
//            permissiblePositions.add(p8);

        return permissiblePositions;
    }
}
