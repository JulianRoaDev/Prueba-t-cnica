package src.model;

// Esta es la clase "Producto" que representa un producto en el sistema.
public class Producto {

    private int id;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;

    // Se almacenan datos como el id, nombre, precio, stock y categoria del producto.
    public Producto(int id, String nombre, double precio, int stock, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return id + "," + nombre + "," + precio + "," + stock + "," + categoria;
    }
}