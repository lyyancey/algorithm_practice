class Problem1482{
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length)return -1;
        int low = 1,high = 1;
        for(int i=0;i<bloomDay.length;i++){
            high = Math.max(bloomDay[i], high);
        }
        while(low<=high){
            int mid = (high-low)/2 + low;
            if(canMake(bloomDay, mid, m, k)){
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return high;
    }
    private boolean canMake(int[] bloomDay, int days, int m, int k){
        int flowers = 0, num= 0;
        for(int i=0;i<bloomDay.length&&num<days;i++){
            if(bloomDay[i]<=days){
                flowers++;
                if(flowers==k){
                    num++;
                    flowers = 0;
                }
            }else{
                flowers = 0;
            }
        }
        return num == days;
    }
}
