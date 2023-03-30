import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class StickersGenerator {
    
    public void readImg(InputStream inputStream, String title) throws IOException {
        //local file:
        //BufferedImage originalImage = ImageIO.read(new File("img/TopMovies_1.jpg"));

        //remote file:
        //InputStream is = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs_1.jpg").openStream();

        BufferedImage originalImage = ImageIO.read(inputStream);

        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 200;
        BufferedImage newImg = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) newImg.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.ORANGE);
        graphics.setFont(fonte);

        graphics.drawString(title, 100, newHeight - 100);

        ImageIO.write(newImg, "jpg", new File("img/" + title + ".jpg"));

    }

}
