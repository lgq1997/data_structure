package queue;

import java.util.Scanner;

//使用数组模拟队列
public class queue1 {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
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

class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    //构造器
    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        arr = new int[this.maxSize];
        this.front = -1;
        this.rear = -1;
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        if(!isFull()){//队列没有满
            rear ++;
            arr[rear] = n;
        }else {
            System.out.println("队列已满");
        }
    }

    //出队列
    public int getQueue(){
        if(!isEmpty()){//队列非空时才可以出队列
            front++;
            return arr[front];
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
//            for(int i = front+1;i<=rear;i++) {
//                System.out.println(arr[i]);
//            }
            for(int i = 0;i<arr.length;i++){
                System.out.printf("arr[%d] = %d\n",i,arr[i]);
            }
        }
    }

    //显示队列头部数据
    public int headQueue(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }

}