package abstractbenchmark;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public abstract class AbstractSortingBenchmark extends SuperBenchmark {

	// benchmark parameters
	static int sortSize;

	// to be initialized
	static List<Integer> numberList;

	// Reflection Objects
	static Class<?> Sorting;
	static Method quicksort;

	static Class<?> GroovySorting;
	static Method Groovyquicksort;

	static Class<?> GroovyIndySorting;
	static Method GroovyIndyquicksort;

	private static void loadConfig() throws Throwable {
		sortSize = Integer.parseInt(configFile.getProperty("SORTNUMBERS"));
	}

	private static void initSort(int amount) {

		numberList = new ArrayList<Integer>();

		for (int i = 0; i < amount; i++) {
			int rand = (int) (100 * Math.random());
			numberList.add(rand);
		}
	}

	private static void initSorting() throws Throwable {
		Sorting = Class.forName("javapure.Sorting");
		quicksort = Sorting.getMethod("quicksort", new Class<?>[] { List.class });
	}

	private static void initGroovySorting() throws Throwable {
		GroovySorting = Class.forName("GroovySorting");
		Groovyquicksort = GroovySorting.getMethod("quicksort", new Class<?>[] { Object.class });
	}

	private static void initGroovyIndySorting() throws Throwable {
		GroovyIndySorting = Class.forName("GroovyIndySorting");
		GroovyIndyquicksort = GroovyIndySorting.getMethod("quicksort", new Class<?>[] { Object.class });
	}

	@BeforeClass
	public static void beforeClass() throws Throwable {

		loadConfig();
		initSort(sortSize);

		initSorting();
		initGroovySorting();
		initGroovyIndySorting();
	}

	@Test
	public void benchSorting() throws Throwable {
		
		System.out.println(quicksort.invoke(Sorting.newInstance(), numberList));
	}

	@Test
	public void benchGroovySorting() throws Throwable {

		System.out.println(Groovyquicksort.invoke(GroovySorting.newInstance(), numberList));
	}

	@Test
	public void benchGroovyIndySorting() throws Throwable {

		System.out.println(GroovyIndyquicksort.invoke(GroovyIndySorting.newInstance(), numberList));
	}

}
