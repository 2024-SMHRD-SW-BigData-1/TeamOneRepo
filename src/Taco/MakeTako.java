package Taco;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


public class MakeTako {
	

	
	private int money = 100000;
	private int takoPrice = 1000;
	private int cnt = 0;
	private int totalTako = 0;
	private int guestLimit = 5;
//	private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//  private static ScheduledFuture<?> timerTask;
	
	
	String [] takoArray =  
	{
		"오리지널 타코야키 : 반죽 붓기 -> 문어 넣기 -> 뒤집기 -> 뒤집기 -> 뒤집기 -> 가쓰오부시 뿌리기",
		"오징어 타코야키 : 반죽 붓기 -> 오징어 넣기 -> 뒤집기 -> 뒤집기 -> 뒤집기 -> 가쓰오부시 뿌리기",
		"김치치즈 타코야키 : 반죽 붓기 -> 김치 넣기 -> 치즈 넣기 -> 뒤집기 -> 뒤집기 -> 가쓰오부시 뿌리기 ",
		"과일 타코야키 : 반죽 붓기 -> 딸기 넣기 -> 바나나 넣기 -> 뒤집기 -> 뒤집기 -> 가쓰오부시 뿌리기",
		"대파 타코야키 : 반죽 붓기 -> 문어 넣기 -> 뒤집기 -> 뒤집기 -> 대파 뿌리기 -> 가쓰오부시 뿌리기"
		
	};
	
	
	
	
	
	
	public void takoProcedure () {
		Random rd = new Random();
		Scanner sc= new Scanner(System.in);
		
		
		
		int tako [] [] = {
				{1, 2, 9, 9, 9, 10},
				{1, 3, 9, 9, 9, 10},
				{1, 4, 6, 9, 9, 10},
				{1, 5, 8, 9, 9, 10},
				{1, 2, 9, 9, 7, 10}
		};
		
		int rdRecipe = rd.nextInt(5);
		
		
		int index = 0;
		System.out.println(takoArray[rdRecipe]);
		System.out.println("[1]반죽 붓기 [2]문어 [3]오징어 [4]김치 [5]딸기 [6]치즈 [7]대파 [8]바나나 [9]뒤집기 [10]가쓰오부시");
		
		
		
		while(true) {
//			wrong = false;
//			ExTimer ext1 = new ExTimer();
//			Thread thread = new Thread(() -> {
//				ext1.extimer1();
//				timer();
//	        });
//	        thread.start();
//			startTimer();
	        
			int select = sc.nextInt();

			if(tako[rdRecipe][index] == select) {
				index++;
			}else if(tako[rdRecipe][index] != select){
//				stopTimer();
//				wrong = true;
				System.out.println("잘못된 조리 순서 입니다.");
				System.out.println("-" +1000+"원");
				money -= 1000;
				cnt++;
				System.out.println();
				break;
			}
//			if(remainTime <= 0) {
//			stopTimer();
//			System.out.println("시간 초과 했습니다. -5000원");
//			money -= 5000;
//			cnt++;
//			System.out.println();
//			break;
//		}
			
			
			
			
			
			if(index >= tako[0].length) {
				System.out.println("타코야키 완성!");
				System.out.println("+"+takoPrice+"원");
				money += takoPrice;
				totalTako++;
				System.out.println();
				break;
			}
			
		}
		
		
	}

//	static int remainingTime = 3;
//	public static void startTimer() {
//		
//		
//        Runnable task = () -> {
//    		
//        	
//        	
//        	if(remainingTime > 0) {
//        		System.out.println("남은 시간 : " + remainingTime + "초");
//        		remainingTime--;
//        	}else
//        		timerTask.cancel(true);
//            // 타이머 동작
//            // 시작 숫자 감소
//            // 0이 되면 타이머 종료
//        };
//        timerTask = scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
//    }
//
//    public static void stopTimer() {
//        if (timerTask != null && !timerTask.isDone()) {
//            timerTask.cancel(true); // 현재 실행 중인 타이머 종료
//        }
//    }
	
	
	
	
	
	
	
	
	
	
	
	
//	public void timer() {
//		
//		Random rd = new Random();
//        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//
//        // 타이머 초기값 설정
//        int initialDelay = rd.nextInt(10)+10;
//
//
//        // Runnable 객체를 생성하여 타이머 작업 정의
//        Runnable task = new Runnable() {
//        	
//        
//        	
//            int remainingTime = initialDelay;
//
//            @Override
//            public void run() {
//            	if(wrong) {
//        			scheduler.shutdown();
//        		}
//                if (remainingTime > 0) {
//                    System.out.println("남은 시간: " + remainingTime + "초");
//                    remainingTime--;
//                    remainTime = remainingTime;
//                    System.out.println(remainTime);
//                    
//                } else {
//                    
//                    scheduler.shutdown(); // 타이머 작업 완료 후 스케줄러 종료
//                }
//            }
//        };
//
//        // 초기 지연 후에 주기적으로 작업을 수행하도록 스케줄링
//        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
//	}
//	
	
	
	
	
	
	
	
	
	
	
	public int getTakoPrice() {
		return takoPrice;
	}
	
	public void setTakoPrice(int takoPrice) {
		this.takoPrice = takoPrice;
	}
	
	public void upgradeTakoPrice() {
		//타코야키 가격 상승
		setTakoPrice(getTakoPrice() + 100);  ;
	}

	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void reduceMoney(int cost) {
		
		setMoney(getMoney()-cost);
	}
	
	public int getCnt() {
		return cnt;
	}
	
	public int getTotalTako() {
		return totalTako;
	}
	
	public int getGuestLimit() {
		return guestLimit;
	}
	
	public void setGuestLimit(int guestLimit) {
		this.guestLimit = guestLimit;
	}
	
}
