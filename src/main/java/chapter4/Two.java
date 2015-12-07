package chapter4;

/**
 * 二分搜索--找出第一次出现的位置
 * @author skywalker
 *
 */
public class Two {

	private static int binarySearch(int[] arr, int num) {
		int l = 0, u = arr.length - 1, n;
		while (l < u) {
			int mid = l + (u - l >> 1);
			n = arr[mid];
			if (n == num) {
				//寻找第一次
				--mid;
				while (mid >= 0 && arr[mid] == num) {
					--mid;
				}
				return mid + 1;
			} else if (n < num) {
				l = mid + 1;
			} else {
				u = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(binarySearch(new int[] {1, 1, 3, 4, 4, 5, 6}, 1));
	}
	
}
