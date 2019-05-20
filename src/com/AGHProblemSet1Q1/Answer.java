package com.AGHProblemSet1Q1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Answer {

    // The logic is as follows
    // 1) convert the number into and array of digits
    // 2) point a pointer to the last element in the array
    //    a) find the next decreasing digit by iterating the array
    //    b) swap the the decreasing digit with the last element in the array
    //    c) reverse all the digits from the swapped position till the end
    // 3) convert the array of digits to a number
    public int getNextBiggestNumber(int n)
    {
        Integer[] digits=getArrayOfDigits(n);
        getNextBiggestNumber(digits);
        int finalNumber=getNumber(digits);
        if(finalNumber<=n)
            return -1;
        return finalNumber;
    }

    //converts an array of digits to a corresponding number
    private int getNumber(Integer[] digits) {
        StringBuilder strNum = new StringBuilder();

        for (int digit : digits)
        {
            strNum.append(digit);
        }
        int finalInt = Integer.parseInt(strNum.toString());
        return finalInt;
    }

    //converts a number to an array of digits
    private Integer[] getArrayOfDigits(int n)
    {
        int temp = n;
        ArrayList<Integer> result = new ArrayList<Integer>();
        do{
            result.add(temp % 10);
            temp /= 10;
        } while  (temp > 0);
        Collections.reverse(result);
        return result.toArray(new Integer[result.size()]);
    }

    // swaps position of an element in the array
    private void swapNumberPosition(Integer[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //reverses all the elements from the specified position to the end of the array
    private void reverse(Integer[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swapNumberPosition(nums, i, j);
            i++;
            j--;
        }
    }

    //finds the next biggest number
    private void getNextBiggestNumber(Integer[] nums) {
        int ptr = nums.length - 2;
        while (ptr >= 0 && nums[ptr + 1] <= nums[ptr]) {
            ptr--;
        }
        if (ptr >= 0) {
            int ptr2 = nums.length - 1;
            while (ptr2 >= 0 && nums[ptr2] <= nums[ptr]) {
                ptr2--;
            }
            swapNumberPosition(nums, ptr, ptr2);
        }
        reverse(nums, ptr + 1);
    }
}
