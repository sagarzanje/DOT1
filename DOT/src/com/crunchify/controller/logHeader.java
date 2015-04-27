package com.crunchify.controller;

import java.sql.Timestamp;
import java.util.List;

public class logHeader {
	
	String serviceCompany;
	String runNumber;
	Timestamp creationDate; //>2007-03-29T16:58:38.0000000+02:00</creationDate>
    String indexType;
    Timestamp startIndex; //2007-03-23T10:09:17.000+01:00</startIndex>
    Timestamp endIndex;//>2007-03-29T16:59:25.000+02:00</endIndex>
    String direction;//>Increasing</direction>
    String indexCurve;//>Time</indexCurve>
    int stepIncrement;  //>0</stepIncrement>
    String indexUnits;//>DateTime</indexUnits>
    double nullValue;///>-999.25</nullValue>
    String uomNamingSystem;// >RP66</uomNamingSystem>   
    List<logCurveInfo> logCurveInfo;

}
