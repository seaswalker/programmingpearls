package chapter3;

/**
 * 判断连字符
 * @author skywalker
 *
 */
public class Five {

	public static void main(String[] args) {
		String[] patterns = {"et-ic", "al-is-tic", "s-tic", "p-tic", "-lyt-ic", "ot-ic", "an-tic", "n-tic", "c-tic", "at-ic"
				, "h-nic", "n-ic", "m-ic", "l-lic", "b-lic", "-clic"};
		String str = "clin-ic";
		for (int i = 0, l = patterns.length; i < l;i ++) {
			if (str.endsWith(patterns[i])) {
				System.out.println(patterns[i]);
				break;
			}
		}
	}
	
}
