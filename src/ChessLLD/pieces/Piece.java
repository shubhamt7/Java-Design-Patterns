package ChessLLD.pieces;

import ChessLLD.Board;
import ChessLLD.Color;
import ChessLLD.Position;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    Position currentPosition;
    Color color;
    String symbol;

    public Piece(Color color, Position currentPosition, String symbol) {
        this.color = color;
        this.currentPosition = currentPosition;
        this.symbol = symbol;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean isValidMove(Board board, Position position){
        return false;
    }

    public List<Position> getPermissiblePositions(Board b, Position p){
        return new ArrayList<>();
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
