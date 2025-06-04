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

        tentenmyplayermove();
    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;

        toColumns();

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

        System.out.println("("+y1+", "+x1+")");

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

                                                System.out.println(z+" "+t+" "+p+" "+r1+" "+r2+" "+r3+" "+r4+" "+r5+" "+r6+" "+r7);

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

                                                    for (int f1 = r7 - 1; f1 >= 0; f1--) {
                                                        if(foundlooseboolean==true){
                                                            break;
                                                        }
                                                        //System.out.println(first + "" + second + third+ fourth+ fifth+ sixth+ seventh+ eigth+ ninth+ f1);
                                                        for (int h = 0; h < tenlooses.size(); h++) {
                                                            if (first == tenlooses.get(h).col1 && second == tenlooses.get(h).col2 && third == tenlooses.get(h).col3 && fourth == tenlooses.get(h).col4 && fifth == tenlooses.get(h).col5 && sixth == tenlooses.get(h).col6 && seventh == tenlooses.get(h).col7 && eigth == tenlooses.get(h).col8 && ninth == tenlooses.get(h).col9 && f1 == tenlooses.get(h).col10) {

                                                                    //System.out.print("First loose board: ");
                                                                    //System.out.println(first + "" + second + third+ fourth+ fifth+ sixth+ seventh+ eigth+ ninth+ f1);
                                                                    //System.out.println("Column differences: " + diffcol1 + diffcol2 + diffcol3+diffcol4+diffcol5+diffcol6+diffcol7+diffcol8+diffcol9+diffcol10);
                                                                    if (z-first != 0) {
                                                                        x = 0;
                                                                        y = first;
                                                                        //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                        m.bestx = x;
                                                                        m.besty = y;
                                                                    } else if (t-second != 0) {
                                                                        x = 1;
                                                                        y = second;
                                                                        //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                        m.bestx = x;
                                                                        m.besty = y;
                                                                    } else if (p-third != 0) {
                                                                        x = 2;
                                                                        y = third;
                                                                        //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                        m.bestx = x;
                                                                        m.besty = y;
                                                                    } else if (r1-fourth != 0) {
                                                                        x = 3;
                                                                        y = fourth;
                                                                        //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                        m.bestx = x;
                                                                        m.besty = y;
                                                                    } else if (r2-fifth != 0) {
                                                                        x = 4;
                                                                        y = fifth;
                                                                        //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                        m.bestx = x;
                                                                        m.besty = y;
                                                                    } else if (r3-sixth != 0) {
                                                                        x = 5;
                                                                        y = sixth;
                                                                        //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                        m.bestx = x;
                                                                        m.besty = y;
                                                                    } else if (r4-seventh != 0) {
                                                                        x = 6;
                                                                        y = seventh;
                                                                        //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                        m.bestx = x;
                                                                        m.besty = y;
                                                                    } else if (r5-eigth != 0) {
                                                                        x = 7;
                                                                        y = eigth;
                                                                        //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                        m.bestx = x;
                                                                        m.besty = y;
                                                                    } else if (r6-ninth != 0) {
                                                                        x = 8;
                                                                        y = ninth;
                                                                        //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                        m.bestx = x;
                                                                        m.besty = y;
                                                                    } else if (r7-tenth != 0) {
                                                                        x = 9;
                                                                        y = tenth;
                                                                        //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                        m.bestx = x;
                                                                        m.besty = y;
                                                                    }
                                                                foundlooseboolean=true;
                                                                    break;

                                                            }
                                                        }
                                                    }

                                                    for (int f2 = r6 - 1; f2 >= 0; f2--) {
                                                        //System.out.println(first + "" + second + third+ fourth+ fifth+ sixth+ seventh+ eigth+ f2+ tenth);
                                                        if(foundlooseboolean==true){
                                                            break;
                                                        }
                                                        if (f2 < tenth) {
                                                            tenth = f2;
                                                        }

                                                        for (int h = 0; h < tenlooses.size(); h++) {
                                                            if (first == tenlooses.get(h).col1 && second == tenlooses.get(h).col2 && third == tenlooses.get(h).col3 && fourth == tenlooses.get(h).col4 && fifth == tenlooses.get(h).col5 && sixth == tenlooses.get(h).col6 && seventh == tenlooses.get(h).col7 && eigth == tenlooses.get(h).col8 && f2 == tenlooses.get(h).col9 && tenth == tenlooses.get(h).col10) {

                                                                //System.out.print("First loose board: ");
                                                                //System.out.println(first + "" + second + third+ fourth+ fifth+ sixth+ seventh+ eigth+ ninth+ f1);
                                                                //System.out.println("Column differences: " + diffcol1 + diffcol2 + diffcol3+diffcol4+diffcol5+diffcol6+diffcol7+diffcol8+diffcol9+diffcol10);
                                                                if (z-first != 0) {
                                                                    x = 0;
                                                                    y = first;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (t-second != 0) {
                                                                    x = 1;
                                                                    y = second;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (p-third != 0) {
                                                                    x = 2;
                                                                    y = third;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r1-fourth != 0) {
                                                                    x = 3;
                                                                    y = fourth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r2-fifth != 0) {
                                                                    x = 4;
                                                                    y = fifth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r3-sixth != 0) {
                                                                    x = 5;
                                                                    y = sixth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r4-seventh != 0) {
                                                                    x = 6;
                                                                    y = seventh;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r5-eigth != 0) {
                                                                    x = 7;
                                                                    y = eigth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r6-ninth != 0) {
                                                                    x = 8;
                                                                    y = ninth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r7-tenth != 0) {
                                                                    x = 9;
                                                                    y = tenth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                }
                                                                foundlooseboolean=true;
                                                                    break;
                                                            }
                                                        }
                                                        tenth = r7;
                                                    }

                                                    for (int f3 = r5 - 1; f3 >= 0; f3--) {
                                                        //System.out.println(first + "" + second + third+ fourth+ fifth+ sixth+ seventh+ f3+ ninth+ tenth);
                                                        if(foundlooseboolean==true){
                                                            break;
                                                        }
                                                        if (f3 < ninth) {
                                                            ninth = f3;
                                                        }
                                                        if (f3 < tenth) {
                                                            tenth = f3;
                                                        }

                                                        for (int h = 0; h < tenlooses.size(); h++) {
                                                            if (first == tenlooses.get(h).col1 && second == tenlooses.get(h).col2 && third == tenlooses.get(h).col3 && fourth == tenlooses.get(h).col4 && fifth == tenlooses.get(h).col5 && sixth == tenlooses.get(h).col6 && seventh == tenlooses.get(h).col7 && f3 == tenlooses.get(h).col8 && ninth == tenlooses.get(h).col9 && tenth == tenlooses.get(h).col10) {
                                                                //System.out.print("First loose board: ");
                                                                //System.out.println(first + "" + second + third+ fourth+ fifth+ sixth+ seventh+ eigth+ ninth+ f1);
                                                                //System.out.println("Column differences: " + diffcol1 + diffcol2 + diffcol3+diffcol4+diffcol5+diffcol6+diffcol7+diffcol8+diffcol9+diffcol10);
                                                                if (z-first != 0) {
                                                                    x = 0;
                                                                    y = first;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (t-second != 0) {
                                                                    x = 1;
                                                                    y = second;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (p-third != 0) {
                                                                    x = 2;
                                                                    y = third;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r1-fourth != 0) {
                                                                    x = 3;
                                                                    y = fourth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r2-fifth != 0) {
                                                                    x = 4;
                                                                    y = fifth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r3-sixth != 0) {
                                                                    x = 5;
                                                                    y = sixth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r4-seventh != 0) {
                                                                    x = 6;
                                                                    y = seventh;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r5-eigth != 0) {
                                                                    x = 7;
                                                                    y = eigth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r6-ninth != 0) {
                                                                    x = 8;
                                                                    y = ninth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r7-tenth != 0) {
                                                                    x = 9;
                                                                    y = tenth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                }
                                                                foundlooseboolean=true;
                                                                    break;
                                                            }
                                                        }
                                                        ninth = r6;
                                                        tenth = r7;
                                                    }

                                                    for (int f4 = r4 - 1; f4 >= 0; f4--) {
                                                        if(foundlooseboolean==true){
                                                            break;
                                                        }
                                                        //System.out.println(first + "" + second + third+ fourth+ fifth+ sixth+ f4+ eigth+ ninth+ tenth);

                                                        if (f4 < eigth) {
                                                            eigth = f4;
                                                        }
                                                        if (f4 < ninth) {
                                                            ninth = f4;
                                                        }
                                                        if (f4 < tenth) {
                                                            tenth = f4;
                                                        }

                                                        for (int h = 0; h < tenlooses.size(); h++) {
                                                            if (first == tenlooses.get(h).col1 && second == tenlooses.get(h).col2 && third == tenlooses.get(h).col3 && fourth == tenlooses.get(h).col4 && fifth == tenlooses.get(h).col5 && sixth == tenlooses.get(h).col6 && f4 == tenlooses.get(h).col7 && eigth == tenlooses.get(h).col8 && ninth == tenlooses.get(h).col9 && tenth == tenlooses.get(h).col10) {
                                                                //System.out.print("First loose board: ");
                                                                //System.out.println(first + "" + second + third+ fourth+ fifth+ sixth+ seventh+ eigth+ ninth+ f1);
                                                                //System.out.println("Column differences: " + diffcol1 + diffcol2 + diffcol3+diffcol4+diffcol5+diffcol6+diffcol7+diffcol8+diffcol9+diffcol10);
                                                                if (z-first != 0) {
                                                                    x = 0;
                                                                    y = first;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (t-second != 0) {
                                                                    x = 1;
                                                                    y = second;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (p-third != 0) {
                                                                    x = 2;
                                                                    y = third;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r1-fourth != 0) {
                                                                    x = 3;
                                                                    y = fourth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r2-fifth != 0) {
                                                                    x = 4;
                                                                    y = fifth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r3-sixth != 0) {
                                                                    x = 5;
                                                                    y = sixth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r4-seventh != 0) {
                                                                    x = 6;
                                                                    y = seventh;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r5-eigth != 0) {
                                                                    x = 7;
                                                                    y = eigth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r6-ninth != 0) {
                                                                    x = 8;
                                                                    y = ninth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r7-tenth != 0) {
                                                                    x = 9;
                                                                    y = tenth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                }
                                                                foundlooseboolean=true;
                                                                    break;
                                                            }
                                                        }
                                                        eigth = r5;
                                                        ninth = r6;
                                                        tenth = r7;
                                                    }


                                                    for (int f5 = r3 - 1; f5 >= 0; f5--) {
                                                        //System.out.println(first + "" + second + third+ fourth+ fifth+ f5+ seventh+ eigth+ ninth+ tenth);
                                                        if(foundlooseboolean==true){
                                                            break;
                                                        }
                                                        if (f5 < seventh) {
                                                            seventh = f5;
                                                        }
                                                        if (f5 < eigth) {
                                                            eigth = f5;
                                                        }
                                                        if (f5 < ninth) {
                                                            ninth = f5;
                                                        }
                                                        if (f5 < tenth) {
                                                            tenth = f5;
                                                        }

                                                        for (int h = 0; h < tenlooses.size(); h++) {
                                                            if (first == tenlooses.get(h).col1 && second == tenlooses.get(h).col2 && third == tenlooses.get(h).col3 && fourth == tenlooses.get(h).col4 && fifth == tenlooses.get(h).col5 && f5 == tenlooses.get(h).col6 && seventh == tenlooses.get(h).col7 && eigth == tenlooses.get(h).col8 && ninth == tenlooses.get(h).col9 && tenth == tenlooses.get(h).col10) {

                                                                //System.out.print("First loose board: ");
                                                                //System.out.println(first + "" + second + third+ fourth+ fifth+ sixth+ seventh+ eigth+ ninth+ f1);
                                                                //System.out.println("Column differences: " + diffcol1 + diffcol2 + diffcol3+diffcol4+diffcol5+diffcol6+diffcol7+diffcol8+diffcol9+diffcol10);
                                                                if (z-first != 0) {
                                                                    x = 0;
                                                                    y = first;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (t-second != 0) {
                                                                    x = 1;
                                                                    y = second;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (p-third != 0) {
                                                                    x = 2;
                                                                    y = third;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r1-fourth != 0) {
                                                                    x = 3;
                                                                    y = fourth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r2-fifth != 0) {
                                                                    x = 4;
                                                                    y = fifth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r3-sixth != 0) {
                                                                    x = 5;
                                                                    y = sixth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r4-seventh != 0) {
                                                                    x = 6;
                                                                    y = seventh;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r5-eigth != 0) {
                                                                    x = 7;
                                                                    y = eigth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r6-ninth != 0) {
                                                                    x = 8;
                                                                    y = ninth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r7-tenth != 0) {
                                                                    x = 9;
                                                                    y = tenth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                }
                                                                foundlooseboolean=true;
                                                                    break;
                                                            }
                                                        }
                                                        seventh = r4;
                                                        eigth = r5;
                                                        ninth = r6;
                                                        tenth = r7;
                                                    }

                                                    for (int f6 = r2 - 1; f6 >= 0; f6--) {
                                                        if(foundlooseboolean==true){
                                                            break;
                                                        }
                                                        //System.out.println(first + "" + second + third+ fourth+ f6+ sixth+ seventh+ eigth+ ninth+ tenth);

                                                        if (f6 < sixth) {
                                                            sixth = f6;
                                                        }
                                                        if (f6 < seventh) {
                                                            seventh = f6;
                                                        }
                                                        if (f6 < eigth) {
                                                            eigth = f6;
                                                        }
                                                        if (f6 < ninth) {
                                                            ninth = f6;
                                                        }
                                                        if (f6 < tenth) {
                                                            tenth = f6;
                                                        }

                                                        for (int h = 0; h < tenlooses.size(); h++) {
                                                            if (first == tenlooses.get(h).col1 && second == tenlooses.get(h).col2 && third == tenlooses.get(h).col3 && fourth == tenlooses.get(h).col4 && f6 == tenlooses.get(h).col5 && sixth == tenlooses.get(h).col6 && seventh == tenlooses.get(h).col7 && eigth == tenlooses.get(h).col8 && ninth == tenlooses.get(h).col9 && tenth == tenlooses.get(h).col10) {

                                                                //System.out.print("First loose board: ");
                                                                //System.out.println(first + "" + second + third+ fourth+ fifth+ sixth+ seventh+ eigth+ ninth+ f1);
                                                                //System.out.println("Column differences: " + diffcol1 + diffcol2 + diffcol3+diffcol4+diffcol5+diffcol6+diffcol7+diffcol8+diffcol9+diffcol10);
                                                                if (z-first != 0) {
                                                                    x = 0;
                                                                    y = first;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (t-second != 0) {
                                                                    x = 1;
                                                                    y = second;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (p-third != 0) {
                                                                    x = 2;
                                                                    y = third;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r1-fourth != 0) {
                                                                    x = 3;
                                                                    y = fourth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r2-fifth != 0) {
                                                                    x = 4;
                                                                    y = fifth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r3-sixth != 0) {
                                                                    x = 5;
                                                                    y = sixth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r4-seventh != 0) {
                                                                    x = 6;
                                                                    y = seventh;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r5-eigth != 0) {
                                                                    x = 7;
                                                                    y = eigth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r6-ninth != 0) {
                                                                    x = 8;
                                                                    y = ninth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r7-tenth != 0) {
                                                                    x = 9;
                                                                    y = tenth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                }
                                                                foundlooseboolean=true;
                                                                    break;

                                                            }
                                                        }
                                                        sixth = r3;
                                                        seventh = r4;
                                                        eigth = r5;
                                                        ninth = r6;
                                                        tenth = r7;
                                                    }

                                                    for (int f7 = r1 - 1; f7 >= 0; f7--) {
                                                        if(foundlooseboolean==true){
                                                            break;
                                                        }
                                                        //System.out.println( first+ "" + second + third+ f7+ fifth+ sixth+ seventh+ eigth+ ninth+ tenth);

                                                        if (f7 < fifth) {
                                                            fifth = f7;
                                                        }
                                                        if (f7 < sixth) {
                                                            sixth = f7;
                                                        }
                                                        if (f7 < seventh) {
                                                            seventh = f7;
                                                        }
                                                        if (f7 < eigth) {
                                                            eigth = f7;
                                                        }
                                                        if (f7 < ninth) {
                                                            ninth = f7;
                                                        }
                                                        if (f7 < tenth) {
                                                            tenth = f7;
                                                        }

                                                        for (int h = 0; h < tenlooses.size(); h++) {
                                                            if (first == tenlooses.get(h).col1 && second == tenlooses.get(h).col2 && third == tenlooses.get(h).col3 && f7 == tenlooses.get(h).col4 && fifth == tenlooses.get(h).col5 && sixth == tenlooses.get(h).col6 && seventh == tenlooses.get(h).col7 && eigth == tenlooses.get(h).col8 && ninth == tenlooses.get(h).col9 && tenth == tenlooses.get(h).col10) {
                                                                //System.out.print("First loose board: ");
                                                                //System.out.println(first + "" + second + third+ fourth+ fifth+ sixth+ seventh+ eigth+ ninth+ f1);
                                                                //System.out.println("Column differences: " + diffcol1 + diffcol2 + diffcol3+diffcol4+diffcol5+diffcol6+diffcol7+diffcol8+diffcol9+diffcol10);
                                                                if (z-first != 0) {
                                                                    x = 0;
                                                                    y = first;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (t-second != 0) {
                                                                    x = 1;
                                                                    y = second;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (p-third != 0) {
                                                                    x = 2;
                                                                    y = third;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r1-fourth != 0) {
                                                                    x = 3;
                                                                    y = fourth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r2-fifth != 0) {
                                                                    x = 4;
                                                                    y = fifth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r3-sixth != 0) {
                                                                    x = 5;
                                                                    y = sixth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r4-seventh != 0) {
                                                                    x = 6;
                                                                    y = seventh;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r5-eigth != 0) {
                                                                    x = 7;
                                                                    y = eigth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r6-ninth != 0) {
                                                                    x = 8;
                                                                    y = ninth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r7-tenth != 0) {
                                                                    x = 9;
                                                                    y = tenth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                }
                                                                foundlooseboolean=true;
                                                                    break;
                                                            }
                                                        }
                                                        fifth = r2;
                                                        sixth = r3;
                                                        seventh = r4;
                                                        eigth = r5;
                                                        ninth = r6;
                                                        tenth = r7;
                                                    }

                                                    for (int b = p - 1; b >= 0; b--) {
                                                        if(foundlooseboolean==true){
                                                            break;
                                                        }
                                                        //System.out.println(first + "" + second + b+ fourth+ fifth+ sixth+ seventh+ eigth+ ninth+ tenth);

                                                        if (b < fourth) {
                                                            fourth = b;
                                                        }
                                                        if (b < fifth) {
                                                            fifth = b;
                                                        }
                                                        if (b < sixth) {
                                                            sixth = b;
                                                        }
                                                        if (b < seventh) {
                                                            seventh = b;
                                                        }
                                                        if (b < eigth) {
                                                            eigth = b;
                                                        }
                                                        if (b < ninth) {
                                                            ninth = b;
                                                        }
                                                        if (b < tenth) {
                                                            tenth = b;
                                                        }

                                                        for (int h = 0; h < tenlooses.size(); h++) {
                                                            if (first == tenlooses.get(h).col1 && second == tenlooses.get(h).col2 && b == tenlooses.get(h).col3 && fourth == tenlooses.get(h).col4 && fifth == tenlooses.get(h).col5 && sixth == tenlooses.get(h).col6 && seventh == tenlooses.get(h).col7 && eigth == tenlooses.get(h).col8 && ninth == tenlooses.get(h).col9 && tenth == tenlooses.get(h).col10) {
                                                                //System.out.print("First loose board: ");
                                                                //System.out.println(first + "" + second + third+ fourth+ fifth+ sixth+ seventh+ eigth+ ninth+ f1);
                                                                //System.out.println("Column differences: " + diffcol1 + diffcol2 + diffcol3+diffcol4+diffcol5+diffcol6+diffcol7+diffcol8+diffcol9+diffcol10);
                                                                if (z-first != 0) {
                                                                    x = 0;
                                                                    y = first;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (t-second != 0) {
                                                                    x = 1;
                                                                    y = second;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (p-third != 0) {
                                                                    x = 2;
                                                                    y = third;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r1-fourth != 0) {
                                                                    x = 3;
                                                                    y = fourth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r2-fifth != 0) {
                                                                    x = 4;
                                                                    y = fifth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r3-sixth != 0) {
                                                                    x = 5;
                                                                    y = sixth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r4-seventh != 0) {
                                                                    x = 6;
                                                                    y = seventh;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r5-eigth != 0) {
                                                                    x = 7;
                                                                    y = eigth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r6-ninth != 0) {
                                                                    x = 8;
                                                                    y = ninth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r7-tenth != 0) {
                                                                    x = 9;
                                                                    y = tenth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                }
                                                                foundlooseboolean=true;
                                                                    break;
                                                            }
                                                        }
                                                        fourth = r1;
                                                        fifth = r2;
                                                        sixth = r3;
                                                        seventh = r4;
                                                        eigth = r5;
                                                        ninth = r6;
                                                        tenth = r7;
                                                    }

                                                    for (int e = t - 1; e >= 0; e--) {
                                                        if(foundlooseboolean==true){
                                                            break;
                                                        }

                                                        if (e < third) {
                                                            third = e;
                                                        }
                                                        if (e < fourth) {
                                                            fourth = e;
                                                        }
                                                        if (e < fifth) {
                                                            fifth = e;
                                                        }
                                                        if (e < sixth) {
                                                            sixth = e;
                                                        }
                                                        if (e < seventh) {
                                                            seventh = e;
                                                        }
                                                        if (e < eigth) {
                                                            eigth = e;
                                                        }
                                                        if (e < ninth) {
                                                            ninth = e;
                                                        }
                                                        if (e < tenth) {
                                                            tenth = e;
                                                        }

                                                        //System.out.println(first + "" + e + third+ fourth+ fifth+ sixth+ seventh+ eigth+ ninth+ tenth);
                                                        for (int h = 0; h < tenlooses.size(); h++) {
                                                            if (first == tenlooses.get(h).col1 && e == tenlooses.get(h).col2 && third == tenlooses.get(h).col3 && fourth == tenlooses.get(h).col4 && fifth == tenlooses.get(h).col5 && sixth == tenlooses.get(h).col6 && seventh == tenlooses.get(h).col7 && eigth == tenlooses.get(h).col8 && ninth == tenlooses.get(h).col9 && tenth == tenlooses.get(h).col10) {

                                                                //System.out.print("First loose board: ");
                                                                //System.out.println(first + "" + second + third+ fourth+ fifth+ sixth+ seventh+ eigth+ ninth+ f1);
                                                                //System.out.println("Column differences: " + diffcol1 + diffcol2 + diffcol3+diffcol4+diffcol5+diffcol6+diffcol7+diffcol8+diffcol9+diffcol10);
                                                                if (z-first != 0) {
                                                                    x = 0;
                                                                    y = first;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (t-second != 0) {
                                                                    x = 1;
                                                                    y = second;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (p-third != 0) {
                                                                    x = 2;
                                                                    y = third;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r1-fourth != 0) {
                                                                    x = 3;
                                                                    y = fourth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r2-fifth != 0) {
                                                                    x = 4;
                                                                    y = fifth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r3-sixth != 0) {
                                                                    x = 5;
                                                                    y = sixth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r4-seventh != 0) {
                                                                    x = 6;
                                                                    y = seventh;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r5-eigth != 0) {
                                                                    x = 7;
                                                                    y = eigth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r6-ninth != 0) {
                                                                    x = 8;
                                                                    y = ninth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r7-tenth != 0) {
                                                                    x = 9;
                                                                    y = tenth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                }
                                                                foundlooseboolean=true;
                                                                    break;
                                                            }
                                                        }
                                                        third = p;
                                                        fourth = r1;
                                                        fifth = r2;
                                                        sixth = r3;
                                                        seventh = r4;
                                                        eigth = r5;
                                                        ninth = r6;
                                                        tenth = r7;
                                                    }

                                                    for (int q = z - 1; q >= 1; q--) {
                                                        if(foundlooseboolean==true){
                                                            break;
                                                        }

                                                        if (q < second) {
                                                            second = q;
                                                        }
                                                        if (q < third) {
                                                            third = q;
                                                        }
                                                        if (q < fourth) {
                                                            fourth = q;
                                                        }
                                                        if (q < fifth) {
                                                            fifth = q;
                                                        }
                                                        if (q < sixth) {
                                                            sixth = q;
                                                        }
                                                        if (q < seventh) {
                                                            seventh = q;
                                                        }
                                                        if (q < eigth) {
                                                            eigth = q;
                                                        }
                                                        if (q < ninth) {
                                                            ninth = q;
                                                        }
                                                        if (q < tenth) {
                                                            tenth = q;
                                                        }

                                                        //System.out.println(q + "" + second + third+ fourth+ fifth+ sixth+ seventh+ eigth+ ninth+ tenth);
                                                        for (int h = 0; h < tenlooses.size(); h++) {
                                                            if (q == tenlooses.get(h).col1 && second == tenlooses.get(h).col2 && third == tenlooses.get(h).col3 && fourth == tenlooses.get(h).col4 && fifth == tenlooses.get(h).col5 && sixth == tenlooses.get(h).col6 && seventh == tenlooses.get(h).col7 && eigth == tenlooses.get(h).col8 && ninth == tenlooses.get(h).col9 && tenth == tenlooses.get(h).col10) {
                                                                //System.out.print("First loose board: ");
                                                                //System.out.println(first + "" + second + third+ fourth+ fifth+ sixth+ seventh+ eigth+ ninth+ f1);
                                                                //System.out.println("Column differences: " + diffcol1 + diffcol2 + diffcol3+diffcol4+diffcol5+diffcol6+diffcol7+diffcol8+diffcol9+diffcol10);
                                                                if (z-first != 0) {
                                                                    x = 0;
                                                                    y = first;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (t-second != 0) {
                                                                    x = 1;
                                                                    y = second;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (p-third != 0) {
                                                                    x = 2;
                                                                    y = third;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r1-fourth != 0) {
                                                                    x = 3;
                                                                    y = fourth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r2-fifth != 0) {
                                                                    x = 4;
                                                                    y = fifth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r3-sixth != 0) {
                                                                    x = 5;
                                                                    y = sixth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r4-seventh != 0) {
                                                                    x = 6;
                                                                    y = seventh;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r5-eigth != 0) {
                                                                    x = 7;
                                                                    y = eigth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r6-ninth != 0) {
                                                                    x = 8;
                                                                    y = ninth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                } else if (r7-tenth != 0) {
                                                                    x = 9;
                                                                    y = tenth;
                                                                    //System.out.println("Correct move: (" + x + ", " + y + ")");
                                                                    m.bestx = x;
                                                                    m.besty = y;
                                                                }
                                                                foundlooseboolean=true;
                                                                    break;
                                                            }
                                                        }
                                                    }

                                                tentenboards.add(m);

                                                if (foundlooseboolean == false) {
                                                    tenlooses.add(m);
                                                } else {
                                                    tenwins.add(m);
                                                }

                                                //System.out.println();
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