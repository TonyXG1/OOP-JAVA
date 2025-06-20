
public class Even <T> implements Enumerable<Even>{
	private long data;
	public Even() {
		data = 0;
	}
	
	public Even(long n) throws IllegalArgumentException{
		if(n < 0 || n%2 != 0) throw new IllegalArgumentException("The element is not even");
		data = n;
	}
	
	@Override
	public long f() {
	 return data/2+1;
	}
	@Override
	public Even g(long n) throws IllegalArgumentException {
	 if (n<=0)throw new IllegalArgumentException("Illegal number");
	 return new Even(2*(n-1));
	}
	@Override
	public String toString(){
	 return Long.toString(data);
	}
	
}
