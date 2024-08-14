package invmang;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to jdbc connectivity with mysql");
        System.out.println("this is a shopping mall inventory");
        System.out.println("containg list of products");
        while(true){
            System.out.println("1.insert data");
            System.out.println("2.display data");
            System.out.println("3.upadte data");
            System.out.println("4.delete data");
            System.out.println("enter your choice(0 to exit)");
            int choice=sc.nextInt();
            if(choice==0){
                System.out.println("you chose to exit");
                break;
            }
            switch(choice){
                case 1 -> InsertData.main(null);
                case 2 -> DisplayData.main(null);
                case 3 -> UpdateDetails.main(null);
                case 4 -> DeleteDetails.main(null);
                default -> System.out.println("invalid coide");

            }

        }


    }

}