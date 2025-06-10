package controlflow;

public class Buildingswitch {
    public void Build(char ch){
        switch(ch){
            case 'a':
            case 'f':
            case 'h':
                System.out.println("11floors");
                break;
            case 'b':
            case 'g':
            case 'j':
                System.out.println("15floors");
                break;
            case 'c':
            case 'i':
            case 'k':
                System.out.println("21floors");
                break;
            case 'd':
            case 'l':
            case 'm':
                System.out.println("25floors");
                break;
            case 'e':
            case 'n':
            case 'o':
                System.out.println("30floors");
                break;
            default:
                System.out.println("5floors");

        }
    }

    public static void main(String[] args) {
        Buildingswitch buildingswitch=new Buildingswitch();
        buildingswitch.Build('d');
        buildingswitch.Build('e');
        buildingswitch.Build('n');
        buildingswitch.Build('q');
    }
}
