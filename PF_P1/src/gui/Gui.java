package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

public class Gui {

    JFrame frame;
    JPanel sidebar, dropdownPanel;
    boolean isDropdownVisible = false;
    JTabbedPane tabbedPane;
    private JButton dashboardButton;
    private JLabel opcion1, opcion2, opcion3, opcion4;
    private Connection conexion; // Añadir la conexión

    public Gui() {
        conexion = ConexionDB.getConexion(); // Obtener la conexión antes de inicializar la interfaz gráfica
        initialize();
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ConexionDB.cerrarConexion();  // Cierra la conexión a la base de datos
                JOptionPane.showMessageDialog(frame, "La conexión se ha cerrado correctamente.", 
                        "Cierre de Conexión", JOptionPane.INFORMATION_MESSAGE);  // Mostrar mensaje de cierre
                System.exit(0);  // Finaliza la aplicación
            }
        });
    }

    

    private void initialize() {
    	
        // Configuración de la ventana principal
    	
        frame = new JFrame("Tienda de celulares - Proyecto Final");
        frame.setBounds(100, 100, 1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        // Crear Sidebar
        
        sidebar = new JPanel();
        sidebar.setBackground(new Color(54, 57, 63)); // Color oscuro
        sidebar.setLayout(null); // Usamos layout null para controlar el posicionamiento manual
        sidebar.setPreferredSize(new Dimension(250, frame.getHeight())); // Sidebar más ancho
        frame.getContentPane().add(sidebar, BorderLayout.WEST); // Sidebar a la izquierda

        // Botón principal (Dashboard)
        
        dashboardButton = new JButton("Dashboard");
        dashboardButton.setBounds(30, 49, 180, 30);
        dashboardButton.setBackground(new Color(45, 48, 54));
        dashboardButton.setForeground(Color.WHITE);
        dashboardButton.setFocusPainted(false); // Eliminar el borde cuando se hace clic
        dashboardButton.setFont(new Font("Arial", Font.BOLD, 16));
        dashboardButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        sidebar.add(dashboardButton);
        
        // Crear el JTabbedPane para las pestañas
        
        tabbedPane = new JTabbedPane();
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        // Panel para el menú desplegable
        
        dropdownPanel = new JPanel();
        dropdownPanel.setBackground(new Color(45, 48, 54));
        dropdownPanel.setLayout(new GridLayout(4, 1));
        dropdownPanel.setBounds(30, 82, 180, 120);
        dropdownPanel.setVisible(false);
        sidebar.add(dropdownPanel);

        // Inicialización de opciones para el menú desplegable
        
        opcion1 = createDropdownOption("Inventario");
        opcion2 = createDropdownOption("Cliente");
        opcion3 = createDropdownOption("Factura a cliente");
        opcion4 = createDropdownOption("Recibo de pago");

        // Agregar cada una al dropwdownPanel
        
        dropdownPanel.add(opcion1);
        dropdownPanel.add(opcion2);
        dropdownPanel.add(opcion3);
        dropdownPanel.add(opcion4);

        
        
        // ActionListener para mostrar u ocultar el menú desplegable
        
        dashboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isDropdownVisible = !isDropdownVisible;
                dropdownPanel.setVisible(isDropdownVisible);
                sidebar.revalidate();
                sidebar.repaint();
            }
        });

        // Acciones de las opciones del menú
        
        opcion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openTab("Inventario", "Contenido del Inventario");
            }
        });

        opcion2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openTab("Cliente", "Contenido del Cliente");
            }
        });

        opcion3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openTab("Factura a Cliente", "Contenido de la Factura a Cliente");
            }
        });

        opcion4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openTab("Recibo de Pago", "Contenido del Recibo de Pago");
            }
        });

        frame.setVisible(true);
    }

    // Método para crear opciones estilizadas (sin fondo)
    
    private JLabel createDropdownOption(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setOpaque(false); // Sin fondo
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label.setForeground(new Color(173, 216, 230)); 
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                label.setForeground(Color.WHITE); // Regresar al color original
            }
        });
        return label;
    }

    // Método para abrir una nueva pestaña en el JTabbedPane
    
    private void openTab(String tabTitle, String tabContent) {
    	
        // Verificamos si ya existe una pestaña con este título
    	
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            if (tabbedPane.getTitleAt(i).equals(tabTitle)) {
                tabbedPane.setSelectedIndex(i); // Seleccionamos la pestaña existente
                return;
            }
        }

        // Si no existe, agregamos una nueva pestaña
        
        JPanel panel = new JPanel();
        panel.add(new JLabel(tabContent));
        tabbedPane.addTab(tabTitle, panel);
        tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1); // Seleccionar la nueva pestaña
    }
  
    
    
}