package com.mars.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mars.Model.Robot;
import com.mars.Service.MountResultService;
import com.mars.Service.CommandExecuteService;

import Exceptions.InvalidCommandException;

@RestController
@RequestMapping("/rest")
public class MarsController {

	private CommandExecuteService commandExecuteService;

	private MountResultService mountResultService;

	@Autowired
	public void setCommandExecuteService(CommandExecuteService commandExecuteService) {
		this.commandExecuteService = commandExecuteService;
	}

	@Autowired
	public void setMountResultService(MountResultService mountResultService) {
		this.mountResultService = mountResultService;
	}

	@PostMapping("/mars/{commands}")
	public ResponseEntity<?> moveRobot(@PathVariable String commands) {
		try {
			Robot robot = this.commandExecuteService.execute(commands);
			return ResponseEntity.ok(mountResultService.mount(robot));
		} catch (InvalidCommandException e) {
			return ResponseEntity.badRequest().body("400 Bad Request");
		}

	}

}
