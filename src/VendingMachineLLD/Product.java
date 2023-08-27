package VendingMachineLLD;

public class Product {
    int id;
    String name;
    int number;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    int price;

    public Product(int id, String name, int number, int price) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", number=").append(number);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
