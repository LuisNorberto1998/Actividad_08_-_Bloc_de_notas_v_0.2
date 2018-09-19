
package models;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Norberto
 *
 * public class Imagen extends JPanel{
 * @Override public void paintComponent(Graphics g){ Dimension tam=getSize();
 * ImageIcon imagen = new ImageIcon(new
 * ImageIcon(getClass().getResource("/image/fondo.png")).getImage());
 * g.drawImage(imagen.getImage(),0,0,tam.width,tam.height,null); }
 *
 * }
 */
public class ModelFondoPanel extends javax.swing.JPanel {

    public ModelFondoPanel() {
        this.setSize(675,500); //se selecciona el tamaño del panel
    }

//Se crea un método cuyo parámetro debe ser un objeto Graphics
    @Override
    public void paint(Graphics g) {
        Dimension tam = getSize();

//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
        ImageIcon Img = new ImageIcon(getClass().getResource("/images/fondo.jpg"));

//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
        g.drawImage(Img.getImage(),0,0,tam.width,tam.height,null); 

        setOpaque(false);
        super.paintComponent(g);
    }
}
