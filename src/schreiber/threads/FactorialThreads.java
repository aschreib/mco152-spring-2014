package schreiber.threads;

public class FactorialThreads {

	public static void main(String[] args) {
		Thread t1 = new Factorial(1000);
		Thread t2 = new Factorial(500);

		t1.start();
		t2.start();

	}

}
