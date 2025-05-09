public class Board {

    public int col1;
    public int col2;
    public int col3;
    public int col4;
    public int col5;
    public int col6;
    public int col7;
    public int col8;
    public int col9;
    public int col10;
    public int bestx;
    public int besty;

    public Board (int pcol1, int pcol2, int pcol3, int pcol4, int pcol5, int pcol6,int pcol7, int pcol8, int pcol9, int pcol10, int pbestx, int pbesty){
        col1=pcol1;
        col2=pcol2;
        col3=pcol3;
        col4=pcol4;
        col5=pcol5;
        col6=pcol6;
        col7=pcol7;
        col8=pcol8;
        col9=pcol9;
        col10=pcol10;
        bestx=pbestx;
        besty=pbesty;
    }

    public void printInfo(){
        System.out.println(col1+""+col2+col3+col4+col5+col6+col7+col8+col9+col10+" ("+bestx+", "+besty+")");

    }

}
