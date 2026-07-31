import src.model.Producto;
import src.service.ProductoService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductoService service = new ProductoService();

        int opcion;

        do {

            System.out.println("\n1. Crear");
            System.out.println("2. Listar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    double precio;

                    do {
                        System.out.print("Precio: ");
                        precio = sc.nextDouble();
                    } while (precio < 0);

                    int stock;

                    do {
                        System.out.print("Stock: ");
                        stock = sc.nextInt();
                    } while (stock < 0);

                    sc.nextLine();

                    System.out.print("Categoria: ");
                    String categoria = sc.nextLine();

                    service.crear(new Producto(id, nombre, precio, stock, categoria));

                    break;

                case 2:
                    service.listar();
                    break;

                case 3:

                    System.out.print("ID: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();

                    do {
                        System.out.print("Precio: ");
                        precio = sc.nextDouble();
                    } while (precio < 0);

                    do {
                        System.out.print("Stock: ");
                        stock = sc.nextInt();
                    } while (stock < 0);

                    sc.nextLine();

                    System.out.print("Categoria: ");
                    categoria = sc.nextLine();

                    service.actualizar(id, nombre, precio, stock, categoria);

                    break;

                case 4:

                    System.out.print("ID: ");
                    id = sc.nextInt();

                    service.eliminar(id);

                    break;

            }

        } while (opcion != 5);
    }
}