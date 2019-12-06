package com.lp.controller;

import com.lp.common.ResultJson;
import com.lp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * 
 * @author 刘攀
 * @time 2019年3月8日下午2:41:05
 * @version 1.0
 * @describe
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/list")
	public ResultJson listUser() {
		ResultJson json = new ResultJson();
		try {
			json.setData(this.userService.listUser());
		} catch (Exception e) {
			json.setMessage(e.getMessage());
			json.setStatusCode(ResultJson.FAILURE);
		}
		return json;
	}


	@PostMapping(value = "")
	public ResultJson saveUser(String userName,String password) {
		ResultJson json = new ResultJson();
		try {
			this.userService.saveUser(userName,password);
		} catch (Exception e) {
			json.setMessage(e.getMessage());
			json.setStatusCode(ResultJson.FAILURE);
		}
		return json;
	}

	@GetMapping(value = "/list/user")
	public ResultJson selectUserList() {
		ResultJson json = new ResultJson();
		try {
			json.setData(this.userService.selectUserList());
		} catch (Exception e) {
			json.setMessage(e.getMessage());
			json.setStatusCode(ResultJson.FAILURE);
		}
		return json;
	}

	@GetMapping(value = "/list/page")
	public ResultJson selectUserPage() {
		ResultJson json = new ResultJson();
		try {
			json.setData(this.userService.selectUserPage());
		} catch (Exception e) {
			json.setMessage(e.getMessage());
			json.setStatusCode(ResultJson.FAILURE);
		}
		return json;
	}

	@GetMapping(value = "/list/id")
	public ResultJson selectUserListById() {
		ResultJson json = new ResultJson();
		try {
			json.setData(this.userService.selectUserListById());
		} catch (Exception e) {
			json.setMessage(e.getMessage());
			json.setStatusCode(ResultJson.FAILURE);
		}
		return json;
	}
}
