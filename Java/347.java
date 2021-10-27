class Problem347{
    public int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(int[] num1, int[] num2){
                return num2[1] - num1[1];
            }
        });
        for(int num : map.keySet()){
            pq.offer(new int[]{num, map.get(num)});
        }
        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}