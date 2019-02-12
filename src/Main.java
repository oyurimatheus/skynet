import br.com.caelum.funcs.Sigmoide;
import br.com.caelum.rede.Rede;

public class Main {

    public static void main(String[] args) {

        Sigmoide sigmoide = new Sigmoide();

        var rede = new Rede(2, 2, 2, 3, sigmoide);

        double[] entradas = { 2.0, 3.5,  4.2, 9.9, 2.0 };

        var results = rede.pensa(entradas);

        
        for (double d : results) {
            System.out.println(d);
        }
    }
}
