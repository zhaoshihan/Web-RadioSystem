package ssm.service;
import org.springframework.stereotype.Service;
import ssm.entity.Member;
import ssm.dao.IMemberDao;

import javax.annotation.Resource;
import java.util.List;

@Service("MemberService")
public class MemberService implements IMemberService{
    @Resource
    private IMemberDao memberDao;

    @Override
    public Member getMemberById(int id){
        return memberDao.getMemberById(id);
    }

    @Override
    public Member getMemberByAccount(String account){
        return memberDao.getMemberByAccount(account);
    }

    @Override
    public boolean addMember(Member member){
        return memberDao.addMember(member) > 0;
    }

    @Override
    public boolean updateMember(Member member){
        return memberDao.updateMember(member) > 0;
    }

    @Override
    public boolean deleteMember(Member member){
        return memberDao.deleteMember(member) > 0;
    }

    @Override
    public List<Member> getAllMembers(){
        return memberDao.getAllMembers();
    }
}
