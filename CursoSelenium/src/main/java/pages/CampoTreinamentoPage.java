package pages;

import core.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static core.DriverFactory.getDriver;


public class CampoTreinamentoPage extends BasePage {


    public void setNome(String nome) {
        dsl.escreveByid("elementosForm:nome", nome);
    }

    public String getAtributoNameByID() {
        return dsl.acharElementoByID("elementosForm:nome").getAttribute("value");
    }
    public void setSugestao(String sugestao) {
        dsl.escreveByid("elementosForm:sugestoes", sugestao);
    }
    public String getAtributoSugestaoByID() {
        return dsl.acharElementoByID("elementosForm:sugestoes").getAttribute("value");
    }
    public void clicarRadioButtonSexo(String indice_ratio){
        dsl.clicar("elementosForm:sexo:"+indice_ratio);

    }
    public boolean verificarSexoSelecionado(String indice_ratio){
        return dsl.verificarSelecionado("elementosForm:sexo:"+indice_ratio);
    }

    public void clicarComidaFavita(String indice_comida) {
        dsl.clicar("elementosForm:comidaFavorita:"+indice_comida);
    }

    public boolean verificarComidaFavorita(String indice_comida) {
        return dsl.verificarSelecionado("elementosForm:comidaFavorita:"+indice_comida);
    }

    public WebElement getEscolaridade() {
        return dsl.getElement("elementosForm:escolaridade");
    }

    public void selecionarComboEscolaridade(String escolaridade) {
        Select combo = new Select(getEscolaridade());
        dsl.selecionarCombo(combo,escolaridade);
    }
    public void selecionarComboEsportes(String esportes) {
        Select combo = new Select(getEsportes());
        dsl.selecionarCombo(combo,esportes);
    }

    private WebElement getEsportes() {
        return dsl.getElement("elementosForm:esportes");
    }

    public String verificarEscolaridade() {
        Select combo = new Select(getEscolaridade());
        return dsl.verficarPrimeiroCombo(combo);
    }

    public boolean encontrarElementoEscolariadade(String escolaridade) {
        WebElement element = getEscolaridade();
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(escolaridade)) {
                return true;
            }
        }
        return false;
    }
    public int verificarSelecionadosEsportes(){
        Select combo = new Select(getEsportes());
        List<WebElement> allop = combo.getAllSelectedOptions();
        return allop.size();
    }

    public void clicarBtn() {
        dsl.clicar("buttonSimple");
    }

    public String verificarBotaoSimples() {
        return dsl.verificarAtributo("buttonSimple");
    }

    public void clicarLink() {

        dsl.clicarByLink("Voltar");
    }

    public String getTextResultado() {
        return dsl.acharElementoByID("resultado").getText();
    }

    public String getTitle(){
        return dsl.getElementByTagName("body").getText();
    }

    public WebElement getCampoNome() {
        return dsl.getElement("elementosForm:nome");
    }

    public void clicarAlertButton() {
        dsl.clicar("alert");
    }

    public String vericarAlerta() {
        Alert alert = dsl.getAlert();
        return alert.getText();
    }

    public void aceitarAlert() {
        Alert alert = dsl.getAlert();
        alert.accept();
    }

    public void clicarPopUp() {
        dsl.clicar("buttonPopUpEasy");
    }
}
