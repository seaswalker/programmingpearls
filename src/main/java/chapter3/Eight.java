package chapter3;

import java.util.Arrays;

/**
 * 七段数码管显示数字
 * @author skywalker
 *
 */
public class Eight {

	//字节的为从左向右数
	private static byte[] numByte = {
		((byte) (0b10111110)),
		((byte) (0b00001010)),
		((byte) (0b11101100)),
		((byte) (0b11101010)),
		((byte) (0b01011010)),
		((byte) (0b11110010)),
		((byte) (0b11110110)),
		((byte) (0b00101010)),
		((byte) (0b11111110)),
		((byte) (0b01111010)),
	};
	
	/**
	 * 根据给定的数字获取5个字节的数组
	 * @param num 16位(0-65536)
	 * @return
	 */
	private static byte[] light(int num) {
		if (num < 0 || num > 65536) {
			throw new IllegalArgumentException("the num should be between 0 to 65536.");
		}
		byte[] result = new byte[5];
		//默认是0
		Arrays.fill(result, numByte[0]);
		int index = 0, temp;
		while (num > 0) {
			temp = num % 10;
			result[index++] = numByte[temp];
			num /= 10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(light(101)));
	}
	
}
