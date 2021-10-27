class Problem150{
    public int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(!isOpe(tokens[i])){
                stack.push(Integer.valueOf(tokens[i]));
            }else if(tokens[i] == "+"){
                stack.push(stack.pop() + stack.pop());
            }else if(tokens[i] == "-"){
                stack.push(-stack.pop() + stack.pop());
            }else if(tokens[i] == "*"){
                stack.push(stack.pop() * stack.pop());
            }else if(tokens[i] == "/"){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 / num1);
            }
        }
        return stack.pop();
    }
    private boolean isOpe(String s){
        if(s.length() == 1 &&(s.charAt(0) < '1' || s.charAt(0)>'9')){
            return true;
        }
        return false;
    }
}