package ChessLLD;

import ChessLLD.pieces.Piece;

import java.util.Scanner;

public class ChessGame {
    private Board board;
    private boolean isGameFinished;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public ChessGame(){
        this("Player1", "Player2");
    }

    public ChessGame(String player1Name, String player2Name) {
        this.board = new Board();
        this.isGameFinished = false;
        this.player1 = new Player(player1Name, Color.WHITE);
        this.player2 = new Player(player2Name, Color.BLACK);
        currentPlayer = player1;
    }

    public void playGame(){
        Scanner sc = new Scanner(System.in);
        int startRow, startCol, destRow, destCol;
        while(!isGameFinished){

            board.display();

            System.out.println(currentPlayer.getName() + ", " + "Please enter your move (start cell -> end cell)");
            startRow = sc.nextInt();
            startCol = sc.nextInt();
            destRow = sc.nextInt();
            destCol = sc.nextInt();
            Position startPosition = new Position(startRow, startCol);
            Position destPosition = new Position(destRow, destCol);

            Piece pieceAtStart = board.getPiece(startPosition);

            while(  pieceAtStart == null
                    || !pieceAtStart.isValidMove(board, destPosition)
                    || pieceAtStart.getColor() != currentPlayer.getColor()
                    || startPosition.equals(destPosition))
            {
                board.display();
                System.out.println(currentPlayer.getName() + ", " + "Please enter valid move (start cell -> end cell)");
                startRow = sc.nextInt();
                startCol = sc.nextInt();
                destRow = sc.nextInt();
                destCol = sc.nextInt();
                startPosition = new Position(startRow, startCol);
                destPosition = new Position(destRow, destCol);
                pieceAtStart = board.getPiece(startPosition);
            }

            board.move(startPosition, destPosition);
            if(board.isKingAlive()) {
                currentPlayer = currentPlayer.equals(player1) ? player2 : player1;
            }else{
                isGameFinished = true;
                System.out.println(currentPlayer.getName() + ", " + "You won the Game!!!");
                board.display();
                break;
            }
        }
    }
}
