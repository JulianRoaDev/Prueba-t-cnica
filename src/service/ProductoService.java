package src.service;

import src.model.Producto;

import java.io.*;
import java.util.ArrayList;

public class ProductoService {

    private final String archivo = "data/productos.txt";
    private ArrayList<Producto> productos = new ArrayList<>();

    public ProductoService() {
        cargar();
    }

    private void cargar() {
        productos.clear();

        try {
            File file = new File(archivo);

            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.isEmpty()) continue;

                String[] d = linea.split(",");

                productos.add(new Producto(
                        Integer.parseInt(d[0]),
                        d[1],
                        Double.parseDouble(d[2]),
                        Integer.parseInt(d[3]),
                        d[4]
                ));
            }

            br.close();

        } catch (Exception e) {
        }
    }

    private void guardar() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(archivo));

            for (Producto p : productos) {
                pw.println(p);
            }

            pw.close();

        } catch (Exception e) {
        }
    }

    public void crear(Producto p) {
        productos.add(p);
        guardar();
    }

    public void listar() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos.");
            return;
        }

        for (Producto p : productos) {
            System.out.println("ID: " + p.getId() +
                    " | Nombre: " + p.getNombre() +
                    " | Precio: " + p.getPrecio() +
                    " | Stock: " + p.getStock() +
                    " | Categoria: " + p.getCategoria());
        }
    }

    public void actualizar(int id, String nombre, double precio, int stock, String categoria) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                p.setNombre(nombre);
                p.setPrecio(precio);
                p.setStock(stock);
                p.setCategoria(categoria);
                guardar();
                return;
            }
        }

        System.out.println("Producto no encontrado.");
    }

    public void eliminar(int id) {
        productos.removeIf(p -> p.getId() == id);
        guardar();
    }
}