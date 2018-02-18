package com.mars.Model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RobotTests extends TestCase {

	@Test
	public void shouldStartsOrientedToNorth() {
		Robot robot = new Robot();
		assertEquals('N', robot.getOrientation());
	}

	@Test
	public void shouldMoveToUpWhenIsOrientedToNorth() {
		Robot robot = new Robot();
		assertEquals('N', robot.getOrientation());
		assertEquals(0, robot.getCoordinate().getY());
		assertEquals(0, robot.getCoordinate().getX());
		robot.move();
		assertEquals(1, robot.getCoordinate().getY());
		assertEquals(0, robot.getCoordinate().getX());
	}

	@Test
	public void shouldMoveToLeftWhenIsOrientedToWest() {
		Robot robot = new Robot();
		assertEquals('N', robot.getOrientation());
		robot.turnLeft();
		assertEquals('W', robot.getOrientation());
		assertEquals(0, robot.getCoordinate().getY());
		assertEquals(0, robot.getCoordinate().getX());
		robot.move();
		assertEquals(0, robot.getCoordinate().getY());
		assertEquals(-1, robot.getCoordinate().getX());
	}

	@Test
	public void shouldMoveToDownWhenIsOrientedToSoulth() {
		Robot robot = new Robot();
		assertEquals('N', robot.getOrientation());
		robot.turnLeft();
		assertEquals('W', robot.getOrientation());
		robot.turnLeft();
		assertEquals('S', robot.getOrientation());
		assertEquals(0, robot.getCoordinate().getY());
		assertEquals(0, robot.getCoordinate().getX());
		robot.move();
		assertEquals(-1, robot.getCoordinate().getY());
		assertEquals(0, robot.getCoordinate().getX());
	}

	@Test
	public void shouldMoveToRigthWhenIsOrientedToEast() {
		Robot robot = new Robot();
		assertEquals('N', robot.getOrientation());
		robot.turnRigth();
		assertEquals('E', robot.getOrientation());
		assertEquals(0, robot.getCoordinate().getY());
		assertEquals(0, robot.getCoordinate().getX());
		robot.move();
		assertEquals(0, robot.getCoordinate().getY());
		assertEquals(1, robot.getCoordinate().getX());
	}

	@Test
	public void shouldUpdateOrientationCorrectlyWhenTurnLeftWasCalled() {
		Robot robot = new Robot();
		assertEquals('N', robot.getOrientation());
		robot.turnLeft();
		assertEquals('W', robot.getOrientation());
		robot.turnLeft();
		assertEquals('S', robot.getOrientation());
		robot.turnLeft();
		assertEquals('E', robot.getOrientation());
	}

	@Test
	public void shouldUpdateOrientationCorrectlyWhenTurnRigthWasCalled() {
		Robot robot = new Robot();
		assertEquals('N', robot.getOrientation());
		robot.turnRigth();
		assertEquals('E', robot.getOrientation());
		robot.turnRigth();
		assertEquals('S', robot.getOrientation());
		robot.turnRigth();
		assertEquals('W', robot.getOrientation());
	}

}
