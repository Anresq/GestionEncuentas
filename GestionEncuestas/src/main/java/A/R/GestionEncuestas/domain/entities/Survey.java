package A.R.GestionEncuestas.domain.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "surveys")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Survey")
    private Long id_Survey;

    
    @Column(nullable = false, length = 255)
    private String survey_title;

    @Lob
    @Column(nullable = false )
    private String description;


    @Column(nullable = false )
    private LocalDate creation_date;

    @Column(nullable = false)
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "id_creator", referencedColumnName = "id_user")
    private User creator;

    @OneToMany(mappedBy = "survey", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Question> questions;
}

