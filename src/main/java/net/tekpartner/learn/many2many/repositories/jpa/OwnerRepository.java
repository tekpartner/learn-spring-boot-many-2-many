package net.tekpartner.learn.many2many.repositories.jpa;

import net.tekpartner.learn.many2many.persistence.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Chandrashekar R. Gaajula
 */
@Transactional(readOnly = true)
public interface OwnerRepository extends JpaRepository<Owner, Long>, JpaSpecificationExecutor<Owner> {

    Optional<Owner> findByName(String name);
}
