package ssm.service;
import ssm.entity.Member;
import java.util.List;

public interface IMemberService {

    public Member getMemberById(int id);
    public Member getMemberByName(String name);
    public List<Member> getAllMembers();
    public boolean addMember(Member member);
    public boolean updateMember(Member member);
    public boolean deleteMember(Member member);
}
