package jp.co.fostone.springwebsys.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.fostone.springwebsys.jpa.entities.Player;
import jp.co.fostone.springwebsys.service.PlayerService;

@Controller
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	PlayerService service;

	/**
	 * 初期画面
	 * @param model
	 * @return
	 */
	@GetMapping
	public String index(Model model) {
//		List<Player> list = service.findAll();
//		model.addAttribute("players", list);
		return "player/index";
	}

	/**
	 * 新規画面を初期化
	 * @param model
	 * @return
	 */
    @GetMapping("new")
    public String newPlayer(Model model) {
        Player player = new Player();
        model.addAttribute("player", player);
        return "player/new";
    }

    /**
     * 編集画面開く
     * @param id
     * @param model
     * @return
     */
	@GetMapping("{id}/edit")
	public String edit(@PathVariable String id, Model model) {
		Player player = service.getOne(id);
		model.addAttribute("player", player);
		return "player/edit";
	}

	/**
	 * 参照画面開く
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("{id}")
	public String show(@PathVariable String id, Model model) {
		Player player = service.getOne(id);
		model.addAttribute("player", player);
		return "player/show";
	}

	/**
	 * データ削除
	 * @param id
	 * @return
	 */
	@PostMapping("{id}")
	public String destroy(@PathVariable String id) {
//		service.delete(id);
		String[] ids = new String[] {"Grp3"};
		service.deleteByIds(ids);
		return "redirect:/player";
	}

	/**
	 * データ新規
	 * @param player
	 * @param bindingResult
	 * @return
	 */
	@PostMapping
	public String create(@Valid @ModelAttribute Player player, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "player/new";
		}
		service.save(player);
		return "redirect:/player";
	}

	/**
	 * データ修正
	 * @param id
	 * @param player
	 * @param bindingResult
	 * @return
	 */
	@PutMapping("{id}")
	public String update(@PathVariable String id, @Valid @ModelAttribute Player player, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "player/edit";
		}
		player.setId(id);
		service.save(player);
		return "redirect:/player";
	}

	//500 exp
	@RequestMapping(value="/exp2")
	public String exp2(Model model) {
		int a = 2 / 0;
		return "";
	}

//	/**
//	 * 異常処理
//	 * @param e
//	 * @return
//	 */
//	@ExceptionHandler(Exception.class)
//	@ResponseBody
//	public String exp(Exception e) {
//		return this.getClass().getSimpleName() + ":" + e.getMessage();
//	}

}
