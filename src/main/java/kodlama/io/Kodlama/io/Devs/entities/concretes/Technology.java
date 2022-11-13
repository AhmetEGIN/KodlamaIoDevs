package kodlama.io.Kodlama.io.Devs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="technologies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Technology {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;

	
	//JoinColumn ilişkinin owning side kısmında bulunur. Varlığı ilişkilendirmede kullanacağımız sütunu belirlememizi sağlar(foreign key).
	
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "programming_language_id", foreignKey = @ForeignKey(name = "programming_language_id"))
	private ProgrammingLanguage programmingLanguage;
	
}
