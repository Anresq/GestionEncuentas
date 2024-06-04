package A.R.GestionEncuestas.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "option_questions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Option_Question")
    private Long id_Option_Question ;

    @Lob
    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "id_Question", referencedColumnName = "id_Question")
    private Question question;
    
}
