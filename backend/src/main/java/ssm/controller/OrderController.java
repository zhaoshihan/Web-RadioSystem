package ssm.controller;
import ssm.entity.Order;
import ssm.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("")
public class OrderController {
    @Resource
    private OrderService orderService;

    @RequestMapping("/findOrder")
    public String findOrder(Model model){
        int id = 1;
        Order order = this.orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "index";
    }
}
