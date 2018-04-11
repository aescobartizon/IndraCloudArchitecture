package com.indra.ar.books.repositories;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.indra.ar.books.BooksApplication;

@TestPropertySource(locations = "src/test/resources/test.properties")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BooksApplication.class})
public class BooksRepositoryTest {

	public void  testInitiBean() {
		BooksRepository booksRepository;
	}
}
