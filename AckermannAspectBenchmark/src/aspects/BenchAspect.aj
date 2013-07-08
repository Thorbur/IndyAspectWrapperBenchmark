package aspects;

import org.aspectj.lang.annotation.SuppressAjWarnings;

public aspect BenchAspect {
	
	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Object n, Object m) : call(* *.ackermann(..)) && args(n,m) && !within(*.groovy.*) {
		
		if(n.equals(3) && m.equals(7)){
			//System.out.println(n + " " + m);
		}
		
		return proceed(n,m);
	}
	
}
