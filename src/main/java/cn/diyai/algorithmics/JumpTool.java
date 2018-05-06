package cn.diyai.algorithmics;

public class JumpTool {

	public static void main(String[] args) {

		System.out.println(JumpFloorII(1) == 1);
		System.out.println(JumpFloorII(4) == 8);
		System.out.println(5 % 2);
		System.out.println(5 / 2);
		System.out.println(JumpFloor(1));
		System.out.println(JumpFloor(5));

	}

	/**
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 * 
	 * 分析
	 * 
	 * f(n) = f(n-1)+f(n-2)+ ... f(n-n)
	 * 
	 * f(n) = f(0) +f(1)+f(2)+...f(n-1)
	 * 
	 * f(n) = 2*f(n-1)
	 * 
	 * @param target
	 * @return
	 */
	public static int JumpFloorII(int target) {
		if (target <= 0) {
			return -1;
		} else if (target == 1) {
			return 1;
		} else {
			return 2 * JumpFloorII(target - 1);
		}
	}

	/**
	 * 
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 * 
	 * @param target
	 * @return
	 */
	public static int JumpFloor(int target) {
		if (target <= 0) {
			return -1;
		} else if ((target == 1) || (target == 2)) {
			return target;
		} else {
			return JumpFloor(target - 1) + JumpFloor(target - 2);
		}

	}

}
