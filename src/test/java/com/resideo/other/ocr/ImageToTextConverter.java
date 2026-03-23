package com.honeywell.commons.ocr;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Utility class for converting images to text using Tesseract OCR.
 */
public class ImageToTextConverter {


    public static String convertImageToText(String imagePath, String tessDataPath, String language) {
        ITesseract tesseract = new Tesseract();

        tesseract.setDatapath(tessDataPath);
        tesseract.setLanguage(language);
        tesseract.setPageSegMode(7); // Treat image as a single text line (helps with small images)

        try {
            // Preprocess image to improve accuracy
            BufferedImage image = preprocessImage(new File(imagePath));
            return tesseract.doOCR(image);
        } catch (IOException e) {
            return "Error reading image file: " + e.getMessage();
        } catch (TesseractException e) {
            return "Error during OCR: " + e.getMessage();
        }
    }

    /**
     * Converts the image to grayscale and enhances contrast.
     * This helps Tesseract perform better on simple text images.
     */
    private static BufferedImage preprocessImage(File imageFile) throws IOException {
        BufferedImage original = ImageIO.read(imageFile);
        BufferedImage grayscale = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g = grayscale.createGraphics();
        g.drawImage(original, 0, 0, null);
        g.dispose();
        return grayscale;
    }

    public static void main(String[] args) {
        String imagePath = "./src/test/resources/Images/ScreenShotFromDenali/summer.png";
        String tessDataPath = System.getProperty("user.home")
                + File.separator + "AppData"
                + File.separator + "Local"
                + File.separator + "Programs"
                + File.separator + "Tesseract-OCR"
                + File.separator + "tessdata";
        String language = "eng";
        String extractedText = convertImageToText(imagePath, tessDataPath, language);
        System.out.println("Extracted Text: " + extractedText);
    }
}
