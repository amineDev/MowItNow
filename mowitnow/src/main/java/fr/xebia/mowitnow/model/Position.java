package fr.xebia.mowitnow.model;

/**
 * 
 * @author TIFAKAM
 * 
 *         <p>
 * 
 *         Position of the Mower , it's represented by x,y and a Direction
 * 
 * 
 */
public class Position
{

	private int x;
	private int y;
	private Direction direction;



	/**
	 * 
	 * @param x
	 * @param y
	 * @param direction
	 */
	public Position(int x, int y, Direction direction)
	{

		this.x = x;
		this.y = y;
		this.direction = direction;
	}



	/**
	 * 
	 * @return
	 */
	public int getX()
	{

		return this.x;
	}



	/**
	 * 
	 * @param x
	 */
	public void setX(int x)
	{

		this.x = x;
	}



	/**
	 * 
	 * @return
	 */
	public int getY()
	{

		return this.y;
	}



	/**
	 * 
	 * @param y
	 */
	public void setY(int y)
	{

		this.y = y;
	}



	/**
	 * 
	 * @return
	 */
	public Direction getDirection()
	{

		return this.direction;
	}



	/**
	 * 
	 * @param direction
	 */
	public void setDirection(Direction direction)
	{

		this.direction = direction;
	}



}
