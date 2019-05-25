package main.java.com.sparrow.zg.exercises.Code_5_25.jucUtil;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(3);
		for (int i = 0; i < 3; i++) {
			new Thread(() -> {
				System.out.println("线程" + Thread.currentThread().getName() + "开始");
				countDownLatch.countDown();
			}).start();
		}
		try {
			countDownLatch.await();
			System.out.println("线程全部到达,开始执行");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
