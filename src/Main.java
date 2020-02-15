import java.io.File;
import java.io.FileNotFoundException;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/connor/IdeaProjects/SudokuSolver/src/sudokuOne");
        Suduku suduku = new Suduku(file);
        System.out.println("This is the sudoku");
        suduku.printArray();
        System.out.println("This is the post sudoku");
        suduku.solve();
        suduku.printArray();
    }
}