package sample;

public class MaxPath {

	public int maxPathMoves(int[][] matrix) {
		
	    int[][] moves = { {-1, 1}, {0, 1}, {1, 1} };
	    
	    int m = matrix.length, n = matrix[0].length;
	    
	    int[][] queue = new int[m * n][2];
	    
	    int front = 0, rear = 0;

	    for (int i = 0; i < m; ++i) {
	        queue[rear++] = new int[] {i, 0};
	    }

	    int[][] matrixmoves = new int[m][n];
	    int result = 0;

	    while (front < rear) {
	        int[] p = queue[front++];
	        int i = p[0], j = p[1];

	        for (int[] move : moves) {
	            int x = i + move[0], y = j + move[1];
	            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]
	                && matrixmoves[x][y] < matrixmoves[i][j] + 1) {
	            	matrixmoves[x][y] = matrixmoves[i][j] + 1;
	            	result = Math.max(result, matrixmoves[x][y]);
	                queue[rear++] = new int[] {x, y};
	            }
	        }
	    }

	    return result;
	}
	   

    public static void main(String[] args) {
        int[][] matrix1 = {{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}};
        int[][] matrix2 = {{3, 2, 4}, {2, 1, 9}, {1, 1, 7}};
        
        MaxPath maxPath = new MaxPath();
        System.out.println(maxPath.maxPathMoves(matrix1)); // Output: 3
        System.out.println(maxPath.maxPathMoves(matrix2)); // Output: 0
    }
}


