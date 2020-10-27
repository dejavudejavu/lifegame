package lifegame;

public class map {
    public int maxLength;
    public int maxWidth;
    public int nowGeneration;
    public int[][] grid; //一个数据代表一个细胞,0代表死，1代表活
    logic Log;
    
    public map(int maxLength, int maxWidth) {
        this.maxLength = maxLength;
        this.maxWidth = maxWidth;
        nowGeneration = 0;
        grid = new int[maxLength + 2][maxWidth + 2];
        for (int i = 0; i <= maxLength + 1; i++) {
            for (int j = 0; j <= maxWidth + 1; j++)
                grid[i][j] = 0;
        }
    }
    

//    public int getlength() {
//    	return maxLength;
//    }
//    
//    public int getwidth() {
//    	return maxWidth;
//    }
//    
    

    
}
