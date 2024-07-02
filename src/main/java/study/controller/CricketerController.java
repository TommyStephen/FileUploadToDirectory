package study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import study.model.Cricketer;
import study.service.CricketService;

@RestController
@CrossOrigin
public class CricketerController {

	@Autowired
	private CricketService cricketService;
	
	@PostMapping("/FileUploadToDirectory/cricketer/add")
	private Cricketer addCricketer(@RequestPart MultipartFile file, String name,
			String representation) {
		return cricketService.addCricketer(file, name, representation);	
	}
	@GetMapping("/FileUploadToDirectory/cricketer/findAll")
	private List<Cricketer> findAll(){
		return cricketService.findAll();
	}
	
	
	
}
