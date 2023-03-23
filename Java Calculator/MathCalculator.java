public class MathCalculator {
    public static void main(String[]args){
        //scanner can come here
        Scanner input= new Scanner(System.in);
        int num1;
        int num2;
        int operator;
        System.out.println("Insert your first  number: ");
        num1=input.nextInt();
        System.out.println("Insert your second number: ");
        num2=input.nextInt();
        System.out.println("Choose an operator from the following: " );
        System.out.println("1.ADD , 2.SUB , 3.MULT , 4.DIV , 5.MOD , 6.FACT , 7.POW");
        operator= input.nextInt();
        
        
        //Switch statement goes here(In the switch statement we call the respective methods within the cases)
        switch (operator) {
            case 1:
                int addition=add(num1,num2);//addition method
                break;
            case 2:
                //subtract method
                break;
            case 3:
                //multiply method
                int multiplication=multiply(num1,num2);
                break;
            case 4:
                //divide method
                int division=divide(num1,num2);
                break;
            case 5:
                //modulus method
                int modulus=modula(num1,num2);
                break;
            case 6:
                //factorial method
                break;
            case 7:
                //power method
                break;
            default:
                System.out.println("You may have entered an Incorrect operation");
        }
    }
    //addition method
    //naming method
       private add(int num1, int num2){
       int result = num1+num2; //declared a variable result
        return result;
        System.out.println(result);
       };
    //subtraction method
    //multiplication method 
    static int multiply(int a, int b){
        return a*b;
    }
   
    //division method
    static int divide(int a, int b){
		if (b == 0) {
			System.out.println ("cannot divide by 0");
			result = "error";
		} 
			else {
				result = a / b;
			}
	return result;
	}
   
    //modulus method
    static int modula(int a, int b){
		return a % b;
    }    
    
    //factorial method
    //power(exponential)
}
