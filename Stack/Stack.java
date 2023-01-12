package deneme;

public class Stack {
         private int top;
         private Object[] elements;
         public Stack(int capacity) {
        	 elements=new Object[capacity];
        	 top=-1;
         }
         public boolean isEmpty() {
        	 return (top==-1);
         }
         public boolean isFull() {
        	 return (top+1==elements.length);
         }
         public void push(Object data) {
        	 if (isFull()) {
				System.out.println("Stack overflow");
			}
        	 else {
				top++;
				elements[top]=data;
			}
         }
         public Object pop() {
        	 if (isEmpty()) {
				System.out.println("Stack is empty");
				return null;
			}
        	 else {
				Object rData=elements[top];
				top--;
				return rData;
			}
         }
         public Object peek() {
        	 if (isEmpty()) {
				System.out.println("Stack is null");
				return null;
			}
        	 else {
				return elements[top];
			}
         }
         int size() {
        	 return top+1;
         }
        
}
