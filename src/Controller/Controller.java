package Controller;

import java.sql.SQLException;

import Model.ScoreDAO;
import Model.ScoreDTO;
import Model.UserDAO;
import Model.UserDTO;

public class Controller
{
	public void insert(UserDTO dto)
	{
		// DAO에 있는 insert에 dto를 보내주는 작업
		// 1. StudentDAO 객체 생성
		UserDAO dao = new UserDAO();
		// 2. insert로 dto보내주기
		int cnt = dao.insert(dto);

		if (cnt > 0)
		{
			System.out.println("유저 등록 성공!");
		} else
		{
			System.out.println("유저 등록 실패!");
		}
	}

	public UserDTO login(UserDTO dto)
	{
		// 1. StudentDAO 객체 생성
		UserDAO dao = new UserDAO();

		UserDTO cnt = dao.login(dto);

		if (cnt.getName() == null)
		{
			System.out.println("아이디, 비밀번호가 일치하지 않습니다");
			return null;
		}
		System.out.println("환영합니다 " + cnt.getName() + "님");

		return cnt;
	}

	public ScoreDTO scoreStart(ScoreDTO dto)
	{
		// 기본 dao선언
		ScoreDAO dao = new ScoreDAO();
		// 정상적인 경우에는 점수의 id값을 리턴받음
		int dtos = dao.scoreStart(dto);


		// 0이 리턴된 경우는 비정상적이니 널을 리턴하고 그 외에는 텍스트를 출력함
		if (dtos != 0)
		{
			System.out.println("유저 등록 성공!");
		} else
		{
			System.out.println("유저 등록 실패!");
			return null;
		}
		
		// 리턴받은id값으로 새로운 점수 데이터를 생성함
		ScoreDTO cnt = new ScoreDTO(dtos, dto.getscoreName(), 0, 0);
		
		return cnt;
	}

}
