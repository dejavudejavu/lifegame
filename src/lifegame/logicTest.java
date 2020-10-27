package lifegame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class logicTest {

	private static logic Logic=new logic(10, 10);
	@BeforeEach
	void setUp() throws Exception {
		Logic.deleteAllCell();
	}

	@Test
	void testLogic() {
		assertEquals(10,Logic.maxLength);
		assertEquals(10,Logic.maxWidth);
	}

	@Test
	void testRandomCell() {
		//Logic.randomCell();
		//Logic.grid[1][3];
	}

	@Test
	void testUpdate() {
		//±ﬂ‘µ≤‚ ‘
		for(int i=1;i<=10;i++)
			for(int j=1;j<=10;j++)
				Logic.grid[i][j]=1;
		Logic.update();
		boolean flag = true;
		if(Logic.grid[1][1]==1&&Logic.grid[1][10]==1&&Logic.grid[10][1]==1&&Logic.grid[10][10]==1)
		{
			flag = true;
		}
		else 
			flag = false;	
		assertEquals(true,flag);
		//¥ÌŒÛ≤‚ ‘
		
		Logic.deleteAllCell();
		Logic.grid[4][5]=Logic.grid[4][6]=Logic.grid[5][5]=Logic.grid[5][6]=1;

		int[][] a1=new int[12][12];
		for(int i=0;i<12;i++)
		{
			for(int j=0;j<12;j++)
			{
				a1[i][j]=0;
			}
		}
		
		Logic.update();
		
		boolean flag2 = true;
		for(int i=1;i<11;i++)
			for(int j=1;j<11;j++)
			{
				if(a1[i][j]!=Logic.grid[i][j])
				{
					flag2 = false;
				}
			}
		assertEquals(false,flag2);
		
		//“ª∞„≤‚ ‘
		Logic.deleteAllCell();
		boolean flag3 = true;
		Logic.grid[4][5]=Logic.grid[4][6]=Logic.grid[5][5]=Logic.grid[5][6]=Logic.grid[1][9]=Logic.grid[3][7]=1;

		a1[4][5]=a1[4][7]=a1[5][5]=a1[3][6]=a1[5][6]=1;
		Logic.update();		
		for(int i=1;i<11;i++)
			for(int j=1;j<11;j++)
				if(a1[i][j]!=Logic.grid[i][j])
					flag3=false;
		assertEquals(true,flag3);
					
	}

	@Test
	void testDeleteAllCell() {
		Logic.deleteAllCell();
		boolean flag=true;
		for(int i=0;i<12;i++)
			for(int j=0;j<12;j++)
				if(Logic.grid[i][j]==1)
					flag=false;
		assertEquals(true,flag);				
	}

	@Test
	void testSetGrid() {
		Logic.deleteAllCell();
		int[][] a=new int[12][12];
		for(int i=0;i<12;i++)
			for(int j=0;j<12;j++)
				a[i][j]=0;
		a[5][3]=1;
		Logic.setGrid(a);	
		boolean flag=true;
		if(Logic.grid[5][3]==1)
		{
			for(int i=0;i<12;i++)
				for(int j=0;j<12;j++)
					if(i==5&&j==3)
					{
						
					}
					else if(Logic.grid[i][j]==1)
						flag=false;
		}
		else flag=false;
		assertEquals(true,flag);		
	}

	@Test
	void testGetGrid() {
		Logic.deleteAllCell();
		Logic.grid[6][3]=1;
		int[][] Grid=Logic.getGrid();
		boolean flag=true;
		if(Grid[6][3]==1)
		{
			for(int i=0;i<12;i++)
				for(int j=0;j<12;j++)
					if(i==6&&j==3)
					{
						
					}
					else if(Grid[i][j]==1)
						flag=false;
		}
		else flag=false;
		assertEquals(true,flag);
	}

	@Test
	void testGetNowGeneration() {
		Logic.setNowGeneration(5);
		int G=Logic.getNowGeneration();
		assertEquals(5,G);
	}

	@Test
	void testSetNowGeneration() {
		Logic.setNowGeneration(4);
		assertEquals(4,Logic.nowGeneration);
	}

}
