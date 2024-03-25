public class RotateMatrix {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
//                System.out.println(" i = " + (n - 1 - j) + " j = " + i);
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;

            }
        }
    }

    private void rotateMat(int[][] matrix) {
        int l = 0;
        int r = matrix.length - 1;

        while (l < r) {
            for (int i =0; i< r - l; i++) {
                int top = l;
                int bottom = r;

                int temp = matrix[top][l+i];

                matrix[top][l+i] = matrix[bottom-i][l];

                matrix[bottom-i][l] = matrix[bottom][r -i];

                matrix[bottom][r - i] = matrix[top + i][r];

                matrix[top + i][r] = temp;
            }
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };

        int[][] mat1 = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };
        RotateMatrix rm = new RotateMatrix();
        rm.rotate(mat);
        rm.rotateMat(mat1);
        for (int i =0; i< mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i =0; i< mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                System.out.print(mat1[i][j] + " ");
            }
            System.out.println();
        }

    }
}
