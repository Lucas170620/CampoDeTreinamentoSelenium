package core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

import static core.DriverFactory.getDriver;

public class DSL {
    public void escreveByid(String id ,String message){
        getDriver().findElement(By.id(id)).sendKeys(message);
    }

    public WebElement acharElementoByID(String id) {
        return getDriver().findElement(By.id(id));
    }

    public void clicar(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public boolean verificarSelecionado(String id) {
        return getDriver().findElement(By.id(id)).isSelected();
    }

    public WebElement getElement(String id) {
        return getDriver().findElement(By.id(id));
    }

    public void selecionarCombo(Select combo, String escolaridade) {
        combo.selectByVisibleText(escolaridade);
    }

    public String verficarPrimeiroCombo(Select combo) {
        return combo.getFirstSelectedOption().getText();
    }

    public String verificarAtributo(String id) {
        return getDriver().findElement(By.id(id)).getAttribute("value");
    }

    public void clicarByLink(String link) {
        getDriver().findElement(By.linkText(link)).click();
    }

    public WebElement getElementByTagName(String tag) {
        return getDriver().findElement(By.tagName(tag));
    }

    public Alert getAlert() {
        return getDriver().switchTo().alert();
    }
}
