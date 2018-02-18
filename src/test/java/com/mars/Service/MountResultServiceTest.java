package com.mars.Service;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mars.Model.Coordinate;
import com.mars.Model.Robot;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MountResultServiceTest extends TestCase {

	@Mock
	Robot robot;

	@Test
	public void shouldReturnResultCorrectly() {
		MountResultService mountResultService = new MountResultService();
		when(robot.getCoordinate()).thenReturn(new Coordinate(2, 3));
		when(robot.getOrientation()).thenReturn('S');
		assertEquals("(2, 3, S)", mountResultService.mount(robot));
	}
}
