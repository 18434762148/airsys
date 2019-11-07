package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import entity.Account;
import service.prototype.IAccountService;

/**
 * 账户管理Controller类
 * @author Administrator
 *
 */
@Controller
public class AccountController {
	@Autowired
	private IAccountService actService;
	@RequestMapping("/user/{id}")
	@ResponseBody
	public String getUser(@PathVariable("id") int id) {
		Account act = actService.searchAccount(id);
		return JSON.toJSONString(act);
	}
	@RequestMapping("/users")
	public ModelAndView getUsers() {
		ModelAndView mv = new ModelAndView("list");
		List<Account> acts = actService.listPaged(1, 10);
		mv.addObject("acts", acts);
		return mv;
	}
	@RequestMapping("/deleteUser/{id}")
	@ResponseBody
	public String deleteUser(@PathVariable("id") int id) {
		return "success";
	}
	@RequestMapping("/updateUser/{id}")
	@ResponseBody
	public String updateUser(@PathVariable("id") int id) {
		return "success";
	}
}






