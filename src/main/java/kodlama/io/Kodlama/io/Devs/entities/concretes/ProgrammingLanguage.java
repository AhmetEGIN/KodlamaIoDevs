package kodlama.io.Kodlama.io.Devs.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "programmingLanguages")
@Entity
public class ProgrammingLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	
	// Çift yönlü ilişkilerde iki entity arasında sonsuz döngü(infitive recursion) gerçekleşebilir. Bu durumu engellemek için ana entity(parent) 'ye JsonManagedReference annotation unu eklememiz gereklidir.
	// Buna karşılık child entity'ye de JsonBackReference annotation unu eklememiz gerekir.
	@JsonManagedReference
	@OneToMany(mappedBy = "programmingLanguage" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Technology> technologies;
	// Eğer listenin (ya da generic bir şeyin) yapısını belirtmeyeceksek bunu OneToMany(targetEntity = Technology.class) ile belirtmemiz gerek.
	
	//mappedBy = mappedBy özelliği çift yönlü ilişkinin inverse side kısmında bulunur.  OneToMany -ManyToOne ilişkilerde inverse side One tarafıdır.
		//mappedBy ilişki sahibi olmayan tarafı tanımlamak için kullanılır.
	// cascade = Entityler arasındaki ilişkilerin davranışlarını cascade ile ayarlayabiliriz. 
	   //Örneğin bir programlama dilini sildiğimizde onun teknolojilerinin de silinmesi.
	// fetch = FetchType birbirleri arasında bir ilişkiye sahip olan entitylerin birinin çağırılması durumunda diğerinin de çağırılıp çağırılmayacağını belirtir.
		// Örneğin FetchType.Eager  -- programmingLanguage entitysini yüklediğimizde Technology entity sini de yükler
		// FetchType.Lazy  --  ProgrammingLanguage entity'sini yüklediğimizde Technology entity'si ihtiyaç halinde yüklenir.
	
	
}
