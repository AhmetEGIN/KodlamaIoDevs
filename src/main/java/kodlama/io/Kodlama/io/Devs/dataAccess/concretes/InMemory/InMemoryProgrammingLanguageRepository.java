package kodlama.io.Kodlama.io.Devs.dataAccess.concretes.InMemory;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

	List<ProgrammingLanguage> languages;

	public InMemoryProgrammingLanguageRepository() {
		languages = new ArrayList<ProgrammingLanguage>();
		languages.add(new ProgrammingLanguage(1, "C#"));
		languages.add(new ProgrammingLanguage(2, "Java"));
		languages.add(new ProgrammingLanguage(3, "Python"));
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		languages.add(programmingLanguage);

	}

	@Override
	public void delete(ProgrammingLanguage programmingLanguage) {
		ProgrammingLanguage languageToDelete = findProgrammingLanguage(programmingLanguage.getId());
		if (languageToDelete != null) {
			languages.remove(languageToDelete);
		} else {
			throw new IndexOutOfBoundsException();
		}

	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		ProgrammingLanguage languageToUpdate = findProgrammingLanguage(programmingLanguage.getId());
		languageToUpdate.setName(programmingLanguage.getName());
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return languages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return findProgrammingLanguage(id);
	}

	// private codes

	private ProgrammingLanguage findProgrammingLanguage(int id) {
		ProgrammingLanguage _programmingLanguage = null;
		for (ProgrammingLanguage language : languages) {
			if (language.getId() == id) {
				_programmingLanguage = language;
			}
		}
		return _programmingLanguage;

	}

}
