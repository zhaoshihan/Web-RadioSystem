package ssm.service;
import org.springframework.stereotype.Service;
import ssm.entity.Member;
import ssm.dao.IMemberDao;

import javax.annotation.Resource;

@Service("MemberService")
public class MemberService implements IMemberService{
    @Resource
    private IMemberDao memberDao;

    public Member getMemberById(int id){
        return memberDao.getMemberById(id);
    }
}
