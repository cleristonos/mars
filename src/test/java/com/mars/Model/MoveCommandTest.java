package com.mars.Model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoveCommandTest extends TestCase {

	@Mock
	MovableIterface movable;

	@Test
	public void shouldExecuteMoveOneTime() {
		MoveCommand moveCommand = new MoveCommand();
		moveCommand.execute(movable);
		verify(movable, times(1)).move();
	}
}
