package Lgq_travel.springboot.controller;

import Lgq_travel.springboot.entity.Manager;
import Lgq_travel.springboot.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
public class ManagerController {
    @Autowired
   private ManagerService managerService;

    /**
     * 新增管理员
     */
    @RequestMapping(value = "/insertManager")
    public String insertManager(Manager manager){
//        Integer uuid = (Integer) UUID.randomUUID().toString();
        managerService.insertManager(manager);
        return "redirect:/listManager";
    }

    /**
     * 删除管理员
     */
    @RequestMapping(value = "/deleteManager")
    public @ResponseBody
    String deleteManager(Integer id){
        managerService.deleteManager(id);
        return "OK";
    }

    /**
     * 展示管理员列表
     */
    @RequestMapping(value = "/listManager")
    public String getAllManager(Model model, @RequestParam(required=false)String name){
        List<Manager> list = managerService.getAllManager(name);
        model.addAttribute("list",list);
        model.addAttribute("name",name);
        return "manager/listManager";
    }

    /**
     * 管理员登陆
     */
    @RequestMapping(value = "/managerLogin")
    public String confirmManager(Model model, HttpSession session, Manager manager){
        Manager manager1 = managerService.confirmManager(manager);
        if(manager1!=null) {
            if (manager1.getFlag() == 1 || manager1.getFlag() == 0) {
                //将manager对象存到session中
                session.setAttribute("manager", manager1);
                return "redirect:/manager";
            }
            model.addAttribute("errorInfo", "账号信息错误！");
            return "redirect:/managerLoginPage";
        }
        model.addAttribute("errorInfo", "用户名或密码错误！");
        return "redirect:/managerLoginPage";
    }

    /**
     * 管理员注销
     * @param request
     * @return
     */
    @RequestMapping(value = "/managerLogout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        //从session中将user删除
        session.removeAttribute("user");
        return "manager/login";
    }
}
