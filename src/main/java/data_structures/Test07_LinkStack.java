package data_structures;

/**
 * @author Ly.
 * @create 2020-10-28 18:54
 */
public class Test07_LinkStack {
    public static void main(String[] args) {
        LinkStack stack = new LinkStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.showStack();
        stack.pop();
    }
}
class LinkStack{
    private int no;
    private Link head;

    public Boolean isEmpty(){
        return head == null;
    }

    //往栈中添加元素(头插法)
    public void push(int num){
        Link link = new Link(num);
        if(isEmpty()){
            head = link;
            return;
        }
        link.setNext(head);
        head = link;
    }

    //从栈中去元素
    public void pop(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        System.out.println("出栈的元素是:" + head.getNo());
        head = head.getNext();
    }

    //展示栈的元素
    public void showStack(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        Link tmp = head;
        while (true){
            if(tmp.getNext() == null){
                System.out.println(tmp.getNo());
                return;
            }
            System.out.println(tmp.getNo());
            tmp = tmp.getNext();
        }
    }
}
class Link{
    private int no;
    private Link next;

    public Link(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }
}