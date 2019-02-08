public class QueenBoard{
  private int[][]board;
  private int size;  = board.length;

  public QueenBoard(int size){
    board = new int[size][size];
    size = board.length;
    reset();
  }

  public void reset() {
    //int size = board.length;
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        board[r][c] = 0;
      }
    }
  }

  private boolean addQueen(int row, int col) {
    if (board[row][col] == 0) {
      //int size = board.length;
      int r;
      int c;
      for (c = col; c < size; c++) {
        board[row][c] = board[row][c] +1;
      }
      for (r = 0; r < size; r++) {
        board[r][col] = board[r][col] +1;
      }
      for (r = row, c = col; r-1 > -1 && c + 1 < size; r--, c++) {
        board[r-1][c+1] = board[r-1][c+1] + 1;
      }
      for (r = row, c = col; r+1 < size && c + 1 < size; r++, c++) {
        board[r+1][c+1] = board[r+1][c+1] + 1;
      }
      board[row][col] = 9;
      return true;
    }
    else {
      return false;
    }
  }

  public boolean removeQueen(int row, int col) {
    //int size = board.length;
    int r;
    int c;
    for (c = col; c < size; c++) {
      board[row][c] = board[row][c] -1;
    }
    for (r = 0; r < size; r++) {
      board[r][col] = board[r][col] -1;
    }
    for (r = row, c = col; r-1 > -1 && c + 1 < size; r--, c++) {
      board[r-1][c+1] = board[r-1][c+1] - 1;
    }
    for (r = row, c = col; r+1 < size && c + 1 < size; r++, c++) {
      board[r+1][c+1] = board[r+1][c+1] - 1;
    }
    board[row][col] = 0;
    return true;
  }

  public boolean isException() { //if there is any non zeros on board
    //int size = board.length;
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        if (board[r][c] != 0) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean notSolution() { //checks if a column is elminated.
    //int size = board.length;
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        if (board[r][c] == 0) { //if column is not eliminated
          return false;
        }
      }
    }
    return true; //column is eliminated
  }

  public boolean solve() {
    if (isException()) {
      throw new IllegalStateException();
    }
    if ()
    else {
      for (int r = 0; i < board.length; i++) {
        addQueen()
      }
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
    A.reset();
    System.out.println(A.toString());
    System.out.println(A.addQueen(1,1));
    System.out.println(A.toString());
    System.out.println(A.addQueen(3,1));
    System.out.println(A.toString());
    System.out.println(A.addQueen(3,2));
    System.out.println(A.toString());
    System.out.println(A.removeQueen(3,2));
    System.out.println(A.toString());
  }

  //private boolean addQueen(int r, int c)
  //private boolean removeQueen(int r, int c)
}
