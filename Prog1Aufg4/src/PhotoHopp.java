import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.*;

public class PhotoHopp {
    public static void main(String[] args) throws IOException {



        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image srcImage1 = toolkit.getImage("river.gif");
        Image srcImage2 = toolkit.getImage("fki_start.jpg");
        Image srcImage3 = toolkit.getImage("farbenkreis_b.gif");
        Image srcImage4 = toolkit.getImage("eigenes.jpg");


        ImageFilter colorfilter = new TestFilter();
        Image filteredImage1 = toolkit.createImage(
                new FilteredImageSource(srcImage1.getSource(),colorfilter));
        Image filteredImage2 = toolkit.createImage(
                new FilteredImageSource(srcImage2.getSource(),colorfilter));
        Image filteredImage3 = toolkit.createImage(
                new FilteredImageSource(srcImage3.getSource(),colorfilter));
        Image filteredImage4 = toolkit.createImage(
                new FilteredImageSource(srcImage4.getSource(),colorfilter));

        JFrame frame = new JFrame("Images and pixelwise filtering");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.RED);
        Panel allImagesPanel = new Panel();
        allImagesPanel.setLayout(new GridLayout(0,4));
        allImagesPanel.add(new ImagePanel(srcImage1));
        allImagesPanel.add(new ImagePanel(srcImage2));
        allImagesPanel.add(new ImagePanel(srcImage3));
        allImagesPanel.add(new ImagePanel(srcImage4));
        allImagesPanel.add(new ImagePanel(filteredImage1));
        allImagesPanel.add(new ImagePanel(filteredImage2));
        allImagesPanel.add(new ImagePanel(filteredImage3));
        allImagesPanel.add(new ImagePanel(filteredImage4));
        frame.getContentPane().add(allImagesPanel);
        frame.setBounds(50,50,1500,500);
        frame.setVisible(true);

        while(true){
            frame.repaint();
        }
    }
}

class ImagePanel extends JPanel  {
    private Image image;

    public ImagePanel(Image image)  {
        this.image = image;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        System.out.println("paintComponent" + this + image.getWidth(this) + " " + image.getHeight(this));
        g.drawImage(image, 10, 10,image.getWidth(this) , image.getHeight(this), this);
    }
}



class TestFilter extends RGBImageFilter {



    public int filterRGB(int x, int y, int pixel) {

       int filteredPixel = 0;

       //Hier zum Färben R/G/B, zum Filtern r/g/b, zum RotBlau-Tausch RB und zum Dunkel-Anzeigen dark, für die halbe Deckkraft halfOpacity,
        // um das Bild heller zu machen light, für Schwarzweiß blackwhite, für Grau grey, für Negativ negative, für einen Teil des Bilds part oder für einen Blur blur einfügen.
       String color = "lighter";

        // 0x => Interpret as something
        // 0xAARRGGBB  => ALPHA RED GREEN BLUE

        // enjoy working on pixels here
        // extract one color part as an example
        //filteredPixel = (pixel & 0xffffffff);



        // Färben (color = R/G/B) oder Filtern (color = r/g/b)

        if (Arrays.asList("R", "G", "B", "r", "g", "b").contains(color)) {
            switch(color){
                case "R":
                    filteredPixel = (0xffff0000);
                    break;
                case "G":
                    filteredPixel = (0xff00ff00);
                    break;
                case "B":
                    filteredPixel = (0xff0000ff);
                    break;
                case "r":
                    filteredPixel = (pixel & 0xffff0000);
                    break;
                case "g":
                    filteredPixel = (pixel & 0xff00ff00);
                    break;
                case "b":
                    filteredPixel = (pixel & 0xff0000ff);
                    break;
            }

        } else {
            filteredPixel = (pixel);
        }

        // Color Swap

        if (color == "RB") {

            // 11111111 11111111 00000000 11111111

            int alpha = (pixel >> 24) & 0x000000FF;
            int red = (pixel >> 16) & 0x000000FF;
            int green = (pixel >> 8) & 0x000000FF;
            int blue = (pixel >> 0) & 0x000000FF;

            filteredPixel = (alpha << 24) | (blue << 16) | (green << 8) | (red);

        }

        if(color == "dark"){

            int red = (pixel >> 16) & 0x000000FF;
            int green = (pixel >> 8) & 0x000000FF;
            int blue = (pixel >> 0) & 0x000000FF;

            if(red < 100 && green < 100 && blue < 100) {
                filteredPixel = (pixel);
            } else {
                filteredPixel = (0xFFFFFFFF);
            }
        }

        if(color == "halfOpacity"){
            int alpha = (pixel >> 24) & 0xFF;
            alpha = alpha / 2;
            int rest = (pixel & 0x00FFFFFF);
            filteredPixel = (alpha << 24) | (rest << 0);
        }

        if(color == "lighter") {

            int alpha = ((pixel >> 24) & 0x000000FF);
            int red = ((pixel >> 16) & 0x000000FF) + 0x00000050;
            int green = ((pixel >> 8) & 0x000000FF) + 0x000000FF;
            int blue = ((pixel >> 0) & 0x000000FF) + 0x00000050;



            filteredPixel = (alpha << 24) | (red << 16) | (green << 8) | (blue << 0);
        }

        if(color == "blackwhite"){

            int red = (pixel >> 16) & 0x000000FF;
            int green = (pixel >> 8) & 0x000000FF;
            int blue = (pixel >> 0) & 0x000000FF;

            if(red < 115 && green < 115 && blue < 115) {
                filteredPixel = (0xFF000000);
            } else {
                filteredPixel = (0xFFFFFFFF);
            }
        }

        if(color == "grey"){

            int alpha = ((pixel >> 24) & 0x000000FF);
            int red = (pixel >> 16) & 0x000000FF;
            int green = (pixel >> 8) & 0x000000FF;
            int blue = (pixel >> 0) & 0x000000FF;
            int brightness = (red + green + blue)/3;


            filteredPixel = (alpha << 24) | (brightness << 16) | (brightness << 8) | (brightness << 0);

        }

        if(color == "negative"){
            int alpha = ((pixel >> 24) & 0x000000FF);
            int red = ((pixel >> 16) & 0x000000FF);
            int green = ((pixel >> 8) & 0x000000FF);
            int blue = ((pixel >> 0) & 0x000000FF);
            red = ~red & 0x000000FF;
            green = ~green & 0x000000FF;
            blue = ~blue & 0x000000FF;


            filteredPixel = (alpha << 24) | (red << 16) | (green << 8) | (blue << 0);
        }

        if(color == "part"){


            if(x < 100) {
                filteredPixel = (pixel);
            } else {
                filteredPixel = (0xFFFFFFFF);
            }

        }

        if(color == "blur"){

            if(((x%2) == 0 && (y%2) == 0)){

                    filteredPixel = (0xFF000000);

                } else {
                    filteredPixel = pixel;

                }

        }







        return filteredPixel;


    }
}