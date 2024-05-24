package code;
import java.util.*;
class XOgame{
	Scanner sc=new Scanner(System.in);
	int grid;
	char arr[][];
	int coordinateX;
	int coordinateY;
	int cellsOccupied;
	boolean notWin=true;
	XOgame(int grid)
	{
		arr=new char[grid][grid];
		this.grid=grid;
		for(int i=0;i<grid;i++)
			for(int j=0;j<grid;j++)
				arr[i][j]='.';
	}
	void display()
	{
		System.out.println();
		for(int i=0;i<grid;i++)
		{
			for(int j=0;j<grid;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	void xTurn()
	{
		System.out.println("\nX's turn, enter coordinates");
		coordinateX=sc.nextInt();
		coordinateY=sc.nextInt();
		if(coordinateX>grid ||coordinateX<0 ||  coordinateY>grid || coordinateX<0)
		{
			System.out.println("\n Invalid coordinates !\n Try Again !");
			xTurn();
		}
		else if(arr[coordinateX][coordinateY]=='.')
		{
			arr[coordinateX][coordinateY]='X';
			cellsOccupied++;
			display();
			checkWin();			
		}
		else {
			System.out.println("\nAlready Occupied !\n Try Again !");
			xTurn();
		}
	}
	void oTurn()
	{
		System.out.println("\nY's turn, enter coordinates");
		coordinateX=sc.nextInt();
		coordinateY=sc.nextInt();
		if(coordinateX>grid ||coordinateX<0 ||  coordinateY>grid || coordinateX<0)
		{
			System.out.println("\n Invalid coordinates !\n Try Again !");
			oTurn();
		}
		else if(arr[coordinateX][coordinateY]=='.')
		{
			arr[coordinateX][coordinateY]='O';
			cellsOccupied++;
			display();
			checkWin();			
		}
		else {
			System.out.println("\nAlready Occupied !\n Try Again !");
			oTurn();
		}
	}
	void checkWin()
	{
		int x=0;
		int y=0;
		for(int i=0;i<grid;i++)
		{
			x=0;
			y=0;
			for(int j=0;j<grid;j++)
			{
				if(arr[i][j]=='X')
				{
					x++;
				}
				else if(arr[i][j]=='O')
				{
					y++;
				}
			}
			if(x==grid)
			{
				System.out.println("X Wins!");
				notWin=false;
				return;
			}
			else if(y==grid)
			{
				System.out.println("Y Wins!");
				notWin=false;
				return;
			}
		}
		for(int j=0;j<grid;j++)
		{
			x=0;
			y=0;
			for(int i=0;i<grid;i++)
			{
				if(arr[i][j]=='X')
				{
					x++;
				}
				else if(arr[i][j]=='O')
				{
					y++;
				}
			}
			if(x==grid)
			{
				System.out.println("X Wins!");
				notWin=false;
				return;
			}
			else if(y==grid)
			{
				System.out.println("Y Wins!");
				notWin=false;
				return;
			}
		}
		x=0;
		y=0;
		for(int i=0;i<grid;i++)
		{
			if(arr[i][i]=='X')
			{
				x++;
			}
			else if(arr[i][i]=='O')
			{
				y++;
			}
			if(x==grid)
			{
				System.out.println("X Wins!");
				notWin=false;
				return;
			}
			else if(y==grid)
			{
				System.out.println("Y Wins!");
				notWin=false;
				return;
			}
		}
		x=0;
		y=0;
		for(int i=0;i<grid;i++)
		{
			if(arr[i][grid-1-i]=='X')
			{
				x++;
			}
			else if(arr[i][grid-1-i]=='O')
			{
				y++;
			}
			if(x==grid)
			{
				System.out.println("X Wins!");
				notWin=false;
				return;
			}
			else if(y==grid)
			{
				System.out.println("Y Wins!");
				notWin=false;
				return;
			}
		}
	}
}

public class Sample {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("\nX O game\n\nEnter the grid : ");
		XOgame a=new XOgame(sc.nextInt());
		int i=0;
		while(a.notWin && a.cellsOccupied< a.grid*a.grid)
		{
			if(i++%2==0)
			a.xTurn();
			else
			a.oTurn();
		}
		if(a.cellsOccupied== a.grid)
			System.out.println("Drawn !");
	}
}
