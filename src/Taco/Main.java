package Taco;

import java.util.Scanner;

import Controller.Controller;
import Model.UserDTO;


public class Main
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Screen screen = new Screen();
		Scanner sc = new Scanner(System.in);
		
//		screen.StartDraw();
//		screen.Clear();
		// 게임 시작
		
		// 로그인
		while(true)
		{
			// 학생 등록 - insert()
			System.out.println("==== 유저 등록 ====");
			System.out.print("ID >>");
			int ID = sc.nextInt();
			System.out.print("PW >>");
			int PW = sc.nextInt();
			System.out.print("닉네임 >>");
			String Name = sc.next();

			// StudentDTO 객체 생성
			UserDTO dto = new UserDTO(ID, PW, Name);
			// 1. Controller 객체생성
			Controller con = new Controller();
			// 2. Controller insert에 접근
			con.insert(dto);
			
			if(false)
			{
				break;
			}
		
		// 플레이 기록 확인
		
		
		
		// 게임 진행
		//선택 >> 1.장사 시작 2.가게 상황 확인 3.홍보하기 4.메뉴 개발 5.게임 종료
		
		
		
		
		
	}

}
}
