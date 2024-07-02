package study.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import study.model.Cricketer;

public interface CricketService {

	Cricketer addCricketer(MultipartFile file, String name, String representation);

	List<Cricketer> findAll();

	

}
