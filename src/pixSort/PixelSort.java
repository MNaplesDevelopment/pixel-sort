package pixSort;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PixelSort {
	
	static BufferedImage img;
	static int height;
	static int width;
	
	public static void main(String args[])	{
		try	{
			img = ImageIO.read(new File("image1.png"));
		} catch(Exception e)	{
			e.printStackTrace();
		}
		height = img.getHeight();
		width = img.getWidth();
		
		int[] pix = new int[height * width];
		
		System.out.println("Loaded! Indexing...");
		
		// Store each pixel in an array
		for(int i = 0; i < width; i++)	{
			for(int j = 0; j < height; j++)	{
				int p = img.getRGB(i, j);
				p &= ~0b11111111000000000000000000000000; // Removes the alpha channel
				//p |= 0b00000000000000010000000100000001; // Sets minimum value to 1 for each color
				pix[(i * height) + j] = p;
			}
		}
		
		System.out.println("Finished Indexing!\nSorting...");
		
		BinaryInsertionSort sort = new BinaryInsertionSort();
		sort.sort(pix);
		
		System.out.println("Done sorting!\nIndexing back...");
		
		BufferedImage pixelSorted = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		// Loads sorted pixels into a new image
		for(int i = 0; i < width; i++)	{
			for(int j = 0; j < height; j++)	{
				pixelSorted.setRGB(i, j, pix[(i * height) + j]);
			}
		}
		
		try{
            File out = new File("pic.png");
            ImageIO.write(pixelSorted, "png", out);
            System.out.println("DONE! :D");
        }
        catch(IOException e)    {
            e.printStackTrace();
        }
	}
}
