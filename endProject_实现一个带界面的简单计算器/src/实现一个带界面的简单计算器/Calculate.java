package ʵ��һ��������ļ򵥼�����;

/**�õ��������**/
import java.util.List;//�����ӿ���
import java.util.ArrayList;//������
import java.util.Stack;//ջ��
import java.text.DecimalFormat;//���ִ�����

/**��һ�� ��׺���ʽת��Ϊ��׺���ʽ��Ȼ����ֵ**/
public class  Calculate {
	
    /**��׺���ʽת��Ϊ��׺���ʽ**/
    public static List<String> nifToSuf(char[] str) {
        List<String> exp = new ArrayList<>();//�洢�м����Ķ���
        Stack<Character> op = new Stack<>();//�����ջ
        StringBuilder sb = new StringBuilder("");//�洢���ֵ��ַ���
        for (int i = 0; i < str.length; i++) {
            // ���������
            if ((i == 0 && str[i] != '(') || (i != 0 && isDigit(str[i], str[i - 1]))) {
                sb.append(str[i]);
                // ��������һλ������һλ���ַ���������ӵ�exp����,sb���
                if (i == str.length - 1 || (i + 1 < str.length && isSymbol(str[i + 1]))){
                    exp.add(sb.toString());
                    sb = new StringBuilder("");
                }
            }
           //���������
            else if (isBracket(str[i])) {
                // ����������ţ�ֱ����opջ
                if (str[i] == '(') {
                    op.push(str[i]);
                } 
                //����������ţ���opջ��ջ ��ӵ�expֱ������'(',����һ�� '(' ')' ��ȥ
                else {                   
                    char temp;
                    while ((temp = op.pop()) != '(') {
                        exp.add(temp + "");
                    }
                }   
            } 
           //����ǲ�����
            else if (isOperation(str[i])) {
                while (true) {
                    // �յ�ջֱ����ջ
                    if (op.isEmpty()) {
                        op.push(str[i]);
                        break;                       
                    } 
                   //���ջ���ķ������ȼ�С��ɨ�赽�ķ��ţ���ջ
                    else if (getPriority(op.peek()) < getPriority(str[i])) {
                        op.push(str[i]);
                        break;                      
                    } 
                    //ջ���ķ������ȼ����ڵ��� ɨ�赽�ķ��ţ����ջ��exp,������ɨ��ջ����һ������
                    else {
                        exp.add(op.pop() + "");
                    }
                }
            }
        }
        // ��ʣ��ķ���ȫ����exp
        while (!op.isEmpty()) {
            exp.add(op.pop() + "");
        }
        return exp;
    }
   
    /**����������׺���ʽ**/
    public static Double calExpression(List<String> Exp) {
        Stack<Double> numStack = new Stack<>();
        for (String str : Exp) {
            // ������������������ջ�����ֵ���������ٽ�����ջ
            if (str.length() == 1 && isOperation(str.charAt(0))) {
                double num2 = numStack.pop();
                double num1 = numStack.pop();
                numStack.push(calTwoNum(num1, num2, str));
            } 
            //��������֣���ֱ����ջ
            else {
                numStack.push(new Double(str));
            }
        }
        //����ջ��Ԫ��
        return numStack.peek();
    }
    /**����������**/
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
        throw new RuntimeException("ERROR��");
    }

    /**��ȡ���ȼ�**/
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
        throw new RuntimeException("���ǼӼ��˳�����(");
    }  
    
    /**�ж��Ƿ�Ϊ����**/
    public static boolean isDigit(char ch, char leftBracket) {
        // ���ǰһ���������ţ��ұߵ����ֿ��ܴ���������
        if (leftBracket == '(') {
            return ch == '-' || ch == '+' || (ch >= 48 && ch <= 57);
        }
        // ǰһ�����Ų��������ţ���chֻ�������ֻ�С����
        return (ch >= 48 && ch <= 57) || ch == '.';
    }
    /**�ж��Ƿ�Ϊ�����**/
    public static boolean isOperation(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
    /**�ж��Ƿ�Ϊ����**/
    public static boolean isBracket(char ch) {
        return ch == '(' || ch == ')';
    }
    /**�ж��Ƿ�Ϊ����**/
    public static boolean isSymbol(char ch) {
        return isOperation(ch) || isBracket(ch);
    }
}

