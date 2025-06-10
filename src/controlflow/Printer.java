package controlflow;

public class Printer {
    public void floor(int n){
        for(int i=0; i<n;i++){
            System.out.println("floor" +i);
        }
    }

    public static void main(String[] args) {
        Printer print=new Printer();
        print.floor(11);
    }
}
