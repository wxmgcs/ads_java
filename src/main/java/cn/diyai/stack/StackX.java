package cn.diyai.stack;

//中缀表达式转后缀表达式
public class StackX {

    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackX(int size) {
        this.maxSize = size;
        this.stackArray = new char[maxSize];
        this.top = -1;
    }

    public void push(char j){
        stackArray[++top] = j;
    }

    public char pop(){
       return  stackArray[top--];
    }

    public boolean isEmpty(){
        return top== -1;
    }

    public int size(){
        return top +1;
    }

    public char peekN(int n){
        return stackArray[n];
    }


    public void displayStack(String s){
        System.out.print(s);
        System.out.print("Stack(bottom-->top):");

        for (int j= 0; j < size();j++){
            System.out.print(peekN(j));
            System.out.print(" ");
        }
        System.out.println("");
    }
}
