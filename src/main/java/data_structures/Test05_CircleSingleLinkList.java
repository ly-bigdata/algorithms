package data_structures;

/**
 * @author Ly.
 * @create 2020-10-27 18:47
 */
public class Test05_CircleSingleLinkList {
    public static void main(String[] args) {
        CircleLink c = new CircleLink();
        c.add(5);
        c.showLink();

        System.out.println("==================");

        c.del(2,2);
    }
}

class CircleLink{

    LinkNodes first ;

    public void add(int num){
        if(num < 1){
            System.out.println("输入参数有误");
        }
        LinkNodes flag = null;
        for (int i = 1; i <= num; i++) {
            if(i == 1){
                LinkNodes next = new LinkNodes(i);
                first = next;
                next.setNo(i);
                next.setNext(next);
                flag = next;
            }else {
                LinkNodes next = new LinkNodes(i);
                next.setNo(i);
                flag.setNext(next);
                next.setNext(first);
                flag = next;
            }
        }
    }

    //展示环形链表中的数据
    public void showLink(){
        LinkNodes flag = first;
        while (true){
            if(flag.getNext() == first){
                System.out.println(flag.getNo());
                break;
            }
            System.out.println(flag.getNo());
            flag = flag.getNext();
        }
    }

    //指定删除第几个开始的第几个数
    public void del(int pre, int num){
        if(pre < 1){
            System.out.println("输入参数有误");
        }
        LinkNodes flag = first;

        //首先定位到第pre个位置
        for (int i = 0; i < pre-1; i++) {
            flag = flag.getNext();
        }

        while (true){
            if(flag.getNext() == flag){
                break;
            }
            for (int i = 1; i < num - 1; i++) {
                flag = flag.getNext();
            }
            System.out.println(flag.getNext().getNo());
            flag.setNext(flag.getNext().getNext());
            flag = flag.getNext();
        }
        System.out.println("最后一个元素" + flag.getNo());
    }
}

class LinkNodes{
    private int no;
    private LinkNodes next;

    public LinkNodes(int num){
        no = num;
        next = null;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public LinkNodes getNext() {
        return next;
    }

    public void setNext(LinkNodes next) {
        this.next = next;
    }
}
