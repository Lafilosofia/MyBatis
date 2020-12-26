package web;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadFile {
	//注入业务层
	@Autowired
	private UploadService service;
	
	@RequestMapping("/showUploadHtml.do")
	public String showUpload(){
		return "upload";
	}
	
	@RequestMapping(value="/upload.do")
	@ResponseBody
	public JsonResult<String> upload(MultipartFile file,HttpSession session,HttpServletRequest request) throws IllegalStateException, IOException{
		System.out.println("url:" + request.getRequestURL() + "uri:" + request.getRequestURI());
		/*MultipartFile获得附件的集合,使用的技术有jquery框架,以及SpringMVC摘要
		 * 主要实现异步文件上传,同时封装其对象*/
		//获取真实路径
		String path = session.getServletContext().getRealPath("");
		System.out.println("真实路径:" + path);
		//获取文件真实名字
		String fileName = file.getOriginalFilename();
		System.out.println("真实名字" + fileName);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String time = simpleDateFormat.format(new Date());
		
		File f = new File(path, "/upload/" + time +  "/" + fileName);
		if (!f.exists()) {
			f.mkdirs();//如果没有则创建目录
		}
		//上传文件
		file.transferTo(f);
		//返回路径
		String pathName = "/upload/" + time +  "/" + fileName;
		//修改数据库中的路径
		service.updateImageByIdService(1, pathName);
		return new JsonResult<String>(pathName);
	}
}
