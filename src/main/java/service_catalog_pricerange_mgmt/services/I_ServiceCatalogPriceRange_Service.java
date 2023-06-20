package service_catalog_pricerange_mgmt.services;

import java.util.ArrayList;
import service_catalog_pricerange_mgmt.model.dto.ServiceCatalogPriceRange_DTO;

public interface I_ServiceCatalogPriceRange_Service
{
    public ServiceCatalogPriceRange_DTO newServiceCatalogPriceRange(ServiceCatalogPriceRange_DTO resourceClassStructureDTO);
    public ArrayList<ServiceCatalogPriceRange_DTO> getAllServiceCatalogPriceRanges();
    public ArrayList<ServiceCatalogPriceRange_DTO> getSelectServiceCatalogsBetweenPrices(ArrayList<Long> ids, Float frPrice, Float toPrice);
    public ArrayList<ServiceCatalogPriceRange_DTO> getSelectServiceCatalogsPriceRanges(ArrayList<Long> ids);
    public ArrayList<ServiceCatalogPriceRange_DTO> getSelectServiceCatalogsForPriceRange(Float frPrice, Float toPrice);
    public void updServiceCatalogPriceRange(ServiceCatalogPriceRange_DTO ServiceCatalogPriceRange_DTO);
    public void delAllServiceCatalogPriceRanges();    
    public void delSelectServiceCatalogsBetweenPrices(ArrayList<Long> ids, Float frPrice, Float toPrice);
    public void deltSelectServiceCatalogsPriceRanges(ArrayList<Long> ids);
    public void delSelectServiceCatalogsForPriceRange(Float frPrice, Float toPrice);
}



