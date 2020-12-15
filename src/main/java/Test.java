import com.abc.dao.util.DBUtil;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;


//存储过程的Java代码调用
public class Test {
    public static void main(String[] args) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "call proc_transfer_money(?,?,?) ";
        CallableStatement cs = con.prepareCall(sql);
        cs.setString(1,"zhou1");
        cs.setString(2,"zhou2");
        cs.setBigDecimal(3,new BigDecimal(100));
        cs.executeUpdate();
        DBUtil.close(null,cs,con);

    }
}
