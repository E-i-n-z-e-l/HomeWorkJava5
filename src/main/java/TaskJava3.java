/*
На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга
(обратите внимание на алгоритм backtracking(поиск с возвратом)).
 */




public class TaskJava3 {
    public static void main(String[] args) {
        int[][] board = new int[8][8];
        solve(board, 0);
    }

    public static boolean solve(int[][] board, int col) {
        if (col == 8) {
            printBoard(board);
            return true;
        }

        boolean result = false;
        for (int row = 0; row < 8; row++) {
            if (isValid(board, row, col)) {
                board[row][col] = 1;
                result = solve(board, col + 1) || result;
                board[row][col] = 0;
            }
        }
        return result;
    }
    /*
    Функция isValid проверяет, может ли ферзь быть добавлен на данную позицию.
    Мы проверяем все вертикальные, горизонтальные и диагональные ряды относительно текущей позиции ферзя.
     */
    public static boolean isValid(int[][] board, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) return false;
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }
        for (int i = row, j = col; i < 8 && j >= 0; i++, j--) {
            if (board[i][j] == 1) return false;
        }
        return true;
    }
    /*
    Функция printBoard просто выводит текущее состояние доски в консоль.
     */
    public static void printBoard(int[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
