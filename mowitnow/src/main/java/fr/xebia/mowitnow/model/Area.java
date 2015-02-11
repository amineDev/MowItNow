package fr.xebia.mowitnow.model;


/**
 * 
 * 
 * @author TIFAKAM
 * 
 *         <p>
 *         An Area it's represented by an absciss and ordinate
 * 
 */
public class Area
{

	private int xMax;
	private int yMax;



	/**
	 * 
	 * @param xMax absciss
	 * 
	 * @param yMax ordinate
	 */
	public Area(int xMax, int yMax)
	{

		this.xMax = xMax;
		this.yMax = yMax;
	}



	/**
	 * 
	 * @return
	 */
	public int getxMax()
	{

		return this.xMax;
	}



	/**
	 * 
	 * @param xMax
	 */
	public void setxMax(int xMax)
	{

		this.xMax = xMax;
	}



	/**
	 * 
	 * @return
	 */
	public int getyMax()
	{

		return this.yMax;
	}



	/**
	 * 
	 * @param yMax
	 */
	public void setyMax(int yMax)
	{

		this.yMax = yMax;
	}



	/**
	 * Check if the Area contains a position
	 * 
	 * @param position
	 * @return
	 */
	public boolean containsPosition(Position position)
	{

		boolean isValid = (position.getX() <= getxMax()) && (position.getY() <= getyMax());
		isValid = (isValid) && (position.getX() >= 0) && (position.getY() >= 0);

		return isValid;
	}
}
