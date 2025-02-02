package game2048logic;

import game2048rendering.Side;
import static game2048logic.MatrixUtils.rotateLeft;
import static game2048logic.MatrixUtils.rotateRight;

/**
 * @author  Josh Hug
 */
public class GameLogic {
    /** Moves the given tile up as far as possible, subject to the minR constraint.
     *
     * @param board the current state of the board
     * @param r     the row number of the tile to move up
     * @param c -   the column number of the tile to move up
     * @param minR  the minimum row number that the tile can land in, e.g.
     *              if minR is 2, the moving tile should move no higher than row 2.
     * @return      if there is a merge, returns the 1 + the row number where the merge occurred.
     *              if no merge occurs, then return 0.
     */
    public static int moveTileUpAsFarAsPossible(int[][] board, int r, int c, int minR) {
        int value = board[r][c];
        if (value == 0) {
            return 0;
        }
        int newRow = r;
        while (newRow > minR && board[newRow - 1][c] == 0) {
            newRow--;
        }
        if (newRow > minR && board[newRow - 1][c] == value) {
            board[newRow - 1][c] *= 2;
            board[r][c] = 0;
            return newRow;
        } else if (newRow != r) {
            board[newRow][c] = value;
            board[r][c] = 0;
        }
        return 0;
    }

    /**
     * Modifies the board to simulate the process of tilting column c
     * upwards.
     *
     * @param board     the current state of the board
     * @param c         the column to tilt up.
     */
    public static void tiltColumn(int[][] board, int c) {
        int size = board.length;
        int[] temp = new int[size];
        int index = 0;
        for (int r = 0; r < size; r++) {
            if (board[r][c] != 0) {
                temp[index++] = board[r][c];
            }
        }
        int[] newColumn = new int[size];
        int newIndex = 0;
        for (int i = 0; i < index;) {
            if (i < index - 1 && temp[i] == temp[i + 1]) {
                newColumn[newIndex++] = temp[i] * 2;
                i = i + 2;
            } else {
                newColumn[newIndex++] = temp[i];
                i = i + 1;
            }
        }
        for (int r = 0; r < size; r++) {
            board[r][c] = newColumn[r];
        }
    }

    /**
     * Modifies the board to simulate tilting all columns upwards.
     *
     * @param board     the current state of the board.
     */
    public static void tiltUp(int[][] board) {
        int size = board.length;
        for (int c = 0; c < size; c++) {
            tiltColumn(board, c);
        }
    }

    /**
     * Modifies the board to simulate tilting the entire board to
     * the given side.
     *
     * @param board the current state of the board
     * @param side  the direction to tilt
     */
    public static void tilt(int[][] board, Side side) {
        if (side == Side.EAST) {
            rotateLeft(board);
            tiltUp(board);
            rotateRight(board);
        } else if (side == Side.WEST) {
            rotateRight(board);
            tiltUp(board);
            rotateLeft(board);
        } else if (side == Side.SOUTH) {
            rotateRight(board);
            rotateRight(board);
            tiltUp(board);
            rotateLeft(board);
            rotateLeft(board);
        } else {
            tiltUp(board);
        }
    }
}
