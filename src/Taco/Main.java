package Taco;

import java.util.Scanner;

import Controller.Controller;
import Model.ScoreDTO;
import Model.UserDTO;


public class Main
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Screen screen = new Screen();
		Scanner sc = new Scanner(System.in);
		
		UserDTO player = null;
		
//		screen.StartDraw();
//		screen.Clear();
		// 게임 시작
		
		// 로그인
		boolean loginLoop = true;
		
		while(loginLoop)
		{
			System.out.println("==== 로그인/회원가입 ====");
			System.out.println("로그인을 원하시면 1 아니면 2를 입력해 주세요");
			int check = sc.nextInt();
			
			switch (check) {
			case 1:
				
				System.out.println("==== 유저 로그인 ====");
				System.out.print("ID >>");
				int ID1 = sc.nextInt();
				System.out.print("PW >>");
				int PW1 = sc.nextInt();
				
				// StudentDTO 객체 생성
				UserDTO dto1 = new UserDTO(ID1, PW1);
				Controller con1 = new Controller();
				
				player = con1.login(dto1);
				if(player != null)
				{
					System.out.println("");
					loginLoop = false;
				}
				
				break;
			
			case 2: 
				System.out.println("==== 유저 회원가입 ====");
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
				break;

			default:
				System.out.println("1또는 2를 입력해주세요");
				break;
			}
			


		}
		// 플레이 기록 확인
		
		// 게임 진행
		System.out.println(player.getscoreID() + "은 현재 기록id입니다");
		if(player.getscoreID() == 0)
		{
			System.out.println("값이 비어있네요");
			
			System.out.print("점수 이름을 정하세요 : ");
			String scorename = sc.next();
			
			ScoreDTO dto = new ScoreDTO(0, scorename, 0, 0);
			Controller con = new Controller();
			player.setscoreID(con.scoreStart(dto).getscoreID());
			con.update(player);
		}
		System.out.println(player.getscoreID() + "?");
		
		
		while(true)
		{
			System.out.print("환영합니다 : ");
			Controller con = new Controller();
			// 2. Controller insert에 접근
			ScoreDTO sdto = new ScoreDTO(player.getscoreID(), null, 0, 0);
			con.scoreSelectOne(sdto);
			String scorename = sc.next();
		}
		
		
		
	}

}
