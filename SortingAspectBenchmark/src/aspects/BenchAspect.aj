package aspects;

import java.util.List;

import org.aspectj.lang.annotation.SuppressAjWarnings;

public aspect BenchAspect {
	
	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Object n) : call(* *.quicksort(..)) && args(n) && !within(*.groovy.*) {
		
		if(((List<?>) n).size() > 25000){
			System.out.println(((List<?>) n).size());
		}
		
		return proceed(n);
	}
}
