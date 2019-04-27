import br.com.gilmar.Avaliacao;
import br.com.gilmar.ValoresInvalidosException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AvaliacaoTeste {
    private Avaliacao avaliacao;

    @Before
    public void setup(){
        avaliacao = new Avaliacao();
    }

    /*
        //CT01
        public void testaQuantidadeParametrosMenorQuatro(){
            var resultado = avaliacao.avalia(46.0,6.0,5);
        }
    */

    //CT03
    @Test(expected = ValoresInvalidosException.class)
    public void testaNotaMenorZero() throws ValoresInvalidosException{
            avaliacao.avalia(-7.0, 6.0, 5.0,96.0);
    }

    //CT04
    @Test(expected = ValoresInvalidosException.class)
    public void testaNota1MaiorDez() throws ValoresInvalidosException{
        avaliacao.avalia(11.0, 6.0, 5.0,96.0);
    }

    //CT05
    @Test(expected = ValoresInvalidosException.class)
    public void testaSegundaNotaMenorZero() throws ValoresInvalidosException{
        avaliacao.avalia(8.0, -1.0, 5, 96);
    }

    //CT06
    @Test
    public void testaSegundaNotaMaiorDez(){
        try{
            String resultado = avaliacao.avalia(8.0, 11.0, 5.0, 96.0);
        }catch (Exception e){
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }

    //CT07
    @Test
    public void testaFaltaNegativa(){
        try{
            String resultado = avaliacao.avalia(8.0, 7.0, -3, 96);
        }catch (Exception e){
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }

    //CT08
    @Test
    public void testaFalta97(){
        try{
            String resultado = avaliacao.avalia(8.0, 7.0, 97, 96);
        }catch (Exception e){
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }

    //CT09
    @Test
    public void testaCargaHorariaNegativa(){
        try{
            String resultado = avaliacao.avalia(8.0, 7.0, 16, -1);
        }catch (Exception e){
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }

    //CT010
    @Test
    public void testaCargaHoraria97(){
        try{
            String resultado = avaliacao.avalia(8.0, 7.0, 16, 97);
        }catch (Exception e){
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }

    //CT011
    @Test
    public void testaReprovadoPorFalta(){
        try{
            String resultado = avaliacao.avalia(8.0, 7.0, 28, 96);
            Assert.assertTrue(resultado.equals("Reprovado por Falta."));
        }catch (Exception e){
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }

    //CT012
    @Test
    public void testaReprovacaoPorMedia() throws ValoresInvalidosException{
        try{
            String resultado = avaliacao.avalia(2.0, 3.0, 15, 96);
            Assert.assertTrue(resultado.equals("Reprovado por Média."));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //CT013
    @Test
    public void testaSegundaChamada() throws ValoresInvalidosException{
        try{
            String resultado = avaliacao.avalia(4.0, 5.0, 15, 96);
            Assert.assertTrue(resultado.equals("Prova Extra."));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //CT014
    @Test
    public void testaAprovado() throws ValoresInvalidosException{
        try{
            String resultado = avaliacao.avalia(7.0, 8.0, 15, 96);
            Assert.assertTrue(resultado.equals("Aprovado."));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
