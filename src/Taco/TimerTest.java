//package Taco;
//
//import java.util.Random;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
//public class TimerTest {
//
//	public static void main(String[] args) {
//		Random rd = new Random();
//        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//
//        // 타이머 초기값 설정
//        int initialDelay = rd.nextInt(10)+10;
//
//        // 타이머가 1초마다 감소하도록 설정
//        int period = 1;
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
//            	
//                if (remainingTime >= 0) {
//                    System.out.println("Remaining time: " + remainingTime + " seconds");
//                    remainingTime--;
//                } else {
//                    
//                    scheduler.shutdown(); // 타이머 작업 완료 후 스케줄러 종료
//                }
//            }
//        };
//
//        // 초기 지연 후에 주기적으로 작업을 수행하도록 스케줄링
//        scheduler.scheduleAtFixedRate(task, 0, period, TimeUnit.SECONDS);
//    }
//		
//		
//		
//		
//	
//
//}
