import java.util.Arrays;

public class Main {

    private static final int SIZE = 3;

    public static void main(String[] args) {
        int[][] initialBoard = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };

        solvePuzzle(initialBoard);
    }

    private static void solvePuzzle(int[][] board) {
        if (isGoalState(board)) {
            System.out.println("Solution found!");
            printBoard(board);
        } else {
           
            exploreMoves(board);
        }
    }

    private static void exploreMoves(int[][] board) {
        for (int[] move : getPossibleMoves(board)) {
           
            int[][] newBoard = makeMove(board, move);

           
            solvePuzzle(newBoard);
        }
    }

    private static boolean isGoalState(int[][] board) {
        int[][] goalState = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };
        return Arrays.deepEquals(board, goalState);
    }

    private static int[][] makeMove(int[][] board, int[] move) {
        int[][] newBoard = copyBoard(board);
        int zeroRow = move[0];
        int zeroCol = move[1];
        int newRow = move[2];
        int newCol = move[3];

        newBoard[zeroRow][zeroCol] = board[newRow][newCol];
        newBoard[newRow][newCol] = 0;

        return newBoard;
    }

    private static int[][] copyBoard(int[][] board) {
        int[][] newBoard = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(board[i], 0, newBoard[i], 0, SIZE);
        }
        return newBoard;
    }

    private static void printBoard(int[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getPossibleMoves(int[][] board) {
        
        
        return new int[][]{
                {0, 0, 0, 1}, 
                {0, 0, 1, 0}, 
                
        };
    }
}
