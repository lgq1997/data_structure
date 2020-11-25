package stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(4);
        String key = "";
        boolean loop = true;//控制是否退出菜单
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show:显示栈");
            System.out.println("exit：退出程序");
            System.out.println("push：添加数据到栈");
            System.out.println("pop：出栈");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key){
                case "show":
                    as.list();
                    break;
                case "push":
                    System.out.println("请输入你要添加的数据：");
                    int v = scanner.nextInt();
                    as.push(v);
                    break;
                case "pop":
                    try {
                        int value = as.pop();
                        System.out.println("出栈的数据为：" + value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());;
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    System.out.println("输入有误，清重新输入");
                    break;

            }
        }
        System.out.println("程序退出");

    }
}

//定义一个ArrayStack，表示栈
class ArrayStack{
    private int maxSize;//栈的大小
    private  int[] stack;//数组模拟栈
    private int top = -1;//栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }

    //栈空
    public  boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空，没有数据");
        }
        int res = stack[top];
        top--;
        return res;
    }

    //遍历栈
    public void list(){
        if (isEmpty()){
            System.out.println("栈空，无法遍历");
            return;
        }
        for (int i = top;i>=0;i--){
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }
    }

}
