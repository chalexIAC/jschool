package tshop.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import tshop.back.entities.Client;

/**
 * Created by Роднуля on 30.03.2017.
 */
@Transactional
public interface ClientRepository extends JpaRepository<Client, Long> {
@Query("select c from Client as c where c.account.login = :login")
Client getClientByLogin(@Param("login") String login);

}
