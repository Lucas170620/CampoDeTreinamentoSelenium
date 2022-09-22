package suites;

import core.DriverFactory;
import core.Propriedades;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
})
public class ProjectSuiteTeste extends DriverFactory {
    @BeforeClass
    public static void setUp(){
        Propriedades.TIPO_EXECUCAO = Propriedades.TipoExecucao.LOCAL;
    }

    @AfterClass
    public static void tierDown() {

        driver.close();

    }
}
