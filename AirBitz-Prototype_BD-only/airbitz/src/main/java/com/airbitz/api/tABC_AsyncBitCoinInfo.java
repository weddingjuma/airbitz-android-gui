/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.airbitz.api;

public class tABC_AsyncBitCoinInfo {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected tABC_AsyncBitCoinInfo(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(tABC_AsyncBitCoinInfo obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        coreJNI.delete_tABC_AsyncBitCoinInfo(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setPData(SWIGTYPE_p_void value) {
    coreJNI.tABC_AsyncBitCoinInfo_pData_set(swigCPtr, this, SWIGTYPE_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_void getPData() {
    long cPtr = coreJNI.tABC_AsyncBitCoinInfo_pData_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public void setEventType(tABC_AsyncEventType value) {
    coreJNI.tABC_AsyncBitCoinInfo_eventType_set(swigCPtr, this, value.swigValue());
  }

  public tABC_AsyncEventType getEventType() {
    return tABC_AsyncEventType.swigToEnum(coreJNI.tABC_AsyncBitCoinInfo_eventType_get(swigCPtr, this));
  }

  public void setSzTxID(String value) {
    coreJNI.tABC_AsyncBitCoinInfo_szTxID_set(swigCPtr, this, value);
  }

  public String getSzTxID() {
    return coreJNI.tABC_AsyncBitCoinInfo_szTxID_get(swigCPtr, this);
  }

  public void setSzDescription(String value) {
    coreJNI.tABC_AsyncBitCoinInfo_szDescription_set(swigCPtr, this, value);
  }

  public String getSzDescription() {
    return coreJNI.tABC_AsyncBitCoinInfo_szDescription_get(swigCPtr, this);
  }

  public tABC_AsyncBitCoinInfo() {
    this(coreJNI.new_tABC_AsyncBitCoinInfo(), true);
  }

}
