import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
class Apartment{
   ArrayList<Student> apartmentsA = new ArrayList<Student>();
   ArrayList<Student> apartmentsB = new ArrayList<Student>();   
   ArrayList<Student> mainArray = new ArrayList<Student>();   
   ArrayList<Student> anoArray = new ArrayList<Student>();
   public void apartmentAB(int val)
    
{   
     int i;
     int ids;
     int rented;
    
     System.out.println("Here value is "+val);
       
     
     boolean tr = true; 
     while(tr){
      int valid = 1;
      if(val == 1){
     
      mainArray = apartmentsA;
      anoArray = apartmentsB;
      
      }else{
      
      mainArray = apartmentsB;
      anoArray = apartmentsA;
      }
      
       int sizeA = mainArray.size();
       int sizeB = anoArray.size(); 
     System.out.println("");
     System.out.println("");
     System.out.println("");
    System.out.println("****************************************************************************");
    if(val == 1){
      System.out.println("Details: 2 bedrooms with equipped kitchen and laundary facilities.");
      System.out.println("Rent:           RM 300");
    }else{
      System.out.println("Details: 3 bedrooms with 1 master bedroom with attached bathroom but doesnot have kitchen and laundary facilities.");
      System.out.println("Rent:                                     RM 200");
      System.out.println("Master bedroom Additional Rent:           RM 80");
    }
    System.out.println("Registration Charge:           RM 100");
    System.out.println("Rent Valid for: 140 days");  
    System.out.println("****************************************************************************") ; 
    System.out.println("") ;
    System.out.println("---SID------------------------Name----------------Address----------------Rented From-------------Contact-----------");
    if(sizeA != 0){
      for(i=0; i<sizeA; i++){
        System.out.println("---"+mainArray.get(i).SID+"---------------"+mainArray.get(i).name+"  "+mainArray.get(i).address+"   "+mainArray.get(i).date+"----"+mainArray.get(i).contact);
        
       
       

      }  
       
    
    }  
    
     System.out.println("*****************Menu******************");
     System.out.println("1.Press A for Renting Apartment to Student");
     System.out.println("2.Press U for Updating Student");
     System.out.println("3.Press D to Delete");
     System.out.println("4.Press E to Exit");
     System.out.println("*************************************");
     Scanner sc2 = new Scanner(System.in);
     char op =  sc2.next().charAt(0);
     switch(op)
     {
     
     case 'A':
       int seats = 0;
       
          for(i = 0; i<sizeA; i++){
             if((new Date().getTime() - mainArray.get(i).date.getTime())/(1000 * 60 * 60 * 24) <= 140){
                 
                 seats += 1;
             }
           
           }
         
          if(seats<3){
             Student st = new Student();
         
         System.out.println("Enter Student ID:");
         int sidI = sc2.nextInt();
         
         
         
         if(sizeA != 0){
             
         for(i=0; i<sizeA; i++){
           System.out.println("ID is "+mainArray.get(i).SID+"New ID is "+sidI);
           if(mainArray.get(i).SID == sidI){
             
             
            valid = 0;
           } 
         }
         }
         if(sizeB != 0){
         for(i=0; i<sizeB; i++){
           if(anoArray.get(i).SID == sidI){
          valid = 0;
         } 
         }
         }
         if(valid == 0){
            System.out.println("SID cannot be repeated");
         
         }else{
          
          
           
            Scanner s = new Scanner(System.in);
            st.SID = sidI;
            
            System.out.println("Enter Student's Name:");
            st.name = s.nextLine();
            
            System.out.println("Enter Student's Address:");
            st.address = s.nextLine(); 
            
            st.date = new Date();  
            
            System.out.println("Enter Student's Contact:");  
            st.contact = s.nextLine();   
            if(val == 1){
            apartmentsA.add(st);
            }else{
            apartmentsB.add(st);
            }
          
         }
         }else{
           System.out.println("Sorry, There is no Space for any more student, Please check for Apartment type B");
         }
        
         
         break;         
         
       
      case 'U':
         Scanner scs = new Scanner(System.in);
         rented = 0;
         
         if(sizeA != 0){
           System.out.println("Give SID of student: ");
         ids = scs.nextInt();
           for(i = 0; i<sizeA;i++){
              
             if(mainArray.get(i).SID == ids){
                 rented = 1;
                 if(val == 1){
                  
                  System.out.println("Enter new name:");
                  apartmentsA.get(i).name = scs.nextLine();
                  System.out.println("Enter new Address:");
                  apartmentsA.get(i).address = scs.nextLine();
                  System.out.println("Enter new Contact:");
                  apartmentsA.get(i).contact = scs.nextLine(); 
          
                 }else{
                  System.out.println("Enter new name:");
                  apartmentsB.get(i).name = scs.nextLine();
                  System.out.println("Enter new Address:");
                  apartmentsB.get(i).address = scs.nextLine();
                  System.out.println("Enter new Contact:");
                  apartmentsB.get(i).contact = scs.nextLine();
                 }
             }
           }
             if(rented == 0){
            
             System.out.println("Sorry this system couldnot find any user with that SID");
             }
           }else{
             System.out.println("This apartment has not be rented yet!");
            
           }
          break;
     
       case 'D':
         Scanner scss = new Scanner(System.in);
         rented = 0;
        
         
         if(sizeA != 0){
         System.out.println("Give SID of student: ");
         ids = scss.nextInt();
         if(val == 1){
           for(i = 0; i<sizeA;i++){
              
             if(apartmentsA.get(i).SID == ids){
                 rented = 1;
                  
                  apartmentsA.remove(i);
                  System.out.println("Student data has been deleted!");
                
             }
           }
         }else{
          for(i = 0; i<sizeA;i++){
              
             if(apartmentsB.get(i).SID == ids){
                 rented = 1;
                  
                  apartmentsB.remove(i);
                  
                
             }
           }
         }
             if(rented == 0){
            
             System.out.println("Sorry this system couldnot find any user with that SID");
             }
           }else{
             System.out.println("This apartment has not be rented yet!");
            
           }
                 
         break;
       
       case 'E':
         tr = false;
         break;
        
        default: 
        System.out.println("Invalid Input! Please enter valid Entry!");
        break;
     
     }
      }
    }
 }  