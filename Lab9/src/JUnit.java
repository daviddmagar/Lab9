import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JUnit {

	public class MyTests {

		@Test
		public void delimeterTest() {
			DelimiterChecker tester = new DelimiterChecker(); // MyClass is tested
			boolean match = DelimiterChecker.delimiterCheck("{()[]}");
			assertEquals(match, true);
			match = DelimiterChecker.delimiterCheck("{{)))}");
			assertEquals(match, false);
			match = DelimiterChecker.delimiterCheck("{((()[]}");
			assertEquals(match, false);

		}

	}
}
