package wrap;

import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

import org.aspectj.lang.annotation.SuppressAjWarnings;

import de.ecspride.indyaspectwrapper.wrapper.BootstrapWrapper;

public aspect WrapBootstrap {

	BootstrapWrapper wrapper = new BootstrapWrapper(0, 1, this.getClass().getCanonicalName());

	@SuppressAjWarnings("adviceDidNotMatch")
	CallSite around(String name, MethodType type) : execution(CallSite *.*bootstrap(..)) && args(Lookup, *, type, name, ..) && !within(wrap..*) && !within(wrapper..*){

		CallSite cs = proceed(name, type);

		// CallSite Method Dispatch
		// if (!"runScript, <init>, println, name, getLogger".contains(name)) {
		// cs = wrapper.wrapAndWeave(cs, name, type);
		// }

		if (name.contains("fib") || name.contains("ackermann") || name.contains("quicksort")) {
			cs = wrapper.wrapAndWeave(cs, name, type);
		}

		return cs;
	}

}
