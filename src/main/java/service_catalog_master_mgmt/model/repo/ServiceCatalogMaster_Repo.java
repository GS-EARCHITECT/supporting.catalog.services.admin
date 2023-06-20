package service_catalog_master_mgmt.model.repo;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import service_catalog_master_mgmt.model.master.ServiceCatalogMaster;

@Repository("serviceCatalogMasterRepo")
public interface ServiceCatalogMaster_Repo extends JpaRepository<ServiceCatalogMaster, Long> 
{
	@Query(value = "SELECT * FROM SERVICE_CATALOG_MASTER a WHERE a.service_catalog_seq_no in :ids order by service_catalog_seq_no", nativeQuery = true)
	ArrayList<ServiceCatalogMaster> getSelectServiceCatalogs(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM SERVICE_CATALOG_MASTER a WHERE a.company_seq_no in :ids order by service_catalog_seq_no", nativeQuery = true)
	ArrayList<ServiceCatalogMaster> getSelectServiceCatalogsForCompanies(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM SERVICE_CATALOG_MASTER a WHERE ((:fr BETWEEN a.FROM_DTTM and a.FROM_DTTM) and ( :to BETWEEN a.FROM_DTTM and a.FROM_DTTM)) order by service_catalog_seq_no", nativeQuery = true)
	ArrayList<ServiceCatalogMaster> getSelectServiceCatalogsBetweenTimes(@Param("fr") Timestamp fr, @Param("to") Timestamp to);
	
	@Query(value = "DELETE FROM SERVICE_CATALOG_MASTER WHERE a.service_catalog_seq_no in :ids", nativeQuery = true)
	void delSelectServiceCatalogs(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELTE FROM SERVICE_CATALOG_MASTER a WHERE ((:fr BETWEEN a.FROM_DTTM and a.FROM_DTTM) and ( :to BETWEEN a.FROM_DTTM and a.FROM_DTTM))", nativeQuery = true)
	void delSelectServiceCatalogsBetweenTimes(@Param("fr") Timestamp fr, @Param("to") Timestamp to);
	
	@Query(value = "DELETE FROM SERVICE_CATALOG_MASTER a WHERE a.company_seq_no in :ids", nativeQuery = true)
	void delSelectServiceCatalogsForCompanies(@Param("ids") ArrayList<Long> ids);
	
}
