import ssm.dao.IMemberDao;
import ssm.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class MemberDaoTest {
    @Autowired
    private IMemberDao memberDao;

    @Test
    public void testFindMemberById(){
        int id = 1;
        Member member = memberDao.getMemberById(id);
        System.out.println(member.getId() + ": " + member.getName());
    }

}
