package lifegame;
public class logic extends map {
	public logic(int maxLength, int maxWidth) {
		super(maxLength, maxWidth);
		// TODO Auto-generated constructor stub
	}
	//随机初始化细胞
	void randomCell(){
        for (int i = 1; i <=maxLength; i++)
            for (int j = 1; j <= maxWidth; j++)
                grid[i][j] = Math.random()>0.5?1:0;
    }
	//繁衍
    public void update() {
        int[][] newGrid = new int[maxLength + 2][maxWidth + 2];
        for (int i = 1; i <=maxLength; i++)
            for (int j = 1; j <= maxWidth; j++)
                switch (getNeighborCount(i, j)) {
                    case 2:
                        newGrid[i][j] = grid[i][j]; //细胞状态保持不变
                        break;
                    case 3:
                        newGrid[i][j] = 1; // Cell is alive.
                        break;
                    default:
                        newGrid[i][j] = 0; // Cell is dead.
                }
        for (int i = 1; i <= maxLength; i++)
            for (int j = 1; j <= maxWidth; j++)
                grid[i][j] = newGrid[i][j];
        nowGeneration++;
    }
    
    public void deleteAllCell(){
        for (int i = 1; i <= maxLength; i++)
            for (int j = 1; j <= maxWidth; j++)
                grid[i][j] = 0;
    }
    //获取细胞的邻居数量
    private int getNeighborCount(int i1, int j1) {
        int count = 0;
        for (int i = i1 - 1; i <= i1 + 1; i++)
            for (int j = j1 - 1; j <= j1 + 1; j++)
                count += grid[i][j]; //如果邻居还活着，邻居数便会+1
        count -= grid[i1][j1]; //每个细胞不是自己的邻居，则如果细胞还活着，邻居数-1.

        return count;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public int[][] getGrid() {
        return grid;
    }
    public int getNowGeneration() {
    	return this.nowGeneration;
    }
    public void setNowGeneration(int now) {
    	this.nowGeneration=now;
}
}
