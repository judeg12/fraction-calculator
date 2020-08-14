//Jude Gerhart, CSE17, project1, This main method is the test class for Calculator.java
  import java.util.Scanner;

public class TestCalculator{
  public static void main (String [] args){
     Scanner scnr = new Scanner(System.in); // import scanner object
    
     /*** data field ***/ 
  int picked =1; //for menue 
  String anotherOperation = "y";
  Calculator calculation = new Calculator(); //creates the object
/****************** print info and menue *****************/
 
    do{
      // prompt to user and print menue page:
    
      System.out.println("1. Add 2 numbers        2. Subtract 2 numbers");
      System.out.println("3. Multiply 2 numbers   4. Divide 2 numbers");
      System.out.println("5. Invert 1 number      6. Mixed Fraction");
      System.out.println("7. Reduce fraction      8. Find GCD");
      System.out.println("9. Compare two numbers ");
   System.out.println("Choose an operation to perform on a number.");
    picked = scnr.nextInt();
   System.out.println("If your number is a fraction, you will be asked for the numerator and denominator.");
   System.out.println("If it is a whole number, you should input your denominator as 1.");
      switch(picked){
        case 1:
          //add 2 numbers
          inputForTwoNumbers(calculation); //ask user for 2 fractions
          System.out.println(calculation.Addition());
          break;
        case 2:
          //Subtract 2 numbers
          inputForTwoNumbers(calculation);
          System.out.println(calculation.Subtraction());
          break;
        case 3:
          //Multiply 2 numbers
          inputForTwoNumbers(calculation);
          System.out.println(calculation.Multiplication());
          break;
        case 4:
          //divide 2 numbers
          inputForTwoNumbers(calculation);
          System.out.println(calculation.Division());
          break; 
        case 5:
          //Inverse (1 number) 
          inputForOneNumber(calculation); //asks user for one fraction 
          System.out.println("Inverse: " + calculation.Inverse());
          break;
        case 6: 
          //mixed fraction (1 number)
          inputForOneNumber(calculation);
          System.out.println(calculation.mixedForm());
          break; 
        case 7: 
          //reduce fraction (1 number)
          inputForOneNumber(calculation);
          System.out.println("reduced fraction: "+calculation.ReduceFraction());
          break;
        case 8: 
          //Find GCD (2 numbers) 
          inputForOneNumber(calculation);
          System.out.println("GCD: " + calculation.findGCD());
          break;
        case 9: 
          //compare 2 numbers
          inputForTwoNumbers(calculation);
          System.out.println("Comparison:" + calculation.Compare());
          break;
        default: 
          System.out.println("Invalid input number.");
      } //end of switch
      
      scnr.nextLine();
   //Give the choice to exit 
      System.out.println("Would you like to perform another operation? enter (y/n)as lower case");
      anotherOperation = scnr.next();
    }while(anotherOperation.equals("y"));

System.exit(0); //quit program
 } //end of main
 public static void inputForOneNumber(Calculator calculation){
    Scanner scnr = new Scanner(System.in);
   System.out.println("Enter a fraction in the form p/q:");
   calculation.setFraction1(scnr.nextLine()); //set 1st fraction in object
 }
 public static void inputForTwoNumbers(Calculator calculation){
     Scanner scnr = new Scanner(System.in);
    System.out.println("Enter a fraction in the form p/q:");
    calculation.setFraction1(scnr.nextLine()); //set 1st fraction in object
    System.out.println("Enter a fraction in the form p/q:");
    calculation.setFraction2(scnr.nextLine()); //set 2nd fraction in object
  }
}