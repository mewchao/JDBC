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
                System.out.println("====================================================");
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
