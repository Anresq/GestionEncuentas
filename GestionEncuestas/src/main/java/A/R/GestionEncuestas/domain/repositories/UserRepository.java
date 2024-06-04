package A.R.GestionEncuestas.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import A.R.GestionEncuestas.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}