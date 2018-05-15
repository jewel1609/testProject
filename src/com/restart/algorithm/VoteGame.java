package com.restart.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class VoteGame {
	
	//1. 투표를 가장 많이 받은 사람 찾아내기 
	//많이 받은 사람이 두명이상일시 문자열 비교를 통해 우선순위를 가려낸다. a > b 
	
	public static String[] votes = {"Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry", "Alex", "Mary", "Mary"};
	
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
        for (String vote : votes) {
            if (map.containsKey(vote)) {
                map.put(vote, map.get(vote) + 1);
            } else {
                map.put(vote, 1);
            }
        }

        Set key = map.keySet();
        
        Iterator iterator = key.iterator();
        while (iterator.hasNext()){
        	System.out.println( (String)iterator.next() );
        }
		
		
	}

}
