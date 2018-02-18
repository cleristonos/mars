package com.mars.Model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoordinateTest extends TestCase {

	@Test
	public void shouldCoordinateStartIn0x0() {
		Coordinate coordinate = new Coordinate();
		assertEquals(0, coordinate.getX());
		assertEquals(0, coordinate.getY());
	}

	@Test
	public void shouldMoveUpIncreasesY() {
		Coordinate coordinate = new Coordinate();
		assertEquals(0, coordinate.getY());
		coordinate.moveUp();
		assertEquals(1, coordinate.getY());
		coordinate.moveUp();
		coordinate.moveUp();
		coordinate.moveUp();
		assertEquals(4, coordinate.getY());
	}

	@Test
	public void shouldMoveRightIncreasesX() {
		Coordinate coordinate = new Coordinate();
		assertEquals(0, coordinate.getX());
		coordinate.moveRight();
		assertEquals(1, coordinate.getX());
		coordinate.moveRight();
		coordinate.moveRight();
		coordinate.moveRight();
		assertEquals(4, coordinate.getX());
	}

	@Test
	public void shouldMoveLeftDecreasesX() {
		Coordinate coordinate = new Coordinate();
		assertEquals(0, coordinate.getX());
		coordinate.moveLeft();
		assertEquals(-1, coordinate.getX());
		coordinate.moveLeft();
		coordinate.moveLeft();
		coordinate.moveLeft();
		assertEquals(-4, coordinate.getX());
	}

	@Test
	public void shouldMoveDownDecreasesY() {
		Coordinate coordinate = new Coordinate();
		assertEquals(0, coordinate.getY());
		coordinate.moveDown();
		assertEquals(-1, coordinate.getY());
		coordinate.moveDown();
		coordinate.moveDown();
		coordinate.moveDown();
		assertEquals(-4, coordinate.getY());
	}

}
