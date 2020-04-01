import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.*;

public class readTxt {
    private int height;
    private int width;
    private int xStart;
    private int yStart;

    readTxt(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        this.height = Integer.parseInt(scan.next());
        this.width = Integer.parseInt(scan.next());
        this.xStart =  Integer.parseInt(scan.next());
        this.yStart =  Integer.parseInt(scan.next());

    }


    public int getXStart(){return xStart;}
    public int getYStart(){return yStart;}
    public int getHeight(){return height;}
    public int getWidth(){return width;}

    public String[][] createMazeArray(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        String maze [][] = new String [height][width];
        scan.next();
        scan.next();
        scan.next();
        scan.next();

        for ( int i=0; i<9; i++){
            for ( int y=0; y<7; y++){
                maze[i][y] = scan.next();
            }
        }
        return maze;
    }

    public void printMaze(String[][] maze){
        for ( int i=0; i<9; i++){
            for ( int y=0; y<7; y++){
                System.out.println(maze[i][y]);
            }
            System.out.println();
        }
    }

    public int totalCharacters(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        int count=0;
        while (scan.hasNext()){
            count++;
            scan.next();
        }
        return count;
    }

    public boolean rightTxt(String filename) throws FileNotFoundException {
        File file = new File(filename);
        return (totalCharacters(file) == ((getWidth()*getHeight())+4));
    }
}
