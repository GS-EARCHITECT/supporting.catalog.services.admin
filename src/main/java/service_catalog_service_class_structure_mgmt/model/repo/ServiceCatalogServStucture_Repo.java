package service_catalog_service_class_structure_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import service_catalog_service_class_structure_mgmt.model.master.ServiceCatalogServStructure;
import service_catalog_service_class_structure_mgmt.model.master.ServiceCatalogServStructurePK;

@Repository("serviceCatalogServicetuctureRepo")
public interface ServiceCatalogServStucture_Repo extends JpaRepository<ServiceCatalogServStructure, ServiceCatalogServStructurePK> 
{
	@Query(value = "SELECT * FROM SERVICE_CATALOG_SERVSTRUCTURE a WHERE (a.service_class_seq_no in :ids and a.par_service_class_seq_no in :pids) order by service_catalog_seq_no", nativeQuery = true)
	ArrayList<ServiceCatalogServStructure> getSelectServiceCatalogStructures(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);

	@Query(value = "SELECT * FROM SERVICE_CATALOG_SERVSTRUCTURE a WHERE a.company_catalog_seq_no in :ids order by service_catalog_seq_no", nativeQuery = true)
	ArrayList<ServiceCatalogServStructure> getSelectServiceCatalogsStructuresForCatalogs(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM SERVICE_CATALOG_SERVSTRUCTURE a WHERE (a.company_catalog_seq_no in :ids and a.service_class_seq_no in :cids) order by service_catalog_seq_no", nativeQuery = true)
	ArrayList<ServiceCatalogServStructure> getSelectServiceChildStructuresForCatalogs(@Param("ids") ArrayList<Long> ids, @Param("cids") ArrayList<Long> cids);
	
	@Query(value = "DELETE FROM SERVICE_CATALOG_SERVSTRUCTURE a WHERE (a.service_class_seq_no in :ids and a.par_service_class_seq_no in :pids)", nativeQuery = true)
	void delSelectServiceCatalogStructures(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);

	@Query(value = "DELETE FROM SERVICE_CATALOG_SERVSTRUCTURE a WHERE a.company_catalog_seq_no in :ids", nativeQuery = true)
	void delSelectServiceCatalogsStructuresForCatalogs(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM SERVICE_CATALOG_SERVSTRUCTURE a WHERE (a.company_catalog_seq_no in :ids and a.service_class_seq_no in :cids)", nativeQuery = true)
	void delSelectServiceChildStructuresForCatalogs(@Param("ids") ArrayList<Long> ids, @Param("cids") ArrayList<Long> cids);
}