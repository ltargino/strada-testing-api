import br.com.teste.desafio.web.model.Post;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PostTest {

    @BeforeAll
    public static void setup () {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
    }

    @Test
    @DisplayName("Validar codigo e corpo da resposta da API")
    public void testPosts () {

        Post randomPost = Post.builder()
                .userId(1)
                .id(1)
                .title("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")
                .body("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto")
                .build();

        List<Post> list = given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("$", Post.class);

        Predicate<Post> matchFilter = post -> {
            return post.getId() == randomPost.getId() &&
                    post.getUserId() == randomPost.getUserId() &&
                    post.getBody().equals(randomPost.getBody()) &&
                    post.getTitle().equals(randomPost.getTitle());
        };

        assertTrue(list.stream().anyMatch(matchFilter));

    }

}
