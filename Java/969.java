import java.util.ArrayList;
import java.util.LinkedList;
import java.utils.*;
class Problem969 {
    LinkedList<Integer> res = new ArrayList<>();
    public List<Integer> pancakeSort(int[] arr){
        sort(arr, arr.length);
        return res;
    }
    public void sort(int[] arr, int n){
        if(n==1)return;
        int maxIndex = 0;
        int maxVal = arr[0];
        for(int i =0;i<n;i++){
            if(maxVal<arr[i]){
                maxVal = arr[i];
                maxIndex = i;
            }
        }
        reverse(arr, 0,maxIndex);
        res.add(maxIndex+1);
        reverse(arr, 0,n-1);
        res.add(n);
        sort(arr, n-1);
    }
    public void reverse(int[] arr, int i,int j){
        while(i<j){
            arr[i] ^=arr[j];
            arr[j] ^=arr[i];
            arr[i] ^=arr[j];
            i++;
            j--;
        }
    }
}
