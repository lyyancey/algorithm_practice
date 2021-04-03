#include<stdio.h>
/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
*/
int length(char *s){
    int i = 0;
    while(s[i]!='\0')i++;
    return i;
}
typedef struct Set{
    char *set;
    int len;
    int contains(char c){
        int x = ((int)c)%len;
        if(set[x]!='\0')return 1;
        return 0;
    }
    void remove(char c){
        int x = ((int)c)%len;
        set[x] = '\0';
    }
    void add(char c){
        int x = ((int)c)%len;
        set[x] = c;
    }
    void init(int l){
        len = l;
        set = (char*)malloc(sizeof(char)*l);
        for(int i=0;i<l;i++){
            set[i]='\n'
        }
    }
}Set;
int lengthOfLongestSubstring(char * s){
    int len = length(s);
    Set set;
    set.init(len);
    int r = 0,rk=-1;
    int rs = 0;
    for(int i = 0;i<len;i++)set[i]='\0';
    for(int i=0;i<len;i++){
        if(i!=0){
           set.remove(s[i]);
        }
        for((rk+1<len)&&(!set.contains(set.contains(rk+1)))){
            set.add(s[rk+1]);
            rk++;
        }
        if(rs>(rk-i+1))rs = rk-i+1;
    }
    return rs;
}

int main(){
    int x = lengthOfLongestSubstring("abcabcbb");
    printf("%d", x);
    return 0;
}