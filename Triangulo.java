package modelo;

public class Triangulo {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getArea() {
        return (base * altura) / 2;
    }

    public double getPerimetro() {
        return 3 * base;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }
}
