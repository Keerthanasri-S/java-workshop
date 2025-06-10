package controlflow;

public class statement {
    public void Operator(int number){
        if(number%2==0){
            System.out.println("Even number");
        }else {
            System.out.println("Odd number");
        }
    }

    public static void main(String[] args) {
     statement statement=new statement();
     statement.Operator(5);
    }
}
