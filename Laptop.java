package HW.Sem_06;

import java.util.Objects;

public class Laptop {
    Brand brand;
    Color color;
    Integer ram;

    public Laptop(Brand brand, Color color, int ram) {
        this.brand = brand;
        this.color = color;
        this.ram = ram;
    }

    public String getBrand() {
        return brand.toString();
    }

    public String getColor() {
        return color.toString();
    }

    public Integer getRam() {
        return ram;
    }

    @Override
    public String toString() {
        return String.format("Brand: %s, Color: %s, RAM: %d", brand, color, ram);
    }

    @Override
    public boolean equals(Object obj) {
        Laptop l = (Laptop) obj;
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        return this.brand.equals(l.brand) && this.color.equals(l.color) && this.ram.equals(l.ram);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.brand, this.color, this.ram);
    }
}
