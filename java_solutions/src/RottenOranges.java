import java.util.LinkedList;
import java.util.Queue;

class RottenOranges {
    private int ROTTEN = 2;
    private int[] MARKER = null;
    private int[][] DIRS = {{0,1}, {0, -1}, {1,0}, {-1,0}};

    public int orangesRotting(int[][] grid) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();

        getStartingIndexes(grid, queue);
        if (queue.size() == 0) return -1;

        queue.add(MARKER);

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            if (arr == null) {
                count++;
                if (queue.isEmpty()) {
                    queue.add(MARKER);
                }
            } else {
                int r = arr[0];
                int c = arr[1];

//                grid[r][c] = 2;
                for (int[] dir: DIRS) {
                    int row = r + dir[0];
                    int col = c + dir[1];

                    if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 2) {
                        continue;
                    }

                    queue.add(new int[]{row, col});
                    grid[row][col] = 2;
                }
            }
        }
        return count;
    }
    private void getStartingIndexes(int[][] grid, Queue<int[]> queue) {
        for (int i = 0; i<grid.length; i++) {
            for (int j = 0; j< grid[0].length; j++) {
                if (grid[i][j] == ROTTEN) {
                    queue.add(new int[]{i, j});
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}