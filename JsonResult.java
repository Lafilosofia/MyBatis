package web;

public class JsonResult {
	
	private int state;//状态(成功与否)
	private String message;//正确/错误返回的提示信息
	//声明两种状态
	public static final int SUCCESS = 1;//成功的状态
	public static final int ERROR = 0;//错误的状态

	
	
	public JsonResult(Throwable e){
		this.state = ERROR;
		this.message = e.getMessage();
	}


	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + "]";
	}


	public JsonResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
