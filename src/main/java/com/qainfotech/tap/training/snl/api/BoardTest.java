package com.qainfotech.tap.training.snl.api;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//@BeforeMethod
//{ public void setup();
//	Board board= new board();
//	
//}
public class BoardTest {

	Board board;
	UUID id, id1, id2, id3;
	UUID del = UUID.randomUUID();

	@BeforeTest
	public void setup() throws FileNotFoundException, UnsupportedEncodingException, IOException {
		this.board = new Board();
	}

	@Test
	public void initialiseboard() throws FileNotFoundException, UnsupportedEncodingException, IOException {
		// this.board= new Board();
		// This command will initialise a new board.
		// Assert that (Actual == Expected)
		AssertJUnit.assertTrue(Files.exists(Paths.get(this.board.getUUID() + ".board")));
	}

	@Test
	public void register_new_player() throws FileNotFoundException, UnsupportedEncodingException, IOException,
			PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption {
		UUID UUIDHarshit = this.board.registerPlayer("Harshit");
		System.out.println(this.board.getData().getJSONArray("players").getJSONObject(0).getString("name"));
		assertEquals(this.board.getData().getJSONArray("players").getJSONObject(0).getString("name"), "Harshit");
		System.out.println("UUIDharshit=" + UUIDHarshit);
		this.id = UUIDHarshit;
		UUID achal_UUID = this.board.registerPlayer("Achal");
		assertEquals(this.board.getData().getJSONArray("players").getJSONObject(1).get("uuid").toString(),
				achal_UUID.toString());
		System.out.println(this.board.getData().getJSONArray("players").getJSONObject(1).getString("name"));
		this.id1 = achal_UUID;
		UUID samarth_UUID = this.board.registerPlayer("Samarth");
		assertEquals(this.board.getData().getJSONArray("players").getJSONObject(2).get("uuid").toString(),
				samarth_UUID.toString());
		System.out.println(this.board.getData().getJSONArray("players").getJSONObject(2).getString("name"));
		this.id2 = samarth_UUID;
		UUID dhondu_UUID = this.board.registerPlayer("Dhondu");
		assertEquals(this.board.getData().getJSONArray("players").getJSONObject(3).get("uuid").toString(),
				dhondu_UUID.toString());
		System.out.println(this.board.getData().getJSONArray("players").getJSONObject(3).getString("name"));
		this.id3 = dhondu_UUID;
		assertEquals(this.board.getData().getJSONArray("players").getJSONObject(0).get("uuid").toString(),
				UUIDHarshit.toString());

		assertEquals(this.board.getData().getJSONArray("players").getJSONObject(0).get("uuid"), UUIDHarshit);

//	 Object id1= this.board.getData().getJSONArray("players").getJSONObject(0).get("uuid");
//	System.out.println(id1); 
		del = dhondu_UUID;
		System.out.println("UUID Dhondu=" + del);
		UUID ID = getid();
		System.out.println(ID);
//String string= deleteplayer();

		this.del = dhondu_UUID;
//this.del.toString();
//System.out.println("TO string"+this.del.toString());
	}

	@Test
	public UUID getid() {
		UUID id;
		id = this.board.uuid;
		return id;
	}

//@Test
//public void getplayerID() throws IOException
// {
// String st;
//System.out.println(this.board.getData().getJSONArray("players").getJSONObject(0).get("uuid").toString()); 
//	
////System.out.println(this.board.getData().getJSONArray("players").getJSONObject(0).getString("name"));
////System.out.println(st);
//	FileReader obj = new FileReader("b08c5cbb-9435-470b-884f-bde8256c3afa.board"); 
//	int i;    
//	 while((i=obj.read())!=-1)   
//	//i=obj.read();
//    System.out.print((char)i);    

	@AfterClass
	public void deleteplayer() throws FileNotFoundException, UnsupportedEncodingException, NoUserWithSuchUUIDException {
		System.out.println("ID to delete" + del);
		UUID match;
		System.out.println("Match:" + this.board.getUUID());
		match = this.board.getUUID();
		this.board.deletePlayer(del);
		System.out.println("player with UUID=" + del + " is deleted");

		assertEquals(this.del, del);

	
		    System.out.println("ID to delete" + this.id);
			UUID match1;
			System.out.println("Match:" + this.board.getUUID());
			match1 = this.id;
			this.board.deletePlayer(match1);
			System.out.println("player with UUID=" + match1 + " is deleted");

			assertEquals(this.id,match1 );
	
			System.out.println("ID to delete" + this.id2);
			UUID match2;
			System.out.println("Match:" + this.board.getUUID());
			match2 = this.id2;
			this.board.deletePlayer(match2);
			System.out.println("player with UUID=" + match2 + " is deleted");

			assertEquals(this.id2,match2 );
	
	   
			System.out.println("ID to delete" + this.id1);
			UUID match3;
			System.out.println("Match:" + this.board.getUUID());
			match3 = this.id1;
			this.board.deletePlayer(match3);
			System.out.println("player with UUID=" + match3 + " is deleted");

			assertEquals(this.id1,match3 );
	
	
	
	
	}

	@Test
	public void rolldice() throws FileNotFoundException, UnsupportedEncodingException, InvalidTurnException {
		String str;
		int i=0;
    
//JsonPath.read(this.board.uuid, $.players[i].position, filters);
		// System.out.println("path="+jsonpath);
     
		while(i!=1)
        {System.out.println("ID to be promoted:" + id);
		this.board.rollDice(this.id);
		str = this.board.getData().getJSONArray("players").getJSONObject(0).get("position").toString();
		System.out.println("Position of first player is " + str);
		if(str.equals("100")) {i=1;   System.out.println("Winner!!"); return ;}
		
        
		System.out.println("ID to be promoted:" + id1);
		this.board.rollDice(this.id1);
		str = this.board.getData().getJSONArray("players").getJSONObject(1).get("position").toString();
		System.out.println("Position of second player is " + str);
		if(str.equals("100")) {i=1;  System.out.println("Winner!!"); return ; }
		
		
		System.out.println("ID to be promoted:" + id2);
		this.board.rollDice(this.id2);
		str = this.board.getData().getJSONArray("players").getJSONObject(2).get("position").toString();
		System.out.println("Position of third player is " + str);
		if(str.equals("100")) {i=1;   System.out.println("Winner!!"); return ; }
		
		
		System.out.println("ID to be promoted:" + id3);
		this.board.rollDice(this.id3);
		str = this.board.getData().getJSONArray("players").getJSONObject(3).get("position").toString();
		System.out.println("Position of fourth player is " + str);
		if(str.equals("100")) {i=1;  System.out.println("Winner!!");  return ; }
		
		}
          
	//return;
	
	}



}
