package Controller;

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
	
	
	
	
	
	
	
	
	
}
