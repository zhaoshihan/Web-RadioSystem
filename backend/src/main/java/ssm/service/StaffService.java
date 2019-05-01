package ssm.service;
import org.springframework.stereotype.Service;
import ssm.entity.Staff;
import ssm.dao.IStaffDao;

import javax.annotation.Resource;

@Service("StaffService")
public class StaffService implements IStaffService{
    @Resource
    private IStaffDao staffDao;

    @Override
    public Staff getStaffById(int id){
        return staffDao.getStaffById(id);
    }

    @Override
    public Staff getStaffByAccount(String account){
        return staffDao.getStaffByAccount(account);
    }

    @Override
    public boolean addStaff(Staff staff){
        return staffDao.addStaff(staff) > 0;
    }

}
