package uk.ac.westminster.productsapi;

public class PhysicalProduct extends Product implements Discountable {

    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    public PhysicalProduct() {
    }

    public PhysicalProduct(Long id, String name, double price,
                           double weightKg, String dimensions) {

        super(id, name, price);

        this.weightKg = weightKg;
        this.dimensions = dimensions;
        this.discountedPrice = price;
    }

    @Override
    public String getSummary() {

        return "Physical: " + getName()
                + " | Weight: " + weightKg + " kg";
    }

    @Override
    public void applyDiscount(double rate) {

        double cappedRate = Math.min(rate, 0.20);

        discountedPrice = getPrice() * (1 - cappedRate);
    }

    @Override
    public double getDiscountedPrice() {

        return discountedPrice;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }
}