package com.crunchify.controller;

public class log {
	
	
	String uidWell;//="Well123" 
	String uidWellbore;//="2KKJH14"
	String uidLog;//="725KKJH14" 
	String uidSource;//="Server1"
	String nameWell;
	String nameWellbore;
	String nameLog;
	logHeader logHeader;
	logData logData;
	commonData commonData;
	@Override
	public String toString() {
		return "log [uidWell=" + uidWell + ", uidWellbore=" + uidWellbore
				+ ", uidLog=" + uidLog + ", uidSource=" + uidSource
				+ ", nameWell=" + nameWell + ", nameWellbore=" + nameWellbore
				+ ", nameLog=" + nameLog + ", logHeader=" + logHeader
				+ ", logData=" + logData + ", commonData=" + commonData + "]";
	} 

}
