# SQL
Host：主机名，双主键之一，值为%时表示匹配所有主机。User：用户名，双主键之一。
简单来说当某用户对应的host不包含“localhost”在内的话，是无法登录的。
当用户的host包含“localhost”时，登录的用户host总是等于localhost
# JDBC
##数据库驱动
应用程序根据数据库厂商对数据库操作有多种方法
## JDBC
提供了一个（java操作数据库的）规范
##
java.sql<br>
还需要导入数据库驱动包<br>
mysql-connector-java-  .jar<br>
Maven<br>
##第一个JDBC程序
创建测试数据库<br>
创建一个普通项目<br>
导入数据库驱动  lib下粘贴jar包   lib右键as a library <br>
编写测试代码 <br>
--加载信息<br>
--用户信息和url<br>
--连接成功，数据库对象<br>
--执行sql对象<br>
--<br>
--释放连接<br>
<br>
把url后边的安全连接参数删除（有警告）或改成false【SQL版本大于connect版本，就要设置成false】<br><br><br>
```
import java.sql.*;

public class jdbcdemo {
    public static void main(String[] args) {
        try{
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //用户信息
            String url="jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai&connectTimeout=5000";
            String username="root";
            String password="123456";
            //连接成功  数据库对象Connection
            Connection connection= DriverManager.getConnection(url,username,password);
            // 执行sql的对象Statement
            Statement statement=connection.createStatement();

            String sql="SELECT * FROM users";

            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next()){
                System.out.println("id="+resultSet.getObject("id"));
                System.out.println("name="+resultSet.getObject("name"));
                System.out.println("passward="+resultSet.getObject("passward"));
                System.out.println("email="+resultSet.getObject("email"));
                System.out.println("birthday="+resultSet.getObject("birthday"));
            }


            //释放
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
```
>DriverManger<br>
 `//DriverManger.registerDriver(new com.mysql.jdbc.Driver())`<br>
>URL<br>
>statement