package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class DriverFactory {
    public static WebDriver driver;

    public static WebDriver getDriver(Propriedades.Browsers browser){
        if (driver != null){
            driver.quit();
        }
        if(Propriedades.TIPO_EXECUCAO == Propriedades.TipoExecucao.LOCAL) {
            switch (browser) {
                case CHROME:
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Navegador Invalido");
            }
        }
        if(Propriedades.TIPO_EXECUCAO == Propriedades.TipoExecucao.NUVEM){
            DesiredCapabilities cap = null ;
            switch (browser) {
                case CHROME:
                    cap = DesiredCapabilities.chrome();
                    break;
                case FIREFOX:
                    cap = DesiredCapabilities.firefox();
                    break;
                default:
                    throw new IllegalArgumentException("Navegador Invalido");

            }
            try {
                driver = new RemoteWebDriver(new URL("https://oauth-lucascandidosantos2014-43f24:b1c868df-f165-46f4-a35e-244ddb37a760@ondemand.us-west-1.saucelabs.com:443/wd/hub"),cap);
            }
            catch (MalformedURLException e){
                System.err.println("Falha na conexão com o Saucelabs");
                e.printStackTrace();
            }
        }

        return driver;
    }
    public static WebDriver getDriver(){
        if(driver ==null){
            return getDriver(Propriedades.browser);
        }
        else {
            return driver;
        }
    }
}
