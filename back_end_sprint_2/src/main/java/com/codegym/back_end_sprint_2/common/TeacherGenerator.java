package com.codegym.back_end_sprint_2.common;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.stream.Stream;

public class TeacherGenerator implements IdentifierGenerator {
    private String prefix = "GV-";
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        String query = "SELECT teacher_code FROM teacher ";
        Stream<String> ids = session.createSQLQuery(query).stream();
        Long max = ids.map(o -> o.replace(prefix, "")).mapToLong(Long::parseLong).max().orElse(0L);
        return prefix + (String.format("%06d", max + 1));
    }
}
