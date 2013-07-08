package benchmark;

import abstractbenchmark.AbstractSortingBenchmark;

import com.carrotsearch.junitbenchmarks.annotation.AxisRange;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;

@AxisRange(min = 0, max = 1)
@BenchmarkMethodChart(filePrefix = "sorting-wrappedmh-aspect-benchmark")
public class WrappedMHAspectSortingBenchmark extends AbstractSortingBenchmark {
}
