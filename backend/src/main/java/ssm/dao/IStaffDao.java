package ssm.dao;
import ssm.entity.Staff;

public interface IStaffDao {
    public Staff getStaffById(int id);
    public Staff getStaffByAccount(String account);
    public int addStaff(Staff staff);
}
