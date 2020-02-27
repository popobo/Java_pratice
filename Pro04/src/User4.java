/**
 * 测试参数传值机制
 * @author 高淇
 *
 */
public class User4 {
    int id;        //id
    String name;   //账户名
    String pwd;   //密码
       
    public User4(int id, String name) {
        this.id = id;
        this.name = name;
    }
      
    public   void   testParameterTransfer01(User4  u){
        u.name="高小八";
    }
     
    public   void   testParameterTransfer02(User4  u){
        u  =  new  User4(200,"高三");
    }
      
   
    public static void main(String[] args) {
        User4   u1  =  new User4(100, "高小七");
        
        // 这里也是值传递，但是传递的是对象，对像属性地址复制进去，没有变，
        // 所以方法内改变u.name也会改变u1.name，因为两者指向的内存是一样的
        u1.testParameterTransfer01(u1); 
        System.out.println(u1.name);
        
        u1.testParameterTransfer02(u1);
        System.out.println(u1.name);
    }
} 