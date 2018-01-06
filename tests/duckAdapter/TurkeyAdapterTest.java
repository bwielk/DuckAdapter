package duckAdapter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TurkeyAdapterTest {
	
	private Duck duck;
	private Turkey turkey;
	private TurkeyAdapter adapter;
	
	@Before
	public void before() {
		duck = new MallardDuck();
		turkey = new WildTurkey();
		adapter = new TurkeyAdapter(turkey);
	}
	
	public static String testFlyDuck(Duck duck){
		return duck.fly();
	}
	
	public static String testQuackDuck(Duck duck){
		return duck.quack();
	}
	
	@Test
	public void duckCanFlyAndQuack(){
		assertEquals("I am flying", duck.fly());
		assertEquals("I am quacking", duck.quack());
	}
	
	@Test
	public void turkeyCanFlyandGobble(){
		assertEquals("I am gobbling", turkey.gobble());
		assertEquals("I am flying in a short distance", turkey.fly());
	}
	
	@Test
	public void turkeyHasDucksBehaviour(){
		assertEquals("I am gobbling", testQuackDuck(adapter));
		assertEquals("I am flying in a short distance. I am still just a Turkey", testFlyDuck(adapter));
	}
}
