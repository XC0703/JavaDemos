package ����һ��Person��;
import java.util.Scanner;
public class Project11 {

 public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);//�û�����
	 int n=sc.nextInt();       //����������
	 sc.nextLine();
	 Person[] per = new Person[n];     //��ʼ��һ��person����
	 for(int i=0; i<n; i++) {     //ѭ���Ӽ�������
         String name = sc.next();
         int age = sc.nextInt();
         boolean genter = sc.nextBoolean();
         per[i] = new Person(name,age,genter);     //�����вι��캯���½�person����
     }
	 for(int j=n-1; j>=0; j--) { //ѭ���������
		 System.out.println(per[j]);
	 }
     Person person = new Person();    //�����޲ι��캯���½�person����
     person.toString();
 }
}
//����һ��Person��
class Person{        
	private String name = null;
    private int age = 0;
    private boolean gender = false;
    private int id = 0;
  //�����޲ι��캯��
    public Person() {      
        System.out.println("This is constructor");
        System.out.println(name+","+age+","+gender+","+id);
    }
  //�����вι��캯��
    public Person(String n, int a, boolean g) {    
        this.name = n;
        this.age = a;
        this.gender = g;
    }
    //Ϊÿ�����Զ���setter/getter����
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