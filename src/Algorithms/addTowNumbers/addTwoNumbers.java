package Algorithms.addTowNumbers;

public class addTwoNumbers {
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode ans=new ListNode(0);
	        ListNode head=ans;
	        int car=0,add1=0,add2=0;
	        while(l1!=null||l2!=null){
	            if(l1!=null&&l2!=null){
	                add1=l1.val;
	                add2=l2.val;
	                l1=l1.next;
	                l2=l2.next;
	            }
	            else if(l1!=null&&l2==null){
	                add1=l1.val;
	                add2=0;
	                l1=l1.next;
	            }
	            else if(l1==null&&l2!=null){
	                add1=0;
	                add2=l2.val;
	                l2=l2.next;
	            }
	            ans.val=(add1+add2+car)%10;
	            if(add1+add2+car>=10){
	                car=1;
	            }
	            else{
	                car=0;
	            }
	            ans.next=new ListNode(0);
	            ans=ans.next;

	        }
	        return head;
	    }
}
