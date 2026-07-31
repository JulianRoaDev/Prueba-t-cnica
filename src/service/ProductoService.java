package src.service;

import src.model.Producto;

import java.io.*;
import java.util.ArrayList;

// en esta clase se implementa la logica de negocio para el CRUD de productos
public class ProductoService {

    private final String archivo = "data/productos.txt";
    private ArrayList<Producto> productos = new ArrayList<>();

    public ProductoService() {
        cargar();
    }

    // Obtener productos devuelve la lista de productos almacenados
    public ArrayList<Producto> obtenerProductos() {
        return productos;
    }

    /*
     * Cargar lee los productos desde un archivo de texto y los almacena en la lista
     * de productos
     */

    /*
     * La diferencia entre cargar y obtenerProductos es que cargar se encarga de
     * leer desde el archivo y llenar la lista, mientras que
     * obtenerProductos simplemente devuelve la lista ya cargada.
     * 
     * Es decir, uno de ellos obtiene los productos para cargarlos a la lista,
     * mientras que el otro obtiene los productos ya cargados en la lista.
     * 
     */

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
                if (linea.isEmpty())
                    continue;

                String[] d = linea.split(",");

                productos.add(new Producto(
                        Integer.parseInt(d[0]),
                        d[1],
                        Double.parseDouble(d[2]),
                        Integer.parseInt(d[3]),
                        d[4]));
            }

            br.close();

        } catch (Exception e) {
        }
    }

    /*
     * Guardar solo guarda los productos en el archivo de texto.
     */
    private void guardar() {
        try {
            // PrintWriter escribe en el txt los productos de la lista, es para modificar el archivo basicamente
            PrintWriter pw = new PrintWriter(new FileWriter(archivo));

            for (Producto p : productos) {
                pw.println(p);
            }

            pw.close();

        } catch (Exception e) {
        }
    }

    // Crear crea el producto y luego llama a guardar para que se almacene en el txt
    public void crear(Producto p) {
        productos.add(p);
        guardar();
    }


    // Listar imprime en consola los productos almacenados
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

    // Actualizar busca el producot y luego llama a guardar para que se almacene la información
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

    // Eliminar busca el producto y luego llama a guardar para que se elimine del txt
    public void eliminar(int id) {
        productos.removeIf(p -> p.getId() == id);
        guardar();
    }
}