/**
 * Copyright (c) 2014, Airbitz Inc
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms are permitted provided that 
 * the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer. 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 3. Redistribution or use of modified source code requires the express written
 *    permission of Airbitz Inc.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * The views and conclusions contained in the software and documentation are those
 * of the authors and should not be interpreted as representing official policies, 
 * either expressed or implied, of the Airbitz Project.
 */

/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.airbitz.api;

public class tABC_ExchangeRateSources {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected tABC_ExchangeRateSources(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(tABC_ExchangeRateSources obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        coreJNI.delete_tABC_ExchangeRateSources(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setNumSources(long value) {
    coreJNI.tABC_ExchangeRateSources_numSources_set(swigCPtr, this, value);
  }

  public long getNumSources() {
    return coreJNI.tABC_ExchangeRateSources_numSources_get(swigCPtr, this);
  }

  public void setASources(SWIGTYPE_p_p_sABC_ExchangeRateSource value) {
    coreJNI.tABC_ExchangeRateSources_aSources_set(swigCPtr, this, SWIGTYPE_p_p_sABC_ExchangeRateSource.getCPtr(value));
  }

  public SWIGTYPE_p_p_sABC_ExchangeRateSource getASources() {
    long cPtr = coreJNI.tABC_ExchangeRateSources_aSources_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_sABC_ExchangeRateSource(cPtr, false);
  }

  public tABC_ExchangeRateSources() {
    this(coreJNI.new_tABC_ExchangeRateSources(), true);
  }

}
