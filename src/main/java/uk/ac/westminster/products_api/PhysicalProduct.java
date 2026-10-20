package uk.ac.westminster.products_api;
/// This is a relationship a Physical Product STILL IS A Product
public class PhysicalProduct extends Products {
    private double weightKg;
    private String dimensions;

    public PhysicalProduct(){}

    public PhysicalProduct(Long id, String name, double price,  double weightKg, String dimensions) {
       super(id, name, price);
       this.weightKg = weightKg;
       this.dimensions = dimensions;
    }
    public double getWeightKg() {
        return weightKg;
    }
    public String getDimensions() {
        return dimensions;
    }
}
