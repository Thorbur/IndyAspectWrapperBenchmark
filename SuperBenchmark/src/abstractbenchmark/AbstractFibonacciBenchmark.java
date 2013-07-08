package abstractbenchmark;

import java.lang.reflect.Method;

import org.junit.BeforeClass;
import org.junit.Test;

public abstract class AbstractFibonacciBenchmark extends SuperBenchmark {

	// benchmark parameters
	static int fibo;

	static// Reflection Objects
	Class<?> Fibonacci;
	static Method fib;

	static Class<?> GroovyFibonacci;
	static Method Groovyfib;

	static Class<?> GroovyIndyFibonacci;
	static Method GroovyIndyfib;	

	public static void loadConfig() throws Throwable {
		
		fibo = Integer.parseInt(configFile.getProperty("FIBONACCINUMBER"));
	}

	public static void initFibonacci() throws Throwable {
		Fibonacci = Class.forName("javapure.Fibonacci");
		fib = Fibonacci.getMethod("fib", new Class<?>[] { int.class });
	}

	public static void initGroovyFibonacci() throws Throwable {
		GroovyFibonacci = Class.forName("GroovyFibonacci");
		Groovyfib = GroovyFibonacci.getMethod("fib", new Class<?>[] { Object.class });
	}

	public static void initGroovyIndyFibonacci() throws Throwable {
		GroovyIndyFibonacci = Class.forName("GroovyIndyFibonacci");
		GroovyIndyfib = GroovyIndyFibonacci.getMethod("fib", new Class<?>[] { Object.class });
	}
	
	@BeforeClass
	public static void beforeClass() throws Throwable {

		loadConfig();
		
		initFibonacci();
		initGroovyFibonacci();
		initGroovyIndyFibonacci();
	}

	@Test
	public void benchFib() throws Throwable {

		System.out.println(fib.invoke(Fibonacci.newInstance(), fibo));
	}

	@Test
	public void benchGroovyFib() throws Throwable {

		System.out.println(Groovyfib.invoke(GroovyFibonacci.newInstance(), fibo));
	}

	@Test
	public void benchGroovyIndyFib() throws Throwable {

		System.out.println(GroovyIndyfib.invoke(GroovyIndyFibonacci.newInstance(), fibo));
	}

}
