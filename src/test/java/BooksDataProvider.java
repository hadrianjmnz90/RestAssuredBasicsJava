import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BooksDataProvider {

    //@Test(dataProvider = "BooksData")
    public void addBook(String bookTitle, String isbn, String aisle, String author) {
        RestAssured.baseURI = "http://216.10.245.166";
        Response resp = given().log().all().
                header("Content-Type", "application/json").
                body( payload.addBook(bookTitle, isbn, aisle, author)).
                when().
                post("/Library/Addbook.php").
                then().assertThat().statusCode(200).
                extract().response();
        System.out.println(resp);
        JsonPath js = ReUsableMethods.rawToJsonResponse(resp);
        String id = js.get("ID");
        System.out.println(id);

        //deleteBOok

    }

    @Test(dataProvider = "DeleteBooksData")
    public void deleteBook(String id) {
        RestAssured.baseURI = "http://216.10.245.166";
        Response resp = given().log().all().
                header("Content-Type", "application/json").
                body( payload.deleteBook(id)).
                when().
                post("/Library/DeleteBook.php").
                then().assertThat().statusCode(200)
                .extract().response();
        System.out.println(resp);
    }
 //   {
   //     "msg": "book is successfully deleted"
   // }
    @DataProvider(name = "BooksData")
    public Object[][] getData() {
        return new Object[][] {
                { "las mil y una noches", "hajp", "002", "anonimo" },
                { "Romeo y Julieta", "hajp", "003", "Shakespiere" },
                { "Crimen y Castigo", "hajp", "004", "Dostoievsy" },
                { "BladeRunner", "hajp", "005", " Philip K. Dick" }};
    }

    @DataProvider(name = "DeleteBooksData")
    public Object[][] deleteData() {
        return new Object[][] {
                { "hajp002" },
                { "hajp003"},
                { "hajp004" }};
    }
}
