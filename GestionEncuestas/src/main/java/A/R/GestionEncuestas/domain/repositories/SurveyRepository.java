package A.R.GestionEncuestas.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import A.R.GestionEncuestas.domain.entities.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey,Long> {
    
}
