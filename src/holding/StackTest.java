package holding;

import java.util.Stack;
/**
 * Created by caoxiaohong on 17/2/23.
 */
public class StackTest {
    public static void main(String[] args) {
     Stack<String> stack=new Stack<String>();
        for(String s:"this ia just a test".split(" ")){
            stack.push(s);
        }
        while(!stack.empty()){
            System.out.println(stack.pop()+",");
        }
    }
}
