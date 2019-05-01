package ssm.entity;
import java.sql.Date;

public class Order {
    private int id;
    private int memberID;
    private int productID;
    private int amount;
    private int unitPrice;
    private Date orderDate;
    private Date sendDate;
    private String sendAddress;

    public Order(){

    }

    public int getId() {
        return id;
    }

    public int getMemberID() {
        return memberID;
    }

    public int getProductID() {
        return productID;
    }

    public int getAmount() {
        return amount;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public String getSendAddress() {
        return sendAddress;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }
}
