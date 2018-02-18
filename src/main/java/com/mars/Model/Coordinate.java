package com.mars.Model;

public class Coordinate {

	private int y;

	private int x;

	public Coordinate() {
		this.x = 0;
		this.y = 0;
	}

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

	public void moveUp() {
		y++;
	}

	public void moveRight() {
		x++;
	}

	public void moveDown() {
		y--;
	}

	public void moveLeft() {
		x--;
	}
}
