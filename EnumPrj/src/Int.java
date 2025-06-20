import javax.lang.model.element.Element;

public class Int implements Enumerable<Int>{
	private long data;
	public Int() {
		data = 0;
	}
	
	public Int(long data) {
		this.data = data;
	}

	@Override
	public long f() {
		if(this.data > 0) return 2*this.data;
		return -(this.data)*2 + 1;
	}

	@Override
	public Int g(long n) throws IllegalArgumentException {
		if(n%2 == 0) return new Int(n/2);
		return new Int(-(n-1)/2);
	}

	@Override
	public String toString() {
		return data + "";
	}
}
