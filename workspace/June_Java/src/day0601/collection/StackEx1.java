package day0601.collection;
import java.util.Stack;
import static java.lang.System.out;

public class StackEx1 {
public static void main(String[] args) {
		String[] groupA= {"���Ű��ź","������Ʈ","����","���ѹα�"};
		
		Stack<String> stack = new Stack<String>();
		for(String n : groupA) 
			stack.push(n);
		
		while(!stack.isEmpty())
			out.println(stack.pop());
	}
}
