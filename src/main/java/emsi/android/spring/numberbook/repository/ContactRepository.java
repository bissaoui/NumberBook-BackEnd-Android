package emsi.android.spring.numberbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import emsi.android.spring.numberbook.controllers.BestMatch;
import emsi.android.spring.numberbook.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
	@Query(value = "select telephone, nom , count(nom) as 'nb' "
			+ "  from contact "
			+ "where prefix = ?1 and  telephone =?2  "
			+ " group by telephone , nom "
			+ " order by nb desc"
			+ " LIMIT 1"
			,nativeQuery = true)
	BestMatch findContactByPrefixN(String prefix,String numero);

}
