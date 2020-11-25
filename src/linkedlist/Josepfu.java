package linkedlist;

//约瑟夫问题
public class Josepfu {
    public static void main(String[] args) {
        //测试
        CircleSingleLinkedList csll = new CircleSingleLinkedList();
        csll.addKid(5);
        csll.showKid();
        System.out.println("***节点出圈***");
        csll.countKid(1,2,5);

    }
}

//创建一个环形单向链表
class CircleSingleLinkedList{
    //创建一个first节点
    private Kid first = new Kid(-1);


    //构建节点数为nums的环形链表
    public void addKid(int nums){
        //nums做一个数据校验
        if (nums < 1){
            System.out.println("nums值不正确");
        }
        //使用for循环创建环形链表
        Kid curKid = null;//辅助指针，帮助构建环形链表
        for (int i = 1;i <= nums;i++){
            //根据编号，创建节点
            Kid kid = new Kid(i);
            //如果是第一个节点，
            if (i == 1){
                first = kid;
                first.setNext(first);
                curKid = first;
            }else {
                curKid.setNext(kid);
                kid.setNext(first);
                curKid = kid;
            }

        }
    }

    //遍历环形链表
    public void showKid(){
        if (first == null){
            System.out.println("链表为空");
        }
        Kid curKid = first;
        while (true){
            System.out.printf("节点的编号为%d\n",curKid.getNo());
            if (curKid.getNext() == first){//到链表尾了
                break;
            }
            curKid = curKid.getNext();
        }
    }

    //根据用户输入，计算节点出圈的顺序
    /*
    startNo：表示从第几个节点开始数
    count：表示数了几下
    nums：表示最初链表的节点数
     */
    public void countKid(int startNo,int count,int nums){
        if (first == null || startNo < 1 || startNo > nums){//链表为空、开始的编号小于1、开始的编号大于节点总数
            System.out.println("参数输入有误");
        }
        //创建辅助指针，指向要出圈的前一个节点,所以初始值是first的前一个节点
        Kid helper = first;
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }

        //报数前先定位,first和helper同时移动startNo-1次，此时first指向要报数的第一个元素，helper指向first的前一个元素
        for (int i = 0;i<startNo-1;i++){
            first = first.getNext();
            helper = helper.getNext();
        }

        //开始报数，
        while (true){
            if (helper == first){//此时权重只有一个元素
                break;
            }
            //同时移动count-1次
            for (int j = 0;j < count - 1;j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("节点%d出圈\n",first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        //将最后留在圈中的那个节点输出
        System.out.printf("节点%d出圈\n",first.getNo());
    }
}

//创建一个Kid类，表示一个节点
class Kid{
    private int no;//编号
    private Kid next;//指向下一个节点
    public Kid(int no) {
        this.no = no;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public Kid getNext() {
        return next;
    }
    public void setNext(Kid next) {
        this.next = next;
    }
}
