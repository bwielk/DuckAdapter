package duckAdapter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AdapterTest {
	
	private Duck duck;
	private Turkey turkey;
	private TurkeyAdapter turkeyAdapter;
	private DuckAdapter duckAdapter;
	
	@Before
	public void before() {
		duck = new MallardDuck();
		turkey = new WildTurkey();
		turkeyAdapter = new TurkeyAdapter(turkey);
		duckAdapter = new DuckAdapter(duck);
	}
	
	public static String testFlyDuck(Duck duck){
		return duck.fly();
	}
	
	public static String testQuackDuck(Duck duck){
		return duck.quack();
	}
	
	public static String testFlyTurkey(Turkey turkey){
		return turkey.fly();
	}
	
	public static String testGobbleTurkey(Turkey turkey){
		return turkey.gobble();
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
	public void turkeyIsConvertedIntoDuck(){
		assertEquals("I am gobbling", testQuackDuck(turkeyAdapter));
		assertEquals("I am flying in a short distance. I am still just a Turkey", testFlyDuck(turkeyAdapter));
	}
	
	@Test
	public void duckIsConvertedIntoTurkey(){
		assertEquals("I am quacking", testGobbleTurkey(duckAdapter));
		assertEquals("I am flying", testFlyTurkey(duckAdapter));
	}
}
