package ChessLLD.pieces;

import ChessLLD.Board;
import ChessLLD.Color;
import ChessLLD.Position;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(Color color, Position currentPosition) {
        super(color, currentPosition, "B");
    }

    public boolean isValidMove(Board board, Position position){
        return getPermissiblePositions(board, currentPosition).contains(position);
    }

    public List<Position> getPermissiblePositions(Board board, Position p){
        ArrayList<Position> permissiblePositions = new ArrayList<>();

        int r = p.getRowNo();
        int c = p.getColNo();

        // checking top-left diagonal
        for(int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--){
            Position pos = new Position(i, j);
            Piece piece = board.getPiece(pos);
            if(piece == null){
                permissiblePositions.add(pos);
            }else{
                if(piece.getColor() != color){
                    permissiblePositions.add(pos);
                }
                break;
            }
        }

        // checking top-right diagonal
        for(int i = r - 1, j = c + 1; i >= 0 && j < 8; i--, j++){
            Position pos = new Position(i, j);
            Piece piece = board.getPiece(pos);
            if(piece == null){
                permissiblePositions.add(pos);
            }else{
                if(piece.getColor() != color){
                    permissiblePositions.add(pos);
                }
                break;
            }
        }

        // checking bottom-left diagonal
        for(int i = r + 1, j = c - 1; i < 8 && j >= 0; i++, j--){
            Position pos = new Position(i, j);
            Piece piece = board.getPiece(pos);
            if(piece == null){
                permissiblePositions.add(pos);
            }else{
                if(piece.getColor() != color){
                    permissiblePositions.add(pos);
                }
                break;
            }
        }

        // checking bottom-right diagonal
        for(int i = r + 1, j = c + 1; i < 8 && j < 8; i++, j++){
            Position pos = new Position(i, j);
            Piece piece = board.getPiece(pos);
            if(piece == null){
                permissiblePositions.add(pos);
            }else{
                if(piece.getColor() != color){
                    permissiblePositions.add(pos);
                }
                break;
            }
        }

        return permissiblePositions;
    }
}
