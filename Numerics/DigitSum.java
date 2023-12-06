package Numerics;

public class DigitSum {

	public static void main(String[] args) {
		int num=1234;
		int ans= findSumOfDigits( num);
		System.out.print(ans);
	}

	public static int findSumOfDigits(int num) {
		// TODO Auto-generated method stub
		int sum=0;
		while(num>0) {
			int div=num%10;
			sum=sum+div;
			num/=10;
		}
		return sum;
	}

	

}
