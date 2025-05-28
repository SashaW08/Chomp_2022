import java.awt.*;
import java.util.ArrayList;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    public ArrayList<Board> tentenboards;
    public ArrayList<Board> tenlooses;
    public ArrayList<Board> tenwins;
    public int x;
    public int y;
    public Board m;
    public int x1;
    public int y1;

    public MyPlayer() {
        columns = new int[10];
        tentenboards=new ArrayList<>();
        tenlooses=new ArrayList<>();
        tenwins=new ArrayList<>();

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;

        toColumns();
        tentenmyplayermove();

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        for(int g=0; g<tentenboards.size(); g++) {
            if (tentenboards.get(g).col1==columns[0] && tentenboards.get(g).col2 == columns[1] && tentenboards.get(g).col3 == columns[2]) {
                x1=tentenboards.get(g).bestx;
                y1=tentenboards.get(g).besty;
            }
        }

        Point myMove = new Point(y1,x1);
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

    public void tentenmyplayermove(){

        for(int z=1; z<=10; z++) {
            for (int t=0; t<=z; t++) {
                for (int p = 0; p <= t; p++) {
                    for(int r1 = 0; r1<=p; r1++ ) {
                        for (int r2 = 0; r2<=r1; r2++) {
                            for (int r3 = 0; r3<=r2; r3++) {
                                for (int r4 = 0; r4<=r3; r4++) {
                                    for (int r5 = 0; r5<=r4; r5++) {
                                        for (int r6 = 0; r6<=r5; r6++) {
                                            for (int r7 = 0; r7<=r6; r7++) {

                                                m = new Board(z,t,p,r1,r2,r3,r4,r5,r6,r7, 0, z - 1);

                                                System.out.println(z+", "+t+", "+p+", "+r1+", "+r2+", "+r3+", "+r4+", "+r5+", "+r6+", "+r7+" THIS BOARD");

                                                boolean foundlooseboolean = false;

                                                int first = z;
                                                int second = t;
                                                int third = p;
                                                int fourth = r1;
                                                int fifth = r2;
                                                int sixth = r3;
                                                int seventh = r4;
                                                int eigth = r5;
                                                int ninth = r6;
                                                int tenth = r7;

                                                for (int b = p - 1; b >= 0; b--) {
                                                    //System.out.println(first+""+second+b);
                                                    for (int h = 0; h < tenlooses.size(); h++) {
                                                        if (first == tenlooses.get(h).col1 && second == tenlooses.get(h).col2 && b == tenlooses.get(h).col3) {
                                                            if (foundlooseboolean == false) { //this is so it only prints the first resulting loose board found
                                                                System.out.print("First loose board: ");
                                                                System.out.println(first + "" + second + b);
                                                                int diffcol1 = z - first;
                                                                int diffcol2 = t - second;
                                                                int diffcol3 = p - b;
                                                                System.out.println("Column differences: " + diffcol1 + diffcol2 + diffcol3);
                                                                if (diffcol1 != 0) {
                                                                    x = 0;
                                                                    y = z - diffcol1;
                                                                    System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (diffcol2 != 0) {
                                                                    x = 1;
                                                                    y = t - diffcol2;
                                                                    System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (diffcol3 != 0) {
                                                                    x = 2;
                                                                    y = p - diffcol3;
                                                                    System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                }
                                                            }
                                                            foundlooseboolean = true;
                                                        }
                                                    }
                                                }

                                                for (int e = t - 1; e >= 0; e--) {

                                                    if (e < third) {
                                                        third = e;
                                                    }
                                                    //System.out.println(first + "" + e + third);
                                                    for (int h = 0; h < tenlooses.size(); h++) {
                                                        if (first == tenlooses.get(h).col1 && e == tenlooses.get(h).col2 && third == tenlooses.get(h).col3) {
                                                            if (foundlooseboolean == false) { //this is so it only prints the first resulting loose board found
                                                                System.out.print("First loose board: ");
                                                                System.out.println(first + "" + e + "" + third);
                                                                int diffcol1 = z - first;
                                                                int diffcol2 = t - e;
                                                                int diffcol3 = p - third;
                                                                System.out.println("Column differences: " + diffcol1 + diffcol2 + diffcol3);
                                                                if (diffcol1 != 0) {
                                                                    x = 0;
                                                                    y = z - diffcol1;
                                                                    System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (diffcol2 != 0) {
                                                                    x = 1;
                                                                    y = t - diffcol2;
                                                                    System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (diffcol3 != 0) {
                                                                    x = 2;
                                                                    y = p - diffcol3;
                                                                    System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                }
                                                            }
                                                            foundlooseboolean = true;
                                                        }
                                                    }
                                                    third = p;
                                                }

                                                for (int q = z - 1; q >= 1; q--) {

                                                    if (q < second) {
                                                        second = q;
                                                    }

                                                    if (q < third) {
                                                        third = q;
                                                    }
                                                    //System.out.println(q + "" + second + third);
                                                    for (int h = 0; h < tenlooses.size(); h++) {
                                                        if (q == tenlooses.get(h).col1 && second == tenlooses.get(h).col2 && third == tenlooses.get(h).col3) {
                                                            if (foundlooseboolean == false) {
                                                                System.out.print("First loose board: ");
                                                                System.out.println(q + "" + second + third);
                                                                int diffcol1 = z - q;
                                                                int diffcol2 = t - second;
                                                                int diffcol3 = p - third;
                                                                System.out.println("Column differences: " + diffcol1 + diffcol2 + diffcol3);
                                                                if (diffcol1 != 0) {
                                                                    x = 0;
                                                                    y = z - diffcol1;
                                                                    System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (diffcol2 != 0) {
                                                                    x = 1;
                                                                    y = t - diffcol2;
                                                                    System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (diffcol3 != 0) {
                                                                    x = 2;
                                                                    y = p - diffcol3;
                                                                    System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                }
                                                            }
                                                            foundlooseboolean = true;
                                                        }
                                                    }
                                                }

                                                tentenboards.add(m);

                                                if (foundlooseboolean == false) {
                                                    tenlooses.add(m);
                                                } else {
                                                    tenwins.add(m);
                                                }

                                                System.out.println();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

//        if(tenwins.size()>0&&tenlooses.size()>0) {
//
//            System.out.println("winners:");
//            for (int o = 0; o < tenwins.size(); o++) {
//                tenwins.get(o).printInfo();
//            }
//            System.out.println("losers:");
//            for (int o = 0; o < tenlooses.size(); o++) {
//                tenlooses.get(o).printInfo();
//            }
//            System.out.println("all boards:");
//            for(int o=0; o<tentenboards.size(); o++){
//                tentenboards.get(o).printInfo();
//            }
//        }
    }
}