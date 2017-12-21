/**
 * 
 */
package com.mongo.domain.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.domain.model.EbsItemMaster;

/**
 * @author ibm
 *
 */
@Repository
public interface EbsItemMasterRepository extends MongoRepository<EbsItemMaster, String>{

	public abstract EbsItemMaster findEbsItemMasterByItemId(Integer itemId);
	
	public abstract List<EbsItemMaster> findEbsItemMasterBySize1AndSize2OrderByItemIdDesc();
}
