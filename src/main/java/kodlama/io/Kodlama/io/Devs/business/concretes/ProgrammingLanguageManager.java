package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage.GetAllProgrammingLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage.GetByIdProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository languageRepository;
	private ModelMapper modelMapper;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository languageRepository, ModelMapper modelMapper) {
		this.languageRepository = languageRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		if (isLanguageAlreadyExist(createProgrammingLanguageRequest.getName())
				&& isLanguageNameEmpty(createProgrammingLanguageRequest.getName())) {
			ProgrammingLanguage programmingLanguage = modelMapper.map(createProgrammingLanguageRequest,
					ProgrammingLanguage.class);
			languageRepository.save(programmingLanguage);
		}
	}

	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguage) {
		ProgrammingLanguage programmingLanguage = languageRepository.getReferenceById(deleteProgrammingLanguage.getId());
		languageRepository.delete(programmingLanguage);
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguage) {
		if (isLanguageNameEmpty(updateProgrammingLanguage.getName())
				&& isLanguageAlreadyExist(updateProgrammingLanguage.getName())) {
			ProgrammingLanguage programmingLanguage = modelMapper.map(updateProgrammingLanguage, ProgrammingLanguage.class);
			languageRepository.save(programmingLanguage);

		}
	}

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
//		List<GetAllProgrammingLanguagesResponse> getAllProgrammingLanguagesResponses = new ArrayList<GetAllProgrammingLanguagesResponse>();
//		for (ProgrammingLanguage programmingLanguage: languageRepository.findAll()) {
//			getAllProgrammingLanguagesResponses.add(new GetAllProgrammingLanguagesResponse(programmingLanguage.getId(), programmingLanguage.getName(), programmingLanguage.getTechnologies()));
//		}
//		return getAllProgrammingLanguagesResponses;
		return modelMapper.map(languageRepository.findAll(), new TypeToken<List<GetAllProgrammingLanguagesResponse>>() {
		}.getType());
	}

	@Override
	public GetByIdProgrammingLanguageResponse getById(int id) {
		ProgrammingLanguage programmingLanguage = languageRepository.getReferenceById(id);

		return modelMapper.map(programmingLanguage, GetByIdProgrammingLanguageResponse.class);
	}

	// business codes - private codes
	private boolean isLanguageNameEmpty(String name) {
		if (name.isEmpty()) {
			System.out.println("Dil adı boş geçilemez");
			return false;
		} else {
			return true;
		}
	}

	private boolean isLanguageAlreadyExist(String name) {
		
		if (languageRepository.getByName(name)== null) {
			return true;
		}
		return false;

	}

}
