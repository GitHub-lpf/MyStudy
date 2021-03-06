package lpf.study.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Code3 {
    //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
    //示例 1:
    //输入: "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    //示例 2:
    //输入: "bbbbb"
    //输出: 1
    //解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    //示例 3:
    //输入: "pwwkew"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    //     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
    //iiii
    //abcabcbb
    //jj
    public static void main(String[] args) {
        String s = "aab";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);

    }
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] strs = s.toCharArray();
        int i = 0,j=0;// 指针
        int maxLength=0;
        if(s.length()==0){
            return 0;
        }
        for (i=0; i < strs.length; i++) {
            if(!set.contains(strs[i])){
                set.add(strs[i]);
                maxLength=Math.max(maxLength,set.size());
            }else{
                while(set.contains(strs[i])){
                    set.remove(strs[j]);
                    j++;
                }
                set.add(strs[i]);
            }
        }
        return maxLength;
    }
}
