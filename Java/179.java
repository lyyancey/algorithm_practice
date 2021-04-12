import java.lang.reflect.Array;
import java.util.*;
class Problem179 {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for(int i=0;i<nums.length;i++)s[i] = String.valueOf(nums[i]);
        Arrays.sort(s,(a,b)->{
            return (b+a).compareTo(a+b);
        });
        StringBuilder t = new StringBuilder();
        if("0".equals(s[0]))return "0";
        for(int i = 0;i<s.length;i++){
            t.append(s[i]);
        }
        return s.toString();

    }
}
