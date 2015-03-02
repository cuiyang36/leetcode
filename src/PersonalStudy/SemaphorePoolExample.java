package PersonalStudy;

import java.util.HashSet;
import java.util.Random;
/**
 * Use Semaphore in Java to simulate a pool example
 */
import java.util.concurrent.Semaphore;

public class SemaphorePoolExample {

	public class Pool {

		private static final int MAX_AVAILABLE = 100;
		private final Semaphore available;
		protected Object[] items;
		protected boolean[] used;
		
		public Pool(){
			available = new Semaphore(MAX_AVAILABLE, true);
			items = new Integer[MAX_AVAILABLE];
			for (int i = 0; i < MAX_AVAILABLE; i++) {
				items[i] = new Integer(i);
			}
			used = new boolean[MAX_AVAILABLE];
		}
		
		public Object getItem() throws InterruptedException {
			available.acquire();
			return getNextAvailableItem();
		}

		public void putItem(Object x) {
			if (markAsUnused(x))
				available.release();
		}

		protected synchronized Object getNextAvailableItem() {
			for (int i = 0; i < MAX_AVAILABLE; ++i) {
				if (!used[i]) {
					System.out.println("unused i: " + i);
					used[i] = true;
					return items[i];
				}
			}
			return null;
		}

		protected synchronized boolean markAsUnused(Object item) {
			for (int i = 0; i < MAX_AVAILABLE; ++i) {
				if (item == items[i]) {
					if (used[i]) {
						used[i] = false;
						System.out.println("mark i unused: " + i + " success");
						return true;
					} else
						System.out
								.println("mark i unused: " + i + " unsuccess");
					return false;
				}
			}
			return false;
		}
	}
	
	public class ThreadDemo extends Thread{
		private String name;
		private Pool pool;
		
		public ThreadDemo(String name, Pool pool){
			this.name = name;
			this.pool = pool;
		}
		
		public void run(){
			System.out.println("name: " + name + " starts!");
			HashSet<Object> set = new HashSet<Object>();
			Random random = new Random();
			while (true) {
				//System.out.println("name " + name);
				try {
					if (random.nextInt(2) == 0) {
						set.add(pool.getItem());
					} else {
						Object delete = null;
						for (Object o : set) {
							delete = o;
							break;
						}
						if (delete != null) {
							set.remove(delete);
							pool.putItem(delete);
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		Pool pool = new SemaphorePoolExample().new Pool();
		Thread t1 = new SemaphorePoolExample().new ThreadDemo("client 2", pool);
		Thread t2 = new SemaphorePoolExample().new ThreadDemo("client 1", pool);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			System.out.println("Interrupted");
		}
	}
}
