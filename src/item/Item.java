package item;

public class Item {
    private String name;
    private String description;
    private int quantity;
    private int price;
    public Item() {
        this.quantity = 0;
        this.price = 0;
        this.name = "Unknown Item";
        this.description = "Unknown Item";
    }

    /**
     * builders
     */
    public Item withName(String name) {
        this.name = name;
        return this;
    }
    public Item withDescription(String description) {
        this.description = description;
        return this;
    }
    public Item withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
    public Item withPrice(int price) {
        this.price = price;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void getDescription() {
        System.out.println(description);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String tmp = "Item: " + name + ", Quantity: " + quantity + ", Price: " + price;
        return tmp;
    }
}
