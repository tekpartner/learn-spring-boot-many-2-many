package net.tekpartner.learn.many2many.repositories.jpa;

import net.tekpartner.learn.many2many.persistence.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Chandrashekar R. Gaajula
 */
@Transactional(readOnly = true)
public interface PublisherRepository extends JpaRepository<Publisher, Long>, JpaSpecificationExecutor<Publisher> {

    Optional<Publisher> findByName(String name);
}
