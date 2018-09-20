package com.notesrestapi.notesrestapi;

import com.notesrestapi.notesrestapi.service.NoteService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NotesrestapiApplicationTests {

	@Autowired
	NoteService noteService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void noteService_createAndFindNote() {
		noteService.createNote("test create note");
		Assert.assertNotNull(noteService.findAll("test create note"));
	}

	@Test
	public void noteService_findAll() {
		noteService.createNote("test note 1");
		noteService.createNote("test note 2");

		Assert.assertTrue(noteService.findAll(null).size() > 0);
	}

	@Test
	public void noteService_findCheese() {
		noteService.createNote("Cheese");
		noteService.createNote("Milk");
		noteService.createNote("Cheese");

		Assert.assertTrue(noteService.findAll("Cheese").size() == 2);
	}
}
