package lifegame;

public class map {
    public int maxLength;
    public int maxWidth;
    public int nowGeneration;
    public int[][] grid; //һ�����ݴ���һ��ϸ��,0��������1�����
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
