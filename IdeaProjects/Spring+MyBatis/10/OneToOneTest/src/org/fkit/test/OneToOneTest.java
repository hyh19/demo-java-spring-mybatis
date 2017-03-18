package org.fkit.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.fkit.domain.Person;
import org.fkit.mapper.PersonMapper;

import java.io.InputStream;

public class OneToOneTest {

    public static void main(String[] args) throws Exception {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        Person person = personMapper.selectPersonById(1);
        System.out.println(person);
        System.out.println(person.getCard());

        session.commit();
        session.close();

    }

}
