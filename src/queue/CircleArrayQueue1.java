package queue;
/*
一、环形队列：
1.front：指向头部元素；rear：指向尾部元素的后一个元素
2.使用sign作为标志位，区分队列满和空
 */
import java.util.Scanner;

//环形队列
public class CircleArrayQueue1 {
    public static void main(String[] args) {
        System.out.println("测试");
        CircleArray1 arrayQueue = new CircleArray1(3);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出队列");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            System.out.println("t(tail):查看队列尾部数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    int num = scanner.nextInt();
                    arrayQueue.addQueue(num);
                    break;
                case 'g':
                    try{
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数字是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res = arrayQueue.headQueue();
                        System.out.printf("头部的数字是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 't':
                    try{
                        int res = arrayQueue.tailQueue();
                        System.out.printf("尾部的数字是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                default:
                    break;
            }
        }
        System.out.println("程序退出");

    }
}

class CircleArray1{
    private int maxSize;
    private int front;//指向头部元素
    private int rear;//指向尾部元素的后一个元素
    private int[] arr;
    private int sign;
    //构造器
    public CircleArray1(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        arr = new int[this.maxSize];
        this.front = 0;//不赋值也可以，int型默认值为0
        this.rear = 0;
        this.sign = 0;
    }
    //判断队列是否满
    public boolean isFull(){
        return sign == 1 && rear == front;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return sign == 0 && rear == front;
    }
    //添加数据到队列（添加元素时才可能发生rear追上front，使队列为满）
    public void addQueue(int n){
        if(!isFull()){//队列没有满
            arr[rear] = n;
            rear = (rear + 1)%maxSize;
            sign = 1;//添加元素会使sign为1
        }else {
            System.out.println("队列已满");
        }
    }
    //出队列（出队列时才可能发生front追上rear，使队列为空）
    public int getQueue(){
        if(!isEmpty()){//队列非空时才可以出队列
            int res = arr[front];
            front = (front + 1)%maxSize;
            sign = 0;//出队列会使sign变为0
            return res;
        }else{
            throw new RuntimeException("队列为空，不能取数据");
        }
    }
    //显示队列所有数据
    public void showQueue(){
        //遍历
        if(isEmpty()){
            System.out.println("队列为空，无法遍历");
        }else {
            for(int i = front;i<front + size();i++) {
                System.out.printf("arr[%d] = %d\n",i % maxSize,arr[i % maxSize]);
            }
        }
    }
    //求出当前队列有效数据的个数
    public int size(){
        if(isFull()){//队列为满时rear=front，不能用下边的方式计算
            return maxSize;
        }
        return (rear + maxSize - front) % maxSize;
    }
    //显示队列头部数据
    public int headQueue(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
    //显示尾部数据，注意rear=0时没有-1这个索引
    public int tailQueue(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            throw new RuntimeException("队列为空");
        }
        return arr[(rear - 1 + maxSize) % maxSize];
    }
}



