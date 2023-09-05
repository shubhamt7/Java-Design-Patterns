package ChessLLD.pieces;

import ChessLLD.Board;
import ChessLLD.Color;
import ChessLLD.Position;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    public Queen(Color color, Position currentPosition) {
        super(color, currentPosition, "Q");
    }

    public boolean isValidMove(Board board, Position position){
        return getPermissiblePositions(board, currentPosition).contains(position);
    }

    public List<Position> getPermissiblePositions(Board board, Position p){
        ArrayList<Position> permissiblePositions = new ArrayList<>();

        int r = p.getRowNo();
        int c = p.getColNo();

        // checking horizontally
        for(int j = c - 1; j >= 0; j--){
            Position pos = new Position(r, j);
            Piece piece = board.getPiece(pos);
            if(piece == null)
                permissiblePositions.add(pos);
            else{
                if(piece.getColor() != color)
                    permissiblePositions.add(pos);
                break;
            }
        }

        for(int j = c + 1; j < 8; j++){
            Position pos = new Position(r, j);
            Piece piece = board.getPiece(pos);
            if(piece == null)
                permissiblePositions.add(pos);
            else{
                if(piece.getColor() != color)
                    permissiblePositions.add(pos);
                break;
            }
        }

        //checking vertically
        for(int i = r - 1; i >= 0; i--){
            Position pos = new Position(i, c);
            Piece piece = board.getPiece(pos);
            if(piece == null)
                permissiblePositions.add(pos);
            else{
                if(piece.getColor() != color)
                    permissiblePositions.add(pos);
                break;
            }
        }

        for(int i = r + 1; i < 8; i++){
            Position pos = new Position(i, c);
            Piece piece = board.getPiece(pos);
            if(piece == null)
                permissiblePositions.add(pos);
            else{
                if(piece.getColor() != color)
                    permissiblePositions.add(pos);
                break;
            }
        }

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
