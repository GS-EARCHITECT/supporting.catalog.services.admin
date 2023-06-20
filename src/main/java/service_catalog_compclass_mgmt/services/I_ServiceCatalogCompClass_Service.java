package service_catalog_compclass_mgmt.services;

import java.util.ArrayList;

import service_catalog_compclass_mgmt.model.dto.ServiceCatalogCompClass_DTO;

public interface I_ServiceCatalogCompClass_Service
{
    public ServiceCatalogCompClass_DTO newServiceCatalogCompClass(ServiceCatalogCompClass_DTO serviceClassStructureDTO);
    public ArrayList<ServiceCatalogCompClass_DTO> getAllServiceCatalogCompanies();
    public ArrayList<ServiceCatalogCompClass_DTO> getSelectServiceCatalogCompanies(ArrayList<Long> rids);
    public ArrayList<ServiceCatalogCompClass_DTO> getSelectServiceCatalogsCompaniesForCatalogs(ArrayList<Long> ids);
    public void updServiceCatalogCompClass(ServiceCatalogCompClass_DTO serviceCatalogCompClass_DTO);
    public void delAllServiceCatalogCompanies();    
    public void delSelectServiceCatalogCompanies(ArrayList<Long> fids);
    public void delSelectServiceCatalogsCompaniesForCatalogs(ArrayList<Long> ids);
}