class Stack{
	int top=-1;
	int capacity=10;
	
	//PUSH
	void push(int arr[],int data) {
		if(top==capacity-1) {
			System.out.println("Stack overflow");
		}
		else {
			top++;
			arr[top]=data;
		}
	}
	
	//POP
	int pop(int arr[]) {
		if(top==-1) {
			System.out.println("Stack underflow");
			return -1;
		}
		else {
			int data=arr[top];
			top--;
			return data;
		}
		
	}
	
	//PEEK
	int peek(int arr[]) {
		if(top==-1) {
			System.out.println("Stack underflow");
			return -1;
		}
		else {
			
			return arr[top];
		}
		
		
	}
	
	//Display
    void display(int arr[]) {
    	if(top==-1) {
    		System.out.println("Stack underflow");
    		return;
    	}
    	for(int i=top;i>=0;i--) {
    		System.out.println(arr[i]+" ");
    	}
    	System.out.println();
    	
    }
	
}

public class Stackarr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s = new Stack();

        int arr[] = new int[10];

        s.push(arr, 10);
        s.push(arr, 20);
        s.push(arr, 30);

        System.out.println("Stack:");
        s.display(arr);

        System.out.println("Peek: " + s.peek(arr));

        System.out.println("Popped: " + s.pop(arr));

        System.out.println("Stack after pop:");
        s.display(arr);

        System.out.println("Peek: " + s.peek(arr));

	}

}
