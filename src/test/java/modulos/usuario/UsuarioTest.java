package modulos.usuario;

import factory.UsuarioDataFactory;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


@DisplayName("Testes de API Rest referentes ao desafio técnico GetNet")
public class UsuarioTest {

    @Test
    @DisplayName("Validar criação de usuário com sucesso e retorno 201")
    public void testValidarCriacaoDeUsuarioComSucesso() {

        baseURI = "https://reqres.in";
        basePath = "/api";

        given()
            .contentType(ContentType.JSON)
            .body(UsuarioDataFactory.criarUsuario())
        .when()
                .post("/users")
        .then()
            .assertThat()
                .statusCode(201)
                .body("name", Matchers.equalTo("Fernanda"))
                .body("job", Matchers.equalTo("Analista de Testes (QA) Sênior - Datum-GetNet"));
    }

    @Test
    @DisplayName("Validar contrato na criação de usuário com sucesso")
    public void testValidarContratoNaCriacaoDeUsuarioComSucesso() {

        baseURI = "https://reqres.in";
        basePath = "/api";

        given()
            .contentType(ContentType.JSON)
            .body(UsuarioDataFactory.criarUsuario())
        .when()
            .post("/users")
        .then()
            .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/postUsersUsuario.json"));
    }

    @Test
    @DisplayName("Validar criação de usuário NAME com tipo de dado diferente e retorno 400")
    public void testValidarCriacaoDeUsuarioNameComTipoDeDadoDiferenteRetorno400() {

        baseURI = "https://reqres.in";
        basePath = "/api";

        given()
            .contentType(ContentType.JSON)
            .body("{\n" +
                    "    \"name\": 1,\n" +
                    "    \"job\": \"Analista de Testes (QA) Sênior\"\n" +
                    "}")
        .when()
            .post("/users")
        .then()
            .assertThat()
                .statusCode(400)
                .body(matchesJsonSchemaInClasspath("schemas/postUsersUsuario.json"));
    }

    @Test
    @DisplayName("Validar criação de usuário JOB com tipo de dado diferente e retorno 400")
    public void testValidarCriacaoDeUsuarioJobComTipoDeDadoDiferenteRetorno400() {

        baseURI = "https://reqres.in";
        basePath = "/api";

        given()
            .contentType(ContentType.JSON)
            .body("{\n" +
                    "    \"name\": \"Fernanda\",\n" +
                    "    \"job\": 1\n" +
                    "}")
        .when()
            .post("/users")
        .then()
            .assertThat()
                .statusCode(400)
                .body(matchesJsonSchemaInClasspath("schemas/postUsersUsuario.json"));
    }

    @Test
    @DisplayName("Validar criação de usuário com name e job em branco e retorno 400")
    public void testValidarCriacaoDeUsuarioRequestComNameEJobEmBrancoRetorno400() {

        baseURI = "https://reqres.in";
        basePath = "/api";

        given()
            .contentType(ContentType.JSON)
            .body("{\n" +
                    "    \"name\": \"\",\n" +
                    "    \"job\": \"\"\n" +
                    "}")
        .when()
            .post("/users")
        .then()
            .assertThat()
                .statusCode(400)
                .body(matchesJsonSchemaInClasspath("schemas/postUsersUsuario.json"));
    }
    @Test
    @DisplayName("Validar criação de usuário com método GET e retorno 400")
    public void testValidarCriacaoDeUsuarioMetodoGetRetorno400() {

        baseURI = "https://reqres.in";
        basePath = "/api";

        given()
            .contentType(ContentType.JSON)
            .body(UsuarioDataFactory.criarUsuario())
        .when()
            .get("/users")
        .then()
            .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/postUsersUsuario.json"))
                .statusCode(400);
    }
}
