package me.lgblog.controller;

import java.io.File;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import me.lgblog.common.PictureResult;
import me.lgblog.util.FileUploadUtil;
import me.lgblog.util.ImgCut;
import me.lgblog.util.Result;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
/*@RequestMapping("/UploadDemo")*/
public class UploadImgController {
	
	@RequestMapping(value = "/uploadHeadImage",method = RequestMethod.GET)
    public String uploadCropper(){
		return "cropper";
	}
	
	@RequestMapping(value = "/uploadHeadImage",method = RequestMethod.POST, produces="text/html;charset=utf-8")
	@ResponseBody  
    public String uploadCropper(
    		@RequestParam(value = "avatar_file",required=false) MultipartFile avatar_file,
			 String avatar_src,String avatar_data, HttpServletRequest request) {
				System.out.println("==========Start=============");
				String realPath = request.getSession().getServletContext().getRealPath("/");
				String resourcePath = "/upload/image/";
		        //判断文件的MIMEtype
		        String type = avatar_file.getContentType();
		        if(type==null || !FileUploadUtil.allowUpload(type)) return  JSON.toJSONString(new Result(null,"不支持的文件类型，仅支持图片！"));
		        System.out.println("file type:"+type);
                String fileName = FileUploadUtil.rename(avatar_file.getOriginalFilename());
                int end = fileName.lastIndexOf(".");
                String saveName = fileName.substring(0,end);
                try {
                	File dir = new File(realPath + resourcePath);
                    if(!dir.exists()){
                        dir.mkdirs();
                    }
                    File file = new File(dir,saveName+"_pic.jpg");
					avatar_file.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();  
		            return  JSON.toJSONString(new Result(null,"上传失败，出现异常："+e.getMessage()));
		        }   
                String srcImagePath = realPath + resourcePath + saveName;
                JSONObject joData = (JSONObject) JSONObject.parse(avatar_data);
                // 用户经过剪辑后的图片的大小  
                // 用户经过剪辑后的图片的大小  
               /* float x = joData.getFloatValue("x");
                float y = joData.getFloatValue("y");
                float w =  joData.getFloatValue("width");
                float h =  joData.getFloatValue("height");*/
                float r = joData.getFloatValue("rotate");
                Random random = new Random();
                int i = random.nextInt(200);
                //这里开始截取操作
                System.out.println("==========imageCutStart=============");
                ImgCut.cutAndRotateImage(srcImagePath, (int)0,(int) 0,(int) 1920+i,(int)1080,(int) r);
                System.out.println("==========imageCutEnd=============");         
            
        return  JSON.toJSONString(new Result(request.getSession().getServletContext().getContextPath()+resourcePath+saveName+"_pic.jpg","上传成功!"));
	}
	@RequestMapping(value = "/picUploads",method = RequestMethod.POST, produces="text/html;charset=utf-8")
	@ResponseBody  
    public String picUpload(
    		@RequestParam(value = "picture") MultipartFile picture,
			 String avatar_src,String avatar_data, HttpServletRequest request) {
				System.out.println("==========Start=============");
				String realPath = request.getSession().getServletContext().getRealPath("/");
				String resourcePath = "/upload/picture/";
		        //判断文件的MIMEtype
		        String type = picture.getContentType();
		        if(type==null || !FileUploadUtil.allowUpload(type)) return  JSON.toJSONString(new PictureResult(null,1));
		        System.out.println("file type:"+type);
                String fileName = FileUploadUtil.rename(picture.getOriginalFilename());
                int end = fileName.lastIndexOf(".");
                String saveName = fileName.substring(0,end);
                String[] data = {request.getSession().getServletContext().getContextPath()+resourcePath+saveName+"_src.jpg"};
                try {
                	File dir = new File(realPath + resourcePath);
                    if(!dir.exists()){
                        dir.mkdirs();
                    }
                    File file = new File(dir,saveName+"_src.jpg");
                    picture.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();  
		            return  JSON.toJSONString(new PictureResult(null,1));
		        }   
                         
            
        return  JSON.toJSONString(new PictureResult(data,0));
  }
}
	
