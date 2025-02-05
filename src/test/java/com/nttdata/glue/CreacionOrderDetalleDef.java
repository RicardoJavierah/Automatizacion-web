package com.nttdata.glue;

import com.nttdata.steps.OrderStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.Date;
import java.util.List;

public class CreacionOrderDetalleDef {

    @Steps
    OrderStep orderStep;


    @When("el usuario crea una orden con los siguientes detalles:")
    public void elUsuarioCreaUnaOrdenConLosSiguientesDetalles(DataTable dataTable) {
         orderStep.creacionOrder(dataTable);
    }

    @Then("valido el codigo de respuesta sea {int}")
    public void ValidoCodigoRespuesta(int statusCode){
        orderStep.validarCode(statusCode);
    }


    @And("el cuerpo de la respuesta debe contener los siguientes valores:")
    public void ValidarBody(DataTable dataTable){
        orderStep.validarBody(dataTable);
    }
}
