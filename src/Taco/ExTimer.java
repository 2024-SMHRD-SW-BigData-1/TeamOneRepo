//package Taco;
//
//import java.util.Random;
//import java.util.Timer;
//import java.util.TimerTask;
//
//public class ExTimer {
//	static int  remainTime;
//	
//	
//	
//	
//	
//	
//	
//	public void extimer1() {
//		
//		Random rd = new Random();
//		remainTime = rd.nextInt(10)+10;
//		
//		Timer t  = new Timer();
//		
//		TimerTask task = new TimerTask() {
//			
//			
//			@Override
//			public void run() {
//				if(MakeTako.wrong) {
//					System.exit(0);
//				}
//				
//				System.out.println("남은 시간 : " + remainTime + "초");
//				remainTime--;
//				
//				if(remainTime <=0) {
//					
//					t.cancel();
//				}
//				
//			}
//			
//		};
//			t.schedule(task, 0, 1000);
//			
//	}
//	
//	
//	
//	
//
//}
