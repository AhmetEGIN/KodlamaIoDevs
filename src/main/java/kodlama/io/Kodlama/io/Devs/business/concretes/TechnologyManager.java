package kodlama.io.Kodlama.io.Devs.business.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {
	private TechnologyRepository technologyRepository;
	private ModelMapper modelMapper;
	private ProgrammingLanguageService languageService;
	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository, ModelMapper modelMapper, ProgrammingLanguageService languageService) {
		this.technologyRepository = technologyRepository;
		this.modelMapper = modelMapper;
		this.languageService = languageService;
	}
	@Override
	public void create(CreateTechnologyRequest technologyRequest) {
			
		Technology technology = modelMapper.map(technologyRequest, Technology.class);
		
		technology.setName(technologyRequest.getName());
		technology.setProgrammingLanguage(modelMapper.map(languageService.getById(technologyRequest.getProgrammingLanguageId()), ProgrammingLanguage.class));
		technologyRepository.save(technology);
		// buradaki mapping kısmı dinamik olmadı
		
		
	}
	@Override
	public void delete(DeleteTechnologyRequest technologyRequest) {
		Technology technology = technologyRepository.getReferenceById(technologyRequest.getId());
		technologyRepository.delete(technology);
		
	}
	@Override
	public void update(UpdateTechnologyRequest technologyRequest) {
		Technology technology = technologyRepository.getReferenceById(technologyRequest.getId());
		technology.setName(technologyRequest.getName());
		technologyRepository.save(technology);
		
	}
	
}
