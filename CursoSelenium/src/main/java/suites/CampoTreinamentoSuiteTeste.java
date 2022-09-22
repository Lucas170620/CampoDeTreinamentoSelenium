package suites;

import core.DriverFactory;
import core.Propriedades;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.TestAlert;
import test.TesteCampoTreinamento;
import test.TesteJanela;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestAlert.class,
        TesteCampoTreinamento.class,
        TesteJanela.class
})
public class CampoTreinamentoSuiteTeste extends DriverFactory {
    @BeforeClass
    public static void setUp(){
        Propriedades.TIPO_EXECUCAO = Propriedades.TipoExecucao.LOCAL;
    }

    @AfterClass
    public static void tierDown() {

        driver.close();

    }

}

