package chapter2;

import org.junit.Test;

/**
 * 练习题第三题
 * @author skywalker
 *
 */
public class Third {

	/**
	 * 第一种变换方式(P14标号1)
	 */
	@Test
	public void one() {
		char[] arr = "abcdefgh".toCharArray();
		int i = 3, n = arr.length, next;
		//运行的次数就是i和n的最大公约数
		for (int j = 0, l = gcd(n, i);j < l; ++j) {
			int index = j;
			char t = arr[index];
			while (true) {
				next = (index + i) % n;
				if (next == j) {
					break;
				}
				arr[index] = arr[next];
				index = next;
			}
			arr[index] = t;
		}
		System.out.println(arr);
	}
	
	/**
	 * 求n和i的最大公约数(辗转相除法)
	 * @param n 由于题意，n是大于i的
	 * @param i
	 */
	private int gcd(int n, int i) {
		int x = n % i;
		if (x == 0) {
			return i;
		}
		return gcd(i, x);
	}
	
	/**
	 * 交换算法
	 */
	@Test
	public void swap() {
		char[] arr = "abcdefgh".toCharArray();
		swapHelper(arr, 3, arr.length);
		System.out.println(arr);
	}
	
	/**
	 * 递归执行交换算法
	 */
	private void swapHelper(char[] arr, int i, int n) {
		if (n < (i << 1)) {
			//如果a < b, 直接插到最后
			char[] temp = new char[i];
			for (int j = 0;j < n; ++j) {
				if (j < i) {
					temp[j] = arr[j];
				} else {
					arr[j - i] = arr[j];
				}
			}
			//添加到末尾
			for (int j = 0;j < i; ++j) {
				arr[n - i + j] = temp[j];
			}
		} else {
			//交换a和br
			char temp;
			for (int j = 0;j < i; ++j) {
				temp = arr[j];
				arr[j] = arr[n - i + j];
				arr[n - i + j] = temp;
			}
			swapHelper(arr, i, n - 3);
		}
 	}
	
	/**
	 * 反转算法
	 */
	@Test
	public void reverse() {
		char[] arr = "abcdefgh".toCharArray();
		reverseHelper(arr, 0, 2);
		reverseHelper(arr, 3, arr.length - 1);
		reverseHelper(arr, 0, arr.length - 1);
		System.out.println(arr);
	}
	
	/**
	 * 反转数组的某一个区间
	 * @param arr 数组
	 * @param b 起始坐标
	 * @param s 结束坐标
	 */
	private void reverseHelper(char[] arr, int b, int s) {
		int times = (s - b + 1) / 2;
		char temp;
		for (int i = b, l = b + times;i < l; ++i) {
			temp = arr[i];
			arr[i] = arr[s - (i - b)];
			arr[s - (i - b)] = temp;
		}
	}
	
}
