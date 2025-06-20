package DynArr;

public class Test {
	public static void brackets(String expr) {
		 Stack<Character> s = new Stack<>();
		  int stackPointer = 0;
		  boolean first = true;
		    
		  try {
		  
		  for(int i = 0; i < expr.length(); i++) {
			  char c = expr.charAt(i);
			  
			  if(c == '(' || c == '{' || c == '[') {
				  first = false;
				  s.push(c);
				  stackPointer++;
				  continue;
			  }
			  
				  if(c == ')' ||  c == '}' || c == ']') {if(first) throw new IllegalStateException();}
					  
					  if (c == ')') {
						  if(s.top() == '(') {s.pop();stackPointer--;}
						  else throw new IllegalStateException();
					  }
					  
					  if (c == '}') {
						  if(s.top() == '{') {s.pop();stackPointer--;}
						  else throw new IllegalStateException();
					  }
					  
					  if (c == ']') {
						  if(s.top() == '[') {s.pop();stackPointer--;}
						  else throw new IllegalStateException();
					  }
				  }
		  	
		  		if(stackPointer!=0) throw new IllegalStateException();
		  	}
		 	
		  	catch (Exception e) {
			  System.out.println("No");
			  return;
		  	}
		  
		  System.out.println("Yes");
		}
		
		
	 public static void main(String[] args) {
	  Stack<Integer> a=new Stack<>();
	  for (int i=1;i<=2;i++)a.push(i);
	  //System.out.println(a);
	  //s.push("Bobson");
	  //s.push("Mama");
	  //s.push("Gyatomir");
	  //System.out.println(s);
	  //System.out.println(s.pop());
	  //System.out.println(s);
	  
	  //brackets("(({}))");
	  
	  a.swap();
	  System.out.println(a);
	  
	  Queue <Integer> q = new Queue<>();
	  for(int i = 1; i<=10; i++) {
		  q.add(i);
	  }
	  int num = q.get();
	  System.out.println(q);
	  System.out.println(num);
	 }
}
