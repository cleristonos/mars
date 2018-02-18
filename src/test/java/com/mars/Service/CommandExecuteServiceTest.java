package com.mars.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mars.Model.Robot;

import Exceptions.InvalidCommandException;
import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommandExecuteServiceTest extends TestCase {

	@Autowired
	public CommandExecuteService commandExecuteService;

	@Test
	public void shouldReturnARobotWhenTheCommandListIsValid() throws InvalidCommandException {
		Robot robot = commandExecuteService.execute("MMRMMRMM");
		assertEquals(2, robot.getCoordinate().getX());
		assertEquals(0, robot.getCoordinate().getY());
		assertEquals('S', robot.getOrientation());
	}

	@Test(expected = InvalidCommandException.class)
	public void shouldThrowsExceptionWhenTheCommandListIsInvalid() throws InvalidCommandException {
		commandExecuteService.execute("AAA");
	}
}
