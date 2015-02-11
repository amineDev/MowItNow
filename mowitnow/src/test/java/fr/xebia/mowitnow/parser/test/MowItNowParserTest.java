/**
 * 
 */
package fr.xebia.mowitnow.parser.test;


import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.xebia.mowitnow.exception.MowItNowException;
import fr.xebia.mowitnow.parser.MowItNowParser;


/**
 * @author TIFAKAM
 * 
 */
public class MowItNowParserTest {


	MowItNowParser mowItNowParser;
	BufferedReader reader;



	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {


		URL url = this.getClass().getResource("/instructions.txt");
		Path path = Paths.get(url.toURI());
		reader = Files.newBufferedReader(path, Charset.defaultCharset());
		mowItNowParser = new MowItNowParser(reader);

	}



	@Test
	public void testParse() throws IOException, MowItNowException {

		mowItNowParser.parse();

		assertEquals(2, mowItNowParser.getMowers().size());
		assertEquals("1 3 N", mowItNowParser.getMowers().get(0).toString());
		assertEquals("5 1 E", mowItNowParser.getMowers().get(1).toString());



	}



	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

		reader.close();
		mowItNowParser = null;
	}


}
