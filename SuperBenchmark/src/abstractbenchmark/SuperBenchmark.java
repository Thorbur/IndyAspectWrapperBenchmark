package abstractbenchmark;

import java.io.IOException;
import java.util.Properties;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;

public class SuperBenchmark extends AbstractBenchmark{
	
	static Properties configFile;

	static {

		configFile = new Properties();
		String resPath = "Benchmark.properties";
		try {
			configFile.load(ClassLoader.getSystemClassLoader().getResourceAsStream(resPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
