package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreDAO
{
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	

	
	// 시작시 점수를 생성해줌
	public int scoreStart(ScoreDTO dto)
	{
		// 테이블에 변경사항이 존재하는지 확인
		int cnt = 0;
		// 1. 동적 로딩 + 권한확인
		dbOpen();
		
		try
		{
			// db에 들어갈 코드들
			// 기록 테이블에 데이터수+1, 점수 이름, 0,0을 입력하여 데이터를 생성함
			String sql = "INSERT INTO "
					+ "기록 (기록ID, 기록이름, 날짜, 점수, 돈, 홍보, 타코야키가격, 타코야키판매수) "
					+ "VALUES((SELECT COUNT(*)+1 FROM 기록), ?, 0, 0, 0, 0, 1000, 0)";
			
			
			psmt = conn.prepareStatement(sql);

			// 1번째 ?를 수정하여 점수이름을 입력받았던 문자열로 대입함
			psmt.setString(1, dto.getscoreName());


			// 업데이트된 횟수를 입력받아서 제대로 실행이 됬는지 확인함
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

		// 다시 엶
		dbOpen();
		// 이번엔 테이블의 숫자를 알아내서 리턴해야하므로 이러한 문자열을 넘겨줌
		String sql2 = "(SELECT COUNT(*) as cnt2 FROM 기록)";
		int cnt2 = 0;
		try
		{
			// 문자열을 실행함
			psmt = conn.prepareStatement(sql2);

			// 실생한 문자열로 리턴을 받아옴 
			// cnt라는 int형 1개만이 올것임
			rs = psmt.executeQuery();
			
			// rs
			// 1) 자바에서 사용할 수 있는 테이블 형태의 데이터
			// 2) cursor가 하나 생겨있음 : rs
			if(rs.next())
			{
				// cnt2에는 데이터의갯수+1개라서 겹치지 않을거임
				cnt2 = rs.getInt("cnt2");
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
		

		// 변경횟수가 0이라면 정상적인 상황이 아님 0을 리턴하여 위험상황을 알림
		if(cnt == 0)
		{
			return 0;
		}
		
		return cnt2;
	}
	
	public ScoreDTO scoreSelectOne(ScoreDTO dto)
	{
		dbOpen();

		String sql = "SELECT * FROM 기록 WHERE 기록ID = ?";

		try
		{
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getscoreID());
			rs = psmt.executeQuery();

			// rs
			// 1) 자바에서 사용할 수 있는 테이블 형태의 데이터
			// 2) cursor가 하나 생겨있음 : rs
			if(rs.next())
			{
				int scoreID = rs.getInt("기록ID");
				String scoreName = rs.getString("기록이름");
				int date = rs.getInt("날짜");
				int point = rs.getInt("점수");
				int money = rs.getInt("돈");
				int isPromoted = rs.getInt("홍보");
				int price = rs.getInt("타코야키가격");
				int selltako = rs.getInt("타코야키판매수");
				System.out.println("타코야키 판매수 받아오기 : " + selltako);
				dto = new ScoreDTO(scoreID,  scoreName, date, point, money, isPromoted, price, selltako);
			}
			
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			System.out.println("sql문 예외사항 발생");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		// list : 학생 정보들이 StudentDTO 자료형으로 다 저장
		return dto;
	}
	
	public int scoreupdate(ScoreDTO dto)
	{
		int cnt = 0;
		
		dbOpen();
		try
		{

			String sql = "UPDATE 기록 "
					+ "SET "
					+ "날짜 = ?, "
					+ "점수 = ?, "
					+ "돈 = ?, "
					+ "홍보 = ?, "
					+ "타코야키가격 = ?, "
					+ "타코야키판매수 = ? "
					+ " WHERE 기록ID = ? ";
    		psmt = conn.prepareStatement(sql);

    		System.out.println("기록ID = " + dto.getscoreID());
    		
			System.out.println("dto.getdate() : " + dto.getdate());
			psmt.setInt(1, dto.getdate());
			
			System.out.println("dto.getpoint() : " + dto.getpoint());
			psmt.setInt(2, dto.getpoint());
			
			System.out.println("dto.getmoney() : " + dto.getmoney());
			psmt.setInt(3, dto.getmoney());
			
			System.out.println("dto.getisPromoted() : " + dto.getisPromoted());
			psmt.setInt(4, dto.getisPromoted());
			
			System.out.println("dto.getprice() : " + dto.getprice());
			psmt.setInt(5, dto.getprice());
			
			System.out.println("dto.getselltako() : " + dto.getselltako());
			psmt.setInt(6, dto.getselltako());
			
			System.out.println("dto.getscoreID() : " + dto.getscoreID());
			psmt.setInt(7, dto.getscoreID());
			


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
