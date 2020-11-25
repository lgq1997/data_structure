package linkedlist;

import java.net.http.HttpRequest;

/*
单链表的增删改查
add():不考虑节点编号，按照先后顺序加入链表
addByOrder():按照节点编号的顺序插入
list():遍历节点输出
 */
public class SingleLinkerListDemo {
    public static void main(String[] args) {
        HeroNode h1 = new HeroNode(0,"aa","aaa");
        HeroNode h2 = new HeroNode(1,"bb","bbb");
        HeroNode h3 = new HeroNode(2,"cc","ccc");
        HeroNode h4 = new HeroNode(3,"dd","ddd");
        SingleLinkerList sll = new SingleLinkerList();
        //测试：按加入的顺序插入
//        sll.add(h2);
//        sll.add(h4);
//        sll.add(h1);
//        sll.add(h3);
//        sll.list();
        //测试：按编号的顺序插入
        sll.addByOrder(h2);
        sll.addByOrder(h4);
        sll.addByOrder(h1);
        sll.addByOrder(h3);
        sll.list();

        //测试：修改节点
        HeroNode hd1 = new HeroNode(2,"ee","eee");
        HeroNode hd2 = new HeroNode(4,"ff","fff");
        System.out.println("修改后：");
        sll.update(hd1);
        sll.list();
        sll.update(hd2);

        //测试：删除节点
        System.out.println("删除后");
        sll.del(2);
        sll.list();
        sll.del(5);

    }

}

//定义一个单链表
class SingleLinkerList{
    //初始化一个头结点，头结点不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");//不存放具体数据

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向列表
    public void add(HeroNode hd){
        HeroNode temp = head;//头结点不能移动，所以定义一个辅助变量temp来遍历链表
        //1.遍历链表，找到最后的节点（.next == null）
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        //2.将节点添加进链表的最后
        temp.next = hd;
    }

    //第二种添加方法，根据人物编号插入到指定位置
    //如果这个编号已存在，则添加失败，并给出提示
    public void addByOrder(HeroNode hd){
        //因为头节点不能移动，所以通过一个辅助接点temp遍历链表
        //temp是要添加位置的前一个节点
        HeroNode temp = head;
        boolean flag = false;//标志添加的编号是否存在
        while (true) {
            if (temp.next == null) {//遍历到最后了，直接加到末尾
                break;
            }
            if(temp.next.no > hd.no ){//找到了要添加的位置，添加到temp后边
                break;
            }else if(temp.next.no == hd.no){//编号已经存在
                flag = true;
                break;
            }
            temp = temp.next;//后移
        }
        if (flag == true){
            System.out.println("待插入的编号已存在，不能加入");
        }else {
            //插入到temp后边
            hd.next = temp.next;
            temp.next = hd;
        }
    }

    //修改节点信息，根据编号修改
    //根据newhd的编号修改
    public void update(HeroNode newhd){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true){
            if (temp == null){//已经遍历到链表最后了
                break;
            }
            if (temp.no == newhd.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = newhd.name;
            temp.nickName = newhd.nickName;
        }else{
            System.out.printf("没有找到编号为%d的节点，不能修改\n",newhd.no);
        }

    }

    //删除节点
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;//标识是否找到编号为no的节点
        //开始遍历链表查找编号为no的节点
        while(true){
            if(temp.next == null){
                break;
            }
            if (temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的节点%d不存在，无法删除\n",no);
        }
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
    public int no;//编号
    public String name;//姓名
    public String nickName;//外号
    public HeroNode next;//指向下一个节点
    //构造器
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public HeroNode() {
    }

    //重写toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
