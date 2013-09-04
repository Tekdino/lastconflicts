package maailma;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Luokka testaamaan maaston generointia
 */
public class MaailmaMonitori extends JFrame {
    public MaailmaMonitori() {
    add(new Maailmankartta());
    }
    
    public static void main(String[] args) {
        
        MaailmaMonitori ikkuna = new MaailmaMonitori();
        
        ikkuna.setTitle("Generated geology");
        ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ikkuna.setSize(800,800);
        ikkuna.setVisible(true);
        
    }
    
    class Maailmankartta extends JPanel {
        public void paintComponent(Graphics kuva) {
            Geologia geologia = new Geologia();
            geologia.asteroidiPommitus(10000);
            
            setBackground(Color.black);
            
            int r,g,b;
            
            r = 200;
            b = 0;
            
            // TODO Jostai syyst antaa out of range arvoja vihreelle värille
            // Voisko mennä negatiivisen puolelle jos kaks asteroidii osuu
            // samaa kohtaa?
            
            //HUOM näyttää vaa vasemman yläruudun, eli ekat 800x800km
            for (int i=0; i<800; i++)
             for (int n=0; n<800; n++) {
               Color vari = new Color(r,geologia.kartta[i][n].korkeus,b);
               kuva.setColor(vari);
               kuva.fillRect(i,n, 3,3);
          }
        }
    }
}
