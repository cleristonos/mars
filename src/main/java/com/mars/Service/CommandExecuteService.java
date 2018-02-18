package com.mars.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.Factory.CommandFactory;
import com.mars.Model.CommandInterface;
import com.mars.Model.Robot;

import Exceptions.InvalidCommandException;

@Service
public class CommandExecuteService {

	private CommandFactory commandFactory;

	private MotionCheckerService motionCheckerService;

	/**
	 * 
	 * @param commandsText
	 * @return Robot
	 * @throws InvalidCommandException
	 */
	public Robot execute(String commandsText) throws InvalidCommandException {
		Robot robot = new Robot();
		List<CommandInterface> commands = commandFactory.createCommandsList(commandsText);
		for (CommandInterface command : commands) {
			command.execute(robot);
		}
		motionCheckerService.checkMotion(robot.getCoordinate());
		return robot;
	}

	@Autowired
	/**
	 * 
	 * @param commandFactory
	 */
	public void setCommandFactory(CommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}

	@Autowired
	/**
	 * 
	 * @param motionCheckerService
	 */
	public void setMotionCheckerService(MotionCheckerService motionCheckerService) {
		this.motionCheckerService = motionCheckerService;
	}

}
