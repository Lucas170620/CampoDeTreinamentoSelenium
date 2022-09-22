package test;

import core.BaseTest;
import core.DSL;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CampoTreinamentoPage;

import java.util.List;

import static core.DriverFactory.getDriver;

public class TesteCampoTreinamento extends BaseTest {
    private CampoTreinamentoPage page ;
    DSL dsl ;
    @Before
    public void inicializa(){
        getDriver().get("file:///"+System.getProperty("user.dir")+"/src/test/resources/componentes.html");
        dsl = new DSL();
        page = new CampoTreinamentoPage();
    }
    @Test
    public void testeTextField(){
        page.setNome("Teste de escrita");
        Assert.assertEquals("Teste de escrita",page.getAtributoNameByID());
    }
    @Test
    public void testeTextArea(){
        page.setSugestao("teste");

        Assert.assertEquals("teste",page.getAtributoSugestaoByID());
    }
    @Test
    public void radioButtonTest(){
        page.clicarRadioButtonSexo("0");
        Assert.assertEquals(true,page.verificarSexoSelecionado("0"));
    }
    @Test
    public void checkboxTest(){
        page.clicarComidaFavita("2");
        Assert.assertEquals(true,page.verificarComidaFavorita("2"));
    }

    @Test
    public void comboTest(){

        //combo.selectByIndex(2);
        //combo.selectByValue("superior");

        page.selecionarComboEscolaridade("2o grau completo");

        Assert.assertEquals("2o grau completo",page.verificarEscolaridade());
    }



    @Test
    public void comboDoisTest(){
        boolean encontrou = page.encontrarElementoEscolariadade("Mestrado");

        Assert.assertTrue(encontrou);
    }
    @Test
    public void comboMultiTest(){
        page.selecionarComboEsportes("Natacao");
        page.selecionarComboEsportes("Corrida");
        page.selecionarComboEsportes("O que eh esporte?");
        Assert.assertEquals(3,page.verificarSelecionadosEsportes());
    }
    @Test
    public void buttonTest(){
        page.clicarBtn();
        Assert.assertEquals("Obrigado!",page.verificarBotaoSimples());
    }
    @Test
    public void linkTest(){
        page.clicarLink();
        Assert.assertEquals("Voltou!",page.getTextResultado());
    }
    @Test
    public void verificarTituloTest(){
        String titulo = page.getTitle();
        Assert.assertTrue(titulo.contains("Campo de Treinamento"));
    }

    @Test
    public void testJavascript(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
        //js.executeScript("alert(`Testando js via selenium`)");
        js.executeScript("document.getElementById(`elementosForm:nome`).value = `Escrito via js`");
        //js.executeScript("document.getElementById(`elementosForm:nome`).type = radio");
        WebElement element = page.getCampoNome();
        js.executeScript("arguments[0].style.border = arguments[1]",element,"solid 4px red");
    }

}
