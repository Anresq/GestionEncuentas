package A.R.GestionEncuestas.domain.entities;

import jakarta.persistence.Column;
import A.R.GestionEncuestas.util.enums.TypeQuestion;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "questions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Question")
    private Long id_Question;

    @Lob
    @Column(nullable = false)
    private String text;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false )
    private TypeQuestion typeQuestion;

    @Column(nullable = false)
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "id_Survey", referencedColumnName = "id_Survey")
    private Survey survey;
}
