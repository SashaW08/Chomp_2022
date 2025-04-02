import java.awt.*;
import java.util.ArrayList;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    ArrayList<String> threethreeboards;

    public MyPlayer() {
        columns = new int[10];

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int column = 0;
        int row = 0;

        row = 1;
        column = 1;

        toColumns();
        threebythreeallboards();

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        Point myMove = new Point(row, column);
        return myMove;
    }

    public void toColumns(){

        for(int x=0; x<10; x++){
            columns[x]=0;
        }

        for(int r=0; r<gameBoard[0].length; r++){
            for (int c=0; c<gameBoard[r].length; c++){
                if(gameBoard[r][c].isAlive){
                    System.out.println("("+r+", "+c+")");
                    columns[c]++;
                }
            }
        }

        for(int x=0; x<10; x++){
            System.out.print(columns[x]+", ");
        }
        System.out.println();

    }

    public void threebythreeallboards(){

        /**the column to the right has a number of chips that is always any number less than or equal to the column directly to the left**/
        /**how to make it not repeat boards?**/
        /**put all of the boards into an array list, and then say if one matches to any of the others, nothing, if no match, then sout what it is**/

        while(true){

            columns[0]=(int)(Math.random()*4);
            columns[1]=(int)(Math.random()*4);
            columns[2]=(int)(Math.random()*4);

            if(columns[2]<=columns[1]&&columns[1]<=columns[0]){
                threethreeboards.add(String.valueOf(columns[0])+String.valueOf(columns[1])+String.valueOf(columns[2]));

                for(int z=0; z<=18; z++) {
                    for(int y=0; y<=18; y++)
                    if (threethreeboards.get(z)==threethreeboards.get(y)){
                        System.out.println("oops");
                        threethreeboards.remove(z);
                    }else{
                        System.out.println("("+columns[0]+columns[1]+columns[2]+")");
                    }
                }
            }

        }

    }

}
