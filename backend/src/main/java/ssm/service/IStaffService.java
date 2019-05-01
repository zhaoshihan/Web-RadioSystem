package ssm.service;
import ssm.entity.Staff;
import java.util.List;

public interface IStaffService {
    public Staff getStaffById(int id);
    public Staff getStaffByAccount(String account);
    public boolean addStaff(Staff staff);

//    public List<Staff> getAllStaffs();
//    public boolean updateStaff(Staff staff);
//    public boolean deleteStaff(Staff staff);
}
