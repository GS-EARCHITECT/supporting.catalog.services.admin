package service_catalog_pricerange_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service_catalog_pricerange_mgmt.model.dto.ServiceCatalogPriceRange_DTO;
import service_catalog_pricerange_mgmt.model.master.ServiceCatalogPriceRange;
import service_catalog_pricerange_mgmt.model.master.ServiceCatalogPriceRangePK;
import service_catalog_pricerange_mgmt.model.repo.ServiceCatalogPriceRange_Repo;

@Service("resourceCatalogPriceRangeServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ServiceCatalogPriceRangeService implements I_ServiceCatalogPriceRange_Service 
{

	@Autowired
	private ServiceCatalogPriceRange_Repo resourceCatalogPriceRangeRepo;

	public ServiceCatalogPriceRange_DTO newServiceCatalogPriceRange(ServiceCatalogPriceRange_DTO resourceCatalogPriceRange_DTO) 
	{
		ServiceCatalogPriceRangePK resourceCatalogPriceRangePK = new ServiceCatalogPriceRangePK();
		resourceCatalogPriceRangePK.setPriceFr(resourceCatalogPriceRange_DTO.getPriceFr());
		resourceCatalogPriceRangePK.setPriceTo(resourceCatalogPriceRange_DTO.getPriceTo());
		resourceCatalogPriceRangePK.setServiceCatalogSeqNo(resourceCatalogPriceRange_DTO.getServiceCatalogSeqNo());		
		ServiceCatalogPriceRange_DTO resourceCatalogPriceRange_DTO2 = null;
		ServiceCatalogPriceRange resourceCatalogPriceRange = null;

		if (!resourceCatalogPriceRangeRepo.existsById(resourceCatalogPriceRangePK)
				) 
		{
			resourceCatalogPriceRange = setServiceCatalogPriceRange(resourceCatalogPriceRange_DTO);
			resourceCatalogPriceRange.setId(resourceCatalogPriceRangePK);
			resourceCatalogPriceRange_DTO2 = getServiceCatalogPriceRange_DTO(resourceCatalogPriceRangeRepo.save(resourceCatalogPriceRange));
		}
		return resourceCatalogPriceRange_DTO2;
	}

	public ArrayList<ServiceCatalogPriceRange_DTO> getSelectServiceCatalogsPriceRanges(ArrayList<Long> ids) 
	{
		ArrayList<ServiceCatalogPriceRange> ServiceClassCategoryList = (ArrayList<ServiceCatalogPriceRange>) resourceCatalogPriceRangeRepo.getSelectServiceCatalogsPriceRanges(ids);
				
		ArrayList<ServiceCatalogPriceRange_DTO> lMasterss = new ArrayList<ServiceCatalogPriceRange_DTO>();
		lMasterss = ServiceClassCategoryList != null ? this.getServiceCatalogPriceRange_DTOs(ServiceClassCategoryList) : null;
		return lMasterss;
	}

	
	public ArrayList<ServiceCatalogPriceRange_DTO> getAllServiceCatalogPriceRanges() 
	{
		ArrayList<ServiceCatalogPriceRange> ServiceClassCategoryList = (ArrayList<ServiceCatalogPriceRange>) resourceCatalogPriceRangeRepo
				.findAll();
		ArrayList<ServiceCatalogPriceRange_DTO> lMasterss = new ArrayList<ServiceCatalogPriceRange_DTO>();
		lMasterss = ServiceClassCategoryList != null ? this.getServiceCatalogPriceRange_DTOs(ServiceClassCategoryList) : null;
		return lMasterss;
	}

	public ArrayList<ServiceCatalogPriceRange_DTO> getSelectServiceCatalogsBetweenPrices(ArrayList<Long> ids, Float frPrice, Float toPrice) 
	{
		ArrayList<ServiceCatalogPriceRange> lMasters = resourceCatalogPriceRangeRepo.getSelectServiceCatalogsBetweenPrices(ids, frPrice, toPrice);
		ArrayList<ServiceCatalogPriceRange_DTO> resourceCatalogPriceRange_DTOs = new ArrayList<ServiceCatalogPriceRange_DTO>();
		resourceCatalogPriceRange_DTOs = lMasters != null ? this.getServiceCatalogPriceRange_DTOs(lMasters) : null;
		return resourceCatalogPriceRange_DTOs;
	}

	public ArrayList<ServiceCatalogPriceRange_DTO> getSelectServiceCatalogsForPriceRange(Float frPrice, Float toPrice)
	{
		ArrayList<ServiceCatalogPriceRange> lMasters = resourceCatalogPriceRangeRepo.getSelectServiceCatalogsForPriceRange(frPrice, toPrice);
		ArrayList<ServiceCatalogPriceRange_DTO> resourceCatalogPriceRange_DTOs = new ArrayList<ServiceCatalogPriceRange_DTO>();
		resourceCatalogPriceRange_DTOs = lMasters != null ? this.getServiceCatalogPriceRange_DTOs(lMasters) : null;
		return resourceCatalogPriceRange_DTOs;
	}
	
	
	public void updServiceCatalogPriceRange(ServiceCatalogPriceRange_DTO resourceCatalogPriceRange_DTO) 
	{
		ServiceCatalogPriceRangePK resourceCatalogPriceRangePK = new ServiceCatalogPriceRangePK();
		resourceCatalogPriceRangePK.setPriceFr(resourceCatalogPriceRange_DTO.getPriceFr());
		resourceCatalogPriceRangePK.setPriceTo(resourceCatalogPriceRange_DTO.getPriceTo());
		resourceCatalogPriceRangePK.setServiceCatalogSeqNo(resourceCatalogPriceRange_DTO.getServiceCatalogSeqNo());		
		ServiceCatalogPriceRange_DTO resourceCatalogPriceRange_DTO2 = null;
		ServiceCatalogPriceRange resourceCatalogPriceRange = null;
		if (resourceCatalogPriceRangeRepo.existsById(resourceCatalogPriceRangePK)) 
		{
			resourceCatalogPriceRange = this.setServiceCatalogPriceRange(resourceCatalogPriceRange_DTO);
			resourceCatalogPriceRangeRepo.save(resourceCatalogPriceRange);
		}
		return;
	}

	public void delSelectServiceCatalogsBetweenPrices(ArrayList<Long> ids, Float frPrice, Float toPrice) 
	{
		resourceCatalogPriceRangeRepo.delSelectServiceCatalogsBetweenPrices(ids, frPrice, toPrice);
		return;
	}

	public void delSelectServiceCatalogsForPriceRange( Float frPrice, Float toPrice) 
	{
		resourceCatalogPriceRangeRepo.delSelectServiceCatalogsForPriceRange(frPrice, toPrice);
		return;
	}
	
	
	public void delAllServiceCatalogPriceRanges() {
		resourceCatalogPriceRangeRepo.deleteAll();
	}

	public void deltSelectServiceCatalogsPriceRanges(ArrayList<Long> ids) 
	{
		resourceCatalogPriceRangeRepo.deltSelectServiceCatalogsPriceRanges(ids);
		return;
	}

	
	private ArrayList<ServiceCatalogPriceRange_DTO> getServiceCatalogPriceRange_DTOs(
			ArrayList<ServiceCatalogPriceRange> lMasters) {
		ServiceCatalogPriceRange_DTO lDTO = null;
		ArrayList<ServiceCatalogPriceRange_DTO> lMasterDTOs = new ArrayList<ServiceCatalogPriceRange_DTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getServiceCatalogPriceRange_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ServiceCatalogPriceRange_DTO getServiceCatalogPriceRange_DTO(ServiceCatalogPriceRange resourceCatalogPriceRange) 
	{
		ServiceCatalogPriceRange_DTO lDTO = new ServiceCatalogPriceRange_DTO();		
		lDTO.setPriceFr(resourceCatalogPriceRange.getId().getPriceFr());
		lDTO.setPriceTo(resourceCatalogPriceRange.getId().getPriceTo());
		lDTO.setServiceCatalogSeqNo(resourceCatalogPriceRange.getId().getServiceCatalogSeqNo());		
		return lDTO;
	}

	private ServiceCatalogPriceRange setServiceCatalogPriceRange(ServiceCatalogPriceRange_DTO lDTO) 
	{
		ServiceCatalogPriceRangePK resourceCatalogPriceRangePK = new ServiceCatalogPriceRangePK();
		ServiceCatalogPriceRange resourceCatalogPriceRange = new ServiceCatalogPriceRange();		
		resourceCatalogPriceRangePK.setPriceFr(lDTO.getPriceFr());
		resourceCatalogPriceRangePK.setPriceTo(lDTO.getPriceTo());
		resourceCatalogPriceRangePK.setServiceCatalogSeqNo(lDTO.getServiceCatalogSeqNo());
		return resourceCatalogPriceRange;
	}
}