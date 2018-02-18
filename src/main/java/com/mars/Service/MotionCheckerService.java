package com.mars.Service;

import org.springframework.stereotype.Service;

import com.mars.Model.Coordinate;

import Exceptions.InvalidCommandException;

@Service
public class MotionCheckerService {

	final int LAND_SIZE_X = 5;
	final int LAND_SIZE_Y = 5;

	/**
	 * 
	 * @param coordinate
	 * @return boolean
	 * @throws InvalidCommandException
	 */
	public boolean checkMotion(Coordinate coordinate) throws InvalidCommandException {
		if (coordinate.getX() + 1 > LAND_SIZE_X) {
			throw new InvalidCommandException("Invalid Motion");
		}

		if (coordinate.getY() + 1 > LAND_SIZE_Y) {
			throw new InvalidCommandException("Invalid Motion");
		}

		if (coordinate.getX() < 0 || coordinate.getY() < 0) {
			throw new InvalidCommandException("Invalid Motion");
		}

		return true;
	}

}
