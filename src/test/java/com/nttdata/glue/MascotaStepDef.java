package com.nttdata.glue;

import com.nttdata.steps.MascotaStep;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MascotaStepDef {

    @Steps
    MascotaStep mascotaStep;
    @When("consulto la tienda de mascotas con IDMASCOTA {int}")
    public void consultoLaTiendaDeMascotasConIDMASCOTA(int idMascota) {
        mascotaStep.consultaMascota(idMascota);
    }
}
