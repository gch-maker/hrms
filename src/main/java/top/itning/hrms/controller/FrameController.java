package top.itning.hrms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import top.itning.hrms.entity.department.Department;
import top.itning.hrms.service.DepartmentService;

import java.util.List;

/**
 * 框架控制器
 *
 * @author Ning
 */
@Controller
public class FrameController {
    private static final Logger logger = LoggerFactory.getLogger(FrameController.class);

    @Autowired
    private DepartmentService departmentService;

    /**
     * 根路径
     *
     * @return 重定向到主页
     */
    @GetMapping("/")
    public String root() {
        logger.debug("root::重定向到主页");
        return "redirect:/index";
    }

    /**
     * 主页控制器
     *
     * @param model 模型
     * @return index.html
     */
    @GetMapping("/index")
    public String index(Model model) {
        List<Department> departmentList = departmentService.getAllDepartmentInfo();
        model.addAttribute("departmentList", departmentList);
        return "index";
    }
}