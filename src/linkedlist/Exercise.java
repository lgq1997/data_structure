package linkedlist;
//练习
public class Exercise {
    public static void main(String[] args) {
        HeroNode h1 = new HeroNode(0,"aa","aaa");
        HeroNode h2 = new HeroNode(1,"bb","bbb");
        HeroNode h3 = new HeroNode(2,"cc","ccc");
        HeroNode h4 = new HeroNode(3,"dd","ddd");
        SingleLinkerList sll = new SingleLinkerList();
        sll.add(h2);
        sll.add(h4);
        sll.add(h1);
        sll.add(h3);
        sll.list();
        //链表长度
        System.out.printf("该链表的长度为：%d\n",getLength(sll.getHead()));

        System.out.println(findLastIndexNode(sll.getHead(),2));

    }

    //一些方法：
    //获取链表有效节点的个数(不包括头结点)
    public static  int getLength(HeroNode head){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode temp = head.next;
        while (temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }
    //查找单链表中倒数第k个节点,找不到返回null
    //单链表，不能逆向遍历，所以变为查到正数第（length - k + 1）个节点
    public static HeroNode findLastIndexNode(HeroNode head,int k){
        int size = getLength(head);
        if (head.next == null || k > size || k <= 0){
            return null;
        }

        //法一：
//        HeroNode temp = head;
//        int count = 1;
//        while(count != (size - k + 1)){
//            temp = temp.next;
//            count++;
//        }
//        return temp.next;

        //法二：
        HeroNode temp = head.next;
        for (int i = 0;i<size-k;i++){
            temp = temp.next;
        }
        return temp;
    }


}
