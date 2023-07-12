package rikkei.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rikkei.academy.model.Role;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface IRoleRepository extends JpaRepository<Role, Long> {
}
