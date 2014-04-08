import java.util.*;
public class RPNcalculator{
    private MyStackArray stack;

    public RPNcalculator(){
	stack = new MyStackArray();
    }
        
    public static boolean isValidNum(String s){
	try{
	    double x = Double.parseDouble(s);
	}
	catch(Exception e){
	    return false;
	}
	return true;
    }

    public static boolean isValidOp(String s){
	String[] ops = {"+", "-", "*", "/", "%", "pow", "sqrt", "abs", "log", "ln", "sin", "cos", "tan", "clear", "off"};
	for (String str: ops){
	    if (s.equals(str))
		return true;
	}
	return false;
    }

    public double operation(String s){
	if (isValidNum(s)){
	    stack.push(s);
	    return Double.parseDouble(s);
	}
	double x = Double.parseDouble(stack.pop());
	 if(s.equals("sqrt")){
	    x = Math.sqrt(x);
	    stack.push(x + "");
	    return x;
	}
	else if(s.equals("abs")){
	    x = Math.abs(x);
	    stack.push(x + "");
	    return x;
	}
	else if(s.equals("log")){
	    x = Math.log10(x);
	    stack.push(x + "");
	    return x;
	}
	else if(s.equals("ln")){
	    x = Math.log(x);
	    stack.push(x + "");
	    return x;
	}
	else if(s.equals("sin")){
	    x = Math.sin(x);
	    stack.push(x + "");
	    return x;
	}
	else if(s.equals("cos")){
	    x = Math.cos(x);
	    stack.push(x + "");
	    return x;
	}
	else if(s.equals("tan")){
	    x = Math.tan(x);
	    stack.push(x + "");
	    return x;
	}
	double y = Double.parseDouble(stack.pop());
	if(s.equals("+")){
	    x += y;
	    stack.push(x + "");
	    return x;
	}
	else if(s.equals("-")){
	    x -= y;
	    stack.push(x + "");
	    return x;
	}
	else if(s.equals("*")){
	    x *= y;	    
	    stack.push(x + "");
	    return x;
	}
	else if(s.equals("/")){
	    x /= y;	    
	    stack.push(x + "");
	    return x;
	}
	else if(s.equals("%")){
	    x %= y;	    
	    stack.push(x + "");
	    return x;
	}
	else if(s.equals("pow")){
	    x = Math.pow(x,y);
	    stack.push(x + "");
	    return x;
	}
	else{ 
	    stack = new MyStackArray();
	}
	throw new ArithmeticException();
    }

    public static void main(String[]args){
	RPNcalculator calc = new RPNcalculator();
	String[] ops = {"+", "-", "*", "/", "%", "pow", "sqrt", "abs", "log", "ln", "sin", "cos", "tan", "clear", "off"};
	System.out.println("\nReverse Polish Notation Calculator\n\n\n<List of Valid Operations>\n");
	int j = 0;
	for (int i = 0; i < ops.length/4 + 1; i++){
	    System.out.print(" ");
	    while (j < (i+1) * 4){
		if (j >= ops.length)
		    break;
		System.out.print(ops[j] + "\t");
		j++;
	    }
	    System.out.println("\n");
	}
	Scanner sc;
	String response;
	while (true){
	    do{
		System.out.println("\n" + "Enter a valid number or operation:");
		sc = new Scanner(System.in);
		response = sc.nextLine();
	    }
	    while(!isValidNum(response) &&
		  !isValidOp(response));
	    if (response.equals("off"))
		break;
	    try{
		double output = calc.operation(response);
		System.out.println(output);
	    }
	    catch(Exception e){
		if (!(e instanceof ArithmeticException))
		    calc = new RPNcalculator();
	    }
	}
    }
}