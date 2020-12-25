package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.net.ssl.internal.www.protocol.https.Handler;

@Controller
public class LoginController {
	@RequestMapping("/login2.do")
	public String login(){
		return "login2";
	}
	
	@RequestMapping(value = "/checkName.do",produces = "text/html;charset=utf-8")
	@ResponseBody		//阻止返回jsp页面	以json格式传到前端
	public String checkName(String name){
		if ("admin".equals(name)) {
			return "0 正确";
		}else {
			return "1错误";
			//throw new RuntimeException();
		}
	}
	
	@RequestMapping(value = "/getCity.do",produces = "text/html;charset=utf-8")
	@ResponseBody
	public String getCity(String  provinceCode){
		if (provinceCode.equals("1")) {
			return "1.西安市;2.渭南市";
		}else if (provinceCode.equals("2")) {
			return "1.昆明市;2.大理市";
		}
		return provinceCode;
	}
	
	
	@ExceptionHandler
	@ResponseBody
	public JsonResult Handler(Exception exception){
		return new JsonResult(exception);
	}
	
	@RequestMapping(value = "/checkName2.do")
	@ResponseBody
	public JsonResult checkName2(String name){
		if ("admin".equals(name)) {
			JsonResult jsonResult = new JsonResult();
			jsonResult.setState(1);
			jsonResult.setMessage("OK");
			return jsonResult;
		}else {
			throw new RuntimeException("用户名不存在");
		}
	}
}
 