class Problem264 {
  public int nthUglyNumber(int n) {
      int[] dp = new int[n+1];
      dp[1]=1;
      int sp2=1, sp3 = 1,sp5 = 1;
      int num2=0,num3=0,num5=0;
      for(int i = 2;i<=n; i++){
          num2 = dp[sp2]*2;
          num3 = dp[sp3]*3;
          num5 = dp[sp5]*5;
          dp[i] = Math.min(Math.min(num2, num3), num5);
          if(dp[i]==num2)sp2++;
          if(dp[i]==num3)sp3++;
          if(dp[i]==num5)sp5++;
      }
      return dp[n];

  }
  public static void main(String[] args){
      Problem264 p = new Problem264();
      p.nthUglyNumber(10);
  }
}
