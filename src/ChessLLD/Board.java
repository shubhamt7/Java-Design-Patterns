package ChessLLD;

import ChessLLD.pieces.*;

public class Board {
    private Cell[][] cells;
    private boolean isKingAlive;

    public Board(){
        cells = new Cell[8][8];
        isKingAlive = true;
        setPieces();
    }

    private void setPieces(){

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                cells[i][j] = new Cell();
            }
        }

        // Setting black pieces
        cells[0][0] = new Cell(new Castle(Color.BLACK, new Position(0, 0)));
        cells[0][7] = new Cell(new Castle(Color.BLACK, new Position(0, 7)));
        cells[0][1] = new Cell(new Knight(Color.BLACK, new Position(0, 1)));
        cells[0][6] = new Cell(new Knight(Color.BLACK, new Position(0, 6)));
        cells[0][2] = new Cell(new Bishop(Color.BLACK, new Position(0, 2)));
        cells[0][5] = new Cell(new Bishop(Color.BLACK, new Position(0, 5)));
        cells[0][3] = new Cell(new King(Color.BLACK, new Position(0, 3)));
        cells[0][4] = new Cell(new Queen(Color.BLACK, new Position(0, 4)));

        for(int j = 0; j < 8; j++){
            cells[1][j] = new Cell(new Pawn(Color.BLACK, new Position(1, j)));
        }

        // Setting white pieces
        cells[7][0] = new Cell(new Castle(Color.WHITE, new Position(7, 0)));
        cells[7][7] = new Cell(new Castle(Color.WHITE, new Position(7, 7)));
        cells[7][1] = new Cell(new Knight(Color.WHITE, new Position(7, 1)));
        cells[7][6] = new Cell(new Knight(Color.WHITE, new Position(7, 6)));
        cells[7][2] = new Cell(new Bishop(Color.WHITE, new Position(7, 2)));
        cells[7][5] = new Cell(new Bishop(Color.WHITE, new Position(7, 5)));
        cells[7][3] = new Cell(new King(Color.WHITE, new Position(7, 3)));
        cells[7][4] = new Cell(new Queen(Color.WHITE, new Position(7, 4)));

        for(int j = 0; j < 8; j++){
            cells[6][j] = new Cell(new Pawn(Color.WHITE, new Position(6, j)));
        }
    }

    public Piece getPiece(Position p){
        int r = p.getRowNo();
        int c = p.getColNo();
        if(insideBounds(p))
            return cells[p.getRowNo()][p.getColNo()].getPiece();
        return null;
    }

    public String getPieceType(Position p){
        Piece piece = cells[p.getRowNo()][p.getColNo()].getPiece();
        return piece == null ? "" : piece.getClass().getSimpleName();
    }

    private void setPiece(Position position, Piece piece){
        cells[position.getRowNo()][position.getColNo()].setPiece(piece);
    }

    public void move(Position p1, Position p2){
        if(getPieceType(p2).equals("King")){
            setKingAlive(false);
        }
        Piece piece = getPiece(p1);
        piece.setCurrentPosition(p2);
        setPiece(p2, piece);
        setPiece(p1, null);
    }

    public boolean isKingAlive() {
        return isKingAlive;
    }

    public void setKingAlive(boolean kingAlive) {
        isKingAlive = kingAlive;
    }

    public boolean insideBounds(Position p){
        int r = p.getRowNo();
        int c = p.getColNo();

        return r >= 0 && r < 8 && c >= 0 && c < 8;
    }

    public void display(){
        System.out.print("    ");
        for(int i = 0; i < 8; i++){
            System.out.print(i + "  ");
        }
        System.out.println();
        System.out.println();
        for(int i = 0; i < 8; i++){
            System.out.print(i + "   ");
            for(int j = 0; j < 8; j++){
                Piece piece = getPiece(new Position(i, j));
                String colorSign = piece != null && piece.getColor() == Color.WHITE ? "w" : "b";
                String value = piece == null ? "__" : colorSign + piece.getSymbol();
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
