package com.spring.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.DTO.UserDTO;
import com.spring.service.iRoleService;
import com.spring.service.iUserService;

@Controller(value = "UserControllerAdmin")
public class UserController {
	@Autowired
	private iUserService userService;
/*	@Autowired
	private iRoleService roleService;*/
	
	@RequestMapping(value = "/quan-tri/nguoi-dung/danh-sach",method = RequestMethod.GET)
	public ModelAndView userList(@RequestParam("page") int page , @RequestParam("limit") int limit) {
		UserDTO user = new UserDTO();
		user.setPage(page);
		user.setLimit(limit);
		ModelAndView md = new ModelAndView("admin/users/list");
		Pageable pageable = new PageRequest(page-1, limit);
		user.setResult(userService.findAll(pageable));
		user.setTotalItems(userService.totalItems());
		user.setTotalPages((int) Math.ceil((double) user.getTotalItems() / user.getLimit()));
		md.addObject("user",user);
		return md;
	}
	//@RequestParam(value = "id", required = false) Long id
	@RequestMapping(value = "/quan-tri/nguoi-dung/chinh-sua", method = RequestMethod.GET)
	public ModelAndView userEditNew(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView md = new ModelAndView("admin/users/edit");
		UserDTO user = new UserDTO();
		if(id != null) {
			user = userService.findById(id);
		}
/*		md.addObject("role", roleService.findAll());*/
		md.addObject("user",user);
		return md;
		
	}
		
}
