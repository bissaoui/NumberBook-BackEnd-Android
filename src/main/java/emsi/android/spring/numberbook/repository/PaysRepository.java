package emsi.android.spring.numberbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emsi.android.spring.numberbook.model.Pays;
@Repository
public interface PaysRepository extends JpaRepository<Pays, Integer> {

}
