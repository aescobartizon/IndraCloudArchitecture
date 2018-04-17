package com.indra.ar.api.books.apibooks.controllers;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.indra.ar.api.books.apibooks.domain.LibroDTO;
import com.indra.ar.api.books.apibooks.domain.LibroDTOImp;
import com.indra.ar.api.books.apibooks.proxy.BooksServiceProxy;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/apibooks/")
public class ApiBooksApp extends AbstractController implements ApiBooks{

	private static final String BOOKS_END_POINT = "/books";
	
	private static final String FIND_BOOKS_END_POINT = "/findbooks";
	
	@Autowired
	@Setter
	@Getter
	BooksServiceProxy booksServiceProxy;
	
	@RequestMapping("/msg")
	public String msg(@RequestHeader("Accept-Language") Locale locale) {
		return getMessageSource().getMessage("field2", null, locale);
	}
	
	@GetMapping(path = BOOKS_END_POINT + "/{id}")
    @ApiOperation(value = "Display book info to non-admin user", response = LibroDTO.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
	public LibroDTOImp getBook(@PathVariable Long id) {

		return  getBooksServiceProxy().getBook(id);

	}
	
	
	@GetMapping(path = FIND_BOOKS_END_POINT + "/{titulo}")
    @ApiOperation(value = "Display books info filtered by title", response = LibroDTO.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
	public List<LibroDTOImp> getBooksByTitulo(@PathVariable String titulo) {
		
		return getBooksServiceProxy().getBooksByTitulo(titulo);

	}
	
	
	@PostMapping(path = BOOKS_END_POINT)
	@ApiOperation(value = "Add book to stock", response = LibroDTO.class)
	public ResponseEntity<LibroDTOImp> createUser(@Valid @RequestBody LibroDTOImp libro) {

		LibroDTOImp libroCreated = getBooksServiceProxy().createBook(libro);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(libroCreated.getId()).toUri();

		return ResponseEntity.created(location).body(libroCreated);
		
	}
	
	@PutMapping(path = BOOKS_END_POINT)
	@ApiOperation(value = "update book info", response = LibroDTO.class)
	public ResponseEntity<LibroDTO> updateBook(@Valid @RequestBody LibroDTOImp libro) {

		return ResponseEntity.accepted().body(getBooksServiceProxy().updateBook(libro));

	}
	
	@DeleteMapping(path = BOOKS_END_POINT + "/{id}")
	@ApiOperation(value = "delete book from stock", response = LibroDTO.class)
	public ResponseEntity<Long> deleteBook(@PathVariable Long id) {
		
		getBooksServiceProxy().deleteBook(id);
		
		return ResponseEntity.accepted().body(id);
		
	}
	
	@RequestMapping("/detect-device")
    public @ResponseBody String detectDevice(Device device) {
        String deviceType = "unknown";
        if (device.isNormal()) {
            deviceType = "normal";
        } else if (device.isMobile()) {
            deviceType = "mobile";
        } else if (device.isTablet()) {
            deviceType = "tablet";
        }
        return "Hello " + deviceType + " browser!";
    }
}
