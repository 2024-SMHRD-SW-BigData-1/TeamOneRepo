package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO
{
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	public int insert(UserDTO dto)
	{
		int cnt = 0;
		// 1. 동적 로딩 + 권한확인
		dbOpen();
		try
		{

			String sql = "INSERT INTO 회원정보 (회원ID, PW, 닉네임) VALUES(?, ?, ?)";
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, dto.getID());
			psmt.setInt(2, dto.getPW());
			psmt.setString(3, dto.getName());

			cnt = psmt.executeUpdate();

		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			System.out.println("sql 실행 에러");
			e.printStackTrace();
		} finally
		{
			dbClose();

		}

		return cnt;
	}
	
	public int update(UserDTO dto)
	{
		int cnt = 0;
		
		dbOpen();
		try
		{

			String sql = "UPDATE 회원정보 SET 기록ID = ? WHERE 회원ID = ?";
    		psmt = conn.prepareStatement(sql);

			psmt.setInt(1, dto.getscoreID());
			psmt.setInt(2, dto.getID());

			cnt = psmt.executeUpdate();

		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			System.out.println("sql 실행 에러");
			e.printStackTrace();
		} finally
		{
			dbClose();

		}
		
		return cnt;
	}
	

	
	public UserDTO login(UserDTO dto)
	{
		
		// 1. 동적 로딩 + 권한확인
		dbOpen();
		String sql = "SELECT * FROM 회원정보 WHERE 회원ID = ? AND PW = ?";
		
		try
		{
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, dto.getID());
			psmt.setInt(2, dto.getPW());

			rs = psmt.executeQuery();
			
			// rs
			// 1) 자바에서 사용할 수 있는 테이블 형태의 데이터
			// 2) cursor가 하나 생겨있음 : rs
			if(rs.next())
			{
				int ID = rs.getInt("회원ID");
				int PW = rs.getInt("PW");
				String Name = rs.getString("닉네임");
				int scoreID = rs.getInt("기록ID");
				dto = new UserDTO(ID,  PW, Name, scoreID);
			}

		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			System.out.println("sql 실행 에러");
			e.printStackTrace();
		} finally
		{
			dbClose();

		}

		return dto;
	}
	
	
	
	// 데이터베이스와의 동적로딩/권한확인
	public void dbOpen()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String id = "campus_24SW_BIG_p1_3";
			String pw = "smhrd3";
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";

			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			System.out.println("동적 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			System.out.println("권한 확인 실패");
			e.printStackTrace();
		}

	}

	// 데이터베이스 자원 반납
	public void dbClose()
	{

		try
		{
			if (rs != null)
			{
				rs.close();
			}

			if (psmt != null)
			{
				psmt.close();
			}

			if (conn != null)
			{
				conn.close();
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
 
}
