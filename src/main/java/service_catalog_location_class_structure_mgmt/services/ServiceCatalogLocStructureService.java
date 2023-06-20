package service_catalog_location_class_structure_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service_catalog_location_class_structure_mgmt.model.dto.ServiceCatalogLocStructure_DTO;
import service_catalog_location_class_structure_mgmt.model.master.ServiceCatalogLocStructure;
import service_catalog_location_class_structure_mgmt.model.master.ServiceCatalogLocStructurePK;
import service_catalog_location_class_structure_mgmt.model.repo.ServiceCatalogLocStucture_Repo;

@Service("serviceCatalogLocStructureServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ServiceCatalogLocStructureService implements I_ServiceCatalogLocStructure_Service 
{

	@Autowired
	private ServiceCatalogLocStucture_Repo serviceCatalogLocStructureRepo;

	public ServiceCatalogLocStructure_DTO newServiceCatalogLocStructure(ServiceCatalogLocStructure_DTO lmsServiceCatalogLocStructure_DTO) {
		ServiceCatalogLocStructurePK lmsServiceCatalogLocStructurePK = new ServiceCatalogLocStructurePK();
		lmsServiceCatalogLocStructurePK.setParPlaceClassSeqNo(lmsServiceCatalogLocStructure_DTO.getParLocationClassSeqNo());
		lmsServiceCatalogLocStructurePK.setPlaceClassSeqNo(lmsServiceCatalogLocStructure_DTO.getLocationClassSeqNo());
		ServiceCatalogLocStructure_DTO lmsServiceCatalogLocStructure_DTO2 = null;
		ServiceCatalogLocStructure lmsServiceCatalogLocStructure = null;

		if (!serviceCatalogLocStructureRepo.existsById(lmsServiceCatalogLocStructurePK)) 
		{
			lmsServiceCatalogLocStructure = setServiceCatalogLocStructure(lmsServiceCatalogLocStructure_DTO);
			lmsServiceCatalogLocStructure.setId(lmsServiceCatalogLocStructurePK);
			lmsServiceCatalogLocStructure_DTO2 = getServiceCatalogLocStructure_DTO(serviceCatalogLocStructureRepo.save(lmsServiceCatalogLocStructure));
		}
		return lmsServiceCatalogLocStructure_DTO2;
	}

	public ArrayList<ServiceCatalogLocStructure_DTO> getAllServiceCatalogLocStructures() 
	{
		ArrayList<ServiceCatalogLocStructure> ServiceClassCategoryList = (ArrayList<ServiceCatalogLocStructure>) serviceCatalogLocStructureRepo
				.findAll();
		ArrayList<ServiceCatalogLocStructure_DTO> lMasterss = new ArrayList<ServiceCatalogLocStructure_DTO>();
		lMasterss = ServiceClassCategoryList != null ? this.getServiceCatalogLocStructure_DTOs(ServiceClassCategoryList) : null;
		return lMasterss;
	}

	public ArrayList<ServiceCatalogLocStructure_DTO> getSelectServiceCatalogLocStructures(ArrayList<Long> ids, ArrayList<Long> cids) 
	{
		ArrayList<ServiceCatalogLocStructure> lMasters = serviceCatalogLocStructureRepo.getSelectServiceCatalogStructures(ids, cids);
		ArrayList<ServiceCatalogLocStructure_DTO> serviceCatalogLocStructure_DTOs = new ArrayList<ServiceCatalogLocStructure_DTO>();
		serviceCatalogLocStructure_DTOs = lMasters != null ? this.getServiceCatalogLocStructure_DTOs(lMasters) : null;
		return serviceCatalogLocStructure_DTOs;
	}

	public ArrayList<ServiceCatalogLocStructure_DTO> getSelectServiceCatalogsStructuresForCatalogs(ArrayList<Long> ids)
	{
		ArrayList<ServiceCatalogLocStructure> lMasters = serviceCatalogLocStructureRepo.getSelectServiceCatalogsStructuresForCatalogs(ids);
		ArrayList<ServiceCatalogLocStructure_DTO> serviceCatalogLocStructure_DTOs = new ArrayList<ServiceCatalogLocStructure_DTO>();
		serviceCatalogLocStructure_DTOs = lMasters != null ? this.getServiceCatalogLocStructure_DTOs(lMasters) : null;
		return serviceCatalogLocStructure_DTOs;
	}
	
	public ArrayList<ServiceCatalogLocStructure_DTO> getSelectServiceChildStructuresForCatalogs(ArrayList<Long> ids, ArrayList<Long> cids) 
	{
		ArrayList<ServiceCatalogLocStructure> lMasters = serviceCatalogLocStructureRepo.getSelectServiceChildStructuresForCatalogs(ids, cids);
		ArrayList<ServiceCatalogLocStructure_DTO> serviceCatalogLocStructure_DTOs = new ArrayList<ServiceCatalogLocStructure_DTO>();
		serviceCatalogLocStructure_DTOs = lMasters != null ? this.getServiceCatalogLocStructure_DTOs(lMasters) : null;
		return serviceCatalogLocStructure_DTOs;
	}

	
	public void updServiceCatalogLocStructure(ServiceCatalogLocStructure_DTO lmsServiceCatalogLocStructure_DTO) {
		ServiceCatalogLocStructurePK lmsServiceCatalogLocStructurePK = new ServiceCatalogLocStructurePK();
		lmsServiceCatalogLocStructurePK.setParPlaceClassSeqNo(lmsServiceCatalogLocStructure_DTO.getParLocationClassSeqNo());
		lmsServiceCatalogLocStructurePK.setPlaceClassSeqNo(lmsServiceCatalogLocStructure_DTO.getLocationClassSeqNo());
		ServiceCatalogLocStructure_DTO lmsServiceCatalogLocStructure_DTO2 = null;
		ServiceCatalogLocStructure lmsServiceCatalogLocStructure = null;

		if (serviceCatalogLocStructureRepo.existsById(lmsServiceCatalogLocStructurePK)) {
			lmsServiceCatalogLocStructure = this.setServiceCatalogLocStructure(lmsServiceCatalogLocStructure_DTO);
			serviceCatalogLocStructureRepo.save(lmsServiceCatalogLocStructure);
		}
		return;
	}

	public void delSelectServiceCatalogLocStructures(ArrayList<Long> ids, ArrayList<Long> cids) 
	{
		serviceCatalogLocStructureRepo.delSelectServiceCatalogStructures(ids, cids);
		return;
	}

	public void delSelectServiceCatalogsStructuresForCatalogs(ArrayList<Long> ids) 
	{
		serviceCatalogLocStructureRepo.delSelectServiceCatalogsStructuresForCatalogs(ids);
		return;
	}
	
	public void delSelectServiceChildStructuresForCatalogs(ArrayList<Long> ids, ArrayList<Long> cids) 
	{
		serviceCatalogLocStructureRepo.delSelectServiceChildStructuresForCatalogs(ids, cids);
		return;
	}

	
	public void delAllServiceCatalogLocStructures() {
		serviceCatalogLocStructureRepo.deleteAll();
	}

	private ArrayList<ServiceCatalogLocStructure_DTO> getServiceCatalogLocStructure_DTOs(
			ArrayList<ServiceCatalogLocStructure> lMasters) {
		ServiceCatalogLocStructure_DTO lDTO = null;
		ArrayList<ServiceCatalogLocStructure_DTO> lMasterDTOs = new ArrayList<ServiceCatalogLocStructure_DTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getServiceCatalogLocStructure_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ServiceCatalogLocStructure_DTO getServiceCatalogLocStructure_DTO(ServiceCatalogLocStructure lmsServiceCatalogLocStructure) 
	{
		ServiceCatalogLocStructure_DTO lDTO = new ServiceCatalogLocStructure_DTO();
		lDTO.setLocationClassSeqNo(lmsServiceCatalogLocStructure.getId().getPlaceClassSeqNo());
		lDTO.setParLocationClassSeqNo(lmsServiceCatalogLocStructure.getId().getParPlaceClassSeqNo());
		lDTO.setServiceCatalogSeqNo(lmsServiceCatalogLocStructure.getId().getServiceCatalogSeqNo());		
		return lDTO;
	}

	private ServiceCatalogLocStructure setServiceCatalogLocStructure(ServiceCatalogLocStructure_DTO lDTO) 
	{
		ServiceCatalogLocStructurePK lmsServiceCatalogLocStructurePK = new ServiceCatalogLocStructurePK();
		ServiceCatalogLocStructure lmsServiceCatalogLocStructure = new ServiceCatalogLocStructure();
		lmsServiceCatalogLocStructurePK.setPlaceClassSeqNo(lDTO.getLocationClassSeqNo());
		lmsServiceCatalogLocStructurePK.setParPlaceClassSeqNo(lDTO.getParLocationClassSeqNo());
		lmsServiceCatalogLocStructurePK.setServiceCatalogSeqNo(lDTO.getServiceCatalogSeqNo());
		lmsServiceCatalogLocStructure.setId(lmsServiceCatalogLocStructurePK);
		return lmsServiceCatalogLocStructure;
	}
}