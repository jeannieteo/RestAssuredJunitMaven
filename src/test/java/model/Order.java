package model;

public class Order {
    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;
    public Order() {}

    public Order(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }

    public int getId() {
        return id;
    }
    public void setId(int setId) {
        id = setId;
    }

    public int getPetId() {
        return petId;
    }
    public void setPetId(int setPetId) {
        petId = setPetId;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int setQuantity) {
        quantity = setQuantity;
    }

    public void setShipDate(String setShipDate) {
        shipDate  = setShipDate;
    }
    public String getShipDate() {
        return shipDate;
    }

    public void setStatus(String setStatus) {
        status = setStatus;
    }
    public String getSTatus() {
        return status;
    }

    public void setComplate(boolean setBoolean) {
        complete = setBoolean;
    }
    public boolean getComplete()  {
        return complete;
    }

}


