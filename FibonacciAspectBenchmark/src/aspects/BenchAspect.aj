package aspects;

import org.aspectj.lang.annotation.SuppressAjWarnings;

public aspect BenchAspect {
	
	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Object n) : call(* *.fib(..)) && args(n) && !within(*.groovy.*) {
		
		if(n.equals(19)){
			//System.out.println(n);
		}
		
		return proceed(n);
	}
	
}
