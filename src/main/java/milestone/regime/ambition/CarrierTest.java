package milestone.regime.ambition;

import java.util.LinkedHashMap;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.websocket.Session;

class WaitThread implements Runnable {
	public CyclicBarrier barrier;
       
	public WaitThread(CyclicBarrier barrier) {
		super();
		this.barrier = barrier;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Horse implements Runnable {
	   Session session;
	String translate;
	public CyclicBarrier barrier;
	public static LinkedHashMap<Integer, String> abc;
	public ExecutorService exec;
	int index;
	static int ex;

	public Horse(CyclicBarrier barrier, ExecutorService exe,Session session) {
		this.barrier = barrier;
		this.exec = exe;
		// TODO Auto-generated constructor stub
this.session=session;
	}

	@Override
	public void run() {

		// TODO Auto-generated method stub
		try {
			while (!Thread.interrupted() && (abc.size() > 0)) {

				synchronized (abc) {
					index = abc.size();

					if (index > 0) {

						translate = abc.get(--index);

						abc.remove(index);
						if (abc.size() == 0) {
							for (int i = 0; i < ex; i++)
								new Thread(new WaitThread(barrier)).start();

						}
					}

				}

				// barrier靠后
				if (translate != null && (!translate.equals(" "))) {

					new Thread(new Critical(translate, index,session)).run();
				}
				barrier.await();

			}
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
	
		}
	}

}

public class CarrierTest {
	private CyclicBarrier barrier;
	public LinkedHashMap<Integer, String> map;
	ExecutorService exec = Executors.newCachedThreadPool();
 Session session;
	public CarrierTest(int t, LinkedHashMap<Integer, String> map, Session session
			) {
		this.session=session;
		this.map = map;
		barrier = new CyclicBarrier(t, new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub

				try {
					Thread.sleep(2000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (Horse.abc.size() == 0) {
					exec.shutdownNow();
				}

			}

		});

		Horse.abc = map;

		for (int i = 0; i < t; i++) {
			exec.execute(new Horse(barrier, exec,session));
		
		}
		// abc.add("consecutive");
		// exec.execute(new Horse(barrier,abc));
		// abc.add("abandone");
		// exec.execute(new Horse(barrier,abc));
		// abc.add("riqiu");
		// exec.execute(new Horse(barrier,abc));
		//
	}
}
