package fr.xebia.mowitnow.model;


/**
 * 
 * @author TIFAKAM
 * 
 *         <p>
 *         Mower it's represented by an Area and a Position
 */
public class Mower
{

	private Area area;
	private Position position;



	/**
	 * 
	 * @param area
	 * @param position
	 */
	public Mower(Area area, Position position)
	{

		this.area = area;
		this.position = position;
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
	 * @param area
	 */
	public void setArea(Area area)
	{

		this.area = area;
	}



	/**
	 * 
	 * @return
	 */
	public Position getPosition()
	{

		return this.position;
	}



	/**
	 * 
	 * @param position
	 */
	public void setPosition(Position position)
	{

		this.position = position;
	}



	/**
	 * Pivot the Mower to 90° to the Right
	 */
	public void pivotToRight()
	{

		Direction direction;
		switch (this.getPosition().getDirection())
		{
			case NORTH:
				direction = Direction.EAST;
				break;
			case EAST:
				direction = Direction.SOUTH;
				break;
			case SOUTH:
				direction = Direction.WEST;
				break;
			case WEST:
				direction = Direction.NORTH;
				break;
			default:
				throw new IllegalArgumentException("Direction Invalid");
		}
		getPosition().setDirection(direction);
	}



	/**
	 * Pivot the Mower to 90° to the Left
	 */
	public void pivotToLeft()
	{

		Direction direction;
		switch (this.getPosition().getDirection())
		{
			case NORTH:
				direction = Direction.WEST;
				break;
			case EAST:
				direction = Direction.NORTH;
				break;
			case SOUTH:
				direction = Direction.EAST;
				break;
			case WEST:
				direction = Direction.SOUTH;
				break;
			default:
				throw new IllegalArgumentException("Direction Invalid");
		}
		getPosition().setDirection(direction);
	}


    /**
     * 
     * Move forward the Mower
     * 
     */
	public void goForward()
	{

		Position pos = new Position(this.position.getX(), this.position.getY(),this.position.getDirection());

		switch (this.getPosition().getDirection())
		{
			case NORTH:
				pos.setY(pos.getY() + 1);
				break;
			case EAST:
				pos.setX(pos.getX() + 1);
				break;
			case SOUTH:
				pos.setY(pos.getY() - 1);
				break;
			case WEST:
				pos.setX(pos.getX() - 1);
				break;
		}
		if (getArea().containsPosition(pos)) {
			setPosition(pos);
		}
	}


    /**
     * Execute an action {D,G,A}
     * 
     * @param code
     */
	public void doAction(String code)
	{

		switch (code)
		{
			case "D":
				pivotToRight();
				break;
			case "G":
				pivotToLeft();
				break;
			case "A":
				goForward();
				break;
		}
	}



	@Override
	public String toString()
	{

		return getPosition().getX() + " " + getPosition().getY() + " "
		        + getPosition().getDirection().name().substring(0, 1);
	}
}
