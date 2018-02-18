package com.mars.Factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mars.Model.CommandInterface;
import com.mars.Model.MoveCommand;
import com.mars.Model.TurnLeftCommand;
import com.mars.Model.TurnRigthCommand;

import Exceptions.InvalidCommandException;

@Component
public class CommandFactory {

	final char MOVE_COMMAND = 'M';
	final char TURN_LEFT_COMMAND = 'L';
	final char TURN_RIGTH_COMMAND = 'R';

	/**
	 * 
	 * @param commandsText
	 * @return List<CommandInterface>
	 * @throws InvalidCommandException
	 */
	public List<CommandInterface> createCommandsList(String commandsText) throws InvalidCommandException {
		List<CommandInterface> commands = new ArrayList<>();
		char[] tokenList = commandsText.toCharArray();
		for (char token : tokenList) {
			commands.add(create(token));
		}
		return commands;
	}

	/**
	 * 
	 * @param token
	 * @return CommandInterface
	 * @throws InvalidCommandException
	 */
	public CommandInterface create(char token) throws InvalidCommandException {
		switch (token) {
		case MOVE_COMMAND:
			return new MoveCommand();
		case TURN_RIGTH_COMMAND:
			return new TurnRigthCommand();
		case TURN_LEFT_COMMAND:
			return new TurnLeftCommand();
		default:
			throw new InvalidCommandException("The token: " + token + " is not a valid command");
		}

	}

}
