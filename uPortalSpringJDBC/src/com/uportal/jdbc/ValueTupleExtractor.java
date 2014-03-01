package com.uportal.jdbc;

import java.sql.ResultSet;  
import java.sql.SQLException;  

import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.ResultSetExtractor;  

import com.uportal.domain.ValueTuple;

public class ValueTupleExtractor implements ResultSetExtractor<ValueTuple> {  
	  
	 public ValueTuple extractData(ResultSet resultSet) throws SQLException,  
	   DataAccessException {  
	    
	  ValueTuple vt = new ValueTuple();  
	  
	  vt.setValue(resultSet.getInt(1)); 
	  vt.setLabel(resultSet.getString(2));
	  try{
		  vt.setTelInfo(resultSet.getString("info"));
		  vt.setForeign(resultSet.getInt(3));
	  }catch(Exception e){
		  //do nothing
	  }
	    
	  return vt;  
	 }  
	  
	}  