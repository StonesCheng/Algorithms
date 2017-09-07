package algorithms;

import java.util.Stack;

public class test5 {
    Stack<Integer> stack1=new Stack<>();
    Stack<Integer> stack2=new Stack<>();
    int length=0;
    public void push(int node){
        stack1.push(node);
    }
    public int pop(){
        while (!stack2.isEmpty()){
            return stack2.pop();
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
    public static void main(String[] args) {

    }
}
