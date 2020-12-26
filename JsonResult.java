package web;

public class JsonResult<T> {
	private T data;//��ȷ����
	private int state;//״̬(�ɹ����)
	private String message;//��ȷ/���󷵻ص���ʾ��Ϣ
	//��������״̬
	public static final int SUCCESS = 1;//�ɹ���״̬
	public static final int ERROR = 0;//�����״̬

	public JsonResult(T data) {
		this.data = data;
		this.state = SUCCESS;
		this.message = "OK";
	}
	
	public JsonResult(Throwable e){
		this.state = ERROR;
		this.message = e.getMessage();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
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
		return "JsonResult [data=" + data + ", state=" + state + ", message=" + message + "]";
	}


	
	
	
	
}
