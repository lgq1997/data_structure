package linkedlist;

public class SingleLinkerListDemo {
    public static void main(String[] args) {
        HeroNode h1 = new HeroNode(0,"aa","aaa");
        HeroNode h2 = new HeroNode(1,"bb","aaa");
        HeroNode h3 = new HeroNode(2,"cc","aaa");
        HeroNode h4 = new HeroNode(3,"dd","aaa");
        SingleLinkerList sll = new SingleLinkerList();
        sll.add(h1);
        sll.add(h2);
        sll.list();

    }
}
//定义一个单链表
class SingleLinkerList{
    //初始化一个头结点
    private HeroNode head = new HeroNode(0,"","");//不存放具体数据

    //添加节点到单向列表
    public void add(HeroNode hd){
        HeroNode temp = head;//
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = hd;
    }

    //显示链表
    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }
}





//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;//指向下一个节点
    //构造器
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
    //重写toString

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", next=" + next +
                '}';
    }



}
