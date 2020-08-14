 /**
   * @author Jude Gerhart
   * @Date May 28th, 2020
   * CSE 17 Programming Project 1
   */

   import java.lang.String;
public class Calculator{
 //data fields for user input, ints. 
 private int numerator1;
 private int denominator1; 
 private int numerator2;
 private int denominator2; 
 
 //--------------------------constructors---------------------//
  /**
   * no arg default constructor
   */
 public Calculator(){
   numerator1 = 0; 
   denominator1 = 1;
    numerator2 = 0; 
   denominator2 = 1;
 }
 /**
  * @param int p the numerator and int q the denominator 
  */
 public Calculator(int p, int q){
   this.numerator1 = p;
   this.denominator1 = q;
 }
 /**
  * @param type whole fraction as one string input
  */
 public Calculator(String input){
   int cut= input.indexOf("/"); //find where the numbers are
   String num=input.substring(0,cut); //first half
   String den=input.substring(cut+1, (input.length())); //second half
     this.numerator1= Integer.valueOf(num); 
     this.denominator1= Integer.valueOf(den); 
   //System.out.println("p: "+numerator1+ "\t q: "+denominator1); //test 
 }
/*_________________setters for numerator and denoinators__________*/
 
 public void setFraction1(String input){
   int cut= input.indexOf("/"); //find where the numbers are
     this.numerator1= Integer.valueOf(input.substring(0,cut)); //first half
     this.denominator1= Integer.valueOf(input.substring(cut+1, (input.length()))); //second half
 }
 public void setFraction2(String input){
   int cut= input.indexOf("/"); //find where the numbers are
     numerator2= Integer.valueOf(input.substring(0,cut)); //first half
     denominator2= Integer.valueOf(input.substring(cut+1, (input.length()))); //second half
 }
 
//____________________________________________________________________________________________________________________//
/** All public methods that execute computations do not take parameters. The input is set by constructors and setters */
 
/**
 * @return type is String
 * Addition of fractions 
 */
 public String Addition(){
   expand(); //match the denominator values
   numerator1 = numerator2 + numerator1; //add
   return ReduceFraction(); //return string
 }
 
/*
 * @return String type 
 * this method subtracts two numbers 
 */
 public String Subtraction(){
   expand(); //match the denominator values 
   numerator1 = numerator1 - numerator2; //subtract
   return ReduceFraction(); //return string
 }
 
/*
 * @return String type 
 * this method mulptiples two numbers
 */
 public String Multiplication(){
   numerator1*=numerator2;
   denominator1*=denominator2;
   return ReduceFraction(); 
 }
 
/**
 * @return type string 
 * this method divides two numbers
 */
 public String Division(){
   
   numerator1 = denominator2 * numerator1;
   denominator1 = numerator2 * denominator1;
   return ReduceFraction();
 }
 
/**
 * @return type is String 
 * Inverse will flip the fraction
 */
 public String Inverse(){
   int temp = denominator1;
   denominator1 = numerator1;
   numerator1 = temp;
   return ReduceFraction();
 }
 
/**
 * @return type string 
 * method will turn regular fraction form into mixed form of fraction
 */
 public String mixedForm(){
   String output;
   if((numerator1/denominator1)<1){ //no need to convert 
     output = numerator1 + "/" + denominator1;
   } 
   else if(((double)numerator1/(double)denominator1)==1.0){ //simplify to 1
     output = "1";
   }
   else{
     int top = numerator1%denominator1; //find left over fraction 
     int whole = (numerator1-top)/denominator1;
     if(top==0){
       output = "" + whole;
     }
     
     else{
     output = whole + " and " + top + "/" + denominator1;
     }
   }
   return output; 
 }
/**
 * @return fraction as type String
 * This method reduces the fraction 
 */
 public String ReduceFraction(){
   int GCD= findGCD();
 //  System.out.println("GCD"+GCD);
   numerator1 = numerator1/GCD;
   denominator1 = denominator1/GCD;
   return formatFrac1();
 }
 /*
 * @return type int 
 * This method finds the greatest common divisor of a fraction
 */
 public int findGCD(){
   int GCD =1;
   int min = minOf(numerator1 , denominator1);
   for(int i=2; i< min+1; i++){
     if((numerator1%i==0)&&(denominator1%i==0)){
       GCD=i;
     }
   }
   return GCD;
 }
/**
 * @return type is String
 * This method compares the value of two fractions
 * and returns the result with < , >, or =.
 */
 public String Compare(){
 String output="";
 if(((double)numerator1/denominator1)<((double)numerator2/denominator2 )){
   output = formatFrac1()+ " < " +formatFrac2();
 }
 else if(((double)numerator2/denominator2)<((double)numerator1/denominator1)){
   output = formatFrac1()+ " > " +formatFrac2();
 }
 else{
   output = formatFrac1()+ " = " +formatFrac2();
 }
   return output;
 }
//private methods returns string format to print the fractions
 private String formatFrac1(){
   if (denominator1==1){ 
     return "" + numerator1; //prints for whole numbers x/1
   }
   else if (denominator1==0){ //prints for x/0
     return "fraction is undefined";
   }
   else{
   return numerator1+"/"+denominator1; //prints fraction as ussual 
   }
 }
 //does the same for fraction 2
 private String formatFrac2(){
   if (denominator2==1){ 
     return "" + numerator1; //prints for whole numbers x/1
   }
   else if (denominator2==0){ //prints for x/0
     return "fraction is undefined";
   }
   else{
   return numerator2+"/"+denominator2; //prints fraction as ussual 
   }
 }
//private method returns minimum of two numbers 
 private int minOf(int a, int b){
   if(a>b){ //compares 
     return b;
   }
   else{ //retursn a if they are equal 
     return a;
   }
 }
//method expand will match the denominator of two fractions to allow addition and subtraction. 
 private void expand(){
   if (denominator1==denominator2){
   }
   else{
     int temp = denominator1; 
   //fraction 1
     numerator1 = numerator1*denominator2;
     denominator1 = denominator1*denominator2;
   //fraction 2
     numerator2 = numerator2*temp;
     denominator2 = denominator2*temp; 
   }
 }
 
} //end of class