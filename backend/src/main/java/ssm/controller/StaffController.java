package ssm.controller;
import ssm.entity.Staff;
import ssm.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("")
public class StaffController {
    @Resource
    private StaffService staffService;

    @RequestMapping("/findStaff")
    public String findStaff(Model model){
        int id = 1;
        Staff staff = this.staffService.getStaffById(id);
        model.addAttribute("staff", staff);
        return "index";
    }
}
