package view;

import src.model.Producto;
import src.service.ProductoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtStock;
    private JTextField txtCategoria;

    private JTable tabla;
    private DefaultTableModel modelo;

    private ProductoService service;

    public VentanaPrincipal() {

        service = new ProductoService();

        setTitle("CRUD Productos");
        setSize(700, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel formulario = new JPanel(new GridLayout(5, 2, 5, 5));

        formulario.add(new JLabel("ID"));
        txtId = new JTextField();
        formulario.add(txtId);

        formulario.add(new JLabel("Nombre"));
        txtNombre = new JTextField();
        formulario.add(txtNombre);

        formulario.add(new JLabel("Precio"));
        txtPrecio = new JTextField();
        formulario.add(txtPrecio);

        formulario.add(new JLabel("Stock"));
        txtStock = new JTextField();
        formulario.add(txtStock);

        formulario.add(new JLabel("Categoría"));
        txtCategoria = new JTextField();
        formulario.add(txtCategoria);

        add(formulario, BorderLayout.NORTH);

        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Categoría");

        tabla = new JTable(modelo);

        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JPanel botones = new JPanel();

        JButton btnGuardar = new JButton("Guardar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnLimpiar = new JButton("Limpiar");

        botones.add(btnGuardar);
        botones.add(btnActualizar);
        botones.add(btnEliminar);
        botones.add(btnLimpiar);

        add(botones, BorderLayout.SOUTH);

        cargarTabla();

        btnGuardar.addActionListener(e -> guardar());

        btnActualizar.addActionListener(e -> actualizar());

        btnEliminar.addActionListener(e -> eliminar());

        btnLimpiar.addActionListener(e -> limpiar());

        tabla.getSelectionModel().addListSelectionListener(e -> {
            int fila = tabla.getSelectedRow();

            if (fila != -1) {
                txtId.setText(modelo.getValueAt(fila, 0).toString());
                txtNombre.setText(modelo.getValueAt(fila, 1).toString());
                txtPrecio.setText(modelo.getValueAt(fila, 2).toString());
                txtStock.setText(modelo.getValueAt(fila, 3).toString());
                txtCategoria.setText(modelo.getValueAt(fila, 4).toString());
            }
        });
    }

    private void guardar() {

        try {

            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            int stock = Integer.parseInt(txtStock.getText());
            String categoria = txtCategoria.getText();

            if (precio < 0 || stock < 0) {
                JOptionPane.showMessageDialog(this, "Precio y stock deben ser positivos.");
                return;
            }

            service.crear(new Producto(id, nombre, precio, stock, categoria));

            cargarTabla();
            limpiar();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Datos inválidos.");
        }

    }

    private void actualizar() {

        try {

            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            int stock = Integer.parseInt(txtStock.getText());
            String categoria = txtCategoria.getText();

            if (precio < 0 || stock < 0) {
                JOptionPane.showMessageDialog(this, "Precio y stock deben ser positivos.");
                return;
            }

            service.actualizar(id, nombre, precio, stock, categoria);

            cargarTabla();
            limpiar();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Datos inválidos.");
        }

    }

    private void eliminar() {

        try {

            int id = Integer.parseInt(txtId.getText());

            service.eliminar(id);

            cargarTabla();
            limpiar();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto.");
        }

    }

    private void cargarTabla() {

        modelo.setRowCount(0);

        for (Producto p : service.obtenerProductos()) {

            modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNombre(),
                    p.getPrecio(),
                    p.getStock(),
                    p.getCategoria()
            });

        }

    }

    private void limpiar() {

        txtId.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        txtCategoria.setText("");

        tabla.clearSelection();

    }

}