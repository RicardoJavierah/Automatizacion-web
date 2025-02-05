package com.nttdata.steps;

import io.restassured.response.Response;
import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.rest.SerenityRest;
import org.apache.xpath.operations.Bool;
import org.junit.Assert;

import static org.hamcrest.Matchers.equalTo;

public class OrderStep {

    public void creacionOrder(DataTable dataTable) {

        String urlBase = "https://petstore.swagger.io/v2";
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        String requestBody = null;
        for (Map<String, String> row : rows) {
            int id = Integer.parseInt(row.get("id"));
            int petId = Integer.parseInt(row.get("petId"));
            int quantity = Integer.parseInt(row.get("quantity"));
            String shipDate = row.get("shipDate");
            String status = row.get("status");
            Boolean complete = Boolean.parseBoolean(row.get("complete"));

            requestBody = "{\n" +
                    "  \"id\": " + id + ",\n" +
                    "  \"petId\": " + petId + ",\n" +
                    "  \"quantity\": " + quantity + ",\n" +
                    "  \"shipDate\": \"" + shipDate + "\",\n" +
                    "  \"status\": \"" + status + "\",\n" +
                    "  \"complete\": " + complete + "\n" +
                    "}";


            // Enviamos la solicitud y guardamos la respuesta
            Response response = SerenityRest.given()
                    .baseUri(urlBase)
                    .contentType("application/json")
                    .relaxedHTTPSValidation()
                    .body(requestBody)
                    .log().all()
                    .post("/store/order");

        }
        System.out.println(rows);
    }

    public void validarCode(int statusCode) {
        Response response = SerenityRest.lastResponse(); // Serenity maneja automáticamente la respuesta

        System.out.println(response);
        if (response == null) {
            throw new IllegalStateException("No se encontró una respuesta en SerenityRest. Asegúrate de que la solicitud POST se ejecutó correctamente.");
        }

        response.then().statusCode(statusCode);
        System.out.println(response.statusCode());
    }

    public void validarBody(DataTable dataTable) {

        System.out.println("Hola");
    }

    public void consultaOrder(int id){
        String urlBase = "https://petstore.swagger.io/v2";
        System.out.println("Test");
        SerenityRest.given()
                .baseUri(urlBase)
                .relaxedHTTPSValidation()
                .get("/store/order/" + String.valueOf(id))
                .then()
                .statusCode(200);
    }


    public void validarCodigo(int statusCode) {
        Response response = SerenityRest.lastResponse(); // Serenity maneja automáticamente la respuesta

        System.out.println(response);
        if (response == null) {
            throw new IllegalStateException("No se encontró una respuesta en SerenityRest. Asegúrate de que la solicitud POST se ejecutó correctamente.");
        }

        response.then().statusCode(statusCode);
        System.out.println(response.statusCode());
    }

    public void validarCuerpo(DataTable dataTable) {
        System.out.println("Test");
    }
}


