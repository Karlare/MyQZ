import java.sql.*;

public class connect {
    public static void main(String[] args) throws SQLException {
        String url ="jdbc:mysql://localhost:3306/qzdb";
        String user ="dyx";
        String password ="123456";

        String sql ="select * from book";
        Connection connection = DriverManager.getConnection(url,user,password);
        PreparedStatement preparedStatement =connection.prepareStatement(sql);
        ResultSet resultSet =preparedStatement.executeQuery();

        while(resultSet.next())
        {
            System.out.println(resultSet.getString( "book"));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
