package service_catalog_master_mgmt.model.dto;

import java.io.Serializable;

public class ServiceCatalogMaster_DTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6327827341755289832L;
	private Long serviceCatalogSeqNo;
	private Long companySeqNo;
	private String catalog;
	private String fromDttm;
	private String remark;
	private String status;
	private String toDttm;

	public Long getServiceCatalogSeqNo() {
		return serviceCatalogSeqNo;
	}

	public void setServiceCatalogSeqNo(Long serviceCatalogSeqNo) {
		this.serviceCatalogSeqNo = serviceCatalogSeqNo;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getFromDttm() {
		return fromDttm;
	}

	public void setFromDttm(String fromDttm) {
		this.fromDttm = fromDttm;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getToDttm() {
		return toDttm;
	}

	public void setToDttm(String toDttm) {
		this.toDttm = toDttm;
	}

	public ServiceCatalogMaster_DTO() {
		super();
	}

	public Long getCompanySeqNo() {
		return companySeqNo;
	}

	public void setCompanySeqNo(Long companySeqNo) {
		this.companySeqNo = companySeqNo;
	}

	public ServiceCatalogMaster_DTO(Long serviceCatalogSeqNo, Long companySeqNo, String catalog, String fromDttm,
			String remark, String status, String toDttm) {
		super();
		this.serviceCatalogSeqNo = serviceCatalogSeqNo;
		this.companySeqNo = companySeqNo;
		this.catalog = catalog;
		this.fromDttm = fromDttm;
		this.remark = remark;
		this.status = status;
		this.toDttm = toDttm;
	}

}