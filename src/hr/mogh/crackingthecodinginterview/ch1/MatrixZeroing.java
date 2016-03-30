package hr.mogh.crackingthecodinginterview.ch1;

import java.util.ArrayList;
import java.util.List;

/**
 * Solves the following problem:
 * <p/>
 * <code>Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0
 * .</code><br/>
 * <p/>
 * Created by vlado on 30.3.2016.
 */
public class MatrixZeroing {

    /**
     * Zeroes out rows and columns of matrix elements that are 0.<br/>
     * Space complexity: <code>O(n)</code>.<br/>
     * Time complexity: <code>O(n^2)</code>.
     * @param matrix Input matrix.
     */
    public static void zeroOut(short[][] matrix) {

        List<Integer> zeroedRows = new ArrayList<>();
        List<Integer> zeroedCols = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!zeroedRows.contains(j)) {
                    if (matrix[i][j] == 0) {
                        zeroedCols.add(i);
                        zeroedRows.add(j);
                    }
                }
            }
        }

        for (int i = 0; i < zeroedCols.size(); i++) {
            executeZeroingOut(matrix, zeroedRows.get(i), zeroedCols.get(i));
        }
    }

    private static void executeZeroingOut(short[][] matrix, int row, int column) {
        if (row >= matrix[0].length || column >= matrix.length) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][row] = 0;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[column][j] = 0;
        }
    }
}
