package ctgu.ll.junitTest;

/**
 * @ClassName: Triangle
 * @author: LIN
 * @date 2020-04-15
 * @Description:测试三角形是否为等边、等腰或者是不等边的
 * @version V1.0
 */
public class Triangle {
	public static String classify(int a, int b, int c) {

		if (!((a + b > c) && (a + c > b) && (b + c > a))) {
			return "非三角形";
		} else if (a == b && a == c && b == c) {
			return "等边三角形";
		} else if (a != b && a != c && b != c) {
			return "不等边三角形";
		} else {
			return "等腰三角形";
		}
	}

}
