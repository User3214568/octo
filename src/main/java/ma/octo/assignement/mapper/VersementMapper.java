package ma.octo.assignement.mapper;

import ma.octo.assignement.domain.Versement;
import ma.octo.assignement.dto.VersementDto;

public class VersementMapper {


    public static VersementDto map(Versement versement) {
        VersementDto versementDto = new VersementDto();
        versementDto.setNomEmetteur(versement.getNameEmetteur());
        versementDto.setDate(versement.getDateExecution());
        versementDto.setMotif(versement.getMotifTransfert());
        versementDto.setMontantTransferer(versement.getMontantTransfer());
        return versementDto;

    }
  
}
