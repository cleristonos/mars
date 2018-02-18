package com.mars.Model;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TurnRigthCommandTest extends TestCase {

	@Mock
	MovableIterface movable;

	@Test
	public void shouldExecuteTurnRigthOneTime() {
		TurnRigthCommand turnRigthCommand = new TurnRigthCommand();
		turnRigthCommand.execute(movable);
		verify(movable, times(1)).turnRigth();
	}
}
