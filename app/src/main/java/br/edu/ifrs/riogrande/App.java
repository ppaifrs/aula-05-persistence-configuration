package br.edu.ifrs.riogrande;

import java.time.LocalDate;

import javax.sql.DataSource;

import br.edu.ifrs.riogrande.config.ConfigurationManager;
import br.edu.ifrs.riogrande.entity.Aluno;
import br.edu.ifrs.riogrande.infra.TesteDataSource;
import br.edu.ifrs.riogrande.persistence.IAlunoRepository;
import br.edu.ifrs.riogrande.persistence.SqlAlunoRepository;

public class App {
    public static void main(String[] args) {
        System.out.println("Estou vivo!");
        
        ConfigurationManager configurationManager =
            new ConfigurationManager();
 
        DataSource dataSource = 
            new TesteDataSource(configurationManager);

        IAlunoRepository alunoRepository =
            new SqlAlunoRepository(dataSource);

        Aluno aluno = new Aluno();
        aluno.setMatricula("202492382");
        aluno.setSenha("1234");
        aluno.setEmail("alguem@aluno.rg.ifrs.edu.br");
        aluno.setDataIngresso(LocalDate.now());

        alunoRepository.save(aluno);

        /*
        ConfigurationManager configurationManager =
            new ConfigurationManager();

        configurationManager
            .get("database.connection.string")
            .ifPresent(System.out::println);

        int rowsPerPage = configurationManager
            .get("pagination.rows.per.page")
            .map(Integer::parseInt)
            .orElseThrow();

        int rowsPerPage2 = configurationManager
            .getInteger("pagination.rows.per.page")
            .orElseThrow();
        
        IAlunoRepository alunoRepository = null;
        */
    }
}
