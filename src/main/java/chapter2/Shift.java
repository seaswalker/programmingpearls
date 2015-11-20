package chapter2;

import java.util.Arrays;

/**
 * 11页问题B，举个栗子:
 * arr = [abcdefgh], i = 3 =>> defghabc
 * @author skywalker
 *
 */
public class Shift {

	/**
	 * 向左旋转
	 * @param arr 被旋转的数组
	 * @param i 旋转位置
	 */
	private static void shift(char[] arr, int i) {
		char[] temp = new char[i];
		for (int j = 0, l = arr.length;j < l; ++j) {
			if (j < i) {
				temp[j] = arr[j];
			} else {
				arr[j - i] = arr[j];
			}
		}
		//添加到末尾
		for (int j = 0;j < i; ++j) {
			arr[arr.length - i + j] = temp[j];
		}
	}
	
	public static void main(String[] args) {
		char[] arr = "abcdefgh".toCharArray();
		shift(arr, 3);
		System.out.println(Arrays.toString(arr));
	}
	
}
