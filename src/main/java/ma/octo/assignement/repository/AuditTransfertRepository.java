package ma.octo.assignement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.octo.assignement.domain.AuditTransfert;

public interface AuditTransfertRepository extends JpaRepository<AuditTransfert, Long> {
	
}
