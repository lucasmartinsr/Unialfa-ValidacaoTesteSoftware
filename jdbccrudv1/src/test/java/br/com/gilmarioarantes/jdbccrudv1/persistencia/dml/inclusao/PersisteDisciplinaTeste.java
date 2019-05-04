package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.inclusao;

import br.com.gilmarioarantes.jdbccrudv1.model.Curso;
import br.com.gilmarioarantes.jdbccrudv1.model.Disciplina;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.consulta.ConsultaCurso;
import br.com.gilmarioarantes.jdbccrudv1.util.GeraListaDisciplinas;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class PersisteDisciplinaTeste {

    Logger logger = Logger.getLogger(PersisteDisciplinaTeste.class.getName());

    @Test
    public void persisteDisciplinaTest(){

        logger.info("Executando o método persisteDisciplinaTest() da classe: " + this.getClass().getSimpleName());

        List<Disciplina> disciplinas = GeraListaDisciplinas.geraLista();

        boolean result = false;

        try{

            int quantidadeCursos = new ConsultaCurso().obtemQuantidadeCursos();

            for(Disciplina disciplina : disciplinas){
                int idCurso = new Random().nextInt(quantidadeCursos)+1;
                Curso curso = new ConsultaCurso().consultaPorId(new Long(idCurso));
                if(curso != null){
                    disciplina.setCurso(curso);
                    result = new PersisteDisciplina().persisteDisciplina(disciplina);
                }
            }
        }catch (Exception e){
            logger.error("Erro ao persistir a disciplina!", e);
        }
        Assert.assertTrue(result);
    }

    @Test
    public void persisteDisciplinaAlfaTest(){
        logger.info("Executando o método persisteDisciplinaAlfaTest() da classe: " + this.getClass().getSimpleName());

        boolean result = false;

        try{
            Disciplina disciplina =  new Disciplina((long)43, "Validação e Teste de Software", 64.0);
            Curso curso = new ConsultaCurso().consultaPorId(new Long(1));
            if(curso != null) {
                disciplina.setCurso(curso);
                result = new PersisteDisciplina().persisteDisciplina(disciplina);
            }
        }catch (Exception e){
                logger.error("Erro ao persistir a disciplina alfa!", e);
        }

        Assert.assertTrue(result);
    }
}
