package benchmark;

import abstractbenchmark.AbstractFibonacciBenchmark;

import com.carrotsearch.junitbenchmarks.annotation.AxisRange;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;

@AxisRange(min = 0, max = 1)
@BenchmarkMethodChart(filePrefix = "fibonacci-basis-benchmark")
public class FibonacciBenchmark extends AbstractFibonacciBenchmark {
}
