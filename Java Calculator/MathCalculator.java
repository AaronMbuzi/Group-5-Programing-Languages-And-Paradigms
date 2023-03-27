package learn;

import java.util.Scanner;

public class MathCalculator {
    public static void main(String[]args){
        //scanner can come here
        Scanner input= new Scanner(System.in);
        double num1;
        double num2;
        int operator; // yes here we can use int because its more like a map
        System.out.println("Insert your first  number: ");
        num1=input.nextInt();
        System.out.println("Insert your second number: ");
        num2=input.nextInt();
        System.out.println("Choose an operator from the following: " );
        System.out.println("1.ADD , 2.SUB , 3.MULT , 4.DIV , 5.MOD , 6.FACT , 7.POW , 8.factorial");
        operator= input.nextInt();
        
        
        //Switch statement goes here(In the switch statement we call the respective methods within the cases)
        switch (operator) {
            case 1:
               add (num1,num2);//addition method
                break;
            case 2:
                subtract(num1, num2);
                break;
            case 3:
                //multiply method
                multiply(num1,num2);
                break;
            case 4:
                //divide method
                 divide(num1,num2); // we just call the method without wasting resources
                break;
            case 5:
                //modulus method
                 modula((int)num1,(int)num2); // have just casted these so that we only deal with integers when we are dealing with mod
                break;
            case 6:
                //factorial method
                break;
            case 7:
                power(num1,num2);
                break;
            case 8:
            	factorial((int)(num1));
            	break;
            default:
                System.out.println("You may have entered an Incorrect operation");
        }
    }
    //addition method
    //naming method
       public static void add(double a, double b){
  //     int result = num1+num2; declared a variable result
        System.out.println(a + b);
       };
    //subtraction method
	private static void subtract(double a, double b){
	      System.out.println(a-b); 
		
		/*	if( a > b){
			int result = num1-num2;
			return result;
			System.out.println(result);
		}else{
			int result = num2-num1;
			return result;
			System.out.println("-"result); // for negative difference
			
		}
	*/
	};
    //multiplication method 
   public static void multiply(double a, double b){ //have put double here so that it can be flexible
       // return a*b; since we are not using the number, we can save some computing power ad just display it
       System.out.println(a*b);
   }
   
    //division method
    static void divide(double a, double b){  // we can make this method void since we are it getting any return from the method
		if (b == 0) {
			System.out.println ("cannot divide by 0");

		} 
			else {
				System.out.println( a / b); // we just display it on console
			}
	
	}
   
    //modulus method
    static int modula(int a, int b){
		return a % b;
    }    
    
    public static void factorial(int a) {
    	if(a < 0) {
    		System.out.println("invalid input");
    		return;
    	}
    	
    	int answer = 1;;
    	for(int i = a; i > 1; i-- ) {
    		answer *= i;
    	}
        System.out.println( a+"! = " +answer);
    }
   public static void power(double a, double b) {
	   System.out.println(Math.pow(a, b));
   }
    
    
}
