package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.UploadImage;

@Service
public class UploadServiceImpl implements UploadService {
	//ע��־ò�
	@Autowired
	private UploadImage mapper;
	@Override
	public boolean updateImageByIdService(int id, String image) {
		boolean b = mapper.updateImageById(id, image);
		return b;
	}

}
