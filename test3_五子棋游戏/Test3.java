package 五子棋游戏;
import java.util.Scanner;
import java.util.Arrays;
class Gobang {
    // 初始化成员变量，落子区域：16*16
    // 用单例模式实现有且只有一个棋盘
    private char[][] chessboard = new char[17][17];
    private static Gobang gb = new Gobang();

    // 私有化无参构造方法： 绘制棋盘且提示黑子先手
    private Gobang() {
        for(int i = 0; i < 17; i++) {
            for(int j = 0; j < 17; j++) {
                if (0 == i && 0 == j) {
                    chessboard[i][j] = (char)32;
                } else if (0 == i && j <= 10) { //控制第一行的情况
                    chessboard[i][j] = (char)(j - 1 + 48);
                } else if (0 == i && j <= 16) {
                    chessboard[i][j] = (char)(j - 11 + 97);
                } else if (0 == j && i <= 10) { // 控制第一列的情况
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

    // 单例模式：从类层级获取棋盘
    public static Gobang getGobang() {
        return gb;
    }
    // 绘制棋盘的成员方法
    public void drawChessboard(boolean flag) {
        System.out.println("----------------------五子棋游戏-------------------");
        System.out.println("-----------------作者：Vigoroushui------------------");
        for(int i = 0; i < 17; i++){
            for(int j = 0; j < 17; j++) {
                System.out.print(chessboard[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }
        if(true == flag) {
            System.out.println("--------------------轮到黑方下棋--------------------");
        } else {
            System.out.println("--------------------轮到白方下棋--------------------");
        }
    }
    // 判断落子合理性的成员方法
    public String judgeRationality(String n) {
        int judge = 0;
        // 判断当前落子是否超出界限 [0,9]&&[a,f]
        for(int i = 1; i < 17; i++) {
            if(String.valueOf(chessboard[0][i]).equals(n)) {
                judge = 1;
                break;
            }
        }
        // 如果落子越界,给定"outer"标示符
        if(1 != judge) {
            return "outer";
        }
        return n;
    }
    // 开始五子棋游戏的成员方法
    public void playChess() {
        boolean flag = true; //用于控制黑白两方落子的标示符，true代表黑方落子，false代表白方落子
        Scanner sc = new Scanner(System.in);
        while(true) {
            //合理值的判断
            System.out.println("请输入您要落子的行位置和列位置（如: a 4）:");
            int cow, column;
            while(true) {
                String a = judgeRationality(sc.next());
                String b = judgeRationality(sc.next());
                // 判断落子是否越界
                if ("outer".equals(a) || "outer".equals(b)) {
                    System.out.println("您落子落到棋盘外面去了,请重新落子：");
                }else {
                    // 将输入的值转为二维数组对应的行列下标
                    cow = (int) a.charAt(0) + 1 - 48;
                    column = (int) b.charAt(0) + 1 - 48;
                    if (cow >= 11) {
                        cow = (int) a.charAt(0) + 11 - 97;
                    }
                    if (column >= 11) {
                        column = (int) b.charAt(0) + 11 - 97;
                    }
                    //判断落子是否已存在
                    if ('&' == chessboard[cow][column] || '#' == chessboard[cow][column]) {
                        System.out.println("您落子的位置已有棋子，请重新落子：");
                    }else {
                        break;
                    }
                }
            }
            // 落子
            if(flag) {
                chessboard[cow][column] = (char) 38; // 用 & 代表黑方落子
            } else {
                chessboard[cow][column] = (char) 35; // 用 # 代表白方落子
            }
            // 判断是否胜利，若胜利，则退出循环
            boolean win = isWin(cow, column);
            if(win && flag){
                System.out.println("恭喜黑子获胜！");
                drawChessboard(true);
                break;
            }else if(win && !flag) {
                System.out.println("恭喜白子获胜！");
                drawChessboard(false);
                break;
            }
            // 交换对手并重新绘制棋盘
            flag = !flag;
            drawChessboard(flag);
        }
    }
    // 判断是否胜利的成员方法
    public boolean isWin(int cow, int column) {
        int highBound = 16;
        int lowBound = 1;
        // 每次落子连成线只可能有4种情况： 横、纵、左斜、右斜
        // 创建4个一维数组分别保存四个方向上9个子
        char[] cowChess = {'*', '*', '*', '*', '*', '*', '*', '*', '*'};
        char[] columnChess = {'*', '*', '*', '*', '*', '*', '*', '*', '*'};
        char[] leftDiagonal = {'*', '*', '*', '*', '*', '*', '*', '*', '*'};
        char[] rightDiagonal = {'*', '*', '*', '*', '*', '*', '*', '*', '*'};
        rightDiagonal[4] = leftDiagonal[4] = columnChess[4] = cowChess[4] = chessboard[cow][column];
        // 生成4个方向的成线数组， 例如：横方向 + + + + & & + + +
        for (int i = 1; i <= 4; i++) {
            // 生成横方向的成线情况
            if (column - i >= lowBound) {
                cowChess[4 - i] = chessboard[cow][column - i];
            }
            if (column + i <= highBound) {
                cowChess[4 + i] = chessboard[cow][column + i];
            }
            // 生成纵方向的成线情况
            if (cow - i >= lowBound) {
                columnChess[4 - i] = chessboard[cow - i][column];
            }
            if (cow + i <= highBound) {
                columnChess[4 + i] = chessboard[cow + i][column];
            }
            // 生成左斜方向上的成线情况
            if (cow - i >= lowBound && column - i >= lowBound) {
                leftDiagonal[4 + i] = chessboard[cow - i][column - i];
            }
            if (cow + i <= highBound && column + i <= highBound) {
                leftDiagonal[4 - i] = chessboard[cow + i][column + i];
            }
            // 生成右斜方向上的成线情况
            if (cow - i >= lowBound && column + i <= highBound) {
                rightDiagonal[4 + i] = chessboard[cow - i][column + i];
            }
            if (column - i >= lowBound && cow + i <= highBound) {
                rightDiagonal[4 - i] = chessboard[cow + i][column - i];
            }
        }
        // 判断4个方向是否存在五子连珠的情况
        boolean resCowChess = fiveSons(cowChess, cow, column);
        boolean resColumnChess = fiveSons(columnChess, cow, column);
        boolean resLeftDiagonal = fiveSons(leftDiagonal, cow, column);
        boolean resRightDiagonal = fiveSons(rightDiagonal, cow, column);
        // 若有一个方向上的存在五子连珠的情况，则胜利
        if(resCowChess || resColumnChess || resLeftDiagonal || resRightDiagonal) {
            return true;
        }else {
            return false;
        }
    }
    // 判断五子连珠的方法，形参为有9个字符的数组(对应四个方向)， 当前落子的行和列
    // 该方法只用于isWin()成员方法中，本质是一维数组中找连续相同的字串
    private boolean fiveSons(char[] sons, int cow, int column) {
        int count = 1; // 统计连续子的个数
        for(int i = 0; i < 5;) {
            if (sons[i] == chessboard[cow][column]) {
                for (int j = i + 1; j < 9; j++) {
                    if(sons[j] == sons[j - 1]) {
                        count += 1;
                        if(5 == count) return true; // 若找到五子连珠的情况，则返回胜利标示符true
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
        Gobang g2 = Gobang.getGobang(); // g和g2指向同一个棋盘
	}
}
