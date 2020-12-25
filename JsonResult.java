package web;

public class JsonResult {
	
	private int state;//״̬(�ɹ����)
	private String message;//��ȷ/���󷵻ص���ʾ��Ϣ
	//��������״̬
	public static final int SUCCESS = 1;//�ɹ���״̬
	public static final int ERROR = 0;//�����״̬

	
	
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
