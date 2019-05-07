package ssm.controller;
import com.sun.tools.corba.se.idl.constExpr.Or;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import ssm.entity.Order;
import ssm.service.IOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderRestController {
    @Resource
    IOrderService orderService;

    @RequestMapping(value = "/query/all", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = orderService.getAllOrders();
        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @RequestMapping(value = "/query/{memberID}", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> getProductById(@PathVariable("memberID") int memberID){
        List<Order> orders = orderService.getOrderByMemberId(memberID);
        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @RequestMapping(value = "/addList", method = RequestMethod.POST)
    public ResponseEntity addListOrder(@RequestBody List<Order> orderList){
        for (Order order: orderList){
            Order orderExist = orderService.getOrderById(order.getId());
            if (orderExist != null) {
                return new ResponseEntity(HttpStatus.CONFLICT);
            }else{
                boolean result = orderService.addOrder(order);
                if(!result){
                    return new ResponseEntity(HttpStatus.FORBIDDEN);
                }
            }
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addOrder(@RequestBody Order order){
        Order orderExist = orderService.getOrderById(order.getId());
        if (orderExist != null) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }else{
            boolean result = orderService.addOrder(order);
            if(result){
                return new ResponseEntity(HttpStatus.OK);
            }
            else {
                return new ResponseEntity(HttpStatus.FORBIDDEN);
            }
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity updateOrder(@RequestBody Order order){
        Order orderExist = orderService.getOrderById(order.getId());
        if(orderExist != null){
            boolean result = orderService.updateOrder(order);
            if(result){
                return new ResponseEntity(HttpStatus.OK);
            }else{
                return new ResponseEntity(HttpStatus.FORBIDDEN);
            }
        }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity deleteOrder(@RequestBody Order order){
        Order orderExist = orderService.getOrderById(order.getId());
        if(orderExist != null){
            boolean result = orderService.deleteOrder(order);
            if(result){
                return new ResponseEntity(HttpStatus.OK);
            }else{
                return new ResponseEntity(HttpStatus.FORBIDDEN);
            }
        }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
