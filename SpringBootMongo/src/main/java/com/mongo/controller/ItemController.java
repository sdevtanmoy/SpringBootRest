/**
 * 
 */
package com.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mongo.domain.model.EbsItemMaster;
import com.mongo.domain.repo.EbsItemMasterRepository;

/**
 * @author ibm
 *
 **This is UI REST Controller for Item object manipulation
 **The services are listed below
 *	GET - 		/api/items  		- gets all items list
 *	GET - 		/api/items/{itemId} - get a item find by item id
 *	POST - 		/api/items 			- post a single payload in RequestBody of item details to create a new item details.
 *	PUT - 		/api/items/{itemId} - put updates a existing item data, having the item id in request parameter. 
 *	DELETE - 	/api/items/{itemId} - delete an item object having the id in UI parameter.
 *	DELETE - 	/api/items 			- removes all item details - not recommended to have in application.
 */
@RestController
@RequestMapping("/api")
public class ItemController {

	//---------------------Added Dependency of DAO layer to perform all data retrieval/manipulation work----------------
	@Autowired(required = true)
	private EbsItemMasterRepository ebsItemMasterRepository;
	
	
	
	//----------Retrieve all items details----------------------------------------------------------------
	//--alternatively written //@RequestMapping(value = "/items", method= RequestMethod.GET)
	@GetMapping(
			value = "/items",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
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
	
	//---------------Retrieve Item details by it's Id value-------------------------------------------
	//--alternatively written //@RequestMapping(value = "/items/{itemId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(
			value = "/items/{itemId}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<EbsItemMaster> getEbsItemById(@PathVariable("itemId") String itemId){
		if(null == itemId || itemId.isEmpty()){
			return new ResponseEntity<EbsItemMaster>(HttpStatus.BAD_REQUEST);
		}
		
		EbsItemMaster itemMaster = null;
		try{
			itemMaster = this.ebsItemMasterRepository.findEbsItemMasterByItemId(Integer.parseInt(itemId));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		if(null == itemMaster){
			return new ResponseEntity<EbsItemMaster>(HttpStatus.NO_CONTENT);
		}
		else{
			return new ResponseEntity<EbsItemMaster>(itemMaster, HttpStatus.OK);
		}
	}
	//---------------- Create a new Item object------------------------------------
	//--alternatively written //@RequestMapping(value="/items", method = RequestMethod.POST)
	@PostMapping(
			value = "/items"
			)
	public ResponseEntity<EbsItemMaster> createItem(@RequestBody EbsItemMaster item, UriComponentsBuilder ucBuilder){
		
		// check the item already exists or not in DB
		// if exists return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		if(null != item && (null == item.getItemId() || item.getItemId().intValue() <= 0) ){
			item = this.ebsItemMasterRepository.save(item);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/items/{itemId}").buildAndExpand(item.getItemId()).toUri());
			return new ResponseEntity<EbsItemMaster>(item, HttpStatus.OK);
		}
		else{
			return new ResponseEntity<EbsItemMaster>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//-------Update an existing item --------------------------------------------------
	//--alternatively written //@RequestMapping(value = "/items/{itemId}", method = RequestMethod.PUT)
	@PutMapping(
			value = "/items/{itemId}"
			)
	public ResponseEntity<EbsItemMaster> updateEbsItem(@PathVariable("itemId") String itemId, @RequestBody EbsItemMaster item ){
		
		if(null == itemId || itemId.trim().isEmpty()){
			return new ResponseEntity<EbsItemMaster>(HttpStatus.BAD_REQUEST);
		}
		else{
			EbsItemMaster itemDao = null;
			
			try {
				itemDao = this.ebsItemMasterRepository
						.findEbsItemMasterByItemId(Integer.parseInt(itemId));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(null == itemDao){
				return new ResponseEntity<EbsItemMaster>(HttpStatus.NOT_FOUND);
			}
			
			itemDao.setStyleCode(item.getStyleCode());
			itemDao.setColorCode(item.getColorCode());
			itemDao.setItemType(item.getItemType());
			itemDao.setPsGlCode(item.getPsGlCode());
			itemDao.setPsGlGroup(item.getPsGlGroup());
			itemDao.setSize1(item.getSize1());
			itemDao.setSize2(item.getSize2());
			itemDao.setSizeVerCode(item.getSizeVerCode());
			
			try {
				this.ebsItemMasterRepository.save(itemDao);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return new ResponseEntity<EbsItemMaster>(itemDao, HttpStatus.OK);
		}
	}
	
	//--------------------------Deleting an item by id ---------------------------------------------
	//--alternatively written //@RequestMapping(value = "/items/{itemId}" , method = RequestMethod.DELETE)
	@DeleteMapping(
			value = "/items/{itemId}"
			)
	public ResponseEntity<EbsItemMaster> deleteEbsItemById(@PathVariable("itemId") String itemId){
		
		if(null == itemId || itemId.trim().isEmpty()){
			return new ResponseEntity<EbsItemMaster>(HttpStatus.BAD_REQUEST);
		}
		else{
			EbsItemMaster itemDao = null;
			
			try {
				itemDao = this.ebsItemMasterRepository
						.findEbsItemMasterByItemId(Integer.parseInt(itemId));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(null == itemDao){
				return new ResponseEntity<EbsItemMaster>(HttpStatus.NOT_FOUND);
			}
			else{
				try {
					this.ebsItemMasterRepository.delete(itemDao);
					return new ResponseEntity<EbsItemMaster>(itemDao, HttpStatus.OK);
					
				} 
				catch (Exception e) {
					System.err.println(e.getMessage());
					return new ResponseEntity<EbsItemMaster>(HttpStatus.CONFLICT);
				}
			}
		}
	}

	//-----------------Delete all item details---------------------------------------
	//--alternatively written //@RequestMapping(value = "/items", method = RequestMethod.DELETE)
	@DeleteMapping(
			value = "/items"
			)
	
	public ResponseEntity<EbsItemMaster> deleteAllEbsItem(){
		try {
			this.ebsItemMasterRepository.deleteAll();
			return new ResponseEntity<EbsItemMaster>(HttpStatus.OK);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return new ResponseEntity<EbsItemMaster>(HttpStatus.CONFLICT);
		}
	}
}
