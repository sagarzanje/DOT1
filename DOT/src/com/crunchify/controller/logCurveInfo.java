package com.crunchify.controller;

import java.sql.Timestamp;

public class logCurveInfo {

	String mnemonic;//>Time</mnemonic>
    String unit;//>DateTime</unit>
    double nullValue;//>-999.25</nullValue>
    String startIndex;//>2007-03-23T10:09:17.000+01:00</startIndex>
    String endIndex;//>2007-03-29T16:59:25.000+02:00</endIndex>
    String columnIndex;//>1</columnIndex>
    String curveDescription;//>Time</curveDescription>
    String typeLogData;//>DateTime</typeLogData>
    String mnemAlias;
    
	public String getMnemAlias() {
		return mnemAlias;
	}
	public void setMnemAlias(String mnemAlias) {
		this.mnemAlias = mnemAlias;
	}
	public String getMnemonic() {
		return mnemonic;
	}
	public void setMnemonic(String mnemonic) {
		this.mnemonic = mnemonic;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Override
	public String toString() {
		return "logCurveInfo [mnemonic=" + mnemonic + ", unit=" + unit
				+ ", nullValue=" + nullValue + ", startIndex=" + startIndex
				+ ", endIndex=" + endIndex + ", columnIndex=" + columnIndex
				+ ", curveDescription=" + curveDescription + ", typeLogData="
				+ typeLogData + ", mnemAlias=" + mnemAlias + "]";
	}
	public double getNullValue() {
		return nullValue;
	}
	public void setNullValue(double nullValue) {
		this.nullValue = nullValue;
	}
	
	public String getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(String startIndex) {
		this.startIndex = startIndex;
	}
	public String getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(String endIndex) {
		this.endIndex = endIndex;
	}
	
	public String getColumnIndex() {
		return columnIndex;
	}
	public void setColumnIndex(String columnIndex) {
		this.columnIndex = columnIndex;
	}
	public String getCurveDescription() {
		return curveDescription;
	}
	public void setCurveDescription(String curveDescription) {
		this.curveDescription = curveDescription;
	}
	public String getTypeLogData() {
		return typeLogData;
	}
	public void setTypeLogData(String typeLogData) {
		this.typeLogData = typeLogData;
	}
}
