package service_catalog_master_mgmt.services;

import org.slf4j.Logger;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service_catalog_master_mgmt.model.dto.ServiceCatalogMaster_DTO;
import service_catalog_master_mgmt.model.master.ServiceCatalogMaster;
import service_catalog_master_mgmt.model.repo.ServiceCatalogMaster_Repo;

@Service("serviceCatalogMasterServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ServiceCatalogMaster_Service implements I_ServiceCatalogMaster_Service 
{
//	private static final Logger logger = LoggerFactory.getLogger(ServiceCatalogMasterService.class);
	
	@Autowired
	private ServiceCatalogMaster_Repo serviceCatalogMasterRepo;

	public ServiceCatalogMaster_DTO newServiceCatalog(ServiceCatalogMaster_DTO lMaster) 
	{
		if (!serviceCatalogMasterRepo.existsById(lMaster.getServiceCatalogSeqNo())) {
			ServiceCatalogMaster serviceCatalogMaster = serviceCatalogMasterRepo
					.save(this.setServiceCatalogMaster(lMaster));
			lMaster = getServiceCatalogMaster_DTO(serviceCatalogMaster);
		}
		return lMaster;
	}
	
	public ArrayList<ServiceCatalogMaster_DTO> getAllServiceCatalogs() 
	{
		ArrayList<ServiceCatalogMaster> serviceCatalogList = (ArrayList<ServiceCatalogMaster>) serviceCatalogMasterRepo
				.findAll();
		ArrayList<ServiceCatalogMaster_DTO> lMasters = new ArrayList<ServiceCatalogMaster_DTO>();
		lMasters = serviceCatalogList != null ? this.getServiceCatalogMaster_DTOs(serviceCatalogList) : null;
		return lMasters;
	}

	public ArrayList<ServiceCatalogMaster_DTO> getSelectServiceCatalogsBetweenTimes(String fr, String to) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateTimeFr = LocalDateTime.parse(fr, formatter);
		LocalDateTime dateTimeTo = LocalDateTime.parse(to, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateTimeFr);
		Timestamp ts_To = Timestamp.valueOf(dateTimeTo);
		ArrayList<ServiceCatalogMaster> lMasters = serviceCatalogMasterRepo
				.getSelectServiceCatalogsBetweenTimes(ts_Fr, ts_To);
		ArrayList<ServiceCatalogMaster_DTO> serviceCatalogMasterDTOs = new ArrayList<ServiceCatalogMaster_DTO>();
		serviceCatalogMasterDTOs = lMasters != null ? this.getServiceCatalogMaster_DTOs(lMasters) : null;
		return serviceCatalogMasterDTOs;
	}

	public ArrayList<ServiceCatalogMaster_DTO> getSelectServiceCatalogs(ArrayList<Long> ids) {
		ArrayList<ServiceCatalogMaster> lMasters = serviceCatalogMasterRepo.getSelectServiceCatalogs(ids);
		ArrayList<ServiceCatalogMaster_DTO> serviceCatalogMasterDTOs = new ArrayList<ServiceCatalogMaster_DTO>();
		serviceCatalogMasterDTOs = lMasters != null ? this.getServiceCatalogMaster_DTOs(lMasters) : null;
		return serviceCatalogMasterDTOs;
	}

	public ArrayList<ServiceCatalogMaster_DTO> getSelectServiceCatalogsForCompanies(ArrayList<Long> ids) {
		ArrayList<ServiceCatalogMaster> lMasters = serviceCatalogMasterRepo
				.getSelectServiceCatalogsForCompanies(ids);
		ArrayList<ServiceCatalogMaster_DTO> serviceCatalogMasterDTOs = new ArrayList<ServiceCatalogMaster_DTO>();
		serviceCatalogMasterDTOs = lMasters != null ? this.getServiceCatalogMaster_DTOs(lMasters) : null;
		return serviceCatalogMasterDTOs;
	}

	public void updServiceCatalog(ServiceCatalogMaster_DTO lMaster) {
		ServiceCatalogMaster serviceCatalogMaster = this.setServiceCatalogMaster(lMaster);
		if (serviceCatalogMasterRepo.existsById(lMaster.getServiceCatalogSeqNo())) {
			serviceCatalogMaster.setServiceCatalogSeqNo(lMaster.getServiceCatalogSeqNo());
			serviceCatalogMasterRepo.save(serviceCatalogMaster);
		}
		return;
	}

	public void delSelectServiceCatalogsBetweenTimes(String fr, String to) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateTimeFr = LocalDateTime.parse(fr, formatter);
		LocalDateTime dateTimeTo = LocalDateTime.parse(to, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateTimeFr);
		Timestamp ts_To = Timestamp.valueOf(dateTimeTo);
		serviceCatalogMasterRepo.delSelectServiceCatalogsBetweenTimes(ts_Fr, ts_To);
		return;
	}

	public void delSelectServiceCatalogs(ArrayList<Long> ids) {
		serviceCatalogMasterRepo.delSelectServiceCatalogs(ids);
		return;
	}

	public void delSelectServiceCatalogsForCompanies(ArrayList<Long> ids) {
		serviceCatalogMasterRepo.delSelectServiceCatalogsForCompanies(ids);
		return;
	}

	public void delAllServiceCatalogs() {
		serviceCatalogMasterRepo.deleteAll();
	}

	private ArrayList<ServiceCatalogMaster_DTO> getServiceCatalogMaster_DTOs(ArrayList<ServiceCatalogMaster> lMaster) {
		ServiceCatalogMaster_DTO lDTO = null;
		ArrayList<ServiceCatalogMaster_DTO> lMasterDTOs = new ArrayList<ServiceCatalogMaster_DTO>();
		for (int i = 0; i < lMaster.size(); i++) {
			lDTO = getServiceCatalogMaster_DTO(lMaster.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

		private ServiceCatalogMaster_DTO getServiceCatalogMaster_DTO(ServiceCatalogMaster lMaster) {
		ServiceCatalogMaster_DTO lDTO = new ServiceCatalogMaster_DTO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		lDTO.setFromDttm(formatter.format(lMaster.getFromDttm().toLocalDateTime()));
		lDTO.setToDttm(formatter.format(lMaster.getToDttm().toLocalDateTime()));
		lDTO.setCatalog(lMaster.getCatalog());
		lDTO.setRemark(lMaster.getRemark());
		lDTO.setServiceCatalogSeqNo(lMaster.getServiceCatalogSeqNo());
		lDTO.setStatus(lMaster.getStatus());
		return lDTO;
	}

	private ServiceCatalogMaster setServiceCatalogMaster(ServiceCatalogMaster_DTO lDTO) {
		ServiceCatalogMaster lMaster = new ServiceCatalogMaster();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateTimeFr = LocalDateTime.parse(lDTO.getFromDttm(), formatter);
		LocalDateTime dateTimeTo = LocalDateTime.parse(lDTO.getToDttm(), formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateTimeFr);
		Timestamp ts_To = Timestamp.valueOf(dateTimeTo);
		lMaster.setFromDttm(ts_Fr);
		lMaster.setToDttm(ts_To);
		lMaster.setCatalog(lDTO.getCatalog());
		lMaster.setRemark(lDTO.getRemark());
		lMaster.setStatus(lDTO.getStatus());
		return lMaster;
	}
}