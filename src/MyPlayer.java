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

        for(int z=1; z<=3; z++) {
            for (int t=0; t<=z; t++) {
                for (int p=0; p<=t; p++) {
                    System.out.println(z+""+t+""+p);//this makes the 19 boards
                    threethreeboards.add(z+""+t+""+p);
                    System.out.println("top*********");

                    for(int q=1; q<=z; q++) {
                        for (int e=0; e<=t&&e<=q; e++) {
                            for (int b=0; b<=e&&b<=p; b++) {
                                if(q==z && e==t && b==p) {}else {
                                    if (q<z && e<t && q!=e) {}else {
                                        if (e<t && b<p && e!=b) {}else {
                                            if (q<z && b<p && q!=b) {} else {
                                                System.out.println(q+""+e+""+b);//print out every single board before that one but not the ones where the column to the right goes to  level lower than the column to the left and the column to the left went down more than zero
                                                threethreeboards.add(q+""+e+""+b);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    System.out.println("end*********");
                    System.out.println();
                }
            }
        }
    }

}
