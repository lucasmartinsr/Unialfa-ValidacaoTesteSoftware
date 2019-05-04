package br.com.alfa.lucas.testes;

import br.com.alfa.lucas.InstanciaDriver;
import br.com.alfa.lucas.paginas.PaginaConsultaCep;
import br.com.alfa.lucas.paginas.PaginaResultadoConsulta;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ConsultaEnderecoPOTest {

    private WebDriver driver;
    private PaginaConsultaCep consultaCep;
    private PaginaResultadoConsulta resultado;

    @BeforeTest
    public void setup(){
        this.driver = InstanciaDriver.getDriver();
        driver.get("http://www.buscacep.correios.com.br/sistemas/buscacep/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        consultaCep = new PaginaConsultaCep(this.driver);
        resultado = new PaginaResultadoConsulta(this.driver);
    }

    @Test
    public void consultaPorCep(){
        consultaCep.informarCep("74393580");
        consultaCep.consulta();
        Assert.assertTrue(resultado.getGridResultadoConsulta().getText().contains("Rua SR 17"));
        driver.close();
    }
}
