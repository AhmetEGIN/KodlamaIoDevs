package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository languageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		if (isLanguageNameEmpty(programmingLanguage) && isLanguageAlreadyExist(programmingLanguage)) {
			languageRepository.add(programmingLanguage);
		}
		
	}

	@Override
	public void delete(ProgrammingLanguage programmingLanguage) {
		languageRepository.delete(programmingLanguage);

	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		if (isLanguageNameEmpty(programmingLanguage) && isLanguageAlreadyExist(programmingLanguage)) {
			languageRepository.update(programmingLanguage);
		}

	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return languageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return languageRepository.getById(id);
	}

	// business codes - private codes
	private boolean isLanguageNameEmpty(ProgrammingLanguage programmingLanguage) {
		if (programmingLanguage.getName().isEmpty()) {
			System.out.println("Dil adı boş geçilemez");
			return false;
		} else {
			return true;
		}
	}
	
	private boolean isLanguageAlreadyExist(ProgrammingLanguage programmingLanguage) {
		for (ProgrammingLanguage language : languageRepository.getAll()) {
			if (language.getName().equals(programmingLanguage.getName())) {
				System.out.println("Aynı isimde bir dil zaten mevcut");
				return false;
			}
		}
		return true;
	}

}
