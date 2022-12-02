package ʵ��һ��������ļ򵥼�����;

/**�õ��Ĳ��ֹ�����**/
import java.awt.FlowLayout;//��ʽ����
import java.awt.GridLayout;//���񲼾�
/**�õ��������**/
import java.awt.event.ActionEvent;//��ť�¼�
import java.awt.event.ActionListener;//������
import java.util.List;//�����ӿ���
import java.awt.TextField;//�ı������
import javax.swing.JButton;//��ť���
import java.awt.Color;//��ɫ����
/**�õ���������**/
import javax.swing.JFrame;//��������
import javax.swing.JPanel;//�������
import javax.swing.Box;//��ʽ����

public class Calculator {
	
	/**����ȫ�ֱ���**/
	public static String stringResult = "";//���ڴ洢���ʽ�ַ���
	public static double result = 0 ;//���ڴ洢������
	TextField textField = new TextField(30);//�����ı���Ĵ�СΪ30
	
	/**��������**/
	public void CreateFlame(){
		
		//��������
		JFrame jFrame = new JFrame("������");  //���� 
		jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));//��ʽ���֣����ж���
		jFrame.setSize(500,500);   //��С
		jFrame.setLocation(700,300);  //λ��
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����˳����򣬶�����ֻ�ر�jFrame
		
		//���ð�ť7,8,9��+ 
		JPanel jPanel1 = new JPanel(new GridLayout(1,4,5,5));//���񲼾�,һ�����У�5�����ص�
		jPanel1.add(ActionButtonInput("7"));
		jPanel1.add(ActionButtonInput("8"));
		jPanel1.add(ActionButtonInput("9"));
		jPanel1.add(ActionButtonInput("+"));
		//���ð�ť4��5��6��- 
		JPanel jPanel2 = new JPanel(new GridLayout(1,4,5,5));//���񲼾�,һ�����У�5�����ص�
		jPanel2.add(ActionButtonInput("4"));
		jPanel2.add(ActionButtonInput("5"));
		jPanel2.add(ActionButtonInput("6"));
		jPanel2.add(ActionButtonInput("-"));	
		//���ð�ť1��2��3��* 
		JPanel jPanel3 = new JPanel(new GridLayout(1,4,5,5));//���񲼾�,һ�����У�5�����ص�
		jPanel3.add(ActionButtonInput("1"));
		jPanel3.add(ActionButtonInput("2"));
		jPanel3.add(ActionButtonInput("3"));
		jPanel3.add(ActionButtonInput("*"));
		//���ð�ť.��0��=��/
		JPanel jPanel4 = new JPanel(new GridLayout(1,4,5,5));//���񲼾�,һ�����У�5�����ص�
		jPanel4.add(ActionButtonInput("."));
		jPanel4.add(ActionButtonInput("0"));
		jPanel4.add(ActionButtonEqu("="));
		jPanel4.add(ActionButtonInput("/"));
		//���������ť�ͻ��˰�ť
		JPanel jPanel5 = new JPanel(new GridLayout(1,4,5,5));//���񲼾�,һ�����У�5�����ص�
	    jPanel5.add( ActionButtonDel("CLEAR"));
		jPanel5.add(ActionButtonBack("BACKSPACE"));
		jPanel5.add(ActionButtonInput("("));
		jPanel5.add(ActionButtonInput(")"));
		
		//���ϵ��£��������ӵ�box������
		Box box = Box.createVerticalBox();//��������ĺ�ʽ����  
		box.add(textField);
		box.add(jPanel1);
		box.add(jPanel2);
		box.add(jPanel3);
		box.add(jPanel4);
		box.add(jPanel5);
		
		//��box������ӵ�Frame������
		jFrame.setContentPane(box);
		//������ʾ����
		jFrame.setVisible(true);
	}

	/**������밴ť�ķ���**/
	public JButton ActionButtonInput(String buttonName) {
		JButton button = new JButton(buttonName);//����һ���µİ�ť
		button.setForeground(Color.red);
		button.addActionListener(//Ϊ��ť���ü�������
				new ActionListener() {
		        public void actionPerformed(ActionEvent e) {//����¼�
		        	stringResult =stringResult + buttonName;//��֤ÿ�����벻�����ǰ�������
	            	textField.setText(stringResult);//������ļ����������ı�������ʾ
	            	System.out.println(stringResult);//������ļ��������ڿ���̨��ʾ
	            	}
		    });
		 return button;
	}
	/**��ӵ��ڰ�ť�ķ���**/	
	public JButton ActionButtonEqu(String buttonName) {
		JButton button = new JButton(buttonName);//����һ���µİ�ť
		button.setForeground(Color.red);//���ð�ť����Ϊ��ɫ
		button.addActionListener(//Ϊ��ť���ü�������
				new ActionListener() {
				public void actionPerformed(ActionEvent e) {//����¼�
					char[] str = Calculator.stringResult.toCharArray();//��String��ת��Ϊchar[]��
			        List<String> Exp =  Calculate.nifToSuf(str);// ��ú�׺���ʽ					       
			        result=Calculate.calExpression(Exp);// �����׺���ʽ
					textField.setText(Double.toString(result));//��������ı�������ʾ
					System.out.println(result);//��������ı�������ʾ
				    }
			});
			return button;
		}
	/**��������ť�ķ���**/
	public JButton ActionButtonDel(String buttonName) {
		JButton button = new JButton(buttonName);//����һ���µİ�ť
		button.setForeground(Color.red);//���ð�ť����Ϊ��ɫ
		button.addActionListener(//Ϊ��ť���ü�������
				new ActionListener() {
				public void actionPerformed(ActionEvent e) {//����¼�
					result = 0;
					stringResult = "";
					textField.setText(stringResult);//��������ı����������
				    }
			});
			return button;
		}
	/**��ӻ��˰�ť�ķ���**/
	public JButton ActionButtonBack(String buttonName) {
		JButton button = new JButton(buttonName);//����һ���µİ�ť
		button.setForeground(Color.red);//���ð�ť����Ϊ��ɫ
		button.addActionListener(//Ϊ��ť���ü�������
				new ActionListener() {
				public void actionPerformed(ActionEvent e) {//����¼�
					String text = textField.getText();//��ȡ�ı�������
					//����ı���������ǿջ��߳�����1��ֱ�ӽ��ı������������Ϊ��
					 if("".equals(text)||text.length()==1) {
						 stringResult="";
						 textField.setText(stringResult);
		                 }
					 //����ı��ĳ��ȴ���1��Ҫ��ǰ��ȡ
					 else if(text.length()>1){
						 stringResult = text.substring(0,text.length()-1);
		                 textField.setText(stringResult);
		                }
				}
			});
			return button;
		}
	
	/**������**/
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.CreateFlame();
	}
}
