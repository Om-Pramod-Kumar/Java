import java.util.Arrays;

public class sortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        System.out.println(Arrays.toString(search(arr, 6))); // should print [1, 2]
    }

    static int[] binarysearch(int[][] matrix, int row, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return new int[]{row, mid};
            }
            if (matrix[row][mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    static int[] search(int[][] matrix, int target) {
        int rows = matrix.length;
        int col = matrix[0].length;

        if (rows == 1) {
            return binarysearch(matrix, 0, 0, col - 1, target);
        }

        int rstart = 0;
        int rend = rows - 1;
        int cmid = col / 2;

        // Narrow down to 2 rows
        while (rstart < (rend - 1)) {
            int mid = rstart + (rend - rstart) / 2;
            if (matrix[mid][cmid] == target) {
                return new int[]{mid, cmid};
            }
            if (matrix[mid][cmid] < target) {
                rstart = mid;
            } else {
                rend = mid;
            }
        }

        // Check middle column of the 2 remaining rows
        if (matrix[rstart][cmid] == target) return new int[]{rstart, cmid};
        if (matrix[rstart + 1][cmid] == target) return new int[]{rstart + 1, cmid};

        // Now check 4 possible quadrants
        if (cmid - 1 >= 0 && target <= matrix[rstart][cmid - 1]) {
            return binarysearch(matrix, rstart, 0, cmid - 1, target);
        }
        if (cmid + 1 < col && target >= matrix[rstart][cmid + 1] && target <= matrix[rstart][col - 1]) {
            return binarysearch(matrix, rstart, cmid + 1, col - 1, target);
        }
        if (cmid - 1 >= 0 && target <= matrix[rstart + 1][cmid - 1]) {
            return binarysearch(matrix, rstart + 1, 0, cmid - 1, target);
        } 
        if (cmid + 1 < col) {
            return binarysearch(matrix, rstart + 1, cmid + 1, col - 1, target);
        }

        return new int[]{-1, -1};
    }
}
