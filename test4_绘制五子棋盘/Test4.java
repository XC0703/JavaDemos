package ������������;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Test4 extends JFrame {

	//����ͼƬ
    BufferedImage image;

    {
        try {
            image = ImageIO.read(new File("src/���ⱳ��.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //���������ڲ���
    class myJPanel extends JPanel{
        //���Ʒ���
        @Override
        public void paint(Graphics g) {
            //ǿ������ת���õ�Graphics����Graphics2D����
            Graphics2D g2 = (Graphics2D)g;//�ֵõ�һ֧��
            //��JPanel���Ʊ���ͼƬ
            g2.drawImage(image,0,0,1600,900,null);
            //���û�����ɫ
            g2.setColor(Color.CYAN);
            //���涨����
            g2.fill3DRect(50, 50, 700, 700, true);

            //�����û�����ɫ����ֱ��
            g2.setColor(Color.black);
            //���û���ֱ�ߵĿ��
            g2.setStroke(new BasicStroke(3));

            //������������
            for(int i = 1;i < 16;i ++) {
                g2.drawLine(50,50*i,750,50*i );
            }
            for(int i = 1;i < 16;i ++) {
                g2.drawLine(50*i,50,50*i,750 );
            }

            //�����
            //���û��ʿ��
            g2.setStroke(new BasicStroke(5));
            g2.drawLine(25,25,775, 25);
            g2.drawLine(25,775,775, 775);
            g2.drawLine(25,25,25, 775);
            g2.drawLine(775,25,775, 775);

            //���ĸ���ɫԲ
            g2.fillOval(240, 240, 20, 20);
            g2.fillOval(540, 240, 20, 20);
            g2.fillOval(240, 540, 20, 20);
            g2.fillOval(540, 540, 20, 20);

            //���������������֮�������
            g2.setColor(new Color(176, 166, 100, 254));//���û�����ɫ
            g2.fillRect(26, 26, 749, 23);
            g2.fillRect(26, 49, 23, 725);
            g2.fillRect(49, 752, 725, 23);
            g2.fillRect(752, 49, 23, 703);
        }
    }


    //��װ����
    public void init(){
        //��������
        myJPanel canvas =new myJPanel();
        //��ӻ���
        add(canvas);
        //�ı�ͼ��
        setIconImage(new ImageIcon("src/���ⱳ��.jpg").getImage());
        //���岻�ɱ�
        setResizable(false);
        //����ɹر�
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //���ô����С
        setBounds(0,0,1600,900);
        //������ʾ
        setVisible(true);
    }


    public static void main(String[] args) {
        new Test4().init();
    }
}


