
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;


public class PostmanApiTest {

    @Test
    public void shouldReturnPostRequest() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Здравствуйте, вас приветствует автоответчик," +
                        "пожалуйста оставьте сообщение после звукового сигнала.") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("Здравствуйте, вас приветствует автоответчик," +
                        "пожалуйста, оставьте сообщение после звукового сигнала."));
    }

}
