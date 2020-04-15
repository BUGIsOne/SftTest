package ctgu.ll.junitTest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//参数化运行器
@RunWith(Parameterized.class)

class TriangleTest {

	private int a, b, c;
	private String type;

	@Before
	public void setUp() throws Exception {
	}

	public TriangleTest(int a, int b, int c, String type) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.type = type;
	}

	@Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(
				new Object[][] { 
					{ 10, 20, 30, "非三角形" }, 
					{ 2, 2, 2, "等边三角形" }, 
					{ 0, 0, 0, "非三角形" }, 
					{ 4, 3, 5, "不等边三角形" },
					{ 3, 3, 4, "等腰三角形" }, 
					{ 4, 4, 5, "等腰三角形" }, 
					{ 1, 0, 0, "非三角形" }, 
					{ 1, 1, 1, "等边三角形" },
		});
	}

	@Test
	public void testClassify() {
		assertEquals(this.type, Triangle.classify(a, b, c));
	}



}