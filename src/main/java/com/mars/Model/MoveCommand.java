package com.mars.Model;

public class MoveCommand implements CommandInterface {

	@Override
	public void execute(MovableIterface movable) {
		movable.move();
	}

}
