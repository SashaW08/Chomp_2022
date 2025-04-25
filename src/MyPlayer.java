import java.awt.*;
import java.util.ArrayList;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    ArrayList<Board> threethreeboards;
    ArrayList<Board> threelooses;
    ArrayList<Board> threewins;
    ArrayList<Board> resultingarray;
    public boolean winloose;

    public MyPlayer() {
        columns = new int[10];
        threethreeboards=new ArrayList<>();
        threelooses=new ArrayList<>();
        threewins=new ArrayList<>();
        resultingarray=new ArrayList<>();

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

        threelooses.add(new Board(1,0,0));

        for(int z=1; z<=3; z++) {
            for (int t=0; t<=z; t++) {
                for (int p=0; p<=t; p++) {
                    threethreeboards.add(new Board(z,t,p));

                    System.out.println(z+""+t+""+p);//this makes the 19 boards
                    System.out.println("top*********");

                    resultingarray.clear();
                    winloose=true;

                    boolean foundlooseboolean = false; //if this is false then its a loose board

                    for(int q=1; q<=z; q++) {
                        for (int e=0; e<=t&&e<=q; e++){
                            for (int b=0; b<=e&&b<=p; b++){
                                if(!(q==z && e==t && b==p) && !(q<z && e<t && q!=e) && !(e<t && b<p && e!=b) && !(q<z && b<p && q!=b)){
                                    System.out.println(q+""+e+""+b);//print out every single board before that one but not the ones where the column to the right goes to  level lower than the column to the left and the column to the left went down more than zero

                                   resultingarray.add(new Board(q,e,b));

                                    for(int h=0; h<threelooses.size(); h++) {
                                        if (q == threelooses.get(h).col1 && e == threelooses.get(h).col2 && b == threelooses.get(h).col3) {
                                            threewins.add(new Board(z, t, p));
                                            System.out.println("found loose");
                                            foundlooseboolean = true;
                                        } else {
                                            threelooses.add(new Board(z, t, p));
                                        }
                                    }

                                }
                            }
                        }
                    }

                    if(threewins.size()>0 && resultingarray.size()>0) {

                        for (int x = 0; x < threewins.size(); x++) {
                            for (int v = 0; v < resultingarray.size(); v++) {
                                if (!(resultingarray.get(v).col1 == threewins.get(x).col1 && resultingarray.get(v).col2 == threewins.get(x).col2 && resultingarray.get(v).col3 == threewins.get(x).col3)) {
                                    winloose = false;

                                    //use this if statement to compare every resulting board to every win board. If they are all win boards, then add z,t,p to the loose boards and repeat everything
                                    //figure out how to do only add if every resulting board matches to at least one win board

                                    //boolean: if one of them doesn't match turn it off
                                }
                            }
                        }
                    }

                    if(winloose==false){
                        threewins.add(new Board(z,t,p));
                        System.out.println("This is a win board");
                    }else{
                        threelooses.add(new Board(z,t,p));
                        System.out.println("This is a loose board");
                    }

                    System.out.println("end*********");
                    System.out.println();
                }
            }
        }

        for(int t=0; t<threewins.size(); t++){
            threewins.get(t).printInfo();
        }
        for(int f=0; f<threelooses.size(); f++){
            threelooses.get(f).printInfo();
        }

    }
}