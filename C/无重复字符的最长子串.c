#include<stdio.h>
#include<stdlib.h>
/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
*/
int length(char *s){
    int i = 0;
    while(s[i]!='\0')i++;
    return i;
}
int lengthOfLongestSubstring(char * s){
    int len = length(s);
    char* ss = (char*)malloc(sizeof(char)*len);
    for(int i=0;i<len;i++)ss[i]='\0';
    int r = 0,rk=-1;
    int rs = 0;
    for(int i=0;i<len;i++){
        if(i!=0){
           ss[((int)s[i])%len] = '\0';
        }
        while((rk+1<len)&&(ss[((int)s[rk+1])%len]!='\0')){
            ss[(int)s[rk+1]%len]=s[rk+1];
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