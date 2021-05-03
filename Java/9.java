class Problem9{
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        String s = String.valueOf(x);
        int fast = s.length()-1,slow = 0;
        while(slow<fast){
            if(s.charAt(fast)!=s.charAt(slow))return false;
            slow++;
            fast--;
        }
        return true;
    }
    public boolean isPalindrome1(int x) {
        if(x<0)return false;
        int res = 0, n=x, tem = 0;
        while(n!=0){
            tem = n%10;
            res = res*10+tem;
            n /= 10;
        }
        return res == x;
    }
}
