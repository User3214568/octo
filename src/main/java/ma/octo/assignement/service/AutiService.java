package ma.octo.assignement.service;

import ma.octo.assignement.domain.AuditTransfert;
import ma.octo.assignement.domain.util.EventType;
import ma.octo.assignement.repository.AuditTransfertRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AutiService {

    Logger LOGGER = LoggerFactory.getLogger(AutiService.class);

    @Autowired
    private AuditTransfertRepository auditRepository;
    
   
    public void auditVirement(String message) {
    	audit(message , EventType.VIREMENT);
    }
    public void audit(String message,EventType event) {
    	LOGGER.info("Audit de l'événement {}",event);
    	AuditTransfert audit = new AuditTransfert();
        audit.setEventType(EventType.VIREMENT);
        audit.setMessage(message);
        auditRepository.save(audit);
    }
    public void auditVersement(String message) {
    	audit(message , EventType.VERSEMENT);
    }
}
