  package in.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



import in.com.dto.EmpDto;

public class EmpDao {

	private static final String SQL1 = "insert into emp values (?,?,?,?,?)";
	private static final String SQL2 = "select count(*) from emp where empEmail=? and empPassword=?";
	private static Statement ConnetionFactory;

	public static boolean register(EmpDto dto) throws Exception {

		//write email validation check for registration page
		Connection con = ConnetionFactory.getConnection();
		
		PreparedStatement ptstm = con.prepareStatement(SQL1);
		ptstm.setString(1, dto.getFname());
		ptstm.setString(2, dto.getLname());
		ptstm.setString(3, dto.getEmail());
		ptstm.setString(4, dto.getPassword());
		ptstm.setString(5, dto.getGender());
		int rows = ptstm.executeUpdate();
		return rows > 0;

	}

	public static boolean login(EmpDto dto) throws Exception {
		String countRow = null;
		try {
			Connection con = ConnetionFactory.getConnection();
			PreparedStatement ptstmt = con.prepareStatement(SQL2);
			ptstmt.setString(1, dto.getEmail());
			ptstmt.setString(2, dto.getPassword());
			ResultSet rs = ptstmt.executeQuery();
			rs.next();
			countRow=rs.getString(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return countRow.equals("1");

	}

}
