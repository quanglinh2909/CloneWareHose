import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


public class Configuration {
	final static String DATABASE="datawarehouse";
	final static String USER="root";
	final static String PASS="";
	final static String PATH="D:/Wawhouse/Data";
	final static int HOUR=20,MINUTE=0,SECOND=0;
	final static String FTP="";
	final static String SOURCE_NAME="Xổ Số Minh Ngọc";
	final static String CONTACT="Hoàng Quang Linh";
	final static String ID="";
	public static String getID(Connection con) {
		if(!ID.equals("")) return ID;
		try {
			PreparedStatement ps=con.prepareStatement("select ID from config where Source_Name=? AND Source_Local=? AND FTP=? AND user=? AND pass=?");
			ps.setString(1, SOURCE_NAME);
			ps.setString(2, PATH);
			ps.setString(3, FTP);
			ps.setString(4, USER);
			ps.setString(5, PASS);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			else {
				ps=con.prepareStatement("insert into config(ID,Source_Name,Source_Local,FTP,user,pass) values(?,?,?,?,?,?)");
				String id= UUID.randomUUID().toString();
				ps.setString(1,id);
				ps.setString(2, SOURCE_NAME);
				ps.setString(3, PATH);
				ps.setString(4, FTP);
				ps.setString(5, USER);
				ps.setString(6, PASS);
				int affect=ps.executeUpdate();
				if(affect>0) return id;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ERR";
	}


}
