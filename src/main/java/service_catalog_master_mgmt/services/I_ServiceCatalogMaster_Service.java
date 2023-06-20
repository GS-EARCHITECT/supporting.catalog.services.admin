package service_catalog_master_mgmt.services;

import java.util.ArrayList;
import service_catalog_master_mgmt.model.dto.ServiceCatalogMaster_DTO;

public interface I_ServiceCatalogMaster_Service
{
	abstract public ServiceCatalogMaster_DTO newServiceCatalog(ServiceCatalogMaster_DTO catalogMasterDTO);
    abstract public ArrayList<ServiceCatalogMaster_DTO> getAllServiceCatalogs();
    abstract public ArrayList<ServiceCatalogMaster_DTO> getSelectServiceCatalogsBetweenTimes(String fr, String to);
    abstract public ArrayList<ServiceCatalogMaster_DTO> getSelectServiceCatalogs(ArrayList<Long> ids);
    abstract public ArrayList<ServiceCatalogMaster_DTO> getSelectServiceCatalogsForCompanies(ArrayList<Long> ids);
    abstract public void updServiceCatalog(ServiceCatalogMaster_DTO ServiceCatalogMaster_DTO);
    abstract public void delAllServiceCatalogs();    
    abstract public void delSelectServiceCatalogs(ArrayList<Long> ids);
    abstract public void delSelectServiceCatalogsBetweenTimes(String fr, String to);    
    abstract public void delSelectServiceCatalogsForCompanies(ArrayList<Long> ids);
}