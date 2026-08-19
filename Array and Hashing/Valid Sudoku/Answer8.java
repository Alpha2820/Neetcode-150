import java.util.*;

public class Answer8 {
    public static boolean isSudokuValid(char board[][]) {
        for (int rows = 0; rows < 9; rows++) {
            HashSet<Character> r = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[rows][j] == '.') {
                    continue;
                }
                if (r.contains(board[rows][j])) {
                    return false;
                }
                r.add(board[rows][j]);
            }
        }
        for (int cols = 0; cols < 9; cols++) {
            HashSet<Character> c = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][cols] == '.') {
                    continue;
                }
                if (c.contains(board[j][cols])) {
                    return false;
                }
                c.add(board[j][cols]);
            }
        }
        for (int square = 0; square < 9; square++) {
            HashSet<Character> sq = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') {
                        continue;
                    }
                    if (sq.contains(board[row][col])) {
                        return false;
                    }
                    sq.add(board[row][col]);
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Array");
        int size = sc.nextInt();
        if (size != 9) {
            System.out.println("Invalid size. Please enter 9.");
        }
        sc.nextLine();
        System.out.println("Enter the Elements in the Array");
        char board[][] = new char[size][size];
        for (int i = 0; i < size; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < size; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        boolean isValid = isSudokuValid(board);
        if (isValid) {
            System.out.println("The Sudoku is valid.");
        } else {
            System.out.println("The Sudoku is not valid.");
        }
        sc.close();

    }

}
