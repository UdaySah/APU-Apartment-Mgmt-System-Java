import java.util.Scanner;
import java.util.ArrayList;

class Main{

  public static void main(String args[]){
    
    
     Apartment a = new Apartment();
     boolean res = true;
     while(res){
     System.out.println("*****************Menu****************");
     System.out.println("1.Press 1 for apartment A");
     System.out.println("2.Press 2 for apartment B");
     System.out.println("3.Press 3 to Exit");
     System.out.println("*************************************");
     Scanner sc = new Scanner(System.in);
     String opt1 = sc.next();   
    
    
     
     switch(opt1)
     {
     
       case "1":
        a.apartmentAB(1);
        break;
       case "2" :
         a.apartmentAB(2);
         break;
         
       case "3":
        res = false;
        
       
        break;
        default: 
        System.out.println("Invalid Inputsss! Please enter valid Entry!");
        break;

     
     }
     
     
     }
  }

}