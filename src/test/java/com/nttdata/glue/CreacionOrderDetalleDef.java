package com.nttdata.glue;

import com.nttdata.steps.OrderStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.Date;
import java.util.List;

public class CreacionOrderDetalleDef {

    @Steps
    OrderStep orderStep;


    @When("el usuario crea una orden con los siguientes detalles:")
    public void elUsuarioCreaUnaOrdenConLosSiguientesDetalles(DataTable dataTable) {
         orderStep.creacionOrder(dataTable);
    }
}
