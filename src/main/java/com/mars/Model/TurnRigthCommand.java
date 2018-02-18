package com.mars.Model;

public class TurnRigthCommand implements CommandInterface {

	@Override
	public void execute(MovableIterface movable) {
		movable.turnRigth();
	}

}
