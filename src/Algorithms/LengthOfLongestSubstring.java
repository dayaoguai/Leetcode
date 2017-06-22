package Algorithms;

import java.util.HashMap;

public class LengthOfLongestSubstring {
	 public int LengthOfLongestSubstring(String s){
	        if(s.length()==0)
			    return 0;
	         HashMap<Character , Integer> visit = new HashMap<Character , Integer>();
			 int maxlen=0, laststart=0;
			 for(int i=0;i<s.length();i++){
				 if(visit.containsKey(s.charAt(i))){
					laststart=Math.max(laststart, visit.get(s.charAt(i))+1);
				 }
				 visit.put(s.charAt(i), i);
				 maxlen=Math.max(maxlen, i-laststart+1);
			 }
			return maxlen;
}
}
