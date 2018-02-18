package com.mars.Model;

public class Robot implements MovableIterface {

	private Coordinate coordinate;

	private char orientation;

	final char NORTH = 'N';
	final char EAST = 'E';
	final char SOUTH = 'S';
	final char WEST = 'W';
	final char DEFAULT_ORIENTATION = NORTH;

	/**
	 * 
	 */
	public Robot() {
		this.coordinate = new Coordinate();
		this.orientation = DEFAULT_ORIENTATION;
	}

	@Override
	public Coordinate getCoordinate() {
		return coordinate;
	}

	/**
	 * 
	 * @return char
	 */
	public char getOrientation() {
		return orientation;
	}

	/**
	 * 
	 */
	public void move() {
		switch (orientation) {
		case NORTH:
			coordinate.moveUp();
			break;
		case SOUTH:
			coordinate.moveDown();
			break;
		case EAST:
			coordinate.moveRight();
			break;
		case WEST:
			coordinate.moveLeft();
			break;
		default:
			break;
		}
	}

	/**
	 * 
	 */
	public void turnLeft() {
		switch (orientation) {
		case NORTH:
			orientation = WEST;
			break;
		case SOUTH:
			orientation = EAST;
			break;
		case EAST:
			orientation = NORTH;
			break;
		case WEST:
			orientation = SOUTH;
			break;
		default:
			break;
		}
	}

	/**
	 * 
	 */
	public void turnRigth() {
		switch (orientation) {
		case NORTH:
			orientation = EAST;
			break;
		case SOUTH:
			orientation = WEST;
			break;
		case EAST:
			orientation = SOUTH;
			break;
		case WEST:
			orientation = NORTH;
			break;
		default:
			break;
		}
	}

}
