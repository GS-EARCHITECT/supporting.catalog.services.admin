package service_catalog_rating_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import service_catalog_rating_mgmt.model.master.ServiceCatalogRating;
import service_catalog_rating_mgmt.model.master.ServiceCatalogRatingPK;

@Repository("serviceCatalogRatingRepo")
public interface ServiceCatalogRating_Repo extends JpaRepository<ServiceCatalogRating, ServiceCatalogRatingPK> 
{
	@Query(value = "SELECT * FROM SERVICE_CATALOG_RATINGS a WHERE (a.rating in :fids) order by service_catalog_seq_no", nativeQuery = true)
	ArrayList<ServiceCatalogRating> getSelectServiceCatalogRatings(@Param("fids") ArrayList<Float> fids);

	@Query(value = "SELECT * FROM SERVICE_CATALOG_RATINGS a WHERE a.service_catalog_seq_no in :ids order by service_catalog_seq_no", nativeQuery = true)
	ArrayList<ServiceCatalogRating> getSelectServiceCatalogsRatingsForCatalogs(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM SERVICE_CATALOG_RATINGS a WHERE (a.rating in :fids)", nativeQuery = true)
	void delSelectServiceCatalogRatings(@Param("fids") ArrayList<Float> fids);

	@Query(value = "DELETE FROM SERVICE_CATALOG_RATINGS a WHERE a.service_catalog_seq_no in :ids", nativeQuery = true)
	void delSelectServiceCatalogsRatingsForCatalogs(@Param("ids") ArrayList<Long> ids);
	
}
