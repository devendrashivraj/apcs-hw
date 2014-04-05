public class MyStackArray{
    private String[] list;
    private int top;

    public MyStackArray(){
	list = new String[10];
	top = -1; //empty stack
    }

    public void grow(){
	String[] newList = new String[list.length * 2];
	for (int i = 0; i < top; i++){
	    newList[i] = list[i];
	}
	list = newList;
    }

    public void shrink(){
	String[] newList = new String[list.length / 2];
	for (int i = 0; i <= top; i++){
	    newList[i] = list[i];
	}
	list = newList;
    }

    public void push(String s){
	if (++top >= list.length)
	    grow();
	list[top] = s;
    }

    public String peek(){
	return list[top];
    }
    
    public String pop(){
	String s = list[top];
	if (--top <= list.length/4)
	    shrink();
	return s;
    }

    public boolean isEmpty(){
	return top == -1;
    }

    public int size(){
	return top+1;
    }

    public String toString(){
	String str = "[";
	for (int i = top; i >= 0; i--){
	    str += list[i] + ", ";
	}
	return str + "]";
    }
    
    public static void main(String[]args){
	MyStackArray stack = new MyStackArray();
	System.out.println(stack);
	System.out.println(stack.size());
	System.out.println(stack.isEmpty());
	stack.push("0");
	System.out.println(stack);
	System.out.println(stack.isEmpty());
	for (int i = 0; i < 15; i++){
	    stack.push(i+1+"");
	}
	System.out.println(stack);
	System.out.println(stack.size());
	System.out.println(stack.peek());
	stack.pop();
	System.out.println(stack);
	for (int i = 0; i < 12; i++){
	    stack.pop();

	}
	System.out.println(stack);
	System.out.println(stack.size());
    }
}