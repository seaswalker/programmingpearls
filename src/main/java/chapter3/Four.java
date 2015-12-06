package chapter3;

import java.util.Calendar;

import org.junit.Test;

/**
 * 34页第4题
 * @author skywalker
 *
 */
public class Four {

	/**
	 * 计算给定的两个日期之间的天数
	 */
	@Test
	public void days() {
		Calendar from = Calendar.getInstance();
		from.set(2015, 11 - 1, 5);
		Calendar to = Calendar.getInstance();
		to.set(2015, 12 - 1, 6);
		System.out.println(to.get(Calendar.YEAR));
		System.out.println(daysHelper(from, to));
	}
	
	private static int daysHelper(Calendar from, Calendar to) {
		int[] months = {31, isLeap(to.get(Calendar.YEAR)) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int result = 0;
		for (int i = from.get(Calendar.MONTH), l = to.get(Calendar.MONTH);i < l;i ++) {
			result += months[i];
		}
		result = (result + to.get(Calendar.DATE) - from.get(Calendar.DATE));
		return result;
	}
	
	public static boolean isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	}
	
}
