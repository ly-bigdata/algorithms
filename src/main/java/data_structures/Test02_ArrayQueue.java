package data_structures;

import java.util.Scanner;

/**
 * @author Ly.
 * @create 2020-10-18 19:34
 *
 * 这一个初级的队列.只可使用一次
 */
public class Test02_ArrayQueue {
    public static void main(String[] args) {
        //创建一个队列

        ArrayQueue arrayQueue = new ArrayQueue(3);

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("输入需要的操作:");
            System.out.println("a:入队,g:出队,s:显示队列,h:显示头部");
            String key = scanner.next();
            switch (key){
                case "a" :
                    System.out.println("输入要添加数");
                    int i = scanner.nextInt();
                    arrayQueue.addQueue(i);
                    break;
                case "g" :
                    arrayQueue.getQueue();
                    break;
                case "s" :
                    arrayQueue.showQueue();
                    break;
                case "h" :
                    arrayQueue.head();
                    break;
            }
        }
    }
}
class ArrayQueue{
    //各种属性
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;
    //创建构造器
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断是否为空
    public Boolean isEmpty(){
        if(front == rear){
            return true;
        }else {
            return false;
        }
    }

    //判断是否满
    public Boolean isFull(){
        if(rear + 1 == maxSize){
            return true;
        }else {
            return false;
        }
    }

    //添加队列
    public void addQueue(int num){
        if(isFull()){
            System.out.println("队列满!不可插入.");
        }else {
            rear ++;
            arr[rear] = num;
        }
    }

    //获取队列数据,出队列
    public void getQueue(){
        if (isEmpty()){
            System.out.println("队列空!没有元素.");
        }else{
            front ++;
            int num = arr[front];
            System.out.println(num);
        }
    }

    //显示队列所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列空!没有元素.");
        }else{
            for (int i = 0; i < maxSize; i++) {
                System.out.println(arr[i]);
            }
        }
    }

    //显示头数据
    public void head(){
        if (isEmpty()){
            System.out.println("队列空!没有元素.");
        }else{
            System.out.println(arr[front + 1]);
        }
    }
}
