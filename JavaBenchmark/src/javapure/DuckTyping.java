package javapure;

public class DuckTyping {

	class X{
		public String foo(){
			return "X.foo()";
		}
	}
	
	class Y{
		public String foo(){
			return "Y.foo()";
		}
	}
	
	class Z{
		public String foo(){
			return "Z.foo()";
		}
	}
	
	public void bar(X x) {
		x.foo();
	}
	
	public void bar(Y y) {
		y.foo();
	}
	
	public void bar(Z z) {
		z.foo();
	}
	
	public void run(int iterations){
		
		for(int i=0; i<iterations/3; i++){
			bar(new X());
			bar(new Y());
			bar(new Z());
		}
	}
	
}
