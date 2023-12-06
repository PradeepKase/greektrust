package Numerics;

import java.util.*;

public class WordCounts {
	public static void main(String[] args) {
		String str="my name name is pradeep";
		
		String[] words=str.split(" ");
		
		Map<String, Integer> map= new HashMap<>();
		
		for(int i=0; i<words.length; i++) {
			if(map.containsKey(words[i])) {
				map.put(words[i],map.get(words[i])+1);
			}else {
				map.put(words[i], 1);
			}
		}
		System.out.println(map);
		for( String s : words ) {
			System.out.println(s);
		}
	}
}
