package ma.octo.assignement.service;


import ma.octo.assignement.dto.ArgentTransfertDto;



public interface ArgentTransfert<Source,Destination> {
	/**
	 * 
	 * @param src L'emetteur
	 * @param dst Le compte bénifiant du transfert
	 * @param dto L'object DTO 
	 * @return	boolean indiquant si tous passe bien
	 * @throws Exception 
	 */
	public boolean transferer(ArgentTransfertDto dto) throws Exception;
	
}
