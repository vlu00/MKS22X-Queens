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
      board[r][c] = 9;
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
    return solveHelper(0); //start with column 0
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

/*
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
*/
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
    QueenBoard B = new QueenBoard(1);
    QueenBoard C = new QueenBoard(2);
    QueenBoard D = new QueenBoard(3);
    QueenBoard A = new QueenBoard(4);
    /*
    System.out.println(A.toString());
    System.out.println("adding to 0,0");
    System.out.println(A.addQueen(0,0));
    System.out.println(A.toString());
    System.out.println("adding to 1,1");
    System.out.println(A.addQueen(1,1));
    System.out.println(A.toString());
    System.out.println("adding to 3,1");
    System.out.println(A.addQueen(3,1));
    System.out.println(A.toString());
    System.out.println("adding to 3,2");
    System.out.println(A.addQueen(3,2));
    System.out.println(A.toString());
    System.out.println("removing to 3,1");
    System.out.println(A.removeQueen(3,1));
    System.out.println(A.toString());
    */
    System.out.println("testing solve");
    System.out.println(A.solve());
    System.out.println(A.toString());

  }
}
