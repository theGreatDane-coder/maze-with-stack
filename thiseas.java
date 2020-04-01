import java.io.FileNotFoundException;

public class thiseas {
   public static void main (String [] args) throws FileNotFoundException {
        readTxt tx = new readTxt("maze.txt");
        PositionStackImpl ps = new PositionStackImpl();
        if(!tx.rightTxt("maze.txt")){
             System.out.println("wrong txt");
             System.exit(0);
         }

        int xStart = tx.getXStart();
        int yStart = tx.getYStart();
        String maze[][] = tx.createMazeArray("maze.txt");

        if(!(maze[xStart][yStart].equals("E"))){
            System.out.println("error wrong start");
            System.exit(0);
        }

        ps.push(xStart,yStart);
        int xPoint = xStart;
        int yPoint = yStart;
        int xPointLast = xStart;
        int ypointLast = yStart;
        xPoint = xStart + 1;

        if (maze[xPoint][yPoint].equals("0")){
            ps.push(xPoint,yPoint);
        }else{
            System.out.println("error wrong maze");
            System.exit(0);
        }

        while ( ps.peek().x != (tx.getHeight()-1) && ps.peek().y != (tx.getWidth()-1) && ps.peek().y != 0 && ps.peek().x != 0){
            if ( maze[xPoint][yPoint-1].equals("0") && !(xPoint==xPointLast & (yPoint-1)==ypointLast)  ){
                xPointLast = xPoint;
                ypointLast = yPoint;
                yPoint = yPoint -1;
                ps.push(xPoint,yPoint);
            }else if (maze[xPoint+1][yPoint].equals("0") && !((xPoint+1)==xPointLast & yPoint==ypointLast) ){
                ypointLast = yPoint;
                xPointLast = xPoint;
                xPoint = xPoint +1;
                ps.push(xPoint,yPoint);
            }else if (maze[xPoint][yPoint+1].equals("0") && !(xPoint==xPointLast & (yPoint+1)==ypointLast) ){
                xPointLast = xPoint;
                ypointLast = yPoint;
                yPoint = yPoint +1;
                ps.push(xPoint,yPoint);
            }else if (maze[xPoint-1 ][yPoint].equals("0") && !((xPoint-1)==xPointLast & (yPoint)==ypointLast) ){
                ypointLast = yPoint;
                xPointLast = xPoint;
                xPoint = xPoint -1;
                ps.push(xPoint,yPoint);
            }else{
                maze[xPoint][yPoint] = "1";
                ps.pop();
                yPoint = ypointLast;
                xPoint = xPointLast;
                if( ps.size() != 1) {
                    ps.pop();
                    ypointLast = ps.peek().y;
                    xPointLast = ps.peek().x;
                    ps.push(xPoint, yPoint);
                }else {
                    ypointLast = yStart;
                    xPointLast = xStart + 1;
                }
            }
        }

        if(ps.peek().x == xStart && ps.peek().y== yStart){
            System.out.println("the maze does not have exit");
        }else{
           System.out.println("x: " + ps.peek().x + " y: " + ps.peek().y);
       }
   }
}
