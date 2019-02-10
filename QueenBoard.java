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
          return false;
        }
      }
    }
    return true;
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
    return countHelper(0, 0);
  }

  public boolean canMove(int col) {
    for (int r = 0; r < size; r++) {
      if (board[r][col] == 0) {
        return true;
      }
    }
    return false;
  }

  public int countHelper(int solution, int col) {
    for (int r = 0; r < size; r++) { //go down the column
      if (col > size-1) {
        solution = solution + 1;
        removeQueen(r, col-1);
      }
      else {
        if (addQueen(r, col)) {
          if (canMove(col+1)) {
            countHelper(solution, col+1);
          }
          else {
            removeQueen(r, col);
          }
        }
      }
    }
    return solution;
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
    QueenBoard B = new QueenBoard(1);
    QueenBoard C = new QueenBoard(2);
    QueenBoard D = new QueenBoard(3);
    QueenBoard A = new QueenBoard(4);
    System.out.println(A.countSolutions());
    System.out.println(A.toString());

    /*
    System.out.println("testing solve 1");
    System.out.println(B.solve());
    System.out.println(B.toString());
    System.out.println("testing solve 2");
    System.out.println(C.solve());
    System.out.println(C.toString());
    System.out.println("testing solve 3");
    System.out.println(D.solve());
    System.out.println(D.toString());
    System.out.println("testing solve 4");
    System.out.println(A.solve());
    System.out.println(A.toString());

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


  }
}
