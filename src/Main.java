import java.io.File;
import java.io.FileNotFoundException;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/connor/IdeaProjects/SudokuSolver/src/sudokuOne");
        Sudoku sudoku = new Sudoku(file);
        System.out.println("This is the sudoku");
        sudoku.printArray();
        System.out.println("This is the solved sudoku");
        sudoku.solve();
        sudoku.printArray();
        System.out.println(sudoku.string);


    }
}