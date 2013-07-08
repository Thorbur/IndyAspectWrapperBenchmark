package benchmark;

import abstractbenchmark.AbstractFibonacciBenchmark;

import com.carrotsearch.junitbenchmarks.annotation.AxisRange;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;

@AxisRange(min = 0, max = 1)
@BenchmarkMethodChart(filePrefix = "fibonacci-wrappedmh-aspect-benchmark")
public class WrappedMHAspectFibonacciBenchmark extends AbstractFibonacciBenchmark {
}
