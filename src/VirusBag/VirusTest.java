package VirusBag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class VirusTest {

	@ParameterizedTest
	@CsvFileSource(resources = "./VirusTest.csv",numLinesToSkip = 1)
	public void testXinGuan(Integer num,String symptom, String contact, String result ) {
		assertEquals(result, Virus.diagnose(symptom, contact));
	}
}

