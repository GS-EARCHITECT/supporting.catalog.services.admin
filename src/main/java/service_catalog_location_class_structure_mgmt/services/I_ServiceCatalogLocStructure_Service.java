package service_catalog_location_class_structure_mgmt.services;

import java.util.ArrayList;
import service_catalog_location_class_structure_mgmt.model.dto.ServiceCatalogLocStructure_DTO;

public interface I_ServiceCatalogLocStructure_Service
{
    public ServiceCatalogLocStructure_DTO newServiceCatalogLocStructure(ServiceCatalogLocStructure_DTO resourceClassStructureDTO);
    public ArrayList<ServiceCatalogLocStructure_DTO> getAllServiceCatalogLocStructures();
    public ArrayList<ServiceCatalogLocStructure_DTO> getSelectServiceCatalogLocStructures(ArrayList<Long> ids, ArrayList<Long> cids);
    public ArrayList<ServiceCatalogLocStructure_DTO> getSelectServiceCatalogsStructuresForCatalogs(ArrayList<Long> ids);
    public ArrayList<ServiceCatalogLocStructure_DTO> getSelectServiceChildStructuresForCatalogs(ArrayList<Long> ids, ArrayList<Long> cids);    
    public void updServiceCatalogLocStructure(ServiceCatalogLocStructure_DTO ServiceCatalogLocStructure_DTO);
    public void delAllServiceCatalogLocStructures();    
    public void delSelectServiceCatalogLocStructures(ArrayList<Long> ids, ArrayList<Long> cids);
    public void delSelectServiceCatalogsStructuresForCatalogs(ArrayList<Long> ids);
    public void delSelectServiceChildStructuresForCatalogs(ArrayList<Long> ids, ArrayList<Long> cids);
}



