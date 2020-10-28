package data_structures;

import java.util.Scanner;

/**
 * @author Ly.
 * @create 2020-10-18 20:55
 */
public class Test03_CircleQueue {
    public static void main(String[] args) {
        //创建一个队列

        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(5);

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("输入需要的操作:");
            System.out.println("a:入队,g:出队,s:显示队列,h:显示头部");
            String key = scanner.next();
            switch (key){
                case "a" :
                    System.out.println("输入要添加数");
                    int i = scanner.nextInt();
                    circleArrayQueue.addQueue(i);
                    break;
                case "g" :
                    circleArrayQueue.getQueue();
                    break;
                case "s" :
                    circleArrayQueue.showQueue();
                    break;
                case "h" :
                    circleArrayQueue.head();
                    break;
            }
        }
    }
}
class CircleArrayQueue{
    //各种属性
    private int maxSize;
    //指向第一个元素
    private int front;
    //指向最后一个元素的下一个位置
    private int rear;
    private int[] arr;
    //创建构造器
    public CircleArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
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
        if((rear + 1 ) % maxSize == front){
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
            //先添加数据在rear后移.
            //因为rear指向队列的最后一个元素
            arr[rear] = num;
            rear = (++ rear) % maxSize;
        }
    }

    //获取队列数据,出队列
    public void getQueue(){
        if (isEmpty()){
            System.out.println("队列空!没有元素.");
        }else{
            //先记录数据在打印!
            int num = arr[front];
            System.out.println(num);
            front = (++ front ) % maxSize;
        }
    }

    //显示队列所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列空!没有元素.");
        }else{
            for (int i = front ; i % maxSize != rear; i ++) {
                System.out.print(arr[i] + "\t");
            }
        }
    }

    //显示头数据
    public void head(){
        if (isEmpty()){
            System.out.println("队列空!没有元素.");
        }else{
            System.out.println(arr[front]);
        }
    }
}