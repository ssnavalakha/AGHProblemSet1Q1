package com.AGHProblemSet1Q1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Answer ans=new Answer();
        List<Integer> results=new ArrayList<>();
        results.add(ans.getNextBiggestNumber(112));
        results.add(ans.getNextBiggestNumber(110));
        results.add(ans.getNextBiggestNumber(1100));
        results.add(ans.getNextBiggestNumber(34512));
        results.add(ans.getNextBiggestNumber(123456));
        results.add(ans.getNextBiggestNumber(654321));

        for (Integer result:
             results) {
            if(result==-1)
                System.out.println(false);
            else
                System.out.println(result);
        }
    }
}
