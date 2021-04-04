import java.util.HashMap;
import java.util.*;
class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new  HashMap<Integer, Integer>();
        int ans = 0;
        for(int y : answers){
            map.put(y, map.getOrDefault(y, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int x = entry.getValue(),  y = entry.getKey();
            ans += (x+y)/(y+1)*(y+1);
        }
        return ans;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[] x = {1,2,1};
        int k = s.numRabbits(x);
        System.out.println(k);
    }
}