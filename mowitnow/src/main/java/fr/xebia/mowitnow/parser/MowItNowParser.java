package fr.xebia.mowitnow.parser;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.xebia.mowitnow.exception.MowItNowException;
import fr.xebia.mowitnow.model.Area;
import fr.xebia.mowitnow.model.Direction;
import fr.xebia.mowitnow.model.Mower;
import fr.xebia.mowitnow.model.Position;


/**
 * 
 * @author TIFAKAM
 * 
 *         <p>
 * 
 *         Mower Parser
 * 
 * 
 */
public class MowItNowParser
{

	private static final Logger logger = LoggerFactory.getLogger(MowItNowParser.class);
	private Area area;
	private final List<Mower> mowers;
	private final BufferedReader reader;
	private boolean isEmpty;



	/**
	 * 
	 * @param reader
	 */
	public MowItNowParser(BufferedReader reader)
	{

		this.reader = reader;
		this.mowers = new ArrayList<Mower>();
	}



	/**
	 * 
	 * Parse the file , create the area and mowers then execute commands of every Mower
	 * 
	 * @throws IOException
	 * @throws MowItNowException
	 */
	public void parse()
	        throws IOException, MowItNowException
	{

		logger.info("Start parsing ...");

		createArea();
		while (!this.isEmpty)
		{
			Mower mower = createMower();
			executeMower(mower);
		}
		logger.info("End parsing");
	}



	/**
	 * 
	 * Parse the first line of the file and create an Area
	 * 
	 * @throws IOException
	 * @throws MowItNowException
	 */
	private void createArea()
	        throws IOException, MowItNowException
	{

		logger.info("Creating an Area");

		String line = this.reader.readLine();
		this.isEmpty = ((line == null) || (line.equals("")));
		if (this.isEmpty) {
			throw new MowItNowException("Invalid File commands");
		}
		String[] coordinates = line.split(" ");
		int x = Integer.parseInt(coordinates[0]);
		int y = Integer.parseInt(coordinates[1]);
		this.area = new Area(x, y);

		logger.info("Area created !");
	}



	/**
	 * 
	 * Parse the next line and create a Mower
	 * 
	 * @return
	 * @throws IOException
	 * @throws MowItNowException
	 */
	private Mower createMower()
	        throws IOException, MowItNowException
	{

		Mower mower = null;

		String line = this.reader.readLine();
		this.isEmpty = ((line == null) || (line.equals("")));
		if (!this.isEmpty)
		{
			logger.info("Creating a Mower ...");

			String[] params = line.split(" ");

			int x = Integer.parseInt(params[0]);
			int y = Integer.parseInt(params[1]);
			String directionCode = params[2];

			Direction direction = null;
			switch (directionCode)
			{
				case "N":
					direction = Direction.NORTH;
					break;
				case "E":
					direction = Direction.EAST;
					break;
				case "S":
					direction = Direction.SOUTH;
					break;
				case "W":
					direction = Direction.WEST;
					break;
				default:
					throw new MowItNowException("Invalid Direction");
			}
			Position position = new Position(x, y, direction);

			mower = new Mower(this.area, position);
			this.mowers.add(mower);

			logger.info("Mower Created");
		}
		return mower;
	}



	/**
	 * 
	 * Execute the commands of the Mower
	 * 
	 * @param mower
	 * @throws IOException
	 * @throws MowItNowException
	 */
	private void executeMower(Mower mower)
	        throws IOException, MowItNowException
	{

		String line = this.reader.readLine();
		this.isEmpty = ((line == null) || (line.equals("")));
		if (!this.isEmpty)
		{
			logger.info("Executing commands of the Mower");

			String[] commands = line.split("");
			for (String command : commands) {
				mower.doAction(command);
			}
			logger.info("Commands execution finished ! ");

			logger.info("My position Is " + mower.toString());
		}
	}



	/**
	 * 
	 * @return
	 */
	public Area getArea()
	{

		return this.area;
	}



	/**
	 * 
	 * @return
	 */
	public List<Mower> getMowers()
	{

		return this.mowers;
	}
}
