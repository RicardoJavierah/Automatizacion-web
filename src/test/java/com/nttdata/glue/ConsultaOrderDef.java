package com.nttdata.glue;

import com.nttdata.steps.OrderStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class ConsultaOrderDef {

    @Steps
    OrderStep orderStep;
    @When("consulto la orden con el {int}")
    public void consultoLaOrdenConElIdId(int id) {
       orderStep.consultaOrder(id);
    }

    @Then("Valido el codigo de respuesta {int}")
    public void validarCodigo(int statusCode){
        orderStep.validarCodigo(statusCode);
    }

    @And("cuerpo de la respuesta debe contener los siguientes valores:")
    public void validarBody(DataTable dataTable){
        orderStep.validarCuerpo(dataTable);
    }


}
