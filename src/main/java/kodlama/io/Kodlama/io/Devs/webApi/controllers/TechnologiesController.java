package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
	
	private TechnologyService technologyService;
	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}
	
	@PostMapping("/add")
	public void add(CreateTechnologyRequest technologyRequest) {
		technologyService.create(technologyRequest);
	}
	
	@PostMapping("/delete")
	public void delete(DeleteTechnologyRequest technologyRequest) {
		technologyService.delete(technologyRequest);
	}
	@PostMapping("/update")
	public void update(UpdateTechnologyRequest technologyRequest) {
		technologyService.update(technologyRequest);
	}
}
