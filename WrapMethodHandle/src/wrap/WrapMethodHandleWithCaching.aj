package wrap;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.Hashtable;

import model.MemberNameInfo;

import org.aspectj.lang.annotation.SuppressAjWarnings;

import util.Java7ReflectionHelper;
import wrapper.Wrapper;

public aspect WrapMethodHandleWithCaching {

	Hashtable<MethodHandle, MethodHandle> wrappedMHs = new Hashtable<MethodHandle, MethodHandle>();

	Wrapper wrapper = new Wrapper(this.getClass().getCanonicalName());
	Java7ReflectionHelper java7ReflectionHelper = new Java7ReflectionHelper();

	@SuppressAjWarnings("adviceDidNotMatch")
	MethodHandle around() : call(MethodHandle MethodHandles.explicitCastArguments(..)) && withincode(void *.setCallSiteTarget(..) ) {

		MethodHandle mh = proceed();
		MethodHandle wrapped = mh;

		if (!wrappedMHs.contains(mh)) {
			MemberNameInfo mni = java7ReflectionHelper.getInsideMemberNameInfo(mh);
			try {
				Method inside = mni.getDeclaringClass().getDeclaredMethod(mni.getName(), mni.getMethodType().parameterArray());
				inside.setAccessible(true);

				wrapped = wrapper.getWrappedMethodHandleWithMethod(inside, mh);
				wrappedMHs.put(mh, wrapped);

			} catch (Throwable e) {
				e.printStackTrace();
			}
		} else {
			wrapped = wrappedMHs.get(mh);
		}

		return wrapped;
	}

}
