package schreiber.threads;

import java.math.BigInteger;

public class Factorial extends Thread {

	public static BigInteger factorial(long num) {
		BigInteger factorial = BigInteger.valueOf(num);
		for (long i = num - 1; i > 0; i--) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		return factorial;
	}

	private final long n;

	public Factorial(int n) {
		this.n = n;
	}

	@Override
	public void run() {
		// everything you want thread to do goes in this method
		// TODO Auto-generated method stub
		super.run();

		// System.out.println("Value");
		System.out.println(factorial(n));

	}

}
