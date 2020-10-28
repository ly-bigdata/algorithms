package data_structures;

/**
 * @author Ly.
 * @create 2020-10-21 18:57
 */
public class Test04_SingleLinkList {
    public static void main(String[] args) {
        SingleLinkList list = new SingleLinkList();
        list.addLink2(new LinkNode(1, "松江"));
        list.addLink2(new LinkNode(2, "卢俊义"));
        list.addLink2(new LinkNode(2, "卢俊义"));
        list.addLink2(new LinkNode(3, "无用"));
        list.showLink();
        System.out.println("================");
        list.update(new LinkNode(3, "吴用"));
        list.showLink();
        System.out.println("================");
        //list.remove(new LinkNode(3, "吴用"));
        list.showLink();
        System.out.println("================");
        System.out.println(list.returnIndex(3));
        System.out.println("==============");
        list.reserve();
        list.showLink();

    }
}

class SingleLinkList {

    LinkNode head = new LinkNode(0, "0");

    //翻转链表
    public void reserve(){
        LinkNode temp = head.next;
        LinkNode tmp;

        while (true){
            if (temp.next == null){
                break;
            }
            tmp = temp.next;
            temp.next = temp.next.next;
            tmp.next = head.next;
            head.next = tmp;
        }
    }

    //显示链表中所有的元素
    public void showLink() {
        LinkNode tmp = head;
        while (true) {
            if (tmp.next == null) {
                break;
            }
            tmp = tmp.next;
            System.out.println(tmp);

        }
    }

    //链表中添加元素
    public void addLink(LinkNode value) {
        LinkNode tmp = head;
        while (true) {
            if (tmp.next == null) {//说明到链表的低端.
                break;
            }
            tmp = tmp.next;
        }
        tmp.next = value;
    }

    //添加元素并保持顺序
    public void addLink2(LinkNode value) {
        LinkNode tmp = head;

        while (true) {
            if (tmp.next == null) {//说明到链表的低端.
                tmp.next = value;
                return;
            } else if (tmp.next.no > value.no) {
                break;
            } else if (tmp.next.no == value.no) {
                System.out.println("想插入的编号" + value.no + "已经存在");
                return;
            }
            tmp = tmp.next;
        }
        value.next = tmp.next;
        tmp.next = value;
    }

    //更新元素
    public void update(LinkNode value) {
        LinkNode tmp = head;
        Boolean flag = true;
        while (true) {
            if (tmp.next == null) {//说明到链表的低端.
                tmp.next = value;
                break;
            } else if (tmp.next.no == value.no) {
                flag = false;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            System.out.println("未找到想要删除的元素");
        } else {
            tmp.next.no = value.no;
            tmp.next.name = value.name;
        }
    }

    public void remove(LinkNode value) {
        LinkNode tmp = head;
        Boolean flag = true;
        while (true) {
            if (tmp.next == null) {//说明到链表的低端.
                break;
            } else if (tmp.next.no == value.no) {
                flag = false;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            System.out.println("未找到想要删除的元素");
        } else {
            tmp.next = tmp.next.next;
        }
    }

    //返回倒数第N个节点
    public LinkNode returnIndex(int index) {
        LinkNode tmp = head;
        LinkNode front = head;
        int flag = 0;
        while (true) {
            if (front.next == null) {
                if (flag < index) {
                    System.out.println("元素不够");
                    return null;
                } else {
                    return tmp.next;
                }
            }

            if(flag < index){
                front = front.next;
                flag ++;
            }else if (flag == index) {
                front = front.next;
                tmp = tmp.next;
            }
        }
    }
}

class LinkNode {
    public int no;
    public String name;
    public LinkNode next;

    public LinkNode(int no, String name) {
        this.no = no;
        this.name = name;
        this.next = null;
    }

    @Override
    public String toString() {
        return "LinkNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}