package stack;
/*
用栈实现计算器，给出几个计算式，计算结果
（有bug，如9-2+3+3，遍历完后占中的表达式应从前往后计算，而栈是从后往前取的）
 */

public class Caculator {
    public static void main(String[] args) {
        //计算表达式
        String str = "6-2-2";
        //创建两个栈，数栈和符号栈
        ArrayStack2 asNum = new ArrayStack2(10);
        ArrayStack2 asOper = new ArrayStack2(10);
        //定义相关变量
        int index = 0;//用于扫描表达式
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        //扫描表达式
        while(true){
            ch = str.charAt(index);
            if (asOper.isOper(ch)){//如果扫描到的是个符号
                if (asOper.isEmpty()){//如果栈为空，直接入栈
                    asOper.push(ch);
                }else {//栈不为空，继续操作
                    if (asOper.priority(ch) <= asOper.priority(asOper.peek())){//当前运算符优先级小于等于栈中的优先级
                        num1 = asNum.pop();
                        num2 = asNum.pop();
                        oper = asOper.pop();
                        res = asNum.cal(num1,num2,oper);//计算
                        asNum.push(res);//计算结果入数栈
                        asOper.push(ch);//运算符入符号栈
                    }else {//如果当前优先级大于栈内的优先级，当前符号入栈
                        asOper.push(ch);
                    }
                }
            }else {//如果扫描到的是数字,可能是多位数
                keepNum += ch;
                if (index == str.length()-1){
                    asNum.push(Integer.parseInt(keepNum));
                }else {
                    //判断下一个字符是不是数字
                    if (asOper.isOper(str.charAt(index + 1))) {
                        asNum.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }

            }
            index++;
            if (index >= str.length()){//扫描完毕
                break;
            }
        }
        while (true){
            if (asOper.isEmpty()){//符号栈空了，测运算完毕
                break;
            }
            num1 = asNum.pop();
            num2 = asNum.pop();
            oper = asOper.pop();
            res = asNum.cal(num1,num2,oper);//计算
            asNum.push(res);//计算结果入数栈
        }
        System.out.printf("表达式%s = %d",str,asNum.pop());
    }

}



//创建一个栈
class ArrayStack2 {
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈
    private int top = -1;//栈顶

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //扩展功能一：返回运算符优先级，数字越大，优先级越高
    public int priority(int oper) {//java中int和char可以混用
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    //扩展功能二：判断是否是一个运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //扩展功能三：计算
    public int cal(int num1,int num2,int oper){
        int res = 0;//用于存放计算结果
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

    //返回当前栈顶的值，不出栈
    public int peek(){
        return stack[top];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        int res = stack[top];
        top--;
        return res;
    }

    //遍历栈
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，无法遍历");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }
}