import java.util.Scanner;

public class ConnectFour {

  public static void main(String[] args) {
    int playerTurn = 1;
    Scanner sc = new Scanner(System.in);
    int[][] board = new int[7][6];
    createNewBoard(board);
    printBoard(board);
    for (int turnNumber = 0; turnNumber < 42; turnNumber++) {
      playerTurn = (turnNumber % 2) + 1;
      doPlayerTurn(playerTurn, sc, board);
      int winner =  checkBoard(board);
      if(winner!=0){
        System.out.println("player"+winner+" won");
        break;
      }
    }
  }

  private static int checkBoard(int[][] board) {
    for (int x = 0; x < 7; x++) {
      for (int y = 0; y < 6; y++) {
        if (board[x][y]==0) {
         continue;
        }
        int numberOfPiecesInARow = 1;
        for (int next = 1; next < 4; next++) {
          if(x+next>6){
            continue;
          }
          if (board[x + next][y] == board[x][y]) {
            numberOfPiecesInARow++;
          }
        }
        if (numberOfPiecesInARow == 4) {
          return board[x][y];
        }
        numberOfPiecesInARow=1;
        for (int next = 1; next < 4; next++) {
          if(y+next>5){
            continue;
          }
          if (board[x][y+next] == board[x][y]) {
            numberOfPiecesInARow++;
          }
        }
        if (numberOfPiecesInARow == 4) {
          return board[x][y];
        }
        numberOfPiecesInARow=1;
        for (int next = 1; next < 4; next++) {
          if(y+next>5 || x+next>6){
            continue;
          }
          if (board[x+next][y+next] == board[x][y]) {
            numberOfPiecesInARow++;
          }
        }
        if (numberOfPiecesInARow == 4) {
          return board[x][y];
        }
        numberOfPiecesInARow=1;
        for (int next = 1; next < 4; next++) {
          if(y-next<0 || x-next<0){
            continue;
          }
          if (board[x-next][y-next] == board[x][y]) {
            numberOfPiecesInARow++;
          }
        }
        if (numberOfPiecesInARow == 4) {
          return board[x][y];
        }
      }
    }
    return 0;
  }

  private static void doPlayerTurn(int playerTurn, Scanner sc, int[][] board) {
    System.out.println("It is Player " + playerTurn + "turn");
    System.out.println("where do you want to drop the peice?");
    int columnDrop = 0;
    boolean retry = true;
    int analyzedColumn = 6;
    while (retry == true) {
      columnDrop = sc.nextInt();
      if (board[0][columnDrop] != 0) {
        System.out.println("Column:" + columnDrop + " is full pick another column");
      } else {
        retry = false;
      }
    }
    while (analyzedColumn >= 0) {
      if (board[analyzedColumn][columnDrop] != 0) {
        analyzedColumn--;
      } else {
        board[analyzedColumn][columnDrop] = playerTurn;
        break;
      }
    }
    printBoard(board);
  }

  private static void printBoard(int[][] board) {
    for (int x = 0; x < 7; x++) {
      System.out.println();
      for (int y = 0; y < 6; y++) {
        System.out.print(board[x][y]);
      }
    }
    System.out.println();
  }

  private static void createNewBoard(int[][] board) {
    for (int x = 0; x < 7; x++) {
      for (int y = 0; y < 6; y++) {
        board[x][y] = 0;
      }
    }
  }
}
//   01234567
// 0 00000000
// 1 00000000
// 2 00000000
// 3 00000000
// 4 00000000
// 5 00000000
// 6 00000000