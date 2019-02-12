public class QueenBoard{
  private int[][]board;
  private int size;

  public QueenBoard(int length){
    board = new int[length][length];
    size = length;
    reset();
  }

  public void reset() {
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        board[r][c] = 0;
      }
    }
  }

  public boolean addQueen(int r, int c) {
    if (board[r][c] == 0) {
      board[r][c] = -1;
      for (int i = 1; c + i < size; i++) {
        if (r + i < size) {
          board[r+i][c+i] = board[r+i][c+i] + 1;
        }
        if (r-i > -1) {
          board[r-i][c+i] = board[r-i][c+i] + 1;
        }
        board[r][c+i] = board[r][c+i] + 1;
      }
      return true;
    }
    else {
      return false;
    }
  }

  public boolean removeQueen(int r, int c) {
    board[r][c] = 0;
    for (int i = 1; c + i < size; i++) {
      if (r + i < size) {
        board[r+i][c+i] = board[r+i][c+i] - 1;
      }
      if (r-i > -1) {
        board[r-i][c+i] = board[r-i][c+i] - 1;
      }
      board[r][c+i] = board[r][c+i] - 1;
    }
    return true;
  }

  public boolean solve() {
    if (isException()) {
      throw new IllegalStateException();
    }
    else {
      return solveHelper(0); //start with column 0
    }
  }

  public boolean isException() { //if there is any non zeros on board
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        if (board[r][c] != 0) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean solveHelper(int col) {
    if (col > size-1) { //if you are at the last column n queens have been placed
      return true;
    }
    else {
      for (int r = 0; r < size; r++) { //go down the column
        if (addQueen(r, col)) { //if you can add a queen
          if (solveHelper(col+1)) { //see if you can add queen to next column
            return true;
          }
          else { //cannot add queen to next column
            removeQueen(r,col);
          }
        }
      }
      return false;
    }
  }

  public int countSolutions() {
    return countHelper(0);
  }

  public int countHelper(int col) {
    if (col > size-1) {
      return 1;
    }
    int solutions = 0;
    for (int r = 0; r < size; r++) {
      if (addQueen(r, col)) {
        solutions = solutions + countHelper(col+1);
        removeQueen(r, col);
      }
    }
    return solutions;
  }

  public String toString(){
    String display = "";;
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        if (board[r][c] == -1) {
          display += "Q ";
        }
        else {
          display += "_ ";
        }
      }
      display += "\n";
    }
    return display;
  }

  public static void main(String[] args) {
    QueenBoard A = new QueenBoard(4);
    QueenBoard B = new QueenBoard(5);
    QueenBoard C = new QueenBoard(6);
    QueenBoard D = new QueenBoard(7);
    QueenBoard E = new QueenBoard(8);
    System.out.println(A.countSolutions());
    System.out.println(B.countSolutions());
    System.out.println(C.countSolutions());
    System.out.println(D.countSolutions());
    System.out.println(E.countSolutions());
  }
}
