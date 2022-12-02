package 定义一个Person类;
import java.util.Scanner;
public class Project11 {

 public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);//用户输入
	 int n=sc.nextInt();       //输入对象个数
	 sc.nextLine();
	 Person[] per = new Person[n];     //初始化一个person数组
	 for(int i=0; i<n; i++) {     //循环从键盘输入
         String name = sc.next();
         int age = sc.nextInt();
         boolean genter = sc.nextBoolean();
         per[i] = new Person(name,age,genter);     //利用有参构造函数新建person对象
     }
	 for(int j=n-1; j>=0; j--) { //循环逆序输出
		 System.out.println(per[j]);
	 }
     Person person = new Person();    //利用无参构造函数新建person对象
     person.toString();
 }
}
//定义一个Person类
class Person{        
	private String name = null;
    private int age = 0;
    private boolean gender = false;
    private int id = 0;
  //创建无参构造函数
    public Person() {      
        System.out.println("This is constructor");
        System.out.println(name+","+age+","+gender+","+id);
    }
  //创建有参构造函数
    public Person(String n, int a, boolean g) {    
        this.name = n;
        this.age = a;
        this.gender = g;
    }
    //为每个属性定义setter/getter方法
    public String getName(){      
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    public boolean getGender(){
        return gender;
    }
    public void setGender(boolean gender){
        this.gender=gender;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", id=" + id + "]";
	}
}