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
    if (board[row][col] == 0) {
      board[row][col] = -1;
      int size = board.length;
      for (int c = 0; c < size; c++) {
        board[row][c] = board[row][c] +1;
      }
      for (int r = 0; r < size; r++) {
        board[r][col] = board[r][col] +1;
      }
      return true;
    }
    else {
      return false;
    }
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
    System.out.println(A.addQueen(0,0));
    System.out.println(A.toString());
  }

  //private boolean addQueen(int r, int c)
  //private boolean removeQueen(int r, int c)
}
