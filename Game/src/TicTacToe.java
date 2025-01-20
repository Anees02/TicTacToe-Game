import Model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToe {
    Board board;
    Deque<Player> players;

    public TicTacToe() {

        players = new LinkedList<>();
        PlayingPieceO O = new PlayingPieceO();
        Player player1 = new Player("player1",O);
        PlayingPieceX X = new PlayingPieceX();
        Player player2 = new Player("Player2",X);

        players.add(player1);
        players.add(player2);
        this.board = new Board(3);

    }

    public String startGame() throws IOException {
        boolean nowinner = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(nowinner){
            Player currplayer = players.removeFirst();

            board.displayBoard();
            System.out.println("Player: "+currplayer.getName()+" Enter row,column: ");
            String[] values = br.readLine().split(",");
            int row = Integer.parseInt(values[0]);
            int col = Integer.parseInt(values[1]);

            boolean correctPos = board.addPiece(row,col,currplayer.getPlayingPiece().pieceType);
            if(!correctPos){
                System.out.println("Incorrect position chosen! Please try again!");
                players.addFirst(currplayer);
                continue;
            }

            boolean winner = board.findWinner(currplayer.getPlayingPiece().pieceType);
            boolean free = board.isFreePieceAvailable();

            if(winner){
                board.displayBoard();
                return "Congrats! your the winner: "+currplayer.getName();
            }

            players.addLast(currplayer);

            if(!free){
                nowinner = false;
            }
        }
        return "Unfortunately! the match is tie";
    }


}
