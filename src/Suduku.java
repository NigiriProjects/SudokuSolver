import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Suduku {
  int[][] array = new int[9][9];
  File file;
  int[][][] booleanArray = new int[9][9][9];

  Suduku(File file) throws FileNotFoundException {

    this.file = file;
    parseFile(file);

  }

  private void parseFile(File file) throws FileNotFoundException {
    Scanner in = new Scanner(file);
    for (int i = 0; i < 9; i++) {
      for (int k = 0; k < 9; k++) {
        array[i][k] = in.nextInt();
      }
    }
  }

  public void printArray() {
    for (int i = 0; i < 9; i++) {
      for (int k = 0; k < 9; k++) {
        System.out.print(" " + array[i][k]);
      }
      System.out.println();
    }
  }

  private void setRowCol(int row, int col) {
    int Value = array[row][col] - 1;
    for (int i = 0; i < 9; i++) {
      booleanArray[Value][row][i] = 1;
      booleanArray[Value][i][col] = 1;
    }
  }

  private void setQuad(int row, int col) {
    int quadRow = (row / 3) * 3;
    int quadCol = (col / 3) * 3;
    int val = array[row][col] - 1;
    for (int i = 0; i < 3; i++) {
      for (int k = 0; k < 3; k++) {
        booleanArray[val][quadRow + i][quadCol + k] = 1;
      }
    }
  }

  public void solve() {
    for (int i = 0; i < 9; i++) {
      for (int k = 0; k < 9; k++) {
        if (array[i][k] != 0) {
          setRowCol(i, k);
          setQuad(i, k);
        }
      }
    }
    boolean notSolved;
    do {
        notSolved = false;
      for (int i = 0; i < 9; i++) {
        for (int k = 0; k < 9; k++) {
          if (array[i][k] == 0) {
            int sum = 0;
            for (int j = 0; j < 9; j++) {
              sum = sum + booleanArray[j][i][k];
            }
            if (sum == 8) {
              for (int l = 0; l < 9; l++) {
                if (booleanArray[l][i][k] == 0) {
                  notSolved = true;
                  array[i][k] = l + 1;
                  setRowCol(i, k);
                  setQuad(i, k);
                }
              }
            }
          }
        }
      }
    } while (notSolved);
      }
  public void printBools(){
      for (int[][] array : booleanArray) {
          System.out.println("Bool array");

          for (int i = 0; i < 9; i++) {
              for (int k = 0; k < 9; k++) {
                  System.out.print(" " + array[i][k]);
              }
              System.out.println();
          }

      }
  }
}
