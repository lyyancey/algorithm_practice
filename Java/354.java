class Problem354{
    public int maxEnvelopes(int[][] envelopes){
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] == b[0] ? b[1] - a[1] : a[0]-b[0];
            }
        });
        // 对高度数组寻找LIS
        int[] height = new int[n];
        for(int i=0; i<n; i++){
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }
    private int lengthOfLIS(int[] height){
        int n = height.length;
        int[] top = new int[n];
        int piles = 0;
        for(int i=0; i<n; i++){
            int pocker = height[i];
            int left = 0, right = piles;
            while(left<right){
                int mid = (left+right)/2;
                if(top[mid]>pocker){
                    right = mid;
                }else if(top[mid]<pocker){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            if(left==piles) piles++;
            top[left] = pocker;
        }
        return piles;
    }

    // 第二种方法，耗时较长
    public int maxEnvelopes(int[][] envelopes){
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] == b[0] ? b[1]-a[1] : a[0] - b[0];
            }
        });
        int[] height = new int[n];
        for(int i=0; i<n; i++){
            height[i] = envelopes[i][1];
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=0; i<n; i++){
            for(int j=0;j<i; j++){
                if(height[i]>height[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int res = 1;
        for(int num : dp){
            res = Math.max(res, num);
        }
        return res;
    }
}