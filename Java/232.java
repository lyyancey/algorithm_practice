class MyQueue{
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;
    public MyQueue(){
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }
    public void push(int x){
        inputStack.push(x);
    }
    public int pop(){
        out();
        return outputStack.pop();
    }
    public int peek(){
        out();
        return outputStack.peek();
    }
    public boolean empty(){
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
    private void out(){
        while(outputStack.isEmpty()){
            while(!inputStack.isEmpty()){
                outputStack.push(inputStack.pop());
            }
        }
    }
}