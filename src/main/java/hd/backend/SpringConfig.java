package hd.backend;

import hd.backend.mapper.AddressMapper;
import hd.backend.mapper.BoardMapper;
import hd.backend.repository.*;
import hd.backend.service.*;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    @Autowired
    DataSource dataSource; //Jdbc + JdbcTemplate
    @Autowired
    EntityManager em; //JPA
    @Autowired
    SpringDataJpaOracleAddressRepository repository;  //SpringDataJpa 구현 객체
    @Autowired
    SpringDataJpaOracleBoardRepository Boardrepository;
    /*@Bean
    public AddressRepository addressRepository(){ //Jdbc + JdbcTemplate + JPA
        //return new JdbcOracleAddressRepository(dataSource);
        //return new JdbcTemplateOracleAddressRepository(dataSource);
        return new JpaOracleAddressRepository(em);
    }*/

    @Autowired AddressMapper mapper; //MyBatis
    @Bean
    public AddressService  addressService(){ //Jdbc + MyBatis + JPA
        //return new JdbcOracleAddressService(addressRepository());
        //return new MybatisAddressService(mapper);
        //return new JpaAddressService(addressRepository());
        return new SpringDataJpaAddressService(repository); //SpringDataJpa
    }
    @Autowired
    BoardMapper boardmapper;
    @Bean
    public BoardService  BoardService(){
        //return new JdbcTemplateOracleBoardRepository(dataSource);
        //return new JdbcOracleBoardService(boardRepository());
        //return new MybatisBoardService(boardmapper);
        return new SpringDataJpaBoardService(Boardrepository); //SpringDataJpa
    }
    @Bean
    public BoardRepository boardRepository(){ //Jdbc + JdbcTemplate + JPA
        //return new JdbcOracleBoardRepository(dataSource);
        //return new JdbcTemplateOracleBoardRepository(dataSource);
        return new JpaOracleBoardRepository(em);
    }
}
