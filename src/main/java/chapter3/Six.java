package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 格式信函发生器
 * @author skywalker
 *
 */
public class Six {

	private static final String FILENAME = "template.txt";
	/*
	 * 模板
	 * 注意: {}也是关键字(用来限制出现的次数)，所以也需要转义
	 * .+?应该使用勉强型(?)，否则会得到这样的结果: name}，来自${address}，今年${age
	 */
	private static final Pattern PATTERN = Pattern.compile("\\$\\{(.+?)\\}");
	
	/**
	 * 读取模版
	 * @return
	 * @throws IOException 
	 */
	private static String readTemplate() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(Six.class.getResourceAsStream(FILENAME), "UTF-8"));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line).append("\r\n");
		}
		return sb.toString();
	}
	
	/**
	 * 准备context
	 * @return
	 */
	private static Map<String, String> context() {
		Map<String, String> context = new HashMap<String, String>();
		context.put("name", "小明");
		context.put("age", "24");
		context.put("address", "中国");
		return context;
	}
	
	/**
	 * 解析模板
	 * @param template 模板内容
	 */
	private static String parseTemplate(String template, Map<String, String> context) {
		Matcher matcher = PATTERN.matcher(template);
		StringBuffer parsed = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(parsed, context.get(matcher.group(1)));
		}
		matcher.appendTail(parsed);
		return parsed.toString();
	}
	
	public static void main(String[] args) throws IOException {
		String template = readTemplate();
		Map<String, String> context = context();
		System.out.println(parseTemplate(template, context));
	}
	
}
