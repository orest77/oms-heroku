package com.softserveinc.edu.oms.persistence.dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.softserveinc.edu.oms.domain.AbstractEntity;
import com.softserveinc.edu.oms.persistence.dao.params.SortProperties;

Map<String,String> jdbcUrlSettings = new HashMap<>();
String jdbcDbUrl = System.getenv("JDBC_DATABASE_URL");
if (null != jdbcDbUrl) {
  jdbcUrlSettings.put("hibernate.connection.url", System.getenv("JDBC_DATABASE_URL"));
}

registry = new StandardServiceRegistryBuilder().
    configure("hibernate.cfg.xml").
    applySettings(jdbcUrlSettings).
    build();