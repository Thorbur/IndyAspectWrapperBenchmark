package abstractbenchmark;

import java.lang.reflect.Method;

import org.junit.BeforeClass;
import org.junit.Test;

public abstract class AbstractAckermannBenchmark extends SuperBenchmark {

	// benchmark parameters
	static int ackermannN;
	static int ackermannM;

	// Reflection Objects
	static Class<?> Ackermann;
	static Method ackermann;

	static Class<?> GroovyAckermann;
	static Method Groovyackermann;

	static Class<?> GroovyIndyAckermann;
	static Method GroovyIndyackermann;

	private static void loadConfig() throws Throwable {
		
		ackermannN = Integer.parseInt(configFile.getProperty("ACKERMANNN"));
		ackermannM = Integer.parseInt(configFile.getProperty("ACKERMANNM"));
	}

	private static void initAckermann() throws Throwable {
		Ackermann = Class.forName("javapure.Ackermann");
		ackermann = Ackermann.getMethod("ackermann", new Class<?>[] { int.class, int.class });
	}

	private static void initGroovyAckermann() throws Throwable {
		GroovyAckermann = Class.forName("GroovyAckermann");
		Groovyackermann = GroovyAckermann.getMethod("ackermann", new Class<?>[] { Object.class, Object.class });
	}

	private static void initGroovyIndyAckermann() throws Throwable {
		GroovyIndyAckermann = Class.forName("GroovyIndyAckermann");
		GroovyIndyackermann = GroovyIndyAckermann.getMethod("ackermann", new Class<?>[] { Object.class, Object.class });
	}
	
	@BeforeClass
	public static void beforeClass() throws Throwable {

		loadConfig();

		initAckermann();
		initGroovyAckermann();
		initGroovyIndyAckermann();
	}

	@Test
	public void benchAckermann() throws Throwable {
		System.out.println(ackermann.invoke(Ackermann.newInstance(), ackermannN, ackermannM));
	}

	@Test
	public void benchGroovyAckermann() throws Throwable {

		System.out.println(Groovyackermann.invoke(GroovyAckermann.newInstance(), ackermannN, ackermannM));
	}

	@Test
	public void benchGroovyIndyAckermann() throws Throwable {

		System.out.println(GroovyIndyackermann.invoke(GroovyIndyAckermann.newInstance(), ackermannN, ackermannM));
	}

}
