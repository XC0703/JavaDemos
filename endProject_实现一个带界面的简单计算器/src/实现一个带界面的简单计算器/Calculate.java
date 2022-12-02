package 实现一个带界面的简单计算器;

/**用到的组件类**/
import java.util.List;//容器接口类
import java.util.ArrayList;//容器类
import java.util.Stack;//栈类
import java.text.DecimalFormat;//数字处理类

/**将一个 中缀表达式转化为后缀表达式，然后求值**/
public class  Calculate {
	
    /**中缀表达式转化为后缀表达式**/
    public static List<String> nifToSuf(char[] str) {
        List<String> exp = new ArrayList<>();//存储中间结果的队列
        Stack<Character> op = new Stack<>();//运算符栈
        StringBuilder sb = new StringBuilder("");//存储数字的字符串
        for (int i = 0; i < str.length; i++) {
            // 如果是数字
            if ((i == 0 && str[i] != '(') || (i != 0 && isDigit(str[i], str[i - 1]))) {
                sb.append(str[i]);
                // 如果是最后一位或者下一位是字符，数字添加到exp队列,sb清空
                if (i == str.length - 1 || (i + 1 < str.length && isSymbol(str[i + 1]))){
                    exp.add(sb.toString());
                    sb = new StringBuilder("");
                }
            }
           //如果是括号
            else if (isBracket(str[i])) {
                // 如果是左括号，直接入op栈
                if (str[i] == '(') {
                    op.push(str[i]);
                } 
                //如果是右括号，将op栈出栈 添加到exp直到遇到'(',将这一对 '(' ')' 舍去
                else {                   
                    char temp;
                    while ((temp = op.pop()) != '(') {
                        exp.add(temp + "");
                    }
                }   
            } 
           //如果是操作符
            else if (isOperation(str[i])) {
                while (true) {
                    // 空的栈直接入栈
                    if (op.isEmpty()) {
                        op.push(str[i]);
                        break;                       
                    } 
                   //如果栈顶的符号优先级小于扫描到的符号，入栈
                    else if (getPriority(op.peek()) < getPriority(str[i])) {
                        op.push(str[i]);
                        break;                      
                    } 
                    //栈顶的符号优先级大于等于 扫描到的符号，则出栈给exp,并继续扫描栈顶下一个符号
                    else {
                        exp.add(op.pop() + "");
                    }
                }
            }
        }
        // 将剩余的符号全部入exp
        while (!op.isEmpty()) {
            exp.add(op.pop() + "");
        }
        return exp;
    }
   
    /**计算整个后缀表达式**/
    public static Double calExpression(List<String> Exp) {
        Stack<Double> numStack = new Stack<>();
        for (String str : Exp) {
            // 如果是运算符，则将两个栈顶数字弹出后计算再进行入栈
            if (str.length() == 1 && isOperation(str.charAt(0))) {
                double num2 = numStack.pop();
                double num1 = numStack.pop();
                numStack.push(calTwoNum(num1, num2, str));
            } 
            //如果是数字，则直接入栈
            else {
                numStack.push(new Double(str));
            }
        }
        //返回栈顶元素
        return numStack.peek();
    }
    /**计算两个数**/
    public static Double calTwoNum(double num1, double num2, String op) {
        switch (op) {
            case "+":
                return num1+num2;
            case "-":
                return num1-num2;
            case "*":
                return num1*num2;
            case "/":
                DecimalFormat format = new DecimalFormat("#.0000");
                String str = format.format(num1/num2);
                return Double.parseDouble(str);
        }
        throw new RuntimeException("ERROR！");
    }

    /**获取优先级**/
    public static int getPriority(char ch) {
        switch (ch) {
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        throw new RuntimeException("不是加减乘除或者(");
    }  
    
    /**判断是否为数字**/
    public static boolean isDigit(char ch, char leftBracket) {
        // 如果前一个是左括号，右边的数字可能带有正负号
        if (leftBracket == '(') {
            return ch == '-' || ch == '+' || (ch >= 48 && ch <= 57);
        }
        // 前一个符号不是左括号，则ch只能是数字或小数点
        return (ch >= 48 && ch <= 57) || ch == '.';
    }
    /**判断是否为运算符**/
    public static boolean isOperation(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
    /**判断是否为括号**/
    public static boolean isBracket(char ch) {
        return ch == '(' || ch == ')';
    }
    /**判断是否为符号**/
    public static boolean isSymbol(char ch) {
        return isOperation(ch) || isBracket(ch);
    }
}

