package SingleTon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LazyInitialization {
    private static LazyInitialization instance;
	private LazyInitialization(){
		System.out.println("CreatingLazy..");
	}
	public static LazyInitialization getInstance(){
	    if(instance == null){
	    	instance = new LazyInitialization();
	    }
	    return instance;
	}
}
class TestLazy{
	static void useLazy() {
		LazyInitialization Lazy1=LazyInitialization.getInstance();
		System.out.println(Lazy1.hashCode());
	}
	public static void main(String[] args) {
//		LazyInitialization Lazy1=LazyInitialization.getInstance();
//		LazyInitialization Lazy2=LazyInitialization.getInstance();
//		System.out.println(Lazy1.hashCode());
//		System.out.println(Lazy2.hashCode());
/// 	Lazy initialization is broblamatic with multithread 
		/// because with multithreading 
		/// if more than one thread access our lazy initializaton block
		/// than each thread get instanc as null
		/// hence create its instance
		ExecutorService service=Executors.newFixedThreadPool(2);
		service.submit(TestLazy::useLazy);
		service.submit(TestLazy::useLazy);
		service.shutdown();
	}
}