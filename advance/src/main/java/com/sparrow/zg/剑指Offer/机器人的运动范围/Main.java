package main.java.com.sparrow.zg.剑指Offer.机器人的运动范围;

public class Main {
	public static void main(String[] args) {

	}
	private int cnt = 0;
	private int rows;
	private int cols;
	private int threshold;
	private int[][] digitSum;//对应到arr[r][c]
	private final int[][] next = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public int movingCount(int threshold, int rows, int cols)
	{
		//需要一个记录到达次数的全局变量cnt
		this.rows = rows;
		this.cols = cols;
		this.threshold = threshold;
		initDigitSum(); //初始化限制数组
		boolean[][] marked = new boolean[rows][cols];
		dfs(marked,0,0);//使用dfs搜索可以到达的路
		return cnt;
	}
	public void dfs(boolean[][] marked, int r, int c){
		if(r < 0 || r >= rows || c >= cols || c < 0 || marked[r][c]){
			return ;
		}
		marked[r][c] = true;
		if(this.digitSum[r][c] > this.threshold){
			return ;
		}
		cnt++;
		for(int[] n : next){
			dfs(marked, r + n[0], c + n[1]);
		}
	}
	public void initDigitSum(){
		//先产生一个对应位数组
		int[] arr = new int[Math.max(rows, cols)];
		for(int i = 0; i < arr.length; i++){
			int n = i;
			while(n > 0){
				arr[i]+= n % 10;
				n = n / 10;
			}
		}
		this.digitSum = new int[rows][cols];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				digitSum[i][j] = arr[i] + arr[j];
			}
		}
	}
}
