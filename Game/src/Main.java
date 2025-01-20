import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TicTacToe game = new TicTacToe();
        System.out.println("Game Started All the best for the players");
        System.out.println(game.startGame());
    }
}