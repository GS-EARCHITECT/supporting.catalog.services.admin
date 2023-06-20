package service_catalog_rating_mgmt.services;

import java.util.ArrayList;

import service_catalog_rating_mgmt.model.dto.ServiceCatalogRating_DTO;

public interface I_ServiceCatalogRating_Service
{
    public ServiceCatalogRating_DTO newServiceCatalogRating(ServiceCatalogRating_DTO serviceClassStructureDTO);
    public ArrayList<ServiceCatalogRating_DTO> getAllServiceCatalogRatings();
    public ArrayList<ServiceCatalogRating_DTO> getSelectServiceCatalogRatings(ArrayList<Float> rids);
    public ArrayList<ServiceCatalogRating_DTO> getSelectServiceCatalogsRatingsForCatalogs(ArrayList<Long> ids);
    public void updServiceCatalogRating(ServiceCatalogRating_DTO ServiceCatalogRating_DTO);
    public void delAllServiceCatalogRatings();    
    public void delSelectServiceCatalogRatings(ArrayList<Float> fids);
    public void delSelectServiceCatalogsRatingsForCatalogs(ArrayList<Long> ids);        
}