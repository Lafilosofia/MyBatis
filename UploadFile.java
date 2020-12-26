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
	//ע��ҵ���
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
		/*MultipartFile��ø����ļ���,ʹ�õļ�����jquery���,�Լ�SpringMVCժҪ
		 * ��Ҫʵ���첽�ļ��ϴ�,ͬʱ��װ�����*/
		//��ȡ��ʵ·��
		String path = session.getServletContext().getRealPath("");
		System.out.println("��ʵ·��:" + path);
		//��ȡ�ļ���ʵ����
		String fileName = file.getOriginalFilename();
		System.out.println("��ʵ����" + fileName);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String time = simpleDateFormat.format(new Date());
		
		File f = new File(path, "/upload/" + time +  "/" + fileName);
		if (!f.exists()) {
			f.mkdirs();//���û���򴴽�Ŀ¼
		}
		//�ϴ��ļ�
		file.transferTo(f);
		//����·��
		String pathName = "/upload/" + time +  "/" + fileName;
		//�޸����ݿ��е�·��
		service.updateImageByIdService(1, pathName);
		return new JsonResult<String>(pathName);
	}
}
