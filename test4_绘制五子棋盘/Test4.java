package 绘制五子棋盘;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Test4 extends JFrame {

	//背景图片
    BufferedImage image;

    {
        try {
            image = ImageIO.read(new File("src/主题背景.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //创建画板内部类
    class myJPanel extends JPanel{
        //绘制方法
        @Override
        public void paint(Graphics g) {
            //强制类型转换得到Graphics子类Graphics2D对象
            Graphics2D g2 = (Graphics2D)g;//又得到一支笔
            //先JPanel绘制背景图片
            g2.drawImage(image,0,0,1600,900,null);
            //设置画笔颜色
            g2.setColor(Color.CYAN);
            //填充规定区域
            g2.fill3DRect(50, 50, 700, 700, true);

            //再设置画笔颜色，画直线
            g2.setColor(Color.black);
            //设置画出直线的宽度
            g2.setStroke(new BasicStroke(3));

            //绘制下棋区域
            for(int i = 1;i < 16;i ++) {
                g2.drawLine(50,50*i,750,50*i );
            }
            for(int i = 1;i < 16;i ++) {
                g2.drawLine(50*i,50,50*i,750 );
            }

            //画外框
            //设置画笔宽度
            g2.setStroke(new BasicStroke(5));
            g2.drawLine(25,25,775, 25);
            g2.drawLine(25,775,775, 775);
            g2.drawLine(25,25,25, 775);
            g2.drawLine(775,25,775, 775);

            //画四个黑色圆
            g2.fillOval(240, 240, 20, 20);
            g2.fillOval(540, 240, 20, 20);
            g2.fillOval(240, 540, 20, 20);
            g2.fillOval(540, 540, 20, 20);

            //填充框框与下棋区域之间的区域
            g2.setColor(new Color(176, 166, 100, 254));//设置画笔颜色
            g2.fillRect(26, 26, 749, 23);
            g2.fillRect(26, 49, 23, 725);
            g2.fillRect(49, 752, 725, 23);
            g2.fillRect(752, 49, 23, 703);
        }
    }


    //组装窗体
    public void init(){
        //创建画布
        myJPanel canvas =new myJPanel();
        //添加画板
        add(canvas);
        //改变图标
        setIconImage(new ImageIcon("src/主题背景.jpg").getImage());
        //窗体不可变
        setResizable(false);
        //窗体可关闭
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体大小
        setBounds(0,0,1600,900);
        //窗体显示
        setVisible(true);
    }


    public static void main(String[] args) {
        new Test4().init();
    }
}


