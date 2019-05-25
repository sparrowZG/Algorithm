package main.java.com.sparrow.zg.exercises.Code_5_25.jucUtil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
//循环栅栏
class Producer implements Runnable {
	private CyclicBarrier cyclicBarrier;

	public Producer(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		try {
			System.out.println("线程" + Thread.currentThread().getName() + "开始生产");

			TimeUnit.SECONDS.sleep(2);
			try {
				cyclicBarrier.await();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			System.out.println("线程"+Thread.currentThread().getName()+"生产完了,等待其他线程生产完");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class CyclirBarrierTest {
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
			@Override
			public void run() {
				System.out.println("线程全部到达此处");
			}
		});
		for (int i = 0; i < 3; i++) {
			new Thread(new Producer(cyclicBarrier), String.valueOf(i+1)).start();
		}

	}
}
