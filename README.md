# Explicación del proyecto

Este proyecto es una aplicación Java de escritorio para gestionar productos mediante operaciones CRUD.

La interfaz permite ingresar los datos de un producto y mostrarlos en una tabla, además de guardar los cambios en un archivo de texto para que la información persista.

## ¿Qué hace la aplicación?

La aplicación permite:

- Registrar productos con ID, nombre, precio, stock y categoría.
- Mostrar los productos en una tabla.
- Actualizar información de un producto existente seleccionado.
- Eliminar un producto seleccionado.
- Limpiar los campos.
- Validar que el precio y el stock no sean negativos.

## Estructura del proyecto

- Main.java: es el punto de entrada de la aplicación. Inicia la ventana principal.
- view/VentanaPrincipal.java: contiene la interfaz gráfica con el formulario, la tabla y los botones (No es la más bonita pero sive :D ).
- src/model/Producto.java: representa el modelo de un producto.
- src/service/ProductoService.java: contiene la lógica.
- data/productos.txt: archivo donde se almacenan los productos en formato de texto.

## Tecnologías utilizadas

- Java.
- Swing para la interfaz gráfica.
- Clases de Java como JFrame, JTextField, JTable, DefaultTableModel y JOptionPane.
- ArrayList para almacenar la lista de productos en memoria.

## Requisitos

- Java JDK 17 o superior.

## Cómo ejecutarlo?

### Opción 1: desde un IDE

1. Ejecutar el Main.java que se encuentra en la raíz

# Palabra creativa
Palabra creativa: "Fácil como comer salchipapa"

# Retos
No recordaba como hacer un update a un unico dato de la clase así que mi update actualiza todo el objeto, no es lo más optimo pero funciona, tambien el ID no es auto incrementado ya que imaginando un entorno realista los ID suelen ser una combinación de números y letras o en algunos casos solo letras (aunque en este caso solo acepta números ;P)

# Por qué utilicé java?
Use Java ya que fue lo que más hemos manejado durante la carrera por lo que me sentia más comodo usando este lenguaje, las carpetas las organicé de una manera bastante típica la verdad, dentro de src encuentra las clases y la lógica dentro de model y service respectivamente, en data se encuentra la información y el view la vista del formulario.
