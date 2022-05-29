package com.example.mybatis.controller;

import com.example.mybatis.entity.UserInfo;
import com.example.mybatis.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Inkylin
 * @since 2022-05-29
 */
@RestController
@RequestMapping("/users")
public class UserInfoController {

	@Autowired
	private IUserInfoService userInfoService;


	@PostMapping
	public ResponseEntity<String> create(@RequestBody UserInfo userInfo){
		userInfoService.save(userInfo);
		return ResponseEntity.ok().body(null);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserInfo> get(@PathVariable Long userId){
		UserInfo byId = userInfoService.getById(userId);
		return ResponseEntity.ok().body(byId);
	}


}
