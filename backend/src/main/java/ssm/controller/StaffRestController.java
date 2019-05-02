package ssm.controller;

import org.springframework.http.HttpRequest;
import ssm.entity.Staff;
import ssm.service.IStaffService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/staff")
@CrossOrigin(origins = "*")
public class StaffRestController {
    @Resource
    private IStaffService staffService;

    private String[] getFromBASE64(String authorization){
        if (authorization != null && authorization.toLowerCase().startsWith("basic")) {
            // Authorization: Basic base64credentials
            String base64Credentials = authorization.substring("Basic".length()).trim();
            byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(credDecoded, StandardCharsets.UTF_8);
            // credentials = username:password
            return credentials.split(":", 2);
        }
        else return null;
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public ResponseEntity checkStaff(@RequestHeader("Authorization") String auth){
        String[] values = getFromBASE64(auth);
        if (values != null){
            String account = values[0];
            String password = values[1];
            Staff staffExist = this.staffService.getStaffByAccount(account);
            if(staffExist != null && password.equals(staffExist.getPassword())){
                return new ResponseEntity(HttpStatus.OK);
            }
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else return new ResponseEntity(HttpStatus.UNAUTHORIZED);
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
    public ResponseEntity addStaff(@RequestBody Staff staff) {
        Staff staffExist = staffService.getStaffById(staff.getId());
        if (staffExist != null) {
            return  new ResponseEntity(HttpStatus.CONFLICT);
        }else{
            staffService.addStaff(staff);
            return new ResponseEntity(HttpStatus.OK);
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
