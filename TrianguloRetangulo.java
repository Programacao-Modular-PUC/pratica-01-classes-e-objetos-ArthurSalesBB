public class TrianguloRetangulo {
    // Atributos
    private double h;
    private double c2;
    private double c1; 

    public TrianguloRetangulo(double c1, double c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public double calculaHipotenusa() {
        this.h = Math.sqrt(Math.pow(this.c1, 2) + Math.pow(this.c2, 2));
        return this.h;
    }

    public double calculaArea() {
        return (this.c1 * this.c2) / 2.0;
    }
}