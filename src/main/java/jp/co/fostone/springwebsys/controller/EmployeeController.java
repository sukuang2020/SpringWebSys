package jp.co.fostone.springwebsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
//	@Autowired
//	private EmployeeService service;
//
//	/**
//	 * selectの表示に使用するアイテム
//	 */
//	final static Map<String, String> SELECT_ITEMS = Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
//		{
//			put("SA", "A");
//			put("SB", "B");
//			put("SC", "C");
//			put("SD", "D");
//			put("SE", "E");
//		}
//	});
//
//	/**
//	   * check boxの表示に使用するアイテム
//	   */
//	final static Map<String, String> CHECK_ITEMS = Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
//		{
//			put("CA", "A");
//			put("CB", "B");
//			put("CC", "C");
//			put("CD", "D");
//			put("CE", "E");
//		}
//	});
//
//	/**
//	 * radio buttonの表示に使用するアイテム
//	 */
//	final static Map<String, String> RADIO_ITEMS = Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
//		{
//			put("RA", "A");
//			put("RB", "B");
//			put("RC", "C");
//			put("RD", "D");
//			put("RE", "E");
//		}
//	});
//
//	/**
//	 * 初期画面
//	 * @param model
//	 * @return
//	 */
//	@GetMapping
//	public String index(Model model) {
//		List<Employee> list = service.getAll();
//		model.addAttribute("emps", list);
//		return "employee/index";
//	}
//
//	/**
//	 * 新規画面を初期化
//	 * @param model
//	 * @return
//	 */
//    @GetMapping("new")
//    public String newEmp(Model model) {
//        Employee emp = new Employee();
//        model.addAttribute("emp", emp);
////		model.addAttribute("selectItems", SELECT_ITEMS);
////		model.addAttribute("checkItems", CHECK_ITEMS);
////		model.addAttribute("radioItems", RADIO_ITEMS);
//
//        return "employee/edit";
//    }
//
//    /**
//     * 編集画面開く
//     * @param id
//     * @param model
//     * @return
//     */
//	@GetMapping("edit/{id}")
//	public String openEdit(@PathVariable("id") String id, Model model) {
//		Employee emp = service.getById(id);
//		model.addAttribute("emp", emp);
//		return "employee/edit";
//	}
//
//	/**
//	 * 参照画面開く
//	 * @param id
//	 * @param model
//	 * @return
//	 */
//	@GetMapping("{id}")
//	public String show(@PathVariable String id, Model model) {
//		Employee emp = service.getById(id);
//		model.addAttribute("emp", emp);
//		return "employee/show";
//	}
//
//	/**
//	 * データ削除
//	 * @param ids
//	 * @return
//	 */
//	@DeleteMapping("{id}")
//	public String delete(@PathVariable String id) {
//		String[] ids = id.split(",");
//		for (String delid : ids) {
//			if (StringUtils.isEmpty(delid)) {
//				continue;
//			}
//			service.delById(delid);
//		}
//		return "redirect:/employee";
//	}
//
////	/**
////	 * データ新規
////	 * @param player
////	 * @param bindingResult
////	 * @return
////	 */
////	@PostMapping
////	public String create(@Valid @ModelAttribute Player player, BindingResult bindingResult) {
////		if (bindingResult.hasErrors()) {
////			return "players/new";
////		}
////		if (player.getId() == null) {
////			player.setId(new Long("1"));
////		}
////		service.save(player);
////		return "redirect:/players";
////	}
//
//	/**
//	 * データ新規・修正
//	 * @param id
//	 * @param player
//	 * @param bindingResult
//	 * @return
//	 */
//	@PostMapping("/save")
//	public String add(@Valid @ModelAttribute Employee emp, BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			return "employee/" + emp.getId() + "/edit";
//		}
//		service.save(emp);
//		return "redirect:/employee";
//	}
//
//	/**
//	 * データ新規・修正
//	 * @param id
//	 * @param player
//	 * @param bindingResult
//	 * @return
//	 */
////	@PostMapping("/edit/{id}")
////	public String update(@PathVariable("id") String id, @Valid Employee emp, BindingResult result,
////			Model model) {
////		if (result.hasErrors()) {
////			emp.setId(id);
////			return "employee/edit";
////		}
////		service.save(emp);
////		return "redirect:/employee";
////	}
//	@PostMapping("update/{id}")
//	public String updateStudent(@PathVariable("id") String id, @Valid Employee emp, BindingResult result,
//			Model model) {
//		if (result.hasErrors()) {
//			emp.setId(id);
//			return "employee/edit";
//		}
//		service.save(emp);
//		return "redirect:/employee";
//	}
//
//
//
////
////	@GetMapping("/list")
////	public String list(Model model) {
////		List<Employee> emps = service.getAll();
////		model.addAttribute("emps", emps);
////		return "employee/list";
////	}
////
////
//
////	@GetMapping("/edit/{id}")
////	public String initEdit(Model model, @PathVariable String id) {
////		Employee emp = service.getById(id);
////		model.addAttribute("emp", emp);
////		model.addAttribute("selectItems", SELECT_ITEMS);
////		model.addAttribute("checkItems", CHECK_ITEMS);
////		model.addAttribute("radioItems", RADIO_ITEMS);
////		return "employee/edit";
////	}
////
////	@GetMapping("/add")
////	public String initAdd(Model model) {
////		Employee emp = new Employee();
////		model.addAttribute("emp", emp);
////		model.addAttribute("selectItems", SELECT_ITEMS);
////		model.addAttribute("checkItems", CHECK_ITEMS);
////		model.addAttribute("radioItems", RADIO_ITEMS);
////		return "employee/edit";
////	}
//
////	@PostMapping("/save")
////	public String save(@Valid @ModelAttribute Employee emp, BindingResult bindingResult) {
////		if (bindingResult.hasErrors()) {
////			return "redirect:/employee/edit/"+emp.getId();
////		}
////		service.save(emp);
////		return "redirect:/employee/list";
////	}
//
//
//
}
