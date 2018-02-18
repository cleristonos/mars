package com.mars.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mars.Model.Coordinate;

import Exceptions.InvalidCommandException;
import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MotionCheckerServiceTest extends TestCase {

	@Test(expected = InvalidCommandException.class)
	public void shouldThrowsAnExceptionWhenTheCoordinateXIsOutside() throws InvalidCommandException {
		MotionCheckerService motionCheckerService = new MotionCheckerService();
		motionCheckerService
				.checkMotion(new Coordinate(motionCheckerService.LAND_SIZE_X + 1, motionCheckerService.LAND_SIZE_Y));
	}

	@Test(expected = InvalidCommandException.class)
	public void shouldThrowsAnExceptionWhenCoordinateYIsOutside() throws InvalidCommandException {
		MotionCheckerService motionCheckerService = new MotionCheckerService();
		motionCheckerService
				.checkMotion(new Coordinate(motionCheckerService.LAND_SIZE_X, motionCheckerService.LAND_SIZE_Y + 1));
	}

	@Test(expected = InvalidCommandException.class)
	public void shouldThrowsAnExceptionWhenTheCoordinateXIsNegative() throws InvalidCommandException {
		MotionCheckerService motionCheckerService = new MotionCheckerService();
		motionCheckerService.checkMotion(new Coordinate(-1, motionCheckerService.LAND_SIZE_Y));
	}

	@Test(expected = InvalidCommandException.class)
	public void shouldThrowsAnExceptionWhenTheCoordinateYIsNegative() throws InvalidCommandException {
		MotionCheckerService motionCheckerService = new MotionCheckerService();
		motionCheckerService.checkMotion(new Coordinate(motionCheckerService.LAND_SIZE_X, -1));
	}

	@Test
	public void shouldNotThrowsAnExceptionWhenTheCoordinateIsValid() throws InvalidCommandException {
		MotionCheckerService motionCheckerService = new MotionCheckerService();
		assertTrue(motionCheckerService.checkMotion(
				new Coordinate(motionCheckerService.LAND_SIZE_X - 1, motionCheckerService.LAND_SIZE_Y - 1)));
	}

}