package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.inclusao;

import br.com.gilmarioarantes.jdbccrudv1.model.Aluno;
import br.com.gilmarioarantes.jdbccrudv1.util.FormataData;
import br.com.gilmarioarantes.jdbccrudv1.util.GeraData;
import br.com.gilmarioarantes.jdbccrudv1.util.GeraListaAlunos;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class PersisteAlunoTeste {

    Logger logger = Logger.getLogger(PersisteAlunoTeste.class.getName());

    @Test
    public void persisteAlunoTest(){

        logger.info("Executando o método persisteAlunoTest() da classe: " + this.getClass().getSimpleName());

        List<Aluno> alunos = GeraListaAlunos.geraLista();

        boolean result = false;

        try{
            for(Aluno aluno : alunos){
                result = new PersisteAluno().persisteAluno(aluno);
            }
        }catch (Exception e){
            result = false;
            logger.error("Erro ao persistir o Aluno!", e);
        }
        Assert.assertTrue(result);
    }

    @Test
    public void persisteAlunoAlfaTest() throws Exception {
        boolean result = false;
        logger.info("Executando o método persisteAlunoAlfaTest() da classe: " + this.getClass().getSimpleName());
        try {
             result = new PersisteAluno().persisteAluno(new Aluno((long) 48, "201913496002",
                    "Lucas Martins", "Masculino", new FormataData().stringToTimeStamp("07/09/1995")));
        }catch (Exception e){
            result = false;
            logger.error("Erro ao persistir o Aluno Alfa!", e);
        }
        Assert.assertTrue(result);
    }
}
