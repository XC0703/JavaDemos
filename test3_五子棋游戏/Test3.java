package ��������Ϸ;
import java.util.Scanner;
import java.util.Arrays;
class Gobang {
    // ��ʼ����Ա��������������16*16
    // �õ���ģʽʵ������ֻ��һ������
    private char[][] chessboard = new char[17][17];
    private static Gobang gb = new Gobang();

    // ˽�л��޲ι��췽���� ������������ʾ��������
    private Gobang() {
        for(int i = 0; i < 17; i++) {
            for(int j = 0; j < 17; j++) {
                if (0 == i && 0 == j) {
                    chessboard[i][j] = (char)32;
                } else if (0 == i && j <= 10) { //���Ƶ�һ�е����
                    chessboard[i][j] = (char)(j - 1 + 48);
                } else if (0 == i && j <= 16) {
                    chessboard[i][j] = (char)(j - 11 + 97);
                } else if (0 == j && i <= 10) { // ���Ƶ�һ�е����
                    chessboard[i][j] = (char)(i - 1 + 48) ;
                } else if (0 == j && i <= 16) {
                    chessboard[i][j] = (char)(i - 11 + 97);
                } else {
                    chessboard[i][j] = (char)43;
                }
            }
        }
        drawChessboard(true);
    }

    // ����ģʽ������㼶��ȡ����
    public static Gobang getGobang() {
        return gb;
    }
    // �������̵ĳ�Ա����
    public void drawChessboard(boolean flag) {
        System.out.println("----------------------��������Ϸ-------------------");
        System.out.println("-----------------���ߣ�Vigoroushui------------------");
        for(int i = 0; i < 17; i++){
            for(int j = 0; j < 17; j++) {
                System.out.print(chessboard[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }
        if(true == flag) {
            System.out.println("--------------------�ֵ��ڷ�����--------------------");
        } else {
            System.out.println("--------------------�ֵ��׷�����--------------------");
        }
    }
    // �ж����Ӻ����Եĳ�Ա����
    public String judgeRationality(String n) {
        int judge = 0;
        // �жϵ�ǰ�����Ƿ񳬳����� [0,9]&&[a,f]
        for(int i = 1; i < 17; i++) {
            if(String.valueOf(chessboard[0][i]).equals(n)) {
                judge = 1;
                break;
            }
        }
        // �������Խ��,����"outer"��ʾ��
        if(1 != judge) {
            return "outer";
        }
        return n;
    }
    // ��ʼ��������Ϸ�ĳ�Ա����
    public void playChess() {
        boolean flag = true; //���ڿ��ƺڰ��������ӵı�ʾ����true����ڷ����ӣ�false����׷�����
        Scanner sc = new Scanner(System.in);
        while(true) {
            //����ֵ���ж�
            System.out.println("��������Ҫ���ӵ���λ�ú���λ�ã���: a 4��:");
            int cow, column;
            while(true) {
                String a = judgeRationality(sc.next());
                String b = judgeRationality(sc.next());
                // �ж������Ƿ�Խ��
                if ("outer".equals(a) || "outer".equals(b)) {
                    System.out.println("�������䵽��������ȥ��,���������ӣ�");
                }else {
                    // �������ֵתΪ��ά�����Ӧ�������±�
                    cow = (int) a.charAt(0) + 1 - 48;
                    column = (int) b.charAt(0) + 1 - 48;
                    if (cow >= 11) {
                        cow = (int) a.charAt(0) + 11 - 97;
                    }
                    if (column >= 11) {
                        column = (int) b.charAt(0) + 11 - 97;
                    }
                    //�ж������Ƿ��Ѵ���
                    if ('&' == chessboard[cow][column] || '#' == chessboard[cow][column]) {
                        System.out.println("�����ӵ�λ���������ӣ����������ӣ�");
                    }else {
                        break;
                    }
                }
            }
            // ����
            if(flag) {
                chessboard[cow][column] = (char) 38; // �� & ����ڷ�����
            } else {
                chessboard[cow][column] = (char) 35; // �� # ����׷�����
            }
            // �ж��Ƿ�ʤ������ʤ�������˳�ѭ��
            boolean win = isWin(cow, column);
            if(win && flag){
                System.out.println("��ϲ���ӻ�ʤ��");
                drawChessboard(true);
                break;
            }else if(win && !flag) {
                System.out.println("��ϲ���ӻ�ʤ��");
                drawChessboard(false);
                break;
            }
            // �������ֲ����»�������
            flag = !flag;
            drawChessboard(flag);
        }
    }
    // �ж��Ƿ�ʤ���ĳ�Ա����
    public boolean isWin(int cow, int column) {
        int highBound = 16;
        int lowBound = 1;
        // ÿ������������ֻ������4������� �ᡢ�ݡ���б����б
        // ����4��һά����ֱ𱣴��ĸ�������9����
        char[] cowChess = {'*', '*', '*', '*', '*', '*', '*', '*', '*'};
        char[] columnChess = {'*', '*', '*', '*', '*', '*', '*', '*', '*'};
        char[] leftDiagonal = {'*', '*', '*', '*', '*', '*', '*', '*', '*'};
        char[] rightDiagonal = {'*', '*', '*', '*', '*', '*', '*', '*', '*'};
        rightDiagonal[4] = leftDiagonal[4] = columnChess[4] = cowChess[4] = chessboard[cow][column];
        // ����4������ĳ������飬 ���磺�᷽�� + + + + & & + + +
        for (int i = 1; i <= 4; i++) {
            // ���ɺ᷽��ĳ������
            if (column - i >= lowBound) {
                cowChess[4 - i] = chessboard[cow][column - i];
            }
            if (column + i <= highBound) {
                cowChess[4 + i] = chessboard[cow][column + i];
            }
            // �����ݷ���ĳ������
            if (cow - i >= lowBound) {
                columnChess[4 - i] = chessboard[cow - i][column];
            }
            if (cow + i <= highBound) {
                columnChess[4 + i] = chessboard[cow + i][column];
            }
            // ������б�����ϵĳ������
            if (cow - i >= lowBound && column - i >= lowBound) {
                leftDiagonal[4 + i] = chessboard[cow - i][column - i];
            }
            if (cow + i <= highBound && column + i <= highBound) {
                leftDiagonal[4 - i] = chessboard[cow + i][column + i];
            }
            // ������б�����ϵĳ������
            if (cow - i >= lowBound && column + i <= highBound) {
                rightDiagonal[4 + i] = chessboard[cow - i][column + i];
            }
            if (column - i >= lowBound && cow + i <= highBound) {
                rightDiagonal[4 - i] = chessboard[cow + i][column - i];
            }
        }
        // �ж�4�������Ƿ����������������
        boolean resCowChess = fiveSons(cowChess, cow, column);
        boolean resColumnChess = fiveSons(columnChess, cow, column);
        boolean resLeftDiagonal = fiveSons(leftDiagonal, cow, column);
        boolean resRightDiagonal = fiveSons(rightDiagonal, cow, column);
        // ����һ�������ϵĴ�������������������ʤ��
        if(resCowChess || resColumnChess || resLeftDiagonal || resRightDiagonal) {
            return true;
        }else {
            return false;
        }
    }
    // �ж���������ķ������β�Ϊ��9���ַ�������(��Ӧ�ĸ�����)�� ��ǰ���ӵ��к���
    // �÷���ֻ����isWin()��Ա�����У�������һά��������������ͬ���ִ�
    private boolean fiveSons(char[] sons, int cow, int column) {
        int count = 1; // ͳ�������ӵĸ���
        for(int i = 0; i < 5;) {
            if (sons[i] == chessboard[cow][column]) {
                for (int j = i + 1; j < 9; j++) {
                    if(sons[j] == sons[j - 1]) {
                        count += 1;
                        if(5 == count) return true; // ���ҵ����������������򷵻�ʤ����ʾ��true
                    }else {
                        count = 1;
                        i = j;
                        break;
                    }
                }
            }
            i++;
        }
        return false;
    }
}
public class Test3 {
	public static void main(String[] args) {
        Gobang g = Gobang.getGobang();
        g.playChess();
        Gobang g2 = Gobang.getGobang(); // g��g2ָ��ͬһ������
	}
}
