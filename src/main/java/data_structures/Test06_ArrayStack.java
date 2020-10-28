package data_structures;

import java.util.Scanner;

/**
 * @author Ly.
 * @create 2020-10-28 18:31
 */
public class Test06_ArrayStack {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("输入需要的操作:");
            System.out.println("pop:入队,push:出队,s:显示栈,exit:退出");
            String key = scanner.next();
            switch (key){
                case "push" :
                    System.out.println("输入要添加数");
                    int i = scanner.nextInt();
                    stack.push(i);
                    break;
                case "pop" :
                    stack.pop();
                    break;
                case "s" :
                    stack.showStack();
                    break;
                case "exit" :
                    return;
            }
        }
    }
}
class ArrayStack{
     private int maxSize;
     private int[] stack;
     private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public Boolean isFull(){
        return top == maxSize - 1;
    }

    public Boolean isEmpty(){
        return top == -1;
    }

    //往栈中添加元素
    public void push(int num){
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        stack[++top] = num;
    }

    //从栈中去元素
    public void pop(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        System.out.println(stack[top--]);
    }

    //展示栈的元素
    public void showStack(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.print(stack[i] + "\t");
        }
        System.out.println();
    }
}
