package com.spring.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.DTO.NewDTO;
import com.spring.service.iCategoryService;
import com.spring.service.iNewsService;


@Controller(value = "newsControllerAdmin")
public class NewsController {

	@Autowired
	private iNewsService newsService;
	
	@Autowired
	private iCategoryService categoryService;

	@RequestMapping(value ="/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
	public ModelAndView newsList(@RequestParam("page") int page , @RequestParam("limit") int limit) {
		NewDTO model = new NewDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView md = new ModelAndView("admin/news/List");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setResult(newsService.findAll(pageable));
		model.setTotalItems(newsService.totalItems());
		model.setTotalPages((int) Math.ceil((double) model.getTotalItems() / model.getLimit()));
		md.addObject("model", model);
		
		return md;
		
	}
	
	@RequestMapping(value = "/quan-tri/bai-viet/sua-bai-viet", method = RequestMethod.GET)
	public ModelAndView newsEdit(@RequestParam(value = "id" ,required = false) Long id) {
		ModelAndView md = new ModelAndView("admin/news/edit");
		NewDTO model = new NewDTO();
		if(id != null) {
			model = newsService.findById(id);
		}
		md.addObject("category", categoryService.findAll());
		md.addObject("model", model);
		return md;
		
	}
	

}
