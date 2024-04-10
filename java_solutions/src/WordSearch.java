public class WordSearch {
    private int[][] DIRS = {{1,0}, {-1, 0},{0,1},{0, -1}};
    private boolean isFound = false;
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int r = 0; r < board.length && !isFound ; r++) {
            for (int c = 0; c < board[0].length && !isFound; c++) {
                if (board[r][c] == word.charAt(0) && visited[r][c] == false ) {
                    checkWord(board, word, visited, 0, r, c);
                }
            }
        }
        return isFound;
    }

    private void checkWord(char[][] board, String word, boolean[][] visited, int wordIndex, int row, int col) {
        if (wordIndex >= word.length()) {
            isFound = true;
            return;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
                || visited[row][col] == true|| board[row][col] != word.charAt(wordIndex) ) {
            return;
        }

        visited[row][col] = true;

        for (int i = 0; i < DIRS.length && !isFound; i++) {
            int r = row + DIRS[i][0];
            int c = col + DIRS[i][1];

            checkWord(board, word, visited, (wordIndex + 1), r, c);

        }
        visited[row][col] = false;

    }

    public static void main(String[] args) {
        char[][] grid = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(grid, "SEE"));
    }
}
