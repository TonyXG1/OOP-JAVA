package DynArr;

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
 private int size,count;
 public DynArray(){
  arr=new Object[ENLARGE];   
  size=ENLARGE;
  count=0;
 }
 public int getCount() {
  return count;
 }
 public void add(T a){
  if (count==size)  {
   size+=ENLARGE;
   Object[] newArr=new Object[size];
   for (int i=0;i<count;i++) newArr[i]=arr[i];
   arr=newArr;
  }
  arr[count++]=a;   
 }
 @SuppressWarnings("unchecked")
 public T get(int n) throws ArrayIndexOutOfBoundsException{
  if (n<0 || n>=count) throw new ArrayIndexOutOfBoundsException();
  return (T)arr[n];
 }
 public void set (int n,T v)throws ArrayIndexOutOfBoundsException{
  if (n<0 || n>=count) throw new ArrayIndexOutOfBoundsException();
  arr[n]=v;
 }
 public void removeLast()throws ArrayIndexOutOfBoundsException{
  if (count==0) throw new ArrayIndexOutOfBoundsException();
  count--;
 }
 @Override
 public String toString(){
  String s="{";
  for (int i=0;i<count;i++) {
   if (!s.equals("{")) s+=",";
   s+=arr[i].toString();
  }
  return s+"}";
 }
}

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
 * Stack (Last in first out) - LIFO
 * push
 * pop
 * top
 * swap
 * reverse
 */


  
