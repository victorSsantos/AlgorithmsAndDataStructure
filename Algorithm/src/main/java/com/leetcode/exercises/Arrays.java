package com.leetcode.exercises;

public class Arrays {

    //Exercise 26
    public int removeDuplicates(int[] nums) {
        var n = nums.length;
        if(n <= 1)
            return n;

        int[] temp =  new int[n];

        int j = 0;
        for(int i = 0; i <= n - 1 ; i++ ){
            if(i==0)
                temp[j] = nums[i];
            else
            if(nums[i]!=temp[j])
                temp[++j] = nums[i];
        }

        System.arraycopy(temp, 0, nums, 0, ++j);
        return j;
    }

    //Exercise 169
    public int majorityElement(int[] nums) {
        if(nums.length == 0)
            return 0;

        if(nums.length <= 2)
            return nums[0];

        var n = nums.length;
        java.util.Arrays.sort(nums);

        int current = 0;
        int count = 1;
        for(var i = 1 ; i < n ; i++){

            var last = nums[i-1];
            current = nums[i];

            if(current==last){
                count++;
                if(count>n/2)
                   return current;
            }else{
                count = 1;
            }
        }
        return current;
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0; // Create a variable to save the max profit
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Update the lowest price until now
            } else {
                // Calculate the profit if we sell at current price.
                maxProfit = Math.max(maxProfit, price - minPrice); // Update the max profit
            }
        }
        return maxProfit;
    }

    public int romanToInt(String s) {
        int total = 0;

        for(var i = s.length() - 1 ; i >= 0 ; i--){
            var value = switch (s.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };

            if(4 * value < total) total -= value;
            else total += value;
        }
        return total;
    }

    //Prior to Space
    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split(" ");
        return words[words.length-1].length();
    }

    //Prior to Time
    public int lengthOfLastWord2(String s) {
        var length = 0;
        s = s.trim();

        for(var i = s.length() - 1 ; i >= 0 ; i--){
            if(s.charAt(i) != ' ') length++;
            else break;
        }

        return length;
    }

    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        int i;
        for(i = 1; i <= strs.length - 1 ; i++){
            String currentWord = strs[i];

            if(prefix.length() > currentWord.length())
                prefix = currentWord;
        }

        i = 0;
        while(i <= strs.length - 1){

            if(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() - 1);
                i = 0;
                continue;
            }
            i++;
        }
        return prefix;
    }

    public int strStr(String haystack, String needle) {
        int n = haystack.length() - 1;
        for(var index = 0 ; index <= n ; index++ ){
            if(haystack.startsWith(needle))
                return index;

            haystack = haystack.substring(1);

        }
        return -1;
    }
}


