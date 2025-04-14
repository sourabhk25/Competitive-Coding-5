// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Traverse the board once to validate rows and columns using hash sets.
//   - Traverse again by 3x3 blocks, stepping i and j in multiples of 3 to validate each box.
//   - Use a separate counter to track box index.
//   - Skip cells with '.' and check for duplicates in row, column, and box sets.

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] columns = new HashSet[n];
        HashSet<Character>[] boxes = new HashSet[n];
        int boxCnt = 0;

        for(int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                char temp = board[i][j];
                if(temp == '.') {
                    continue;   //skip cell
                }
                if(rows[i].contains(temp)) {
                    return false;
                }
                rows[i].add(temp);
                if(columns[j].contains(temp)) {
                    return false;
                }
                columns[j].add(temp);
            }
        }

        //loop again for boxes and move i j only by 3, so inside 3x3 can be done using k and l
        for(int i = 0; i < n; i += 3) {
            for(int j = 0; j < n; j += 3) {
                for(int k = 0; k < 3; k++) {
                    for(int l = 0; l < 3; l++) {
                        char temp = board[i + k][j + l];
                        if(temp == '.') {
                            continue;   //skip cell
                        }

                        if(boxes[boxCnt].contains(temp)) {
                            return false;
                        }
                        boxes[boxCnt].add(temp);
                    }
                }
                boxCnt++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidSudoku validator = new ValidSudoku();

        // Sample input: Valid Sudoku board
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        boolean isValid = validator.isValidSudoku(board);
        System.out.println("Is the Sudoku board valid? " + isValid);
    }
}
