package org.tientcheu.framework.mvp;

import org.apache.log4j.Logger;
import org.tientcheu.framework.mvp.api.IAttributeIdentifier;
import org.tientcheu.framework.mvp.api.IComponentVisitor;
import org.tientcheu.framework.mvp.api.IModelTrigger;
import org.tientcheu.framework.mvp.api.IModelValidator;
import org.tientcheu.framework.mvp.api.IPresenter;
import org.tientcheu.framework.mvp.api.Identifiable;
import org.tientcheu.model.home.Bed;
import org.tientcheu.model.home.Freezer;
import org.tientcheu.model.home.House;
import org.tientcheu.model.home.IBed;
import org.tientcheu.model.home.IKitchen;
import org.tientcheu.model.home.IRoom;
import org.tientcheu.model.home.Kitchen;
import org.tientcheu.model.home.Room;

import junit.framework.TestCase;

public class PresenterAttributeTest extends TestCase {

	private static Logger logger = Logger.getLogger(PresenterTest.class);
	private PresenterAttribute presenterAttribute = new PresenterAttribute();
	private String xpath;
	private IAttributeIdentifier attributeIdentifier;
	private IModelTrigger[] triggers;
	private IModelValidator modelValidator;
	private IComponentVisitor componentVisitor;
	private IComponentVisitor labelVisitor;
	private IPresenter presenter;
	private Identifiable[] dependencies;
	private House house;
	
	@Override
	public void setUp(){
		initModel();
	}
	
	private void initModel() {		
		initHouse();
	}

	private void initHouse() {
		house = new House("43rueDeLouvain");
		house.setAddress("43 rue de Louvain");
		house.setPostalCode(92400L);
		initRoom(house);
		initKitchen(house);		
	}

	private IKitchen initKitchen(House house) {
		Kitchen kitchen = new Kitchen("cuisineEntree");
		kitchen.setName("cuisinePrincipale");
		house.setKitchen(kitchen);
		kitchen.setHouse(house);
		initFreezer(kitchen);
		return kitchen;
	}

	private void initFreezer(Kitchen kitchen) {
		Freezer freezer = new Freezer("samsung");
		kitchen.setFreezer(freezer);
		freezer.setKitchen(kitchen);
	}

	private IRoom initRoom(House house) {
		Room room = new Room("chambreNicole");
		room.setName("chambrePrincipale");
		room.setHouse(house);
		initBed(room);
		house.setRoom(room);
		return room;
	}
	
	private IBed initBed(Room room) {
		Bed bed = new Bed("litBaby");
		room.setBed(bed);
		bed.setRoom(room);
		return bed;
	}

	public void testSetSimpleAttribute() throws Exception {
		String houseAddress = "43 rue de louvain";
		
		// set value
		house.setAddress(houseAddress);
		presenterAttribute.setXpath("address");
		presenterAttribute.set(house, houseAddress);
		
		// check
		assertEquals(house.getAddress(), houseAddress);
	}

	public void testSetCompositeAttribute() throws Exception {
		String bedName = "Lit superposé";
		
		// set the composite value
		house.getRoom().getBed().setName(bedName);
		presenterAttribute.setXpath("room.bed.name");
		presenterAttribute.set(house, bedName);
		
		// check
		assertEquals(house.getRoom().getBed().getName(), bedName);
	}
	
	public void testGetSimpleAttribute() {
		fail("Not yet implemented");
	}

	public void testGetCompositeAttribute() throws Exception {
		String bedName = "Lit superposé";
		
		// set the composite value
		house.getRoom().getBed().setName(bedName);
		
		// check
		presenterAttribute.setXpath("room.bed.name");
		assertEquals((String) presenterAttribute.get(house), bedName);
	}
	
	public void testGetAttributeIdentifier() {
		IAttributeIdentifier attributeIdentifier = new BasicAttributeIdentifier("name");
		presenterAttribute.setAttributeIdentifier(attributeIdentifier);
		assertEquals(presenterAttribute.getAttributeIdentifier(), attributeIdentifier);
	}

	private static class BasicAttributeIdentifier implements IAttributeIdentifier{
		
		private String attributeID;

		public BasicAttributeIdentifier(String attributeID){
			this.attributeID = attributeID;
		}
		
		@Override
		public String getIdentifier() {
			return attributeID;
		}

		@Override
		public String getLabel() {
			return attributeID;
		}

		@Override
		public String getHint() {
			return attributeID;
		}		
	}

	public void testSetAttributeIdentifier() {
		IAttributeIdentifier attributeIdentifier = new BasicAttributeIdentifier("name");
		presenterAttribute.setAttributeIdentifier(attributeIdentifier);
		assertEquals(presenterAttribute.getAttributeIdentifier(), attributeIdentifier);
	}

	public void testGetXpath() {
		presenterAttribute.setXpath("name");
		assertEquals(presenterAttribute.getXpath(), "name");
	}

	public void testSetXpath() {
		presenterAttribute.setXpath("name");
		assertEquals(presenterAttribute.getXpath(), "name");
	}

	public void testGetTriggers() {
		fail("Not yet implemented");
	}

	public void testSetTriggers() {
		fail("Not yet implemented");
	}

	public void testGetValidator() {
		fail("Not yet implemented");
	}

	public void testSetValidator() {
		fail("Not yet implemented");
	}

	public void testGetComponentVisitor() {
		fail("Not yet implemented");
	}

	public void testSetComponentVisitor() {
		fail("Not yet implemented");
	}

	public void testGetLabelVisitor() {
		fail("Not yet implemented");
	}

	public void testSetLabelVisitor() {
		fail("Not yet implemented");
	}

	public void testGetPresenter() {
		fail("Not yet implemented");
	}

	public void testGetDependencies() {
		fail("Not yet implemented");
	}

	public void testSetDependencies() {
		fail("Not yet implemented");
	}

}
