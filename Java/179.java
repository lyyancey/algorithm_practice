import java.util.*;
class Problem179 {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        //两个字符串拼接，按字典顺序，判断相对位置，这样得到的最后的值最大
        for(int i=0;i<nums.length;i++)s[i] = String.valueOf(nums[i]);
        Arrays.sort(s,(a,b)->{
            return (b+a).compareTo(a+b);
        });
        StringBuilder t = new StringBuilder();
        //如果第一个是零，则全局是零
        if("0".equals(s[0]))return "0";
        //将最后的字符串顺序拼接
        for(int i = 0;i<s.length;i++){
            t.append(s[i]);
        }
        return s.toString();

    }
}
