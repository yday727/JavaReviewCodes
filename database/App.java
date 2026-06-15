package database;

import java.sql.*;

// 该代码运行需要添加MySQL驱动，根据实际情况设置参数，提前创建好数据库和表
public class App {
    public static void main(String[] args) {
        // 连接mydb数据库，不启用SSL，MySQL8.0必须添加时区参数
        String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=Asia/Shanghai";
        // 根据实际情况填写用户与密码
        String user = "root";
        String password = "MySQL123456";

        // 需提前在mydb中创建含“name”“work”两个字段的表
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database.");
            // Statement
            // 执行DML(INSERT/UPDATE/DELETE)
            Statement statement = connection.createStatement();    // 创建SQL语句执行对象，用于发送静态SQL语句
            String sqlInsert = "INSERT INTO characters(name, work) VALUES('Pieberry', 'WitchSpring')";    // 定义SQL语句：向characters表插入(Pieberry, WitchSpring)
            int rowsAffected = statement.executeUpdate(sqlInsert);    // 执行SQL语句并返回影响行数
            System.out.println("rows affected: " + rowsAffected);

            // 执行DQL(SELECT)
            String sqlQuery = "SELECT * FROM characters";    // 定义SQL语句：查询users中的所有字段
            ResultSet resultSet1 = statement.executeQuery(sqlQuery);    // 执行SQL语句并返回结果集

            // 遍历结果集
            while (resultSet1.next()) {
                System.out.println(resultSet1.getString(1) + "\t" + resultSet1.getString(2));    // 通过列索引获取值，索引从1开始
            }

            // PreparedStatement
            String sql = "INSERT INTO characters(name, work) VALUES(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "Luna");
            preparedStatement.setString(2, "WitchSpring2");
            preparedStatement.executeUpdate();

            // 遍历结果集
            ResultSet resultSet2 = statement.executeQuery(sqlQuery);
            while (resultSet2.next()) {
                System.out.println(resultSet2.getString("name") + "\t" + resultSet2.getString("work"));    // 通过列名获取值
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
