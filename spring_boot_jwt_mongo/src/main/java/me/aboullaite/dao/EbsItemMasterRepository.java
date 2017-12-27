/**
 * 
 */
package me.aboullaite.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import me.aboullaite.model.EbsItemMaster;


/**
 * @author tanmoydas
 *
 */
@Repository
public interface EbsItemMasterRepository extends MongoRepository<EbsItemMaster, String>{

	public abstract EbsItemMaster findEbsItemMasterByItemId(Long itemId);
	
	public abstract List<EbsItemMaster> findEbsItemMasterByStyleCode(String styleCode);
	
	public abstract List<EbsItemMaster> findEbsItemMasterByStyleCodeAndColorCodeOrderByColorCodeAsc(String styleCode, String colorCode);
	
	
}
