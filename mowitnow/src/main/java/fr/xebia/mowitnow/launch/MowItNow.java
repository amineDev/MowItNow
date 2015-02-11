package fr.xebia.mowitnow.launch;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.xebia.mowitnow.exception.MowItNowException;
import fr.xebia.mowitnow.model.Mower;
import fr.xebia.mowitnow.parser.MowItNowParser;


/**
 * 
 * @author TIFAKAM
 *
 * <p>
 * Launch the programme
 */
public class MowItNow
{

	private static final Logger logger = LoggerFactory.getLogger(MowItNow.class);
	private static MowItNowParser mowItNowParser;


    /**
     * 
     * @param args
     */
	public static void main(String[] args)
	{

		try
		{
			String inputFileName = args[0];
			String outputFileName = args[1];

			readCommandsFromFile(inputFileName);
			writeResult(outputFileName);
		} catch (Exception e)
		{
			logger.error("Error invalid params ", e);
			System.exit(1);
		}
	}



	
	/**
	 * 
	 * Read  file and execute it's commands
	 * 
	 * @param fileName
	 */
	private static void readCommandsFromFile(String fileName)
	{

		InputStream in = null;
		try
		{
			in = new FileInputStream(fileName);

			BufferedReader reader =
			        new BufferedReader(new InputStreamReader(in, Charset.defaultCharset()));

			mowItNowParser = new MowItNowParser(reader);
			mowItNowParser.parse();
			return;
		} catch (FileNotFoundException e)
		{
			logger.error("Input File not found ", e);
			System.exit(1);
		} catch (IOException e)
		{
			logger.error("Error while reading ", e);
			System.exit(1);
		} catch (MowItNowException e)
		{
			logger.error("Invalid commands in file", e);
			System.exit(1);
		} finally
		{
			try
			{
				in.close();
			} catch (Exception e2)
			{
				logger.error("Error while trying to close input file ", e2);
			}
		}
	}



	
	/**
	 * Write the result of the commands in an output file
	 * 
	 * @param fileName
	 */
	private static void writeResult(String fileName)
	{

		OutputStream out = null;
		PrintWriter printWriter = null;
		try
		{
			out = new FileOutputStream(fileName);

			printWriter =
			        new PrintWriter(new OutputStreamWriter(out, Charset.defaultCharset()), true);
			for (Mower mower : mowItNowParser.getMowers()) {
				printWriter.println(mower.toString());
			}
			printWriter.flush();
			return;
		} catch (FileNotFoundException e)
		{
			logger.error("Input File not found ", e);
			System.exit(1);
		} finally
		{
			try
			{
				printWriter.close();
			} catch (Exception e2)
			{
				logger.error("Error while trying to close the writer ", e2);
			}
			try
			{
				out.close();
			} catch (Exception e2)
			{
				logger.error("Error while trying to close output file ", e2);
			}
		}
	}
}
