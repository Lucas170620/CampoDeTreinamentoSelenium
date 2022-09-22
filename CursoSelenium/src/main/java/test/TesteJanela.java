package test;

import core.BaseTest;
import core.DSL;
import org.junit.*;
import org.openqa.selenium.By;
import pages.CampoTreinamentoPage;

import static core.DriverFactory.getDriver;

public class TesteJanela extends BaseTest {
    private DSL dsl;
    private CampoTreinamentoPage page ;
    @Before
    public void inicializa(){
        getDriver().get("file:///"+System.getProperty("user.dir")+"/src/test/resources/componentes.html");
        dsl = new DSL();
        page = new CampoTreinamentoPage();
    }

    @Test
    public void widowHandlerTest(){
        page.clicarPopUp();
        getDriver().switchTo().window((String)getDriver().getWindowHandles().toArray()[1]);
        getDriver().findElement(By.tagName("textarea")).sendKeys("Deu certo?");
        getDriver().switchTo().window((String)getDriver().getWindowHandles().toArray()[0]);
        getDriver().findElement(By.tagName("textarea")).sendKeys("e agora?");
    }
}
