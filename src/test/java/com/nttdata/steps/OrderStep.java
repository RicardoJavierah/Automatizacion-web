package com.nttdata.steps;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.rest.SerenityRest;

import java.util.List;
import java.util.Map;

public class OrderStep {

    public void creacionOrder(DataTable dataTable){

        String urlBase = "https://petstore.swagger.io/v2";
        //| <id>| <petId> | <quantity>  | <shipDate>| <status>  | <complete> |

        int id;
        int petId;
        int quantity;
        String shipDate;
        String status;
        Boolean complete;


        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row:rows) {
            id = Integer.parseInt(row.get("id"));
            petId = Integer.parseInt(row.get("petId"));
            quantity = Integer.parseInt(row.get("quantity"));
            shipDate = row.get("shipDate");
            status = row.get("status");
            complete = Boolean.valueOf(row.get("complete"));

            SerenityRest.given()
                    .baseUri(urlBase)
                    .contentType("application/json")
                    .relaxedHTTPSValidation()
                    .body("{\n" +
                            "  \"id\": \""+id+"\",\n" +
                            "  \"petId\": \""+petId+"\",\n" +
                            "  \"quantity\": \""+quantity+"\",\n" +
                            "  \"shipData\": \""+shipDate+"\",\n" +
                            "  \"status\": \""+status+"\",\n" +
                            "  \"complete\": \""+complete+"\",\n" +
                            "}")
                    .log().all()
                    .post("/store/order")
                    .then()
                    .statusCode(200)
                    .log().all();
        }



    }
}
