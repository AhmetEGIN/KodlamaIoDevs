package kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.entities.concretes.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgrammingLanguagesResponse {
	private int id;
	private String name;
	private List<Technology> technologies;
}
