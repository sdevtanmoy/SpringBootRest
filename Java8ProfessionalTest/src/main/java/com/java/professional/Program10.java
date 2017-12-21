package com.java.professional;

public class Program10 {

	public static void main(String[] args) {

		// 1.
		Foo<String, Integer> mark = new Foo<String, Integer>("Steve", 1000); 
		System.out.println(mark);
		//2
		Foo<String, String> pair = Foo.<String>twice("Hello World");
		System.out.println(pair);
		
		//3.
		Foo<?, ?> percentage = new Foo<>(97, 32);
		System.out.println(percentage);
		//4.
		Foo<String, String> grade = new Foo<>("John", "A");
		System.out.println(grade);
		
		
		//Foo<Object, Object> percentage = new Foo<String, Integer>("Steve", 100);
	}

}


class Foo<K, V>{
	private K key;
	private V value;
	
	public Foo(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public static <T> Foo<T, T> twice(T value){
		return new Foo<T, T>(value, value);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Foo [key=" + key + ", value=" + value + " hash code"+this.hashCode()+"]"; 
	}
	
	
}