public class Board {

    public int col1;
    public int col2;
    public int col3;

    public Board (int pcol1, int pcol2, int pcol3){
        col1=pcol1;
        col2=pcol2;
        col3=pcol3;
    }

    public void printInfo(){
        System.out.println(col1+""+col2+col3);
    }

}
