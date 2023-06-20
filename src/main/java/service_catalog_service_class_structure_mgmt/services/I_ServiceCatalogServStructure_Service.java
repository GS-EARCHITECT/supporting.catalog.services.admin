package service_catalog_service_class_structure_mgmt.services;

import java.util.ArrayList;
import service_catalog_service_class_structure_mgmt.model.dto.ServiceCatalogServStructure_DTO;

public interface I_ServiceCatalogServStructure_Service
{
    public ServiceCatalogServStructure_DTO newServiceCatalogServStructure(ServiceCatalogServStructure_DTO resourceClassStructureDTO);
    public ArrayList<ServiceCatalogServStructure_DTO> getAllServiceCatalogServStructures();
    public ArrayList<ServiceCatalogServStructure_DTO> getSelectServiceCatalogServStructures(ArrayList<Long> ids, ArrayList<Long> cids);
    public ArrayList<ServiceCatalogServStructure_DTO> getSelectServiceCatalogsStructuresForCatalogs(ArrayList<Long> ids);
    public ArrayList<ServiceCatalogServStructure_DTO> getSelectServiceChildStructuresForCatalogs(ArrayList<Long> ids, ArrayList<Long> cids);    
    public void updServiceCatalogServStructure(ServiceCatalogServStructure_DTO ServiceCatalogServStructure_DTO);
    public void delAllServiceCatalogServStructures();    
    public void delSelectServiceCatalogServStructures(ArrayList<Long> ids, ArrayList<Long> cids);
    public void delSelectServiceCatalogsStructuresForCatalogs(ArrayList<Long> ids);
    public void delSelectServiceChildStructuresForCatalogs(ArrayList<Long> ids, ArrayList<Long> cids);
}