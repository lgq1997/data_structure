package linkedlist;

import java.util.Stack;

/*
单链表的练习：
1.获取链表有效节点的个数(不包括头结点)
2.查找单链表中倒数第k个节点,找不到返回null
3.单链表的反转
4.从尾到头打印单链表,不改变原链表的结构（使用栈）
5.合并两个有序单链表，使其合并后依然有序
 */
public class Exercise {
    public static void main(String[] args) {
        //创建一些节点
        HeroNode h1 = new HeroNode(0,"aa","aaa");
        HeroNode h2 = new HeroNode(1,"bb","bbb");
        HeroNode h3 = new HeroNode(2,"cc","ccc");
        HeroNode h4 = new HeroNode(3,"dd","ddd");
        //创建一个链表
        SingleLinkerList sll = new SingleLinkerList();
        sll.add(h2);
        sll.add(h4);
        sll.add(h1);
        sll.add(h3);
        sll.list();
        //1.链表长度
        System.out.printf("该链表的长度为：%d\n",getLength(sll.getHead()));
        //2.查找链表倒数第k个节点
        System.out.println(findLastIndexNode(sll.getHead(),2));
        //3.反转链表
        System.out.println("反转前");
        sll.list();
        reverseList(sll.getHead());
        System.out.println("反转后");
        sll.list();
        //4.逆序打印链表
        System.out.println("逆序打印链表");
        reversePrint(sll.getHead());
        //*****************************************************//
        //5.合并两个有序单链表，使其合并后依然有序
        System.out.println("合并两个有序链表");
        SingleLinkerList sll1 = new SingleLinkerList();
        SingleLinkerList sll2 = new SingleLinkerList();
        sll1.addByOrder(h1);
        sll1.addByOrder(h3);
        sll2.addByOrder(h4);
        sll2.addByOrder(h2);
        HeroNode hd = concat(sll1.getHead(),sll2.getHead());
        while (hd.next != null){
            System.out.println(hd.next);
            hd = hd.next;
        }


    }

    //一些练习：
    //1.获取链表有效节点的个数(不包括头结点)
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

    //2.查找单链表中倒数第k个节点,找不到返回null
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

    //3.单链表的反转
    public static void reverseList(HeroNode head){
        if (head.next == null || head.next.next == null){
            return;
        }
        HeroNode cur = head.next;//记录要加进新链表的节点
        HeroNode next = cur.next;//记录要加进节点的下一个节点（防止链表断裂）
        HeroNode reverseHead = new HeroNode();//新链表的头
        while(cur != null){
            next = cur.next;//先储存要加入链表的节点的下一个节点，防止链表断裂
            //将节点插入新的链表
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    //4.从尾到头打印单链表,不改变原链表的结构（使用栈）
    public static void reversePrint(HeroNode head){
        if (head.next == null){
            return;
        }
        //创建一个栈
        Stack<HeroNode> stack = new Stack<>();
        //遍历原链表，将原链表的节点压入栈中
        HeroNode temp = head.next;
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }

        //遍历栈，将栈中的节点出栈，打印
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }

    //5.合并两个有序单链表，使其合并后依然有序
    public static HeroNode concat(HeroNode head1,HeroNode head2){
        //思路：把head2的节点按照顺序插入head1中
        HeroNode res = new HeroNode();
        //特殊情况：head1或和head2为空
        if (head1.next == null || head2.next == null){
            res.next = head1.next == null?head2.next:head1.next;
            return res;
        }
        //正文：head1和head2都不为空时：
        //将其中一个链表赋给res，便利另一个链表，按顺序插入res中
        res.next = head1.next;//要返回的链表
        HeroNode cur2 = head2.next;//要插入res的节点
        HeroNode cur2next = head2.next.next;//防止head2链表断裂
        while(cur2 != null){//遍历head2链表
            cur2next = cur2.next;
            HeroNode cur1 = res;
            while (cur1 != null){//遍历head1链表，将和head2链表的值插入head1中合适的位置
                //如果下一个节点编号大于要加入的节点，或者已经遍历到链表尾，将节点插入到链表res中
                if (cur1.next == null || cur1.next.no > cur2.no){
                    cur2.next = cur1.next;
                    cur1.next = cur2;
                    break;
                }
                cur1 = cur1.next;
            }
            cur2 = cur2next;
        }
        return res;
    }

}
