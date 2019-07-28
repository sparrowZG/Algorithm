package main.java.com.sparrow.zg.剑指Offer.矩阵中的路径;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		boolean r  = m.hasPath("ABCESFCSADEE".toCharArray(),3,4,"ABCCED".toCharArray());
		System.out.println(r);

	}
	private final static int[][] next = {{0, -1},{0, 1},{-1, 0},{1, 0}};
	private int rows;
	private int cols;
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
	{
		if(rows == 0 || cols == 0) return false;
		this.rows = rows;
		this.cols = cols;
		boolean[][] marked = new boolean[rows][cols];
		char[][] array = buildeMatrix(matrix);
		for(int r = 0; r < rows; r++){
			for(int c = 0; c < cols; c++){
				if(backtracking(marked, array, str, 0, r, c)){
					return true;
				}
			}
		}
		return false;
	}
	public boolean backtracking(boolean[][] marked, char[][] array, char[] str, int pathLen, int r, int c){
		if(pathLen == str.length) {
			return true;
		}
		if(r < 0 || c < 0 || r >= rows || c >= cols
			||array[r][c] != str[pathLen] || marked[r][c] ){
			return false;
		}
		marked[r][c] = true;
		for(int[] n : next){
			if(backtracking(marked, array, str, pathLen + 1, r + n[0], c + n[1])){
				return true;
			}
		}
		marked[r][c] = false;
		return false;
	}
	public char[][] buildeMatrix(char[] matrix){
		char[][] res = new char[rows][cols];
		for(int r = 0,idx = 0; r < rows; r++){
			for(int c = 0; c < cols; c++){
				res[r][c] = matrix[idx++];
			}
		}
		return res;
	}
}
