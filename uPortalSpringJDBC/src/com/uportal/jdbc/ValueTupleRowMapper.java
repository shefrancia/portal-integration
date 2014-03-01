package com.uportal.jdbc;

import java.sql.ResultSet;  
import java.sql.SQLException;  

import org.springframework.jdbc.core.RowMapper;  

import com.uportal.domain.ValueTuple;  

public class ValueTupleRowMapper implements RowMapper<ValueTuple> {  
	  
	 @Override  
	 public ValueTuple mapRow(ResultSet resultSet, int line) throws SQLException {  
	  ValueTupleExtractor vtExtractor = new ValueTupleExtractor();  
	  return vtExtractor.extractData(resultSet);  
	 }  
	  
	}