package benchmark;

import abstractbenchmark.AbstractAckermannBenchmark;

import com.carrotsearch.junitbenchmarks.annotation.AxisRange;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;

@AxisRange(min = 0, max = 1)
@BenchmarkMethodChart(filePrefix = "ackermann-bootstrap-aspect-benchmark")
public class BootstrapAspectAckermannBenchmark extends AbstractAckermannBenchmark {
}
