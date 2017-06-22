package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import Algorithms.addTowNumbers.ListNode;

public class Solution {
	
	List<List<Integer>> ret = new ArrayList<List<Integer>>();  
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
  		  if((nums1.length+nums2.length)%2==1){
			  return findkth(nums1,nums2,(nums1.length+nums2.length)/2+1);
		  }
		  else
			  return(findkth(nums1,nums2,(nums1.length+nums2.length)/2)+findkth(nums1,nums2,(nums1.length+nums2.length)/2+1))/2;

	        
	    }
	  public double findkth(int[] nums1,int[] nums2,int k){
		  if(nums1.length>nums2.length)
			  return findkth(nums2,nums1,k);
		  if(nums1.length==0)
			  return nums2[k-1];
		  if(k==1){
		      return Math.min(nums1[0],nums2[0]);
		  }
		  int pa=Math.min(k/2, nums1.length);
		  int pb=k-pa;
		  if(nums1[pa-1]<nums2[pb-1]){
			  return findkth( Arrays.copyOfRange(nums1, pa, nums1.length),nums2,k-pa);
		  }
		  else if(nums1[pa-1]>nums2[pb-1])
			  return findkth(nums1,Arrays.copyOfRange(nums2, pb, nums2.length),k-pb);
		  else 
			  return nums1[pa-1];
	  }
	  public String longestPalindrome(String s) {
		  boolean[][] p=new boolean[1000][1000];
		  int laststart=0,maxlen=1,j;
		  for(int i=0;i<s.length();i++){
			  p[i][i]=true;
		  }
		  for(int i=0;i<s.length()-1;i++){
			  if(s.charAt(i)==s.charAt(i+1)){
				  p[i][i+1]=true;
				  maxlen=2;
				  laststart=i;
			  }
		  }
		  for(int len=3;len<s.length();len++)
			  for(int i=0;i<s.length()-len+1;i++){
				  j=i+len-1;
				  if(s.charAt(i)==s.charAt(j)&&p[i+1][j-1]){
					  p[i][j]=true;
					  laststart=i;
					  maxlen=len;
				  }
			  }
		return s.substring(laststart, laststart+maxlen);
	        
	    }
	    public String convert(String s, int numRows) {
	    	if(numRows == 1) return s;
	    	String[] res=new String[numRows]; 
	    	int i = 0, j, gap = numRows-2;
	    	while(i < s.length()){
	    		for(j = 0; i < s.length() && j < numRows; ++j) res[j] += s.charAt(i++);
	    		for(j = gap; i < s.length() && j > 0; --j) res[j] += s.charAt(i++);
	    	}
	    	String str = "";
	    	for(i = 0; i < numRows; ++i)
	    		str += res[i];
	    	return str.replace("null", "");
    }
	    public int reverse(int x) {
	    	final int max=Integer.MAX_VALUE,min=Integer.MIN_VALUE;
	    	int k=10;
	    	long sum=0;

	    	while(x!=0){
	    		sum=x%10+sum*10;
	    		if(sum>max||sum<min){
	    			return 0;
	    		}
	    		x=x/10;
	    		
	    	}
	        return (int)sum;
	    }
	    public int myAtoi(String str) {
	    	int flag=1,index=0,num = 0;
	    	int max=Integer.MAX_VALUE,min=Integer.MIN_VALUE;
	        if(str.length()==0)
	    	 return 0;
	        while(str.charAt(index)==' '){
	        	index++;
	        }
	    	if(str.charAt(index)=='-'||str.charAt(index)=='+'){
	    		flag=str.charAt(index)=='+'?1:-1;
	    		index++;
	    	}
	    	while(index<str.length()){ 
	    		int dig=str.charAt(index)-'0';
	    	    if(dig<0||dig>9) break;
	    	    if(num>max/10||(num==max/10&&dig>max%10))
	    	    	return flag==1?max:min;
	        	num=num*10+dig;
	        	index++;

	    	}
    	    return num*flag; 
    }
	    public boolean isPalindrome(int x) {
	        String str=String.valueOf(x);
	        //if(str.charAt(0)=='-') str=str.substring(1, str.length());
	        for(int head=0,tail=str.length()-1;tail-head>1;head++,tail--){
	        	if(str.charAt(head)!=str.charAt(tail)) return false;
	        }
	        return true;
	    }
	    public boolean isMatch(String s, String p) {
	    	if(p.length()==0) return s.length()==0;
	    	boolean[][] res=new boolean[s.length()+1][p.length()+1];
	    	res[0][0]=true;
	    	for(int j=0;j<p.length();j++){
	    		if(p.charAt(j)!='*'){
	    			for(int i=0;i<s.length();i++){
	    				if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'){
	    					res[i+1][j+1]=res[i][j];
	    				}
	    			}
	    		}
	    		else{
	    			if(j>0&&res[0][j-1]) res[0][j+1]=true;
	    			if(j<1) continue;
	    			if(p.charAt(j-1)!='.'){
	    				for(int i=0;i<s.length();i++){
	    					if(res[i+1][j] || j>0&&res[i+1][j-1]|| i>0 && j>0 && res[i][j+1]&&s.charAt(i)==s.charAt(i-1)&&s.charAt(i-1)==p.charAt(j-1)) 
	    						res[i+1][j+1]=true;
	    				}
	    			} 
	    			else{
	    				int i=0;
	    				while(j>0&&i<s.length()&&!res[i+1][j-1]&&!res[i+1][j]) i++;
	    				while(i<s.length()){
	    					res[i+1][j+1]=true;
	    					i++;
	    				}
	    			}
	    		}
	    	}
	    	
	        return res[s.length()][p.length()];
	    }
	    public int maxArea(int[] height) {
	        int max=0,h,start=0,tail=height.length-1;
	        while(start<tail){
	        	h=Math.min(height[start], height[tail]);
	        	max=Math.max(max, h*(tail-start));
	        	while(height[start]<=h&&start<tail) start++;
	        	while(height[tail]<=h&&start<tail) tail++;
	        }

	    	return max;
	    }
	    public String intToRoman(int num) {
	        String[] roman=new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
	        int[] intTo=new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	        StringBuilder myInt=new StringBuilder();
	        for(int i=0;num>0;i++){
	        	while(num>=intTo[i]){
	        		num-=intTo[i];
	        		myInt.append(roman[i]);
	        	}
	        }
	        return myInt.toString();
	    }
	    public int romanToInt(String s) {
	    	int num=0,lastnum=1001;
	        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
	        map.put('I', 1);
	        map.put('V', 5);
	        map.put('X', 10);
	        map.put('L', 50);
	        map.put('C', 100);
	        map.put('D', 500);
	        map.put('M', 1000);
	        num=map.get(s.charAt(0));
	        lastnum=map.get(s.charAt(0));
	        for(int i=1;i<s.length();i++){
	        	num+=map.get(s.charAt(i))<=lastnum? map.get(s.charAt(i)):(-1)*map.get(s.charAt(i));
	        	lastnum=map.get(s.charAt(i));
	        }
	        return num;
	    }
	    public int longestValidParentheses(String s){
	    	int length=s.length(),max=0,j=0;
	    	int[] dp=new int[length];
	    	for(int i=0;i<length;i++){
	    		dp[i]=0;
	    	}
	    	for(int i=length-2;i>=0;i--){
	    		if(s.charAt(i)=='('){
	    			j=i+dp[i+1]+1;
	    			if(j<length){
	    				if(s.charAt(j)==')'){
	    					dp[i]=dp[i+1]+2;
	    					if(j+1<length){
	    						dp[i]+=dp[j+1];
	    					}
	    				}
	    			}
	    			else{
	    				dp[i]=dp[i+1];
	    			}
	    		if(dp[i]>max){
	    			max=dp[i];
	    		}
	    		}
	    	}
	    	return max;
	    }
	    public List<List<Integer>> threeSum(int[] num) {
	    	if(num==null||num.length<3) return ret;
	    	Arrays.sort(num);
	    	int len=num.length;
	    	for(int i=0;i<len-2;i++){
	    		if(i>0&&num[i]==num[i-1]) continue;
	    		find(num,i+1,len-1,num[i]);
	    	}
			return ret; 
	    }
	    public void find(int[] num,int begin,int end,int target){
	    	while(end>begin){
	    		if(num[begin]+num[end]+target==0){
	    			List<Integer> ans = new ArrayList<Integer>();
	    			ans.add(target);
	    			ans.add(num[begin]);
	    			ans.add(num[end]);
	    			ret.add(ans);
	                while (begin < end && num[begin] == num[begin+1]) begin++;  
	                while (begin < end && num[end] == num[end-1]) end--;  
	                begin++;  
	                end--; 
	    		}
	    		else if(num[begin]+num[end]+target<0){
	    			begin++;
	    		}else{
	    			end--;
	    		}
	    	}
	    }
	    public String longestCommonPrefix(String[] strs){
	    	if(strs.length==0) return "";
	    	String prefix=strs[0];
	    	for(int i=1;i<strs.length;i++){
	    		while(strs[i].indexOf(prefix)!=0){
	    			prefix=prefix.substring(0, prefix.length()-1);
	    		}
	    		if(prefix.isEmpty()) return "";
	    	}
			return prefix;
	    	
	    }
	    public boolean isValid(String s){
	    	
	    }
	    
	  
}
