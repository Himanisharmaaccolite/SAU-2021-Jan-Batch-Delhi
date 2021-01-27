/**
 * CalculatorService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.himani;

public interface CalculatorService extends javax.xml.rpc.Service {
    public java.lang.String getCalculatorAddress();

    public com.himani.Calculator getCalculator() throws javax.xml.rpc.ServiceException;

    public com.himani.Calculator getCalculator(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
