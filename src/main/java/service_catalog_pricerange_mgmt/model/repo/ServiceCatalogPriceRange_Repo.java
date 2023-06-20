package service_catalog_pricerange_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import service_catalog_pricerange_mgmt.model.master.ServiceCatalogPriceRange;
import service_catalog_pricerange_mgmt.model.master.ServiceCatalogPriceRangePK;

@Repository("serviceCatalogPriceRangeRepo")
public interface ServiceCatalogPriceRange_Repo extends JpaRepository<ServiceCatalogPriceRange, ServiceCatalogPriceRangePK> 
{

	@Query(value = "SELECT * FROM SERVICE_CATALOG_TIMERANGE a WHERE (a.service_catalog_SEQ_NO in :ids and ((:frPrice >= b.price_fr and :frPrice <= b.price_to) and (:toPrice >= b.price_fr and :toPrice <= b.price_to)) order by service_catalog_SEQ_NO", nativeQuery = true)
	ArrayList<ServiceCatalogPriceRange> getSelectServiceCatalogsBetweenPrices(@Param("ids") ArrayList<Long> ids,
	@Param("frPrice") Float frPrice, @Param("toPrice") Float toPrice);

	@Query(value = "SELECT * FROM SERVICE_CATALOG_TIMERANGE a WHERE (a.service_class_seq_no in :ids) order by service_catalog_seq_no", nativeQuery = true)
	ArrayList<ServiceCatalogPriceRange> getSelectServiceCatalogsPriceRanges(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM SERVICE_CATALOG_TIMERANGE a WHERE ((:frPrice >= b.price_fr and :frPrice <= b.price_to) and (:toPrice >= b.price_fr and :toPrice <= b.price_to)) order by service_catalog_SEQ_NO", nativeQuery = true)
	ArrayList<ServiceCatalogPriceRange> getSelectServiceCatalogsForPriceRange(@Param("frPrice") Float frPrice, @Param("toPrice") Float toPrice);

	@Query(value = "DELETE FROM SERVICE_CATALOG_TIMERANGE a WHERE (a.service_catalog_SEQ_NO in :ids and ((:frPrice >= b.price_fr and :frPrice <= b.price_to) and (:toPrice >= b.price_fr and :toPrice <= b.price_to)))", nativeQuery = true)
	void delSelectServiceCatalogsBetweenPrices(@Param("ids") ArrayList<Long> ids, @Param("frPrice") Float frPrice, @Param("toPrice") Float toPrice);

	@Query(value = "DELETE FROM SERVICE_CATALOG_TIMERANGE a WHERE (a.service_class_seq_no in :ids)", nativeQuery = true)
	void deltSelectServiceCatalogsPriceRanges(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM SERVICE_CATALOG_TIMERANGE a WHERE ((:frPrice >= b.price_fr and :frPrice <= b.price_to) and (:toPrice >= b.price_fr and :toPrice <= b.price_to))", nativeQuery = true)
	void delSelectServiceCatalogsForPriceRange(@Param("frPrice") Float frPrice, @Param("toPrice") Float toPrice);
}
