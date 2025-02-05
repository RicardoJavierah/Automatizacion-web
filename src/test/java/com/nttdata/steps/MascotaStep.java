package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;

public class MascotaStep {

    private String urlBase = "https://petstore.swagger.io/v2";
    public void consultaMascota(int idMascota) {
        System.out.println("Test");
        SerenityRest.given()
                .baseUri(urlBase)
                .relaxedHTTPSValidation()
                .get("/pet/" + String.valueOf(idMascota))
                .then()
                .statusCode(200);
    }
}
