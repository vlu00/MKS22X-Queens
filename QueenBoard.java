public class QueenBoard{
  private int[][]board;
  private int size;

  public QueenBoard(int length){
    board = new int[length][length];
    size = length;
    reset();
  }

  public void reset() { //board is blank
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        board[r][c] = 0;
      }
    }
  }

  public boolean addQueen(int r, int c) {
    if (board[r][c] == 0) { //if square is not eliminated
      board[r][c] = -1; //place a queen
      for (int i = 1; c + i < size; i++) {
        if (r + i < size) { //haven't reached first row
          board[r+i][c+i] = board[r+i][c+i] + 1; //eliminate diagonal to top right corner
        }
        if (r-i > -1) { //haven't reached last row
          board[r-i][c+i] = board[r-i][c+i] + 1; //eliminate diagonal to bottom right corner
        }
        board[r][c+i] = board[r][c+i] + 1; //eliminate squares in same row
      }
      return true;
    }
    else {
      return false; //can't add queen
    }
  }

  public boolean removeQueen(int r, int c) {
    board[r][c] = 0; //change back to blank space
    for (int i = 1; c + i < size; i++) { //get rid of the eliminated squares associated with the queen
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
    if (isException()) { //if the board is not blank throw an exception
      throw new IllegalStateException();
    }
    else {
      return solveHelper(0); //else solve starting with column 0
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
    if (isException()) { //if the board is not blank throw an exception
      throw new IllegalStateException();
    }
    else {
      return countHelper(0); //else find solutions starting with first column
    }
  }

  public int countHelper(int col) {
    if (col > size-1) { //if you've reached the last column
      return 1; //will add one to solutions;
    }
    int solutions = 0;
    for (int r = 0; r < size; r++) {
      if (addQueen(r, col)) { //if you can add a queen
        solutions = solutions + countHelper(col+1); //continue and see if it is solution
        removeQueen(r, col); //backtracking. Remove that queen to check other solutions
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
}
