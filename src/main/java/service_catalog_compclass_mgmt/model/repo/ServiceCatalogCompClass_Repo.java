package service_catalog_compclass_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import service_catalog_compclass_mgmt.model.master.ServiceCatalogCompClass;
import service_catalog_compclass_mgmt.model.master.ServiceCatalogCompClassPK;

@Repository("serviceCatalogCompClassRepo")
public interface ServiceCatalogCompClass_Repo extends JpaRepository<ServiceCatalogCompClass, ServiceCatalogCompClassPK> 
{
	@Query(value = "SELECT * FROM SERVICE_CATALOG_COMPANIES a WHERE (a.company_class_seq_no in :ids) order by service_catalog_seq_no", nativeQuery = true)
	ArrayList<ServiceCatalogCompClass> getSelectServiceCatalogCompanyClasses(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM SERVICE_CATALOG_COMPANIES a WHERE a.service_catalog_seq_no in :ids order by service_catalog_seq_no", nativeQuery = true)
	ArrayList<ServiceCatalogCompClass> getSelectServiceCatalogsCompanyClassesForCatalogs(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM SERVICE_CATALOG_COMPANIES a WHERE (a.company_class_seq_no in :cids)", nativeQuery = true)
	void delSelectServiceCatalogCompanyClasses(@Param("cids") ArrayList<Long> cids);

	@Query(value = "DELETE FROM SERVICE_CATALOG_COMPANIES a WHERE a.service_catalog_seq_no in :ids", nativeQuery = true)
	void delSelectServiceCatalogsCompanyClassesForCatalogs(@Param("ids") ArrayList<Long> ids);

}
