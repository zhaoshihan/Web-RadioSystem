package ssm.dao;
import ssm.entity.Member;

import java.util.List;

public interface IMemberDao {
    Member getMemberById(int id);
    Member getMemberByAccount(String account);
    List<Member> getAllMembers();
    int addMember(Member member);
    int updateMember(Member member);
    int deleteMember(Member member);
}
