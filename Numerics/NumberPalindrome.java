package Numerics;

public class NumberPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=243;
		boolean b=findPalindrome(num);
		System.out.println(b);
	}

	private static boolean findPalindrome(int i) {
		// TODO Auto-generated method stub
		String str=Integer.toString(i);
		System.out.println(str);
		int l=0;
		int r=str.length()-1;
		while(l<r) {
			if(str.charAt(l)!=str.charAt(r)) {
				return false;
			}
				l++;
				r--;
		}
		return true;
	}

}
