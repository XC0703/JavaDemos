package 实现一个带界面的简单计算器;

/**用到的布局管理器**/
import java.awt.FlowLayout;//流式布局
import java.awt.GridLayout;//网格布局
/**用到的组件类**/
import java.awt.event.ActionEvent;//按钮事件
import java.awt.event.ActionListener;//监听器
import java.util.List;//容器接口类
import java.awt.TextField;//文本框组件
import javax.swing.JButton;//按钮组件
import java.awt.Color;//颜色设置
/**用到的容器类**/
import javax.swing.JFrame;//窗口容器
import javax.swing.JPanel;//面板容器
import javax.swing.Box;//盒式容器

public class Calculator {
	
	/**定义全局变量**/
	public static String stringResult = "";//用于存储表达式字符串
	public static double result = 0 ;//用于存储计算结果
	TextField textField = new TextField(30);//设置文本框的大小为30
	
	/**创建界面**/
	public void CreateFlame(){
		
		//构建窗口
		JFrame jFrame = new JFrame("计算器");  //名字 
		jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));//流式布局，居中对齐
		jFrame.setSize(500,500);   //大小
		jFrame.setLocation(700,300);  //位置
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//真正退出程序，而不是只关闭jFrame
		
		//设置按钮7,8,9，+ 
		JPanel jPanel1 = new JPanel(new GridLayout(1,4,5,5));//网格布局,一行四列，5个像素点
		jPanel1.add(ActionButtonInput("7"));
		jPanel1.add(ActionButtonInput("8"));
		jPanel1.add(ActionButtonInput("9"));
		jPanel1.add(ActionButtonInput("+"));
		//设置按钮4、5、6、- 
		JPanel jPanel2 = new JPanel(new GridLayout(1,4,5,5));//网格布局,一行四列，5个像素点
		jPanel2.add(ActionButtonInput("4"));
		jPanel2.add(ActionButtonInput("5"));
		jPanel2.add(ActionButtonInput("6"));
		jPanel2.add(ActionButtonInput("-"));	
		//设置按钮1、2、3、* 
		JPanel jPanel3 = new JPanel(new GridLayout(1,4,5,5));//网格布局,一行四列，5个像素点
		jPanel3.add(ActionButtonInput("1"));
		jPanel3.add(ActionButtonInput("2"));
		jPanel3.add(ActionButtonInput("3"));
		jPanel3.add(ActionButtonInput("*"));
		//设置按钮.、0、=、/
		JPanel jPanel4 = new JPanel(new GridLayout(1,4,5,5));//网格布局,一行四列，5个像素点
		jPanel4.add(ActionButtonInput("."));
		jPanel4.add(ActionButtonInput("0"));
		jPanel4.add(ActionButtonEqu("="));
		jPanel4.add(ActionButtonInput("/"));
		//设置清除按钮和回退按钮
		JPanel jPanel5 = new JPanel(new GridLayout(1,4,5,5));//网格布局,一行两列，5个像素点
	    jPanel5.add( ActionButtonDel("CLEAR"));
		jPanel5.add(ActionButtonBack("BACKSPACE"));
		jPanel5.add(ActionButtonInput("("));
		jPanel5.add(ActionButtonInput(")"));
		
		//从上到下，将组件添加到box容器中
		Box box = Box.createVerticalBox();//创建横向的盒式布局  
		box.add(textField);
		box.add(jPanel1);
		box.add(jPanel2);
		box.add(jPanel3);
		box.add(jPanel4);
		box.add(jPanel5);
		
		//将box布局添加到Frame容器中
		jFrame.setContentPane(box);
		//窗口显示出来
		jFrame.setVisible(true);
	}

	/**添加输入按钮的方法**/
	public JButton ActionButtonInput(String buttonName) {
		JButton button = new JButton(buttonName);//定义一个新的按钮
		button.setForeground(Color.red);
		button.addActionListener(//为按钮设置监听功能
				new ActionListener() {
		        public void actionPerformed(ActionEvent e) {//添加事件
		        	stringResult =stringResult + buttonName;//保证每次输入不会清除前面的输入
	            	textField.setText(stringResult);//将输入的计算数字在文本框中显示
	            	System.out.println(stringResult);//将输入的计算数字在控制台显示
	            	}
		    });
		 return button;
	}
	/**添加等于按钮的方法**/	
	public JButton ActionButtonEqu(String buttonName) {
		JButton button = new JButton(buttonName);//定义一个新的按钮
		button.setForeground(Color.red);//设置按钮字体为红色
		button.addActionListener(//为按钮设置监听功能
				new ActionListener() {
				public void actionPerformed(ActionEvent e) {//添加事件
					char[] str = Calculator.stringResult.toCharArray();//将String型转化为char[]型
			        List<String> Exp =  Calculate.nifToSuf(str);// 获得后缀表达式					       
			        result=Calculate.calExpression(Exp);// 计算后缀表达式
					textField.setText(Double.toString(result));//将结果在文本框中显示
					System.out.println(result);//将结果在文本框中显示
				    }
			});
			return button;
		}
	/**添加清除按钮的方法**/
	public JButton ActionButtonDel(String buttonName) {
		JButton button = new JButton(buttonName);//定义一个新的按钮
		button.setForeground(Color.red);//设置按钮字体为红色
		button.addActionListener(//为按钮设置监听功能
				new ActionListener() {
				public void actionPerformed(ActionEvent e) {//添加事件
					result = 0;
					stringResult = "";
					textField.setText(stringResult);//将结果和文本框内容清除
				    }
			});
			return button;
		}
	/**添加回退按钮的方法**/
	public JButton ActionButtonBack(String buttonName) {
		JButton button = new JButton(buttonName);//定义一个新的按钮
		button.setForeground(Color.red);//设置按钮字体为红色
		button.addActionListener(//为按钮设置监听功能
				new ActionListener() {
				public void actionPerformed(ActionEvent e) {//添加事件
					String text = textField.getText();//获取文本框内容
					//如果文本框的内容是空或者长度是1，直接将文本框的内容设置为空
					 if("".equals(text)||text.length()==1) {
						 stringResult="";
						 textField.setText(stringResult);
		                 }
					 //如果文本的长度大于1就要向前截取
					 else if(text.length()>1){
						 stringResult = text.substring(0,text.length()-1);
		                 textField.setText(stringResult);
		                }
				}
			});
			return button;
		}
	
	/**主函数**/
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.CreateFlame();
	}
}
