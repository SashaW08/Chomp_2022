import java.awt.*;
import java.util.ArrayList;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    ArrayList<Board> threethreeboards;
    ArrayList<Board> threelooses;
    ArrayList<Board> threewins;
    public int x;
    public int y;

    public MyPlayer() {
        columns = new int[10];
        threethreeboards=new ArrayList<>();
        threelooses=new ArrayList<>();
        threewins=new ArrayList<>();

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
        threebythreemyplayermove();

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        Point myMove = new Point(x, y);
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

    public void threebythreemyplayermove(){

        //the next step is to have myPlayer look at and take in the info of the board (after I move) before it makes its move
        //I know this is the issue because the program is listening to the newPoint(x,y) correctly, which means x and y are what they're supposed to be


        for(int z=1; z<=3; z++) {
            for (int t=0; t<=z; t++) {
                for (int p=0; p<=t; p++) {
                    threethreeboards.add(new Board(z,t,p));

                    System.out.println(z+""+t+""+p);//this makes the 19 boards
                    System.out.println("top*********");

                    boolean foundlooseboolean = false; //if this is false then it's a loose board

                    for(int q=1; q<=z; q++) {
                        for (int e=0; e<=t&&e<=q; e++){
                            for (int b=0; b<=e&&b<=p; b++){
                                if(!(q==z && e==t && b==p) && !(q<z && e<t && q!=e) && !(e<t && b<p && e!=b) && !(q<z && b<p && q!=b)){
                                    //System.out.println(q+""+e+""+b);//print out every single board before that one but not the ones where the column to the right goes to  level lower than the column to the left and the column to the left went down more than zero

                                    for (int h=0; h<threelooses.size(); h++) {
                                        if (q==threelooses.get(h).col1 && e==threelooses.get(h).col2 && b==threelooses.get(h).col3) {
                                            threewins.add(new Board(z, t, p));
                                            if(foundlooseboolean==false) { //this is so it only prints the first resulting loose board found
                                                System.out.println(q + "" + e + "" + b);
                                                int differencecol1=z-q;
                                                int differencecol2=t-e;
                                                int differencecol3=p-b;
                                                System.out.println("Column differences: "+differencecol1+differencecol2+differencecol3);
                                                if(differencecol1!=0){
                                                    x=0;
                                                    y=z-differencecol1;
                                                    System.out.println("Correct move: ("+x+", "+y+")");
                                                }else if(differencecol2!=0){
                                                    x=1;
                                                    y=t-differencecol2;
                                                    System.out.println("Correct move: ("+x+", "+y+")");
                                                }else if(differencecol3!=0){
                                                    x=2;
                                                    y=p-differencecol3;
                                                    System.out.println("Correct move: ("+x+", "+y+")");
                                                }
                                            }
                                            foundlooseboolean = true;
                                        }
                                    }

                                }
                            }
                        }
                    }

                    if (foundlooseboolean==false){
                        threelooses.add(new Board(z, t, p));
                    }

                    System.out.println("end*********");
                    System.out.println();
                }
            }
        }

        //how to get rid of the repeats that show up here?? But it's correct, just repeating for some reason

        if(threewins.size()>0&&threelooses.size()>0) {

            System.out.println("winners:");
            for (int l = 0; l < threewins.size(); l++) {
                threewins.get(l).printInfo();
            }
            System.out.println("losers:");
            for (int o = 0; o < threelooses.size(); o++) {
                threelooses.get(o).printInfo();
            }
            System.out.println("all boards:");
            for(int o=0; o<threethreeboards.size(); o++){
                threethreeboards.get(o).printInfo();
            }
        }

    }
}