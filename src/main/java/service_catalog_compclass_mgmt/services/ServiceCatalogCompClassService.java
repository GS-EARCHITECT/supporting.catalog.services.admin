package service_catalog_compclass_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service_catalog_compclass_mgmt.model.dto.ServiceCatalogCompClass_DTO;
import service_catalog_compclass_mgmt.model.master.ServiceCatalogCompClass;
import service_catalog_compclass_mgmt.model.master.ServiceCatalogCompClassPK;
import service_catalog_compclass_mgmt.model.repo.ServiceCatalogCompClass_Repo;

@Service("serviceCatalogCompClassServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ServiceCatalogCompClassService implements I_ServiceCatalogCompClass_Service 
{

	@Autowired
	private ServiceCatalogCompClass_Repo serviceCatalogCompClassRepo;

	public ServiceCatalogCompClass_DTO newServiceCatalogCompClass(ServiceCatalogCompClass_DTO serviceCatalogCompClass_DTO) {
		ServiceCatalogCompClassPK serviceCatalogCompClassPK = new ServiceCatalogCompClassPK();
		serviceCatalogCompClassPK.setCompanyClassSeqNo(serviceCatalogCompClass_DTO.getCompanyClassSeqNo());
		serviceCatalogCompClassPK.setServiceCatalogSeqNo(serviceCatalogCompClass_DTO.getServiceCatalogSeqNo());
		ServiceCatalogCompClass_DTO serviceCatalogCompClass_DTO2 = null;
		ServiceCatalogCompClass serviceCatalogCompClass = null;

		if (!serviceCatalogCompClassRepo.existsById(serviceCatalogCompClassPK)) {
			serviceCatalogCompClass = setServiceCatalogCompClass(serviceCatalogCompClass_DTO);
			serviceCatalogCompClass.setId(serviceCatalogCompClassPK);
			serviceCatalogCompClass_DTO2 = getServiceCatalogCompClass_DTO(
					serviceCatalogCompClassRepo.save(serviceCatalogCompClass));
		}
		return serviceCatalogCompClass_DTO2;
	}

	public ArrayList<ServiceCatalogCompClass_DTO> getAllServiceCatalogCompanies() 
	{
		ArrayList<ServiceCatalogCompClass> ServiceClassCategoryList = (ArrayList<ServiceCatalogCompClass>) serviceCatalogCompClassRepo
				.findAll();
		ArrayList<ServiceCatalogCompClass_DTO> lMasterss = new ArrayList<ServiceCatalogCompClass_DTO>();
		lMasterss = ServiceClassCategoryList != null ? this.getServiceCatalogCompClass_DTOs(ServiceClassCategoryList)
				: null;
		return lMasterss;
	}

	public ArrayList<ServiceCatalogCompClass_DTO> getSelectServiceCatalogCompanies(ArrayList<Long> rids) 
	{
		ArrayList<ServiceCatalogCompClass> lMasters = serviceCatalogCompClassRepo.getSelectServiceCatalogCompanyClasses(rids);
		ArrayList<ServiceCatalogCompClass_DTO> serviceCatalogCompClass_DTOs = new ArrayList<ServiceCatalogCompClass_DTO>();
		serviceCatalogCompClass_DTOs = lMasters != null ? this.getServiceCatalogCompClass_DTOs(lMasters) : null;
		return serviceCatalogCompClass_DTOs;
	}

	public ArrayList<ServiceCatalogCompClass_DTO> getSelectServiceCatalogsCompaniesForCatalogs(ArrayList<Long> ids) {
		ArrayList<ServiceCatalogCompClass> lMasters = serviceCatalogCompClassRepo.getSelectServiceCatalogsCompanyClassesForCatalogs(ids);
		ArrayList<ServiceCatalogCompClass_DTO> serviceCatalogCompClass_DTOs = new ArrayList<ServiceCatalogCompClass_DTO>();
		serviceCatalogCompClass_DTOs = lMasters != null ? this.getServiceCatalogCompClass_DTOs(lMasters) : null;
		return serviceCatalogCompClass_DTOs;
	}
	
	public void updServiceCatalogCompClass(ServiceCatalogCompClass_DTO serviceCatalogCompClass_DTO) 
	{
		ServiceCatalogCompClassPK serviceCatalogCompClassPK = new ServiceCatalogCompClassPK();
		serviceCatalogCompClassPK.setCompanyClassSeqNo(serviceCatalogCompClass_DTO.getCompanyClassSeqNo());
		serviceCatalogCompClassPK.setServiceCatalogSeqNo(serviceCatalogCompClass_DTO.getServiceCatalogSeqNo());
		ServiceCatalogCompClass serviceCatalogCompClass = null;

		if (serviceCatalogCompClassRepo.existsById(serviceCatalogCompClassPK)) {
			serviceCatalogCompClass = this.setServiceCatalogCompClass(serviceCatalogCompClass_DTO);
			serviceCatalogCompClassRepo.save(serviceCatalogCompClass);
		}
		return;
	}

	public void delSelectServiceCatalogCompanies(ArrayList<Long> rids)
	{
		serviceCatalogCompClassRepo.delSelectServiceCatalogCompanyClasses(rids);
		return;
	}

	public void delSelectServiceCatalogsCompaniesForCatalogs(ArrayList<Long> ids)
	{
		serviceCatalogCompClassRepo.delSelectServiceCatalogsCompanyClassesForCatalogs(ids);
		return;
	}

	
	public void delAllServiceCatalogCompanies() {
		serviceCatalogCompClassRepo.deleteAll();
	}

	private ArrayList<ServiceCatalogCompClass_DTO> getServiceCatalogCompClass_DTOs(
			ArrayList<ServiceCatalogCompClass> lMasters) {
		ServiceCatalogCompClass_DTO lDTO = null;
		ArrayList<ServiceCatalogCompClass_DTO> lMasterDTOs = new ArrayList<ServiceCatalogCompClass_DTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getServiceCatalogCompClass_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ServiceCatalogCompClass_DTO getServiceCatalogCompClass_DTO(ServiceCatalogCompClass serviceCatalogCompClass) {
		ServiceCatalogCompClass_DTO lDTO = new ServiceCatalogCompClass_DTO();
		lDTO.setCompanyClassSeqNo(serviceCatalogCompClass.getId().getCompanyClassSeqNo());		
		lDTO.setServiceCatalogSeqNo(serviceCatalogCompClass.getId().getServiceCatalogSeqNo());
		return lDTO;
	}

	private ServiceCatalogCompClass setServiceCatalogCompClass(ServiceCatalogCompClass_DTO lDTO) 
	{
		ServiceCatalogCompClassPK serviceCatalogCompClassPK = new ServiceCatalogCompClassPK();
		ServiceCatalogCompClass serviceCatalogCompClass = new ServiceCatalogCompClass();
		serviceCatalogCompClassPK.setCompanyClassSeqNo(lDTO.getCompanyClassSeqNo());		
		serviceCatalogCompClassPK.setServiceCatalogSeqNo(lDTO.getServiceCatalogSeqNo());
		serviceCatalogCompClass.setId(serviceCatalogCompClassPK);
		return serviceCatalogCompClass;
	}
}