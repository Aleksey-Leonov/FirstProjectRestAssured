package tests;

import configuration.MyConfig;
import org.aeonbits.owner.ConfigFactory;
import pojo.pets.AvailablePets;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BaseTest {
    public static final MyConfig properties = ConfigFactory.create(MyConfig.class);


    public void deleteElement(String path, String id) {
        given()
                .when()
                .delete(path + id)
                .then().log().all();
    }

    public <T> T get(Class<T> responseClass, String path) {
        return given()
                .when()
                .get(path)
                .then()
                .extract().body().as(responseClass);
    }

    public <T> T get(Class<T> responseClass, String path, String paramPath) {
        return given()
                .when()
                .get(path + paramPath)
                .then()
                .extract().body().as(responseClass);
    }


    public <T> List<T> getList(Class<T> responseClass, String path, String paramPath, String directory) {
        return given()
                .when()
                .get(path + paramPath)
                .then()
                .extract().body().jsonPath().getList(directory, responseClass);
    }

    public <T> void put(Class<T> responseClass, T update, String path) {
        given()
                .body(update)
                .when()
                .put(path)
                .then().log().all()
                .extract().as(AvailablePets.class);
    }

    public <T> T post(Class<T> responseClass, T addObject, String path) {
        return given()
                .body(addObject)
                .when()
                .post(path)
                .then().log().all()
                .extract().as(responseClass);
    }


}
