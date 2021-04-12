class Problem263 {
  public boolean isUgly(int n) {
      if(n<=0){
          return false;
      }
      int[] f = {2,3,5};
      for(int x : f){
          while(n%x==0){
              n/=x;
          }
      }
      return n==1;
  }
  
}
