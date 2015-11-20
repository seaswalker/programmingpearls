package chapter1;

/**
 * 使用位逻辑运算实现位向量
 * @author skywalker
 *
 */
public class Bits {

	//int类型的位宽
	private static final int WIDTH = 32;
	//没32个数占据一个元素
	private static final int SHIFT = 5;
	/*
	 * 这其实是求余数的一种特殊方式(只对2的n次方有效):
	 * x % n == x & 2^n - 1
	 */
	private static final int MASK = 0x1f;
	private int[] bits;
	
	public Bits(int limit) {
		this.bits = new int[limit / WIDTH + 1];
	}
	
	/**
	 * 设置值
	 */
	public void set(int x) {
		//这样的算法决定了是从低位开始的(从右向左)
		bits[x >> SHIFT] |= (1 << (x & MASK)); 
	}
	
	public void clear(int x) {
		bits[x >> SHIFT] &= (0 << (x & MASK)); 
	}
	
	public boolean test(int x) {
		return (bits[x >> SHIFT] >> (x & MASK) & 0x00000001) == 1;
	}
	
	public static void main(String[] args) {
		Bits bits = new Bits(200);
		for (int i = 0;i < 200; i += 2) {
			bits.set(i);
		}
		for (int i = 0;i < 200; ++i) {
			if (bits.test(i)) {
				System.out.print(i + " ");
			}
		}
	}
	
}
