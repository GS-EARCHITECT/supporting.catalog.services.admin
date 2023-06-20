package service_catalog_rating_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service_catalog_rating_mgmt.model.dto.ServiceCatalogRating_DTO;
import service_catalog_rating_mgmt.model.master.ServiceCatalogRating;
import service_catalog_rating_mgmt.model.master.ServiceCatalogRatingPK;
import service_catalog_rating_mgmt.model.repo.ServiceCatalogRating_Repo;

@Service("serviceCatalogRatingServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ServiceCatalogRatingService implements I_ServiceCatalogRating_Service 
{

	@Autowired
	private ServiceCatalogRating_Repo serviceCatalogRatingRepo;

	public ServiceCatalogRating_DTO newServiceCatalogRating(ServiceCatalogRating_DTO lmsServiceCatalogRating_DTO) {
		ServiceCatalogRatingPK lmsServiceCatalogRatingPK = new ServiceCatalogRatingPK();
		lmsServiceCatalogRatingPK.setRating(lmsServiceCatalogRating_DTO.getRating());
		lmsServiceCatalogRatingPK.setServiceCatalogSeqNo(lmsServiceCatalogRating_DTO.getServiceCatalogSeqNo());
		ServiceCatalogRating_DTO lmsServiceCatalogRating_DTO2 = null;
		ServiceCatalogRating lmsServiceCatalogRating = null;

		if (!serviceCatalogRatingRepo.existsById(lmsServiceCatalogRatingPK)) {
			lmsServiceCatalogRating = setServiceCatalogRating(lmsServiceCatalogRating_DTO);
			lmsServiceCatalogRating.setId(lmsServiceCatalogRatingPK);
			lmsServiceCatalogRating_DTO2 = getServiceCatalogRating_DTO(
					serviceCatalogRatingRepo.save(lmsServiceCatalogRating));
		}
		return lmsServiceCatalogRating_DTO2;
	}

	public ArrayList<ServiceCatalogRating_DTO> getAllServiceCatalogRatings() {
		ArrayList<ServiceCatalogRating> ServiceClassCategoryList = (ArrayList<ServiceCatalogRating>) serviceCatalogRatingRepo
				.findAll();
		ArrayList<ServiceCatalogRating_DTO> lMasterss = new ArrayList<ServiceCatalogRating_DTO>();
		lMasterss = ServiceClassCategoryList != null ? this.getServiceCatalogRating_DTOs(ServiceClassCategoryList)
				: null;
		return lMasterss;
	}

	public ArrayList<ServiceCatalogRating_DTO> getSelectServiceCatalogRatings(ArrayList<Float> rids) {
		ArrayList<ServiceCatalogRating> lMasters = serviceCatalogRatingRepo.getSelectServiceCatalogRatings(rids);
		ArrayList<ServiceCatalogRating_DTO> serviceCatalogRating_DTOs = new ArrayList<ServiceCatalogRating_DTO>();
		serviceCatalogRating_DTOs = lMasters != null ? this.getServiceCatalogRating_DTOs(lMasters) : null;
		return serviceCatalogRating_DTOs;
	}

	public ArrayList<ServiceCatalogRating_DTO> getSelectServiceCatalogsRatingsForCatalogs(ArrayList<Long> ids) {
		ArrayList<ServiceCatalogRating> lMasters = serviceCatalogRatingRepo
				.getSelectServiceCatalogsRatingsForCatalogs(ids);
		ArrayList<ServiceCatalogRating_DTO> serviceCatalogRating_DTOs = new ArrayList<ServiceCatalogRating_DTO>();
		serviceCatalogRating_DTOs = lMasters != null ? this.getServiceCatalogRating_DTOs(lMasters) : null;
		return serviceCatalogRating_DTOs;
	}

	public void updServiceCatalogRating(ServiceCatalogRating_DTO lmsServiceCatalogRating_DTO) {
		ServiceCatalogRatingPK lmsServiceCatalogRatingPK = new ServiceCatalogRatingPK();
		lmsServiceCatalogRatingPK.setRating(lmsServiceCatalogRating_DTO.getRating());
		lmsServiceCatalogRatingPK.setServiceCatalogSeqNo(lmsServiceCatalogRating_DTO.getServiceCatalogSeqNo());
		ServiceCatalogRating lmsServiceCatalogRating = null;

		if (serviceCatalogRatingRepo.existsById(lmsServiceCatalogRatingPK)) {
			lmsServiceCatalogRating = this.setServiceCatalogRating(lmsServiceCatalogRating_DTO);
			serviceCatalogRatingRepo.save(lmsServiceCatalogRating);
		}
		return;
	}

	public void delSelectServiceCatalogRatings(ArrayList<Float> rids)
	{
		serviceCatalogRatingRepo.delSelectServiceCatalogRatings(rids);
		return;
	}

	public void delSelectServiceCatalogsRatingsForCatalogs(ArrayList<Long> ids)
	{
		serviceCatalogRatingRepo.delSelectServiceCatalogsRatingsForCatalogs(ids);
		return;
	}

	
	public void delAllServiceCatalogRatings() {
		serviceCatalogRatingRepo.deleteAll();
	}

	private ArrayList<ServiceCatalogRating_DTO> getServiceCatalogRating_DTOs(
			ArrayList<ServiceCatalogRating> lMasters) {
		ServiceCatalogRating_DTO lDTO = null;
		ArrayList<ServiceCatalogRating_DTO> lMasterDTOs = new ArrayList<ServiceCatalogRating_DTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getServiceCatalogRating_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ServiceCatalogRating_DTO getServiceCatalogRating_DTO(ServiceCatalogRating lmsServiceCatalogRating) {
		ServiceCatalogRating_DTO lDTO = new ServiceCatalogRating_DTO();
		lDTO.setRating(lmsServiceCatalogRating.getId().getRating());		
		lDTO.setServiceCatalogSeqNo(lmsServiceCatalogRating.getId().getServiceCatalogSeqNo());
		return lDTO;
	}

	private ServiceCatalogRating setServiceCatalogRating(ServiceCatalogRating_DTO lDTO) 
	{
		ServiceCatalogRatingPK serviceCatalogRatingPK = new ServiceCatalogRatingPK();
		ServiceCatalogRating serviceCatalogRating = new ServiceCatalogRating();
		serviceCatalogRatingPK.setRating(lDTO.getRating());		
		serviceCatalogRatingPK.setServiceCatalogSeqNo(lDTO.getServiceCatalogSeqNo());
		serviceCatalogRating.setId(serviceCatalogRatingPK);
		return serviceCatalogRating;
	}
}