package ssm.service;
import org.springframework.stereotype.Service;
import ssm.entity.Staff;
import ssm.dao.IStaffDao;

import javax.annotation.Resource;

@Service("StaffService")
public class StaffService implements IStaffService{
    @Resource
    private IStaffDao staffDao;

    public Staff getStaffById(int id){
        return staffDao.getStaffById(id);
    }
}
