package ssm.controller;

import ssm.entity.Member;
import ssm.service.IMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.memory.HeapBlock;

import javax.annotation.Resource;
import java.util.List;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "*")
public class MemberRestController {
    @Resource
    private IMemberService memberService;

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
    public ResponseEntity checkMember(@RequestHeader("Authorization") String auth){
        String[] values = getFromBASE64(auth);
        if (values != null){
            String account = values[0];
            String password = values[1];
            Member memberExist = this.memberService.getMemberByAccount(account);
            if(memberExist != null && password.equals(memberExist.getPassword())){
                return new ResponseEntity(HttpStatus.OK);
            }
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value="/query/{id}", method= RequestMethod.GET)
    public ResponseEntity<Member> getMemberById(@PathVariable("id") int id) {
        Member member = this.memberService.getMemberById(id);
        if (member != null) {
            return new ResponseEntity<>(member, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/query/all",method = RequestMethod.GET)
    public ResponseEntity<List<Member>> getAllMembers(){
        List<Member> members = memberService.getAllMembers();
        if (members.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public ResponseEntity addMember(@RequestBody Member member) {
        Member memberExist = memberService.getMemberById(member.getId());
        if (memberExist != null) {
            return  new ResponseEntity(HttpStatus.CONFLICT);
        }else{
            memberService.addMember(member);
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    @RequestMapping(value="/delete", method= RequestMethod.DELETE)
    public ResponseEntity<Member> deleteMember(@RequestBody Member member) {
        Member memberExist = memberService.getMemberById(member.getId());
        if (memberExist != null) {
            memberService.deleteMember(member);
            return new ResponseEntity<>(member,HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Member> updateUser(@PathVariable("id") int id,@RequestBody Member member){
        Member currentMember = memberService.getMemberById(id);
        HttpStatus httpStatus;
        if (currentMember != null) {
            currentMember.setAccount(member.getAccount());
            currentMember.setPassword(member.getPassword());
            boolean result = memberService.updateMember(member);
            if (result) {
                httpStatus = HttpStatus.OK;
            } else {
                httpStatus = HttpStatus.NO_CONTENT;
            }
            return new ResponseEntity<>(currentMember, httpStatus);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
