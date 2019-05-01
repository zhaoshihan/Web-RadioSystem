package ssm.controller;

import ssm.entity.Staff;
import ssm.service.IStaffService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/staff")
@CrossOrigin(origins = "*")
public class StaffRestController {
    @Resource
    private IStaffService staffService;

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public HttpStatus checkStaff(@RequestParam("account") String account, @RequestParam("password") String password){
//        String account = request.getParameter("account");
//        String account = staff.getAccount();
        System.out.println("======Test====== account = " + account);
//        String password = request.getParameter("password");
//        String password = staff.getPassword();
        System.out.println("======Test====== password = " + password);
        Staff staffExist = this.staffService.getStaffByAccount(account);
        if(staffExist != null && password.equals(staffExist.getPassword())){
            return HttpStatus.FOUND;
        }
        return HttpStatus.NOT_FOUND;
    }

    @RequestMapping(value="/query/{id}", method= RequestMethod.GET)
    public ResponseEntity<Staff> getStaffById(@PathVariable("id") int id) {
        Staff staff = this.staffService.getStaffById(id);
        if (staff != null) {
            return new ResponseEntity<>(staff, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public ResponseEntity<Staff> addStaff(@RequestBody Staff staff) {
        Staff memberExist = staffService.getStaffById(staff.getId());
        if (memberExist != null) {
            return  new ResponseEntity<>(HttpStatus.CONFLICT);
        }else{
            staffService.addStaff(staff);
            return new ResponseEntity<>(staff,HttpStatus.CREATED);
        }
    }

//    @RequestMapping(value = "/query/all",method = RequestMethod.GET)
//    public ResponseEntity<List<Staff>> getAllStaffs(){
//        List<Staff> staffs = staffService.getAllStaffs();
//        if (staffs.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(staffs, HttpStatus.OK);
//    }

//    @RequestMapping(value="/delete", method= RequestMethod.DELETE)
//    public ResponseEntity<Staff> deleteStaff(@RequestBody Staff staff) {
//        Staff memberExist = staffService.getStaffById(staff.getId());
//        if (memberExist != null) {
//            staffService.deleteStaff(staff);
//            return new ResponseEntity<>(staff,HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
//    public ResponseEntity<Staff> updateStaff(@PathVariable("id") int id,@RequestBody Staff staff){
//        Staff currentMember = staffService.getStaffById(id);
//        HttpStatus httpStatus;
//        if (currentMember != null) {
//            currentMember.setAccount(staff.getAccount());
//            currentMember.setPassword(staff.getPassword());
//            boolean result = staffService.updateStaff(staff);
//            if (result) {
//                httpStatus = HttpStatus.OK;
//            } else {
//                httpStatus = HttpStatus.NO_CONTENT;
//            }
//            return new ResponseEntity<>(currentMember, httpStatus);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }


}
