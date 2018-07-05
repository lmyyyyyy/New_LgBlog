package me.lgblog.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

public class ImgCut {
	
	
	/**
     * 截取图片
     * @param srcImageFile  原图片地址
     * @param x    截取时的x坐标
     * @param y    截取时的y坐标
     * @param desWidth   截取的宽度
     * @param desHeight   截取的高度
     */
    public static void imgCut(String srcImageFile, int x, int y, int desWidth,
                              int desHeight) {
        try {
            Image img;
            ImageFilter cropFilter;
            BufferedImage bi = ImageIO.read(new File(srcImageFile+"_src.jpg"));
            int srcWidth = bi.getWidth();
            int srcHeight = bi.getHeight();
            if (srcWidth >= desWidth && srcHeight >= desHeight) {
                Image image = bi.getScaledInstance(srcWidth, srcHeight,Image.SCALE_DEFAULT);
                cropFilter = new CropImageFilter(x, y, desWidth, desHeight);
                img = Toolkit.getDefaultToolkit().createImage(
                        new FilteredImageSource(image.getSource(), cropFilter));
                BufferedImage tag = new BufferedImage(desWidth, desHeight,
                        BufferedImage.TYPE_INT_RGB);
                Graphics g = tag.getGraphics();
                g.drawImage(img, 0, 0, null);
                g.dispose();
                //输出文件
                ImageIO.write(tag, "JPEG", new File(srcImageFile+"_cut.jpg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	//删除原来的图片
        	FileUploadUtil.deleteFile(srcImageFile+"_src.jpg");
        }
    }
    
    public static Rectangle CalcRotatedSize(Rectangle src, int angel) {  
        // if angel is greater than 90 degree, we need to do some conversion  
        if (angel >= 90) {  
            if(angel / 90 % 2 == 1){  
                int temp = src.height;  
                src.height = src.width;  
                src.width = temp;  
            }  
            angel = angel % 90;  
        }  
  
        double r = Math.sqrt(src.height * src.height + src.width * src.width) / 2;  
        double len = 2 * Math.sin(Math.toRadians(angel) / 2) * r;  
        double angel_alpha = (Math.PI - Math.toRadians(angel)) / 2;  
        double angel_dalta_width = Math.atan((double) src.height / src.width);  
        double angel_dalta_height = Math.atan((double) src.width / src.height);  
  
        int len_dalta_width = (int) (len * Math.cos(Math.PI - angel_alpha  
                - angel_dalta_width));  
        int len_dalta_height = (int) (len * Math.cos(Math.PI - angel_alpha  
                - angel_dalta_height));  
        int des_width = src.width + len_dalta_width * 2;  
        int des_height = src.height + len_dalta_height * 2;  
        return new java.awt.Rectangle(new Dimension(des_width, des_height));  
    }
    
    public static BufferedImage Rotate(Image src, int angel) {  
        int src_width = src.getWidth(null);  
        int src_height = src.getHeight(null); 
      //  angel=angel>0?angel:(360-angel);
        // calculate the new image size  
        Rectangle rect_des = CalcRotatedSize(new Rectangle(new Dimension(  
                src_width, src_height)), angel);  
  
        BufferedImage res = null;  
        res = new BufferedImage(rect_des.width, rect_des.height,  
                BufferedImage.TYPE_INT_RGB);  
        Graphics2D g2 = res.createGraphics();  
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, rect_des.width,  rect_des.height);
        // transform  
        g2.translate((rect_des.width - src_width) / 2,  
                (rect_des.height - src_height) / 2);  
        g2.rotate(Math.toRadians(angel), src_width / 2, src_height / 2);  
  
        g2.drawImage(src, null, null);  
        return res;  
    }  
    
    /**
     * @param srcImageFile 原图片地址
     * @param dest 新图片地址
     * @param x
     * @param y
     * @param w
     * @param h
     * @param degree 旋转角度
     * @return
     */
  //帶有角度的cut图片
  	public static void cutAndRotateImage(String srcImageFile,int x,int y,int w,int h,int degree){
  		try{
  			BufferedImage src = ImageIO.read(new File(srcImageFile+"_pic.jpg")); //ImageIO.read(new File(srcImageFile)); // 读入文件
  			BufferedImage tag= Rotate(src, degree);
  			 Iterator iterator = ImageIO.getImageReadersByFormatName("jpg");   
  	         ImageReader reader = (ImageReader)iterator.next();   
  	    //     InputStream in=new FileInputStream(tag); 
  	         ByteArrayOutputStream bs = new ByteArrayOutputStream();  
  	         ImageOutputStream ios = ImageIO.createImageOutputStream(bs);  
  	         ImageIO.write(tag, "jpg", ios);
  	         InputStream in=new  ByteArrayInputStream(bs.toByteArray());
  	         ImageInputStream iis=ImageIO.createImageInputStream(in);
  	         reader.setInput(iis, true);   
  	         ImageReadParam param = reader.getDefaultReadParam(); 
  	         x=(x>0?x:0);
  	         y=(y>0?y:0);
  	         Rectangle rect = new Rectangle(x, y, w,h);    
  	         param.setSourceRegion(rect);   
  	         BufferedImage bi = reader.read(0,param);   
  	         //输出文件
  	         ImageIO.write(bi, "jpg", new File(srcImageFile+"_pic.jpg"));  
  		}catch (Exception e) {
            e.printStackTrace();
        }finally{
        	//删除原来的图片
        	FileUploadUtil.deleteFile(srcImageFile+"_src.jpg");
        }
  	}
}
