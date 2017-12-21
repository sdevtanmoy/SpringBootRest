/**
 * 
 */
package com.mongo.domain.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author ibm
 *
 */

@Document(collection = "ebs_item_master")
public class EbsItemMaster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	private String id;

	@NotNull
	@Field("item_id")
	private Integer itemId;
	
	@Indexed(direction = IndexDirection.ASCENDING)
	@Field("style_code")
	private String styleCode;
	
	@Field("ps_gl_code")
	private String psGlCode;
	
	@Field("item_type")
	private String itemType;
	
	@Field("size1")
	private String size1;
	
	@Field("size2")
	private String size2;
	
	@Field("color_code")
	private String colorCode;
	
	@Indexed(direction = IndexDirection.ASCENDING)
	@Field("ps_gl_group")
	private String psGlGroup;
	
	@Field("vendor_code")
	private String vendorCode;
	
	@Field("size_ver_code")
	private String sizeVerCode;
	
	/**
	 * 
	 */
	private EbsItemMaster() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param styleCode
	 * @param psGlCode
	 * @param itemType
	 * @param size1
	 * @param size2
	 * @param colorCode
	 * @param psGlGroup
	 * @param vendorCode
	 * @param sizeVerCode
	 */
	private EbsItemMaster(String styleCode, String psGlCode, String itemType, String size1, String size2,
			String colorCode, String psGlGroup, String vendorCode, String sizeVerCode) {
		this.styleCode = styleCode;
		this.psGlCode = psGlCode;
		this.itemType = itemType;
		this.size1 = size1;
		this.size2 = size2;
		this.colorCode = colorCode;
		this.psGlGroup = psGlGroup;
		this.vendorCode = vendorCode;
		this.sizeVerCode = sizeVerCode;
	}



	/**
	 * @return the itemId
	 */
	public Integer getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the styleCode
	 */
	public String getStyleCode() {
		return styleCode;
	}

	/**
	 * @param styleCode the styleCode to set
	 */
	public void setStyleCode(String styleCode) {
		this.styleCode = styleCode;
	}

	/**
	 * @return the psGlCode
	 */
	public String getPsGlCode() {
		return psGlCode;
	}


	/**
	 * @param psGlCode the psGlCode to set
	 */
	public void setPsGlCode(String psGlCode) {
		this.psGlCode = psGlCode;
	}


	/**
	 * @return the itemType
	 */
	public String getItemType() {
		return itemType;
	}


	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}


	/**
	 * @return the size1
	 */
	public String getSize1() {
		return size1;
	}

	/**
	 * @param size1 the size1 to set
	 */
	public void setSize1(String size1) {
		this.size1 = size1;
	}

	/**
	 * @return the size2
	 */
	public String getSize2() {
		return size2;
	}

	/**
	 * @param size2 the size2 to set
	 */
	public void setSize2(String size2) {
		this.size2 = size2;
	}

	/**
	 * @return the colorCode
	 */
	public String getColorCode() {
		return colorCode;
	}

	/**
	 * @param colorCode the colorCode to set
	 */
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	/**
	 * @return the psGlGroup
	 */
	public String getPsGlGroup() {
		return psGlGroup;
	}

	/**
	 * @param psGlGroup the psGlGroup to set
	 */
	public void setPsGlGroup(String psGlGroup) {
		this.psGlGroup = psGlGroup;
	}

	/**
	 * @return the vendorCode
	 */
	public String getVendorCode() {
		return vendorCode;
	}

	/**
	 * @param vendorCode the vendorCode to set
	 */
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	/**
	 * @return the sizeVerCode
	 */
	public String getSizeVerCode() {
		return sizeVerCode;
	}

	/**
	 * @param sizeVerCode the sizeVerCode to set
	 */
	public void setSizeVerCode(String sizeVerCode) {
		this.sizeVerCode = sizeVerCode;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
