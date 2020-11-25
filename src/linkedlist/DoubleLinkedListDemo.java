package linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 h1 = new HeroNode2(0,"aa","aaa");
        HeroNode2 h2 = new HeroNode2(1,"bb","bbb");
        HeroNode2 h3 = new HeroNode2(2,"cc","ccc");
        HeroNode2 h4 = new HeroNode2(3,"dd","ddd");

        DoubleLinkedList dll = new DoubleLinkedList();
        //测试：按加入的顺序插入
//        dll.add(h2);
//        dll.add(h4);
//        dll.add(h1);
//        dll.add(h3);
//        dll.list();

        //测试：按编号的顺序插入
        System.out.println("按节点编号插入");
        dll.addByOrder(h2);
        dll.addByOrder(h4);
        dll.addByOrder(h1);
        dll.addByOrder(h3);
        dll.list();

        //测试：修改节点
        HeroNode2 hd1 = new HeroNode2(2,"ee","eee");
        HeroNode2 hd2 = new HeroNode2(4,"ff","fff");
        System.out.println("修改后：");
        dll.update(hd1);
        dll.list();
        dll.update(hd2);

        //测试：删除节点
        System.out.println("删除后");
        dll.del(2);
        dll.list();
        dll.del(5);

    }
}

//创建双向链表的类
class DoubleLinkedList{
    //先初始化一个头结点
    private HeroNode2 head = new HeroNode2();

    //头结点的get方法
    public HeroNode2 getHead() {
        return head;
    }

    //删除双向链表的一个节点
    public void del(int no){
        if (head.next == null){
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;//标识是否找到编号为no的节点
        //开始遍历链表查找编号为no的节点
        while(true){
            if(temp == null){
                break;
            }
            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.pre.next = temp.next;
            if (temp.next != null){//易错点，需要判断一下temp的下一个节点是否为空，否则出现空指针异常
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.printf("要删除的节点%d不存在，无法删除\n",no);
        }
    }

    //修改某一节点的内容
    public void update(HeroNode2 newhd){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
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

    //添加一个节点到双向链表末尾
    public void add(HeroNode2 hd){
        HeroNode2 temp = head;//头结点不能移动，所以定义一个辅助变量temp来遍历链表
        //1.遍历链表，找到最后的节点（.next == null）
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        //2.将节点添加进双向链表的最后
        temp.next = hd;
        hd.pre = temp;
    }

    //第二种添加方法，根据人物编号插入到指定位置
    //如果这个编号已存在，则添加失败，并给出提示
    public void addByOrder(HeroNode2 hd){
        //因为头节点不能移动，所以通过一个辅助接点temp遍历链表
        //temp是要添加位置的前一个节点
        HeroNode2 temp = head;
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
            hd.pre = temp;
            temp.next = hd;
            if (hd.next != null){//易错，需要判断一下
                hd.next.pre = hd;
            }
        }
    }

    //遍历双向链表
    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
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
class HeroNode2{
    public int no;//编号
    public String name;//姓名
    public String nickName;//外号
    public HeroNode2 next;//指向下一个节点
    public HeroNode2 pre;//指向前一个节点
    //构造器
    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public HeroNode2() {
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