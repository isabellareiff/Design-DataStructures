import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Life extends JPanel {

	public static int[][] soup;
	public static int cellSize = 11;
	public static int rows;
	public static int columns;
	public static boolean willLive;
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {

		JFrame f = new JFrame();
		Scanner kboard = new Scanner(System.in);
		System.out.println("Please input the filename:");
		String fileName = kboard.nextLine();
		kboard.close();
		if (!fileName.endsWith(".soup"))
		{
			return;
		}
		readSoup(fileName);
		f.setSize(1000, 1000);
		Life l = new Life();
		f.add(l);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

		while(true)
		{
			l.progresses();
			
			Thread.sleep(600);
			l.repaint();
		}
	}


	public void paint(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillRect(0, 0, columns * cellSize, rows * cellSize);
		g.setColor(Color.green);
		for (int r = 0; r < rows; r++)
			for (int c = 0; c < columns; c++)
			{
				if (soup[r][c] != 0)
					g.fillRect(cellSize*c, cellSize*r, cellSize, cellSize);
			}
	}

	// Opens file fileName and puts the soup described inside it into the soup array.
	// Also sets rows and columns to proper values.
	// The soup file must be in the following format:
	// - the first line of the file is two numbers, the number of rows 
	// and number of columns, separated by a space
	// - followed by the promised number of rows, each of which has 0s and 1s, with no spaces separating
	public static void readSoup(String fileName) throws FileNotFoundException
	{
		//YOUR CODE HERE
		Scanner scan;
		scan = new Scanner (new File(fileName));
		rows = scan.nextInt() + 2;
		columns = scan.nextInt() + 2;
		soup = new int [rows] [columns];
		for (int p = 0; p < columns-1; p ++){
			soup[0][p]=0;

		}
		for (int i = 1; i < rows-1; i++){
			soup [i][0]=0;
			for (int j = 1; j < columns-1; j++){
				soup [i][j] = scan.nextInt();
			}
			soup [i][rows-1] = 0;
		}
		for (int q=0; q<columns-1;q++){
			soup[0][q]=0;
		}
		scan.close();
	}


	// Updates the soup according to the rules of Life
	public void progresses()
	{
		// YOUR CODE HERE
		int count;
		int [][] temp = new int [rows][columns];
		for (int i = 0; i<rows; i++){
			temp [i][0] = 0;
			temp [i][columns-1] = 0;
		}
		for (int j = 0; j < columns; j++){
			temp [0][j]=0;
			temp [rows-1][j]=0;
		}
		for (int i = 1; i < rows-1; i ++){
			for (int j = 1; j < columns-1; j ++){
				count = soup [i-1] [j-1] + soup [i-1] [j] + soup [i-1] [j+1] + soup [i] [j-1] + soup [i] [j+1] + soup [i+1] [j-1] + soup [i+1] [j] + soup [i+1] [j+1] ;
				if (soup[i][j]==1){
					if (count == 2 || count == 3){
						temp [i][j] = 1;
					}
				}
				else {
					if (count==3){
						temp[i][j] = 1;
					}
				}

			}

		}
		soup = temp;
	}
}

