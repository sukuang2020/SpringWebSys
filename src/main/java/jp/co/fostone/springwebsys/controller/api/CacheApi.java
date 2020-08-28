//package jp.co.fostone.springwebsys.controller.api;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import jp.co.fostone.springwebsys.demo.CacheService;
//import jp.co.fostone.springwebsys.modal.ApiInfo;
//
//@Controller
//@RequestMapping("api/cache/")
//public class CacheApi {
//	@Autowired
//	private CacheService service;
//
//	@GetMapping("1")
//	public String init(Model model) {
//		Page<ApiInfo> page = Page.empty();
//		page.and(ApiInfo.builder().msg("Spring Cache").build());
//		page.and(ApiInfo.builder().msg("Call findById→Run SQL").build());
//		service.getOne("Grp10");
//		page.and(ApiInfo.builder().msg("Call findById→From Cache").build());
//		service.getOne("Grp10");
//		model.addAttribute("page", page);
//		return "redirect:profile/myprofile";
//	}
//
//}
