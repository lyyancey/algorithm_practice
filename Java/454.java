class Problem454{
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i : nums1){
            for(int j : nums2){
                int tem = i + j;
                map.put(tem, map.getOrDefault(tem, 0)+1);
            }
        }
        for(int i : nums3){
            for(int j : nums4){
                int tem = i + j;
                if(map.containsKey(0 - tem)){
                    res += map.get(0-tem);
                }
            }
        }
        return res;
    }
}