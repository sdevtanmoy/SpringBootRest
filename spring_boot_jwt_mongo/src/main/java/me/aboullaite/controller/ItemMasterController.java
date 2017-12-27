/**
 * 
 */
package me.aboullaite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.aboullaite.dao.EbsItemMasterRepository;
import me.aboullaite.model.EbsItemMaster;

/**
 * @author tanmoydas
 *
 */
@RestController
@RequestMapping("/api")
public class ItemMasterController {

	@Autowired(required = true)
	private EbsItemMasterRepository ebsItemMasterRepository;
	
	//private ApplicationMasterData masterData= ApplicationMasterData.getMasterDataFactory();
	@GetMapping(
			value = "/items",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<EbsItemMaster>> getAllItems(){
		List<EbsItemMaster> ebsItemMasters = null;
		try{
			ebsItemMasters = this.ebsItemMasterRepository.findAll();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		if(null == ebsItemMasters){
			return new ResponseEntity<List<EbsItemMaster>>(HttpStatus.NO_CONTENT);
		}
		else{
			return new ResponseEntity<List<EbsItemMaster>>(ebsItemMasters, HttpStatus.OK);
		}
	}
	
	@GetMapping(
			value = "/items/{itemId}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	@PreAuthorize("hasRole('READWRITE')")
	public ResponseEntity<EbsItemMaster> getItemMasterById(@PathVariable("itemId") String itemId ){
		if(null == itemId || itemId.isEmpty()){
			return new ResponseEntity<EbsItemMaster>(HttpStatus.BAD_REQUEST);
		}
		
		
		EbsItemMaster item = null;
		try{
			item = this.ebsItemMasterRepository.findEbsItemMasterByItemId(Long.parseLong(itemId));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		if(null == item){
			return new ResponseEntity<EbsItemMaster>(HttpStatus.NO_CONTENT);
		}
		else{
			return new ResponseEntity<EbsItemMaster>(item, HttpStatus.OK);
		}
	}
	
}
