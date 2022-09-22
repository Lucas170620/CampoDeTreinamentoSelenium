package test;

import core.BaseTest;
import core.DSL;
import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import pages.CampoTreinamentoPage;

import static core.DriverFactory.getDriver;


public class TestAlert extends BaseTest {
    private CampoTreinamentoPage page ;
    DSL dsl ;
    @Before
    public void inicializa(){
        getDriver().get("file:///"+System.getProperty("user.dir")+"/src/test/resources/componentes.html");
        dsl = new DSL();
        page = new CampoTreinamentoPage();
    }


    @Test
    public void alertTest(){
        page.clicarAlertButton();

        Assert.assertEquals("Alert Simples",page.vericarAlerta());
        page.aceitarAlert();
    }

}
