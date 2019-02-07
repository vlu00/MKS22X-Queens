public class QueenBoard{
  private int[][]board;

  public QueenBoard(int size){
    board = new int[size][size];
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        board[r][c] = 0;
      }
    }
  }

  private boolean addQueen(int row, int col) {
    board[row][col] = -1;
    int size = board.length;
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        if (r == row) {
          board[r][c] =  board[r][c] + 1;
        }
        if 
  }

  public String toString(){
    String display = "";
    int size = board.length;
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        display += board[r][c];
      }
      display += "\n";
    }
    return display;
  }

  public static void main(String[] args) {
    QueenBoard A = new QueenBoard(4);
    System.out.println(A.toString());
  }

  //private boolean addQueen(int r, int c)
  //private boolean removeQueen(int r, int c)
}
