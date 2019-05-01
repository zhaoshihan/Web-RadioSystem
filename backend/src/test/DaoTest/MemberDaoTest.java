package DaoTest;

import ssm.dao.IMemberDao;
import ssm.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class MemberDaoTest {
    @Autowired
    private IMemberDao memberDao;

    @Test
    public void testSelect()
    {
        Member member = memberDao.getMemberById(1);
        assertEquals(member.getName(),"zhangsan");
        member = memberDao.getMemberByAccount()
    }

    @Test
    public void testGetAll(){
        List<Member> members = memberDao.getAllMembers();
        for(Member member:members)
        {
            System.out.println(member.getName());
        }
    }

    @Test
    public void testInsert()
    {
        Member member = new Member();
        member.setId(100);
        member.setName("zsh");
        member.setGender('f');
        member.setCity("Beijing");
        member.setAddress("ChangAn Street");
        member.setPostCode("12345678");
        member.setPhoneNumber("12345678");
        member.setEmail("7777@qq.com");
        member.setAccount("test");
        member.setPassword("123");
        memberDao.addMember(member);
        Member selectMember = memberDao.getMemberById(100);
        assertEquals(selectMember.getName(),"zsh");
    }

}
