package wrap;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

import org.aspectj.lang.annotation.SuppressAjWarnings;

import de.ecspride.indyaspectwrapper.model.MemberNameInfo;
import de.ecspride.indyaspectwrapper.util.Java7ReflectionHelper;
import de.ecspride.indyaspectwrapper.wrapper.MethodHandleWrapper;

public aspect WrapMethodHandle {

	MethodHandleWrapper wrapper = new MethodHandleWrapper(this.getClass().getCanonicalName());
	Java7ReflectionHelper java7ReflectionHelper = new Java7ReflectionHelper();

	@SuppressAjWarnings("adviceDidNotMatch")
	MethodHandle around() : call(MethodHandle MethodHandles.explicitCastArguments(..)) && withincode(void *.setCallSiteTarget(..) ) {

		MethodHandle mh = proceed();

		MemberNameInfo mni = java7ReflectionHelper.getInsideMemberNameInfo(mh);
		if (mni.getName().contains("fib") || mni.getName().contains("ackermann") || mni.getName().contains("quicksort")) {
			try {
				Method inside = mni.getDeclaringClass().getDeclaredMethod(mni.getName(), mni.getMethodType().parameterArray());
				inside.setAccessible(true);

				mh = wrapper.getWrappedMethodHandleWithMethod(inside, mh);

			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

		return mh;
	}

}
