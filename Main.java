public class Main {

    public static void main(String[] args) {
        int n = 8; // You can change the value of N here
        solveNQueens(n);
    }

    private static void solveNQueens(int n) {
        int[] queens = new int[n];
        placeQueens(queens, 0, n);
    }

    private static void placeQueens(int[] queens, int row, int n) {
        if (row == n) {
            printQueens(queens);
            return;
        }

        placeQueenInRow(queens, row, 0, n);
    }

    private static void placeQueenInRow(int[] queens, int row, int col, int n) {
        if (col == n) {
            return;
        }

        if (isSafe(queens, row, col)) {
            queens[row] = col;
            placeQueens(queens, row + 1, n);
        }

        placeQueenInRow(queens, row, col + 1, n);
    }

    private static boolean isSafe(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || queens[i] - i == col - row || queens[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }

    private static void printQueens(int[] queens) {
        int n = queens.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (queens[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
