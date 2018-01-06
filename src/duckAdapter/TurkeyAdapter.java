package duckAdapter;

//You are converting Turkey into a Duck

public class TurkeyAdapter implements Duck {
	
	Turkey turkey;

	public TurkeyAdapter(Turkey turkey){
		this.turkey = turkey;
	}
	
	public String quack() {
		return turkey.gobble();
	}

	public String fly() {
		return turkey.fly() + ". I am still just a Turkey";
	}
}
