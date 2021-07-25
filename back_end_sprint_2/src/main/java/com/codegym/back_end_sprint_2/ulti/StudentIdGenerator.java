package com.codegym.back_end_sprint_2.ulti;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.stream.Stream;

public class StudentIdGenerator implements IdentifierGenerator {


    private String prefix = "SV";
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        String query = "SELECT code FROM student ";
        Stream<String> ids = session.createSQLQuery(query).stream();
        Long max = ids.map(o -> o.replace(prefix, "")).mapToLong(Long::parseLong).max().orElse(0L);
        return prefix + (String.format("%06d", max + 1));
    }
}
