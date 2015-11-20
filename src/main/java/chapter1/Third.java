package chapter1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import beanchmark.BenchMark;
import beanchmark.TimeBenchMark;

/**
 * 第三题，对比效率，顺带解决第四题
 * @author skywalker
 *
 */
public class Third {

	private static final int LIMIT = 10000000;
	private static final int COUNT = 1000000;
	private static int[] nums = new int[COUNT];
	
	static {
		//生成1 000 000个10 000 000以内的不重复的随机数
		Random random = new Random();
		//检查是否重复
		Set<Integer> check = new HashSet<Integer>();
		int num;
		for (int i = 0;i < COUNT;) {
			num = random.nextInt(LIMIT);
			if (check.add(num)) {
				nums[i] = num;
				++i;
			}
		}
	}
	
	/**
	 * 使用位图排序
	 */
	@BenchMark(times = 1)
	public void bit() {
		boolean[] bits = new boolean[LIMIT];
		for (int i = 0;i < COUNT; ++i) {
			bits[nums[i]] = true;
		}
	}
	
	/**
	 * 使用jdk自带方法排序
	 */
	@BenchMark(times = 1)
	public void sort() {
		Arrays.sort(nums);
	}
	
	public static void main(String[] args) {
		TimeBenchMark.run(Third.class);
	}
	
}
