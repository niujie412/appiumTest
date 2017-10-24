import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;

public class SendCode {

    private static final Logger logger = Logger.getLogger(SendCode.class);

    private static final String Driver="com.mysql.jdbc.Driver"; //数据库连接类名
    private static final String SitUrl="jdbc:mysql://20.0.0.2:3306/sms_fyb"; // 数据库连接地址
    private static final String BetaUrl="jdbc:mysql://121.40.127.92:3309/sms_fyb_beta";
    private static final String SitUser="root"; //数据库连接用户名
    private static final String BetaUser="qa_tmp";
    private static final String SitPassword="QA@2015"; //数据库连接密码
    private static final String BetaPassword="mjl84_)l23jda0l_23";



    private static Connection conn; //数据库连接对象
    private ResultSet result; //数据库结果集对象

    /*
     * 创建数据库连接
     */
    public static Connection getConnection(){
        try{
            Class.forName(Driver);
            Connection conn= DriverManager.getConnection(BetaUrl,BetaUser,BetaPassword);
            logger.info("数据库连接成功");
        }catch(Exception e){
            logger.error("数据库连接失败"+e.getMessage());
        }
        return conn;
    }

    public static void closeConnection(Connection conn, Statement stm, ResultSet result){
        try{
            if(result!=null)
                result.close();
            if(stm!=null)
                stm.close();
            if(conn!=null)
                conn.close();
            logger.info("数据库关闭成功");
        }catch(SQLException e){
            logger.error("数据库关闭失败");
        }
    }
    public String getSmsCode(String mobile) throws ClassNotFoundException, SQLException {
        String reslut = null;
        Class.forName(Driver);
        Connection connection = DriverManager.getConnection(BetaUrl,BetaUser,BetaPassword);
        Statement statement = connection.createStatement();
        ResultSet rs=statement.executeQuery(String.format("SELECT content FROM iw_sms WHERE mobile =%s ORDER BY id DESC LIMIT 1",mobile));
        while (rs.next()){
            reslut=rs.getString(1);
            System.out.println(reslut);
        }
        GetResult re = new GetResult();
        String reNum =re.GetResult(reslut);
        return reNum;
    }

    public static void main(String [] args) throws ClassNotFoundException, SQLException {
        PropertyConfigurator.configure("log4j.properties");
        SendCode sendCode =new SendCode();
        System.out.println(sendCode.getSmsCode("15021960281"));
    }
}
