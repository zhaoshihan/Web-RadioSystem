package DaoTest;

import ssm.dao.IStaffDao;
import ssm.entity.Staff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
@Transactional
public class StaffDaoTest {
    @Autowired
    private IStaffDao staffDao;

    @Test
    public void testSelect()
    {
        Staff staff = staffDao.getStaffById(1);
        assertEquals(staff.getName(), "zhaoshihan");
        staff = staffDao.getStaffByAccount("zsh");
        assertEquals(staff.getPassword(), "123");
    }

    @Test
    public void testAdd()
    {
        Staff staff = new Staff();
        staff.setId(100);
        staff.setName("Bob");
        staff.setAccount("Bob123");
        staff.setPassword("123456");
        staffDao.addStaff(staff);
        Staff newStaff = staffDao.getStaffById(100);
        assertEquals(newStaff.getName(), "Bob");
    }

}
