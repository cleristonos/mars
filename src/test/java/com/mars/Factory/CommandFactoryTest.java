package com.mars.Factory;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mars.Model.CommandInterface;
import com.mars.Model.MoveCommand;
import com.mars.Model.TurnLeftCommand;
import com.mars.Model.TurnRigthCommand;

import Exceptions.InvalidCommandException;
import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommandFactoryTest extends TestCase {

	@Test
	public void shouldCreateAListOfCommandCorrectly() throws InvalidCommandException {
		CommandFactory commandFactory = new CommandFactory();
		List<CommandInterface> list = commandFactory.createCommandsList("MMRMMRMM");
		assertEquals(8, list.size());
	}

	@Test
	public void shouldCreateAEmptyListWhenThereIsNoCommands() throws InvalidCommandException {
		CommandFactory commandFactory = new CommandFactory();
		List<CommandInterface> list = commandFactory.createCommandsList("");
		assertEquals(0, list.size());
	}

	@Test(expected = InvalidCommandException.class)
	public void shouldThrowsAExcptionWhenThereIsAnInvalidCommand() throws InvalidCommandException {
		CommandFactory commandFactory = new CommandFactory();
		commandFactory.createCommandsList("AAA");
	}

	@Test(expected = InvalidCommandException.class)
	public void makeShureFactoryThrowsAExceptionWhenThereIsAtLeastOneInvalidCommand() throws InvalidCommandException {
		CommandFactory commandFactory = new CommandFactory();
		commandFactory.createCommandsList("MMRMMRMMA");
	}
	
	@Test
	public void shouldCreatesMoveCommandWhenMoveCommandIsSended() throws InvalidCommandException {
		CommandFactory commandFactory = new CommandFactory();
		CommandInterface command = commandFactory.create('M');
		assertTrue(command instanceof MoveCommand);
	}
	
	@Test
	public void makeShureFactoryCreatesTurnLeftCommandWhenTurnLeftCommandIsSended() throws InvalidCommandException {
		CommandFactory commandFactory = new CommandFactory();
		CommandInterface command = commandFactory.create('L');
		assertTrue(command instanceof TurnLeftCommand);
	}
	
	
	@Test
	public void shouldCreatesTurnRigthCommandWhenTurnRigthCommandIsSended() throws InvalidCommandException {
		CommandFactory commandFactory = new CommandFactory();
		CommandInterface command = commandFactory.create('R');
		assertTrue(command instanceof TurnRigthCommand);
	}
	
	@Test(expected = InvalidCommandException.class)
	public void shouldThrowsAExceptionWhenAnInvalidTokenIsSended() throws InvalidCommandException {
		CommandFactory commandFactory = new CommandFactory();
		commandFactory.create('J');
	}

}
