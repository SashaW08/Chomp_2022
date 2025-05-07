public class Board {

    public int col1;
    public int col2;
    public int col3;
    public int bestx;
    public int besty;

    public Board (int pcol1, int pcol2, int pcol3, int pbestx, int pbesty){
        col1=pcol1;
        col2=pcol2;
        col3=pcol3;
        bestx=pbestx;
        besty=pbesty;
    }

    public void printInfo(){
        System.out.println(col1+""+col2+col3+" ("+bestx+", "+besty+")");
    }

}
