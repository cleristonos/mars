package com.mars.Service;

import org.springframework.stereotype.Service;

import com.mars.Model.Robot;

@Service
public class MountResultService {

	/**
	 * 
	 * @param robot
	 * @return String
	 */
	public String mount(Robot robot) {
		return "(" + robot.getCoordinate().getX() + ", " + robot.getCoordinate().getY() + ", " + robot.getOrientation()
				+ ")";
	}

}
