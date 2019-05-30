package pukhtaweb.api.controllres;


import pukhtaweb.api.entities.ListEntity;
import pukhtaweb.api.entities.BookEntity;
import pukhtaweb.api.models.BookRegRequest;
import pukhtaweb.api.models.BookRegResponse;
import pukhtaweb.api.repositories.BookRepository;
import pukhtaweb.api.repositories.impl.ListRepositoryImpl;
import pukhtaweb.api.repositories.impl.BookRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BookController {
    private final BookRepository bookRepository;
    @Autowired
    ListRepositoryImpl listRepository;
    public BookController() {
        this.bookRepository = new BookRepositoryImpl();
    }
    @PostMapping("/api/book/add")
    public BookRegResponse register(@RequestBody BookRegRequest regRequest) throws Exception {
        BookEntity newBook= new BookEntity();
        newBook.setName(regRequest.getName());
        newBook.setAuthor(regRequest.getAuthor());
        newBook.setGenre(regRequest.getGenre());
        newBook.setYear(regRequest.getYear());
        newBook.setDescription(regRequest.getDescription());


        BookEntity insertedBook=this.bookRepository.insert(newBook);
        BookRegResponse regResponse= new BookRegResponse();
        regResponse.setBookId(insertedBook.getId());
       // ListController a =new ListController();
        add_to_list(insertedBook);


        return regResponse;
    }
    public ListEntity add_to_list(BookEntity entity)throws Exception{
        ListEntity new_book= new ListEntity();
        new_book.setUserId(4);
        new_book.setBookId(entity.getId());
        new_book.setAccept("-");
        ListEntity inserted_element=this.listRepository.insert(new_book);
        return new_book;
    }
}