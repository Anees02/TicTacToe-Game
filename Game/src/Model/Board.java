package Model;

public class Board {
    int size;
    PieceType[][] board;

    int[] rows;
    int[] cols;
    int upper_dia;
    int lower_dia;


    public Board(int size) {
        this.size = size;
        this.board = new PieceType[size][size];
        rows = new int[size];
        cols = new int[size];
        upper_dia = 0;
        lower_dia = 0;
    }

    public boolean addPiece(int row, int col, PieceType p){
        if(this.board[row][col] == null){
            board[row][col] = p;
            int score = p == PieceType.X ? 1:-1;

            rows[row] += score;
            cols[col] += score;
            if(row + col == size)
                upper_dia += score;
            if(row == col)  lower_dia += score;

            return true;
        }
        else{
            return false;
        }
    }

    public boolean isFreePieceAvailable(){
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                if(board[i][j] == null){
                    return true;
                }
            }
        }
        return false;
    }

    public void displayBoard(){
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                System.out.print((board[i][j] == null?" ":board[i][j])+" | ");
            }
            System.out.println();
        }
    }

    public boolean findWinner(PieceType pieceType){

        for(int i = 0;i<size;i++){
            if(rows[i] == -3 || rows[i] == 3) return true;
            if(cols[i] == -3 || cols[i] == 3) return true;
        }
        if(lower_dia == -3 || upper_dia == 3) return true;
        if(lower_dia == 3 || upper_dia == -3) return true;

        return false;

    }
}
