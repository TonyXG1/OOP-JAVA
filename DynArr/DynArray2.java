//Динамичен масив с обобщен тип
class DynArray <T>{
 /*Методи:
  +add
  +getCount
  +get
  +set
  +removeLast
  +toString -->{el0,el1,...,el_last}
  */
 private final int ENLARGE=16;
 private Object arr[];
 private int size, first, last;
 public DynArray(){
  arr=new Object[ENLARGE];   
  size=ENLARGE;
  first = 0;
  last = -1;
 }
 public int getCount() {
  return last - first + 1;
 }
 public void add(T a){
  if (getCount()==size)  {
   size=getCount() + ENLARGE;
   Object[] newArr=new Object[size];
   int lastNew = 0;
   for (int i=first, j = 0;i<=last;i++, j++)
	   {
	   newArr[j]=arr[i];
	   lastNew++;
	   }
   arr=newArr;
   first = 0;
   last = lastNew--;
  }
  arr[++last]=a;   
 }
 @SuppressWarnings("unchecked")
 public T get(int n) throws ArrayIndexOutOfBoundsException{
  if (n<0 || n>=getCount()) throw new ArrayIndexOutOfBoundsException();
  return (T)arr[n];
 }
 public void set (int n,T v)throws ArrayIndexOutOfBoundsException{
  if (n<0 || n>=getCount()) throw new ArrayIndexOutOfBoundsException();
  arr[n]=v;
 }
 public void removeLast()throws ArrayIndexOutOfBoundsException{
  if (getCount()==0) throw new ArrayIndexOutOfBoundsException();
  last--;
 } 
 public int getFirst() {
	return first;
}
public void setFirst(int first) {
	this.first = first;
}
public int getLast() {
	return last;
}
public void setLast(int last) {
	this.last = last;
}
 
 @Override
 public String toString(){
  String s="{";
  for (int i=0;i<getCount();i++) {
   if (!s.equals("{")) s+=",";
   s+=arr[i].toString();
  }
  return s+"}";
 }
}
//Примерен потребителски клас
class Point{
 private int x,y;
 public Point(int a,int b){
  x=a;y=b;
 }
 @Override
 public String toString(){
  return "("+x+","+y+")";
 }
}

/*
 * Stack(LIFO => Last In First Out)
 * push
 * pop
 * top
 * swap
 * reverse
 */


class Stack <T> 
{
	private DynArray<T> list;
	private int stackPtr;
	
	public Stack()
	{
		list = new DynArray<>();
		stackPtr = -1;
	}
	
	public void push(T element)
	{
		list.add(element);
		stackPtr++;
	}
	
	public T pop() throws IllegalStateException
	{
		if(stackPtr == -1) throw new IllegalStateException("Empty Stack");
		
		//alternative
		T temp = list.get(stackPtr);
		list.removeLast();
		stackPtr--;
		return temp;
		
//		return list.get(stackPtr--);
	}
	
	public T top() throws IllegalStateException
	{
		if(stackPtr == -1) throw new IllegalStateException("Empty Stack");
		return list.get(stackPtr);
	}
	
	public boolean isEmpty()
	{
		if(stackPtr == -1) return true;
		return false;
	}
	
	public void swap() throws IllegalStateException
	{
		if(stackPtr < 1) throw new IllegalStateException("Not enough elements to swap");
		
		T temp1 = pop();
		T temp2 = pop();
		
		push(temp1);
		push(temp2);
	}

	@Override
	public String toString() {
		return list.toString();
	}
}
