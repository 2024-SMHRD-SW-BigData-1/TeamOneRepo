package Taco;

import java.util.Random;
import java.util.Scanner;

import Controller.Controller;
import Model.ScoreDAO;
import Model.ScoreDTO;
import Model.UserDTO;

public class ZZZ
{
	public void takogame(UserDTO player)
	{

		Screen screen = new Screen();

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		ScoreDTO usersdto = new ScoreDTO(player.getscoreID(), null, 0, 0);
		Controller usercon = new Controller();
		MakeTako maketako = new MakeTako(usercon.scoreSelectOne(usersdto));

//		maketako.setMoney(200000);
//		maketako.setTakoPrice(2000);

		int select = 0;
		boolean gameloop = true;
//		int operationDay = 0;
		boolean promotion = false;

		while (gameloop)
		{
			System.out.println("===================== 게임 모드 선택 =====================");
			System.out.println("1.오늘 장사 시작 2.가게 현황 3.가게 홍보 4.메뉴 개발 5.게임 종료");
			select = sc.nextInt();
			switch (select)
			{
			case 1:
				maketako.returnTako().setdate(maketako.returnTako().getdate() + 1);

				System.out.println("===== " + (maketako.returnTako().getdate()) + "일 차 장사 시작" + " =====");

				// 랜덤(4,8,16)으로 타코야키 얼마만큼 만들어야 되는지 제시하기
				// 타코야키 다 만들었으면 다음 손님 받기
				// 하루 할당량 만큼 손님을 받았다면 오늘 장사 종료
				// 만든 타코야키 개수 만큼 돈 벌기

				int[] takoCountArray =
				{ 4, 8, 16 };
				int guestLimit = maketako.getGuestLimit();
				int guestCnt = 0;
				while (guestLimit > guestCnt)
				{
					int takoCnt = 0;
					guestCnt++;
					int numTako = takoCountArray[rd.nextInt(3)];

					System.out.println("오늘 받을 손님 수 : " + guestLimit + "명");
					System.out.println(guestCnt + "번 손님이 " + numTako + "개의 타코야키를 주문했습니다.");
					System.out.println();

					while (takoCnt < numTako)
					{

						switch (numTako)
						{
						case 4:
							screen.draw("타코야키 4알.txt");
							break;
						case 8:
							screen.draw("타코야키 8알.txt");
							break;
						case 16:
							screen.draw("타코야키 가득.txt");
							break;

						}

						System.out.println("만들어야 하는 타코야키 개수 : " + (numTako - takoCnt));
						System.out.println();
						maketako.takoProcedure();
						takoCnt++;
					}

				}

				System.out.println();
				System.out.println("하루 장사가 끝났습니다...");
				System.out.println();
				break;

			case 2:
				boolean loop = true;
				while (loop)
				{
					System.out.println("===== 가게 현황 =====");
					System.out.println("[1]현재 보유 금액 확인 [2]타코야키 가게 운영 일수 [3]누적 타코야키 판매 개수 [4]나가기");
					select = sc.nextInt();

					System.out.println();
					if (select == 1)
					{
						// 현재 돈 확인
						System.out.println("보유 금액 : " + maketako.getMoney());
					} else if (select == 2)
					{
						// 타코야키 운영한 누적 날짜
						System.out.println("운영 일수 : " + (maketako.returnTako().getdate()));
					} else if (select == 3)
					{
						// 지금까지 만든 타코야키 개수 확인
						System.out.println("타코야키 판매 개수 : " + maketako.getTotalTako());
						// 게임 메뉴 선택 화면으로 나가기
					} else if (select == 4)
					{
						System.out.println("가게 현황 화면 나가기");
						loop = false;
					} else
					{
						System.out.println("잘못된 입력입니다.");
					}
					System.out.println();
				}
				break;
			case 3:
				if (maketako.returnTako().getisPromoted() != 1)
				{
					loop = true;
					while (loop)
					{
						System.out.println("===== 가게 홍보 =====");
						System.out.println(
								"가게를 홍보할 시 영구적으로 손님 수 5명 증가(비용 : 50000원)" + "(보유 자금 : " + maketako.getMoney() + "원)");
						System.out.println("가게 홍보는 게임에서 단 1번만 가능합니다.");
						System.out.println("[1]가게 홍보 시작 [2]나가기");
						select = sc.nextInt();

						System.out.println();
						if (select == 1)
						{
							// 가게 홍보 -> 하루 당 오는 손님 5명 증가(총 10명)
							if (maketako.getMoney() >= 50000)
							{
								maketako.reduceMoney(50000);
								maketako.setGuestLimit(10);
								System.out.println("하루 당 손님 수가 5명 증가했습니다. 손님 수 : " + maketako.getGuestLimit() + "명");
								System.out.println("보유 자금 : " + maketako.getMoney() + "원");
								System.out.println("홍보를 완료했으므로 화면을 나갑니다.");
//								promotion = true;
								maketako.returnTako().setisPromoted(1);
								loop = false;
							} else
							{
								System.out.println("돈이 " + (50000 - maketako.getMoney()) + "원 부족합니다.");
							}
						} else if (select == 2)
						{
							// 선택 화면으로 나가기
							System.out.println("가게 홍보 페이지 나가기");
							loop = false;
						} else
						{
							System.out.println("잘못된 입력입니다.");
						}

						System.out.println();
					}
				} else
				{
					System.out.println("이미 홍보를 하셨습니다.");
				}
				break;
			case 4:
				loop = true;
				while (loop)
				{
					System.out.println("===== 메뉴 개발 =====");
					System.out.println(
							"메뉴를 개발할 시 타코야키 가격 100원 상승(비용 : 50000원)" + "(보유 자금 : " + maketako.getMoney() + "원)");
					System.out.println("[1]메뉴 개발 시작 [2]나가기");
					select = sc.nextInt();

					System.out.println();
					if (select == 1)
					{
						// 메뉴 개발 -> 타코야키 가격 상승(100원)
						if (maketako.getMoney() >= 50000)
						{
							maketako.reduceMoney(50000);
							maketako.upgradeTakoPrice();
							System.out.println("타코야키 가격이 100원 상승했습니다. 현재 타코야키 가격 : " + maketako.getTakoPrice() + "원");
							System.out.println("보유 자금 : " + maketako.getMoney() + "원");
						} else
						{
							System.out.println("돈이 " + (50000 - maketako.getMoney()) + "원 부족합니다.");
						}
					} else if (select == 2)
					{
						// 선택 화면으로 나가기
						System.out.println("메뉴 개발 화면 나가기");
						loop = false;
					} else
					{
						System.out.println("잘못된 입력입니다.");
					}
					System.out.println();
				}
				break;

			case 5:
				System.out.println("게임 종료");

				Controller con = new Controller();
				con.scoreupdate(maketako.returnTako());
//				System.out.println();
				gameloop = false;
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}

		}
	}
}
