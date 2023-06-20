package service_catalog_service_class_structure_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service_catalog_service_class_structure_mgmt.model.dto.ServiceCatalogServStructure_DTO;
import service_catalog_service_class_structure_mgmt.model.master.ServiceCatalogServStructure;
import service_catalog_service_class_structure_mgmt.model.master.ServiceCatalogServStructurePK;
import service_catalog_service_class_structure_mgmt.model.repo.ServiceCatalogServStucture_Repo;

@Service("serviceCatalogServStructureServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ServiceCatalogServStructureService implements I_ServiceCatalogServStructure_Service 
{

	@Autowired
	private ServiceCatalogServStucture_Repo serviceCatalogServiceStructureRepo;

	public ServiceCatalogServStructure_DTO newServiceCatalogServStructure(ServiceCatalogServStructure_DTO lmsServiceCatalogServStructure_DTO) {
		ServiceCatalogServStructurePK lmsServiceCatalogServStructurePK = new ServiceCatalogServStructurePK();
		lmsServiceCatalogServStructurePK.setParServiceClassSeqNo(lmsServiceCatalogServStructure_DTO.getParServiceClassSeqNo());
		lmsServiceCatalogServStructurePK.setServiceClassSeqNo(lmsServiceCatalogServStructure_DTO.getServiceClassSeqNo());
		ServiceCatalogServStructure_DTO lmsServiceCatalogServStructure_DTO2 = null;
		ServiceCatalogServStructure lmsServiceCatalogServStructure = null;

		if (!serviceCatalogServiceStructureRepo.existsById(lmsServiceCatalogServStructurePK)) 
		{
			lmsServiceCatalogServStructure = setServiceCatalogServStructure(lmsServiceCatalogServStructure_DTO);
			lmsServiceCatalogServStructure.setId(lmsServiceCatalogServStructurePK);
			lmsServiceCatalogServStructure_DTO2 = getServiceCatalogServStructure_DTO(serviceCatalogServiceStructureRepo.save(lmsServiceCatalogServStructure));
		}
		return lmsServiceCatalogServStructure_DTO2;
	}

	public ArrayList<ServiceCatalogServStructure_DTO> getAllServiceCatalogServStructures() 
	{
		ArrayList<ServiceCatalogServStructure> ServiceClassCategoryList = (ArrayList<ServiceCatalogServStructure>) serviceCatalogServiceStructureRepo
				.findAll();
		ArrayList<ServiceCatalogServStructure_DTO> lMasterss = new ArrayList<ServiceCatalogServStructure_DTO>();
		lMasterss = ServiceClassCategoryList != null ? this.getServiceCatalogServStructure_DTOs(ServiceClassCategoryList) : null;
		return lMasterss;
	}

	public ArrayList<ServiceCatalogServStructure_DTO> getSelectServiceCatalogServStructures(ArrayList<Long> ids, ArrayList<Long> cids) 
	{
		ArrayList<ServiceCatalogServStructure> lMasters = serviceCatalogServiceStructureRepo.getSelectServiceCatalogStructures(ids, cids);
		ArrayList<ServiceCatalogServStructure_DTO> serviceCatalogServiceStructure_DTOs = new ArrayList<ServiceCatalogServStructure_DTO>();
		serviceCatalogServiceStructure_DTOs = lMasters != null ? this.getServiceCatalogServStructure_DTOs(lMasters) : null;
		return serviceCatalogServiceStructure_DTOs;
	}

	public ArrayList<ServiceCatalogServStructure_DTO> getSelectServiceCatalogsStructuresForCatalogs(ArrayList<Long> ids)
	{
		ArrayList<ServiceCatalogServStructure> lMasters = serviceCatalogServiceStructureRepo.getSelectServiceCatalogsStructuresForCatalogs(ids);
		ArrayList<ServiceCatalogServStructure_DTO> serviceCatalogServiceStructure_DTOs = new ArrayList<ServiceCatalogServStructure_DTO>();
		serviceCatalogServiceStructure_DTOs = lMasters != null ? this.getServiceCatalogServStructure_DTOs(lMasters) : null;
		return serviceCatalogServiceStructure_DTOs;
	}
	
	public ArrayList<ServiceCatalogServStructure_DTO> getSelectServiceChildStructuresForCatalogs(ArrayList<Long> ids, ArrayList<Long> cids) 
	{
		ArrayList<ServiceCatalogServStructure> lMasters = serviceCatalogServiceStructureRepo.getSelectServiceChildStructuresForCatalogs(ids, cids);
		ArrayList<ServiceCatalogServStructure_DTO> serviceCatalogServiceStructure_DTOs = new ArrayList<ServiceCatalogServStructure_DTO>();
		serviceCatalogServiceStructure_DTOs = lMasters != null ? this.getServiceCatalogServStructure_DTOs(lMasters) : null;
		return serviceCatalogServiceStructure_DTOs;
	}

	
	public void updServiceCatalogServStructure(ServiceCatalogServStructure_DTO lmsServiceCatalogServStructure_DTO) {
		ServiceCatalogServStructurePK lmsServiceCatalogServStructurePK = new ServiceCatalogServStructurePK();
		lmsServiceCatalogServStructurePK.setParServiceClassSeqNo(lmsServiceCatalogServStructure_DTO.getParServiceClassSeqNo());
		lmsServiceCatalogServStructurePK.setServiceClassSeqNo(lmsServiceCatalogServStructure_DTO.getServiceClassSeqNo());
		ServiceCatalogServStructure lmsServiceCatalogServStructure = null;

		if (serviceCatalogServiceStructureRepo.existsById(lmsServiceCatalogServStructurePK)) {
			lmsServiceCatalogServStructure = this.setServiceCatalogServStructure(lmsServiceCatalogServStructure_DTO);
			serviceCatalogServiceStructureRepo.save(lmsServiceCatalogServStructure);
		}
		return;
	}

	public void delSelectServiceCatalogServStructures(ArrayList<Long> ids, ArrayList<Long> cids) 
	{
		serviceCatalogServiceStructureRepo.delSelectServiceCatalogStructures(ids, cids);
		return;
	}

	public void delSelectServiceCatalogsStructuresForCatalogs(ArrayList<Long> ids) 
	{
		serviceCatalogServiceStructureRepo.delSelectServiceCatalogsStructuresForCatalogs(ids);
		return;
	}
	
	public void delSelectServiceChildStructuresForCatalogs(ArrayList<Long> ids, ArrayList<Long> cids) 
	{
		serviceCatalogServiceStructureRepo.delSelectServiceChildStructuresForCatalogs(ids, cids);
		return;
	}

	
	public void delAllServiceCatalogServStructures() {
		serviceCatalogServiceStructureRepo.deleteAll();
	}

	private ArrayList<ServiceCatalogServStructure_DTO> getServiceCatalogServStructure_DTOs(
			ArrayList<ServiceCatalogServStructure> lMasters) {
		ServiceCatalogServStructure_DTO lDTO = null;
		ArrayList<ServiceCatalogServStructure_DTO> lMasterDTOs = new ArrayList<ServiceCatalogServStructure_DTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getServiceCatalogServStructure_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ServiceCatalogServStructure_DTO getServiceCatalogServStructure_DTO(ServiceCatalogServStructure lmsServiceCatalogServStructure) 
	{
		ServiceCatalogServStructure_DTO lDTO = new ServiceCatalogServStructure_DTO();
		lDTO.setServiceClassSeqNo(lmsServiceCatalogServStructure.getId().getServiceClassSeqNo());
		lDTO.setParServiceClassSeqNo(lmsServiceCatalogServStructure.getId().getParServiceClassSeqNo());
		lDTO.setServiceCatalogSeqNo(lmsServiceCatalogServStructure.getId().getServiceCatalogSeqNo());		
		return lDTO;
	}

	private ServiceCatalogServStructure setServiceCatalogServStructure(ServiceCatalogServStructure_DTO lDTO) 
	{
		ServiceCatalogServStructurePK lmsServiceCatalogServStructurePK = new ServiceCatalogServStructurePK();
		ServiceCatalogServStructure lmsServiceCatalogServStructure = new ServiceCatalogServStructure();
		lmsServiceCatalogServStructurePK.setServiceClassSeqNo(lDTO.getServiceClassSeqNo());
		lmsServiceCatalogServStructurePK.setParServiceClassSeqNo(lDTO.getParServiceClassSeqNo());
		lmsServiceCatalogServStructurePK.setServiceCatalogSeqNo(lDTO.getServiceCatalogSeqNo());
		lmsServiceCatalogServStructure.setId(lmsServiceCatalogServStructurePK);
		return lmsServiceCatalogServStructure;
	}
}