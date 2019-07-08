package SingleTon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSafeSingleton {
	private static ThreadSafeSingleton instance;
	private ThreadSafeSingleton(){
		System.out.println("ThreadSafeSingletonCreating...");
	}
	/// Here we have created lazy initialization with synchronized block
	///because of synchronized block the thread will not access the block 
	/// at same time hence over singleton is safe with thread
	
//	public static ThreadSafeSingleton getInstance(){
	public static synchronized ThreadSafeSingleton getInstance(){
	     if(instance == null){
	    	 instance = new ThreadSafeSingleton();
	     }
	     return instance;
	}
}
class TestThreadSafeSingleTon{
	static void UseThread() {
		ThreadSafeSingleton Thread=ThreadSafeSingleton.getInstance();
		System.out.println(Thread.hashCode());
	}
	public static void main(String[] args) {
		ExecutorService service=Executors.newFixedThreadPool(3);
		service.submit(TestThreadSafeSingleTon::UseThread);
		service.submit(TestThreadSafeSingleTon::UseThread);
		service.submit(TestThreadSafeSingleTon::UseThread);
		service.shutdown();
	}
}
