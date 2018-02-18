package com.mars.Model;

public class TurnLeftCommand implements CommandInterface {

	@Override
	public void execute(MovableIterface movable) {
		movable.turnLeft();
	}

}
