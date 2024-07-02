package study.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import study.model.Cricketer;
import study.repository.CricketerRepository;

@Service
public class CricketServiceImpl implements CricketService {
	
	private final String path = "C:\\Data\\Angular\\imageuploadtoAssets\\src\\assets\\";
	@Autowired
	private CricketerRepository cricketerRepository;
	
	@Override
	public Cricketer addCricketer(MultipartFile file, String name, String representation) {
		
		String imageFileName = file.getOriginalFilename();
		String imageFileType = file.getContentType();
			
		
		//send the image file to the directory
		String imageFilePath = path+file.getOriginalFilename();	
		try {
			file.transferTo(new File(imageFilePath));
		} catch (IllegalStateException | IOException e) {
			
			e.printStackTrace();
		}
		return cricketerRepository.save(new Cricketer(name, representation,
				imageFileName, imageFileType, imageFilePath));
	}
	@Override
	public List<Cricketer> findAll() {
		
		return cricketerRepository.findAll();
	}

}
