package core;

public class Propriedades {
    public static boolean FECHAR_BROWSER = true;
    public static Browsers browser = Browsers.FIREFOX;
    public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.NUVEM;

    public enum Browsers {
        CHROME ,
        FIREFOX
    }
    public enum TipoExecucao{
        NUVEM,
        LOCAL
    }

}
