package kodlama.io.Kodlama.io.Devs.business.abstracts;

import kodlama.io.Kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;

public interface TechnologyService {
	void create(CreateTechnologyRequest technologyRequest);
	void delete(DeleteTechnologyRequest technologyRequest);
	void update(UpdateTechnologyRequest technologyRequest);
	
}
