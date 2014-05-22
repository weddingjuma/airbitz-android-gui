/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.airbitz.api;

public class core implements coreConstants {
  public static void setData(SWIGTYPE_p_void value) {
    coreJNI.data_set(SWIGTYPE_p_void.getCPtr(value));
  }

  public static SWIGTYPE_p_void getData() {
    long cPtr = coreJNI.data_get();
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public static void setActive(SWIGTYPE_p_f_int_p_void__void value) {
    coreJNI.active_set(SWIGTYPE_p_f_int_p_void__void.getCPtr(value));
  }

  public static SWIGTYPE_p_f_int_p_void__void getActive() {
    long cPtr = coreJNI.active_get();
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_int_p_void__void(cPtr, false);
  }

  public static void set(CallbackAsyncBitCoinInfo cb) {
    coreJNI.set(cb);
  }

  public static void dispatch(int val) {
    coreJNI.dispatch(val);
  }

  public static tABC_CC ABC_Initialize(String szRootDir, SWIGTYPE_p_f_p_q_const__struct_sABC_AsyncBitCoinInfo__void fAsyncBitCoinEventCallback, SWIGTYPE_p_void pData, String pSeedData, long seedLength, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_Initialize(szRootDir, SWIGTYPE_p_f_p_q_const__struct_sABC_AsyncBitCoinInfo__void.getCPtr(fAsyncBitCoinEventCallback), SWIGTYPE_p_void.getCPtr(pData), pSeedData, seedLength, tABC_Error.getCPtr(pError), pError));
  }

  public static void ABC_Terminate() {
    coreJNI.ABC_Terminate();
  }

  public static tABC_CC ABC_ClearKeyCache(tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_ClearKeyCache(tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_SignIn(String szUserName, String szPassword, SWIGTYPE_p_f_p_q_const__struct_sABC_RequestResults__void fRequestCallback, SWIGTYPE_p_void pData, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_SignIn(szUserName, szPassword, SWIGTYPE_p_f_p_q_const__struct_sABC_RequestResults__void.getCPtr(fRequestCallback), SWIGTYPE_p_void.getCPtr(pData), tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_CreateAccount(String szUserName, String szPassword, String szPIN, SWIGTYPE_p_f_p_q_const__struct_sABC_RequestResults__void fRequestCallback, SWIGTYPE_p_void pData, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_CreateAccount(szUserName, szPassword, szPIN, SWIGTYPE_p_f_p_q_const__struct_sABC_RequestResults__void.getCPtr(fRequestCallback), SWIGTYPE_p_void.getCPtr(pData), tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_SetAccountRecoveryQuestions(String szUserName, String szPassword, String szRecoveryQuestions, String szRecoveryAnswers, SWIGTYPE_p_f_p_q_const__struct_sABC_RequestResults__void fRequestCallback, SWIGTYPE_p_void pData, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_SetAccountRecoveryQuestions(szUserName, szPassword, szRecoveryQuestions, szRecoveryAnswers, SWIGTYPE_p_f_p_q_const__struct_sABC_RequestResults__void.getCPtr(fRequestCallback), SWIGTYPE_p_void.getCPtr(pData), tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_CreateWallet(String szUserName, String szPassword, String szWalletName, int currencyNum, long attributes, SWIGTYPE_p_f_p_q_const__struct_sABC_RequestResults__void fRequestCallback, SWIGTYPE_p_void pData, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_CreateWallet(szUserName, szPassword, szWalletName, currencyNum, attributes, SWIGTYPE_p_f_p_q_const__struct_sABC_RequestResults__void.getCPtr(fRequestCallback), SWIGTYPE_p_void.getCPtr(pData), tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_GetCurrencies(SWIGTYPE_p_p_sABC_Currency paCurrencyArray, SWIGTYPE_p_int pCount, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_GetCurrencies(SWIGTYPE_p_p_sABC_Currency.getCPtr(paCurrencyArray), SWIGTYPE_p_int.getCPtr(pCount), tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_GetPIN(String szUserName, String szPassword, SWIGTYPE_p_p_char pszPIN, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_GetPIN(szUserName, szPassword, SWIGTYPE_p_p_char.getCPtr(pszPIN), tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_SetPIN(String szUserName, String szPassword, String szPIN, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_SetPIN(szUserName, szPassword, szPIN, tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_GetCategories(String szUserName, SWIGTYPE_p_p_p_char paszCategories, SWIGTYPE_p_unsigned_int pCount, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_GetCategories(szUserName, SWIGTYPE_p_p_p_char.getCPtr(paszCategories), SWIGTYPE_p_unsigned_int.getCPtr(pCount), tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_AddCategory(String szUserName, String szCategory, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_AddCategory(szUserName, szCategory, tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_RemoveCategory(String szUserName, String szCategory, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_RemoveCategory(szUserName, szCategory, tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_RenameWallet(String szUserName, String szPassword, String szUUID, String szNewWalletName, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_RenameWallet(szUserName, szPassword, szUUID, szNewWalletName, tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_SetWalletAttributes(String szUserName, String szPassword, String szUUID, long attributes, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_SetWalletAttributes(szUserName, szPassword, szUUID, attributes, tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_CheckRecoveryAnswers(String szUserName, String szRecoveryAnswers, SWIGTYPE_p_bool pbValid, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_CheckRecoveryAnswers(szUserName, szRecoveryAnswers, SWIGTYPE_p_bool.getCPtr(pbValid), tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_GetWalletInfo(String szUserName, String szPassword, String szUUID, SWIGTYPE_p_p_sABC_WalletInfo ppWalletInfo, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_GetWalletInfo(szUserName, szPassword, szUUID, SWIGTYPE_p_p_sABC_WalletInfo.getCPtr(ppWalletInfo), tABC_Error.getCPtr(pError), pError));
  }

  public static void ABC_FreeWalletInfo(tABC_WalletInfo pWalletInfo) {
    coreJNI.ABC_FreeWalletInfo(tABC_WalletInfo.getCPtr(pWalletInfo), pWalletInfo);
  }

  public static tABC_CC ABC_GetWallets(String szUserName, String szPassword, SWIGTYPE_p_p_p_sABC_WalletInfo paWalletInfo, SWIGTYPE_p_unsigned_int pCount, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_GetWallets(szUserName, szPassword, SWIGTYPE_p_p_p_sABC_WalletInfo.getCPtr(paWalletInfo), SWIGTYPE_p_unsigned_int.getCPtr(pCount), tABC_Error.getCPtr(pError), pError));
  }

  public static void ABC_FreeWalletInfoArray(SWIGTYPE_p_p_sABC_WalletInfo aWalletInfo, long nCount) {
    coreJNI.ABC_FreeWalletInfoArray(SWIGTYPE_p_p_sABC_WalletInfo.getCPtr(aWalletInfo), nCount);
  }

  public static tABC_CC ABC_SetWalletOrder(String szUserName, String szPassword, SWIGTYPE_p_p_char aszUUIDArray, long countUUIDs, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_SetWalletOrder(szUserName, szPassword, SWIGTYPE_p_p_char.getCPtr(aszUUIDArray), countUUIDs, tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_GetQuestionChoices(String szUserName, SWIGTYPE_p_f_p_q_const__struct_sABC_RequestResults__void fRequestCallback, SWIGTYPE_p_void pData, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_GetQuestionChoices(szUserName, SWIGTYPE_p_f_p_q_const__struct_sABC_RequestResults__void.getCPtr(fRequestCallback), SWIGTYPE_p_void.getCPtr(pData), tABC_Error.getCPtr(pError), pError));
  }

  public static void ABC_FreeQuestionChoices(tABC_QuestionChoices pQuestionChoices) {
    coreJNI.ABC_FreeQuestionChoices(tABC_QuestionChoices.getCPtr(pQuestionChoices), pQuestionChoices);
  }

  public static tABC_CC ABC_GetRecoveryQuestions(String szUserName, SWIGTYPE_p_p_char pszQuestions, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_GetRecoveryQuestions(szUserName, SWIGTYPE_p_p_char.getCPtr(pszQuestions), tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_ChangePassword(String szUserName, String szPassword, String szNewPassword, String szNewPIN, SWIGTYPE_p_f_p_q_const__struct_sABC_RequestResults__void fRequestCallback, SWIGTYPE_p_void pData, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_ChangePassword(szUserName, szPassword, szNewPassword, szNewPIN, SWIGTYPE_p_f_p_q_const__struct_sABC_RequestResults__void.getCPtr(fRequestCallback), SWIGTYPE_p_void.getCPtr(pData), tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_ChangePasswordWithRecoveryAnswers(String szUserName, String szRecoveryAnswers, String szNewPassword, String szNewPIN, SWIGTYPE_p_f_p_q_const__struct_sABC_RequestResults__void fRequestCallback, SWIGTYPE_p_void pData, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_ChangePasswordWithRecoveryAnswers(szUserName, szRecoveryAnswers, szNewPassword, szNewPIN, SWIGTYPE_p_f_p_q_const__struct_sABC_RequestResults__void.getCPtr(fRequestCallback), SWIGTYPE_p_void.getCPtr(pData), tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_ParseBitcoinURI(String szURI, SWIGTYPE_p_p_sABC_BitcoinURIInfo ppInfo, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_ParseBitcoinURI(szURI, SWIGTYPE_p_p_sABC_BitcoinURIInfo.getCPtr(ppInfo), tABC_Error.getCPtr(pError), pError));
  }

  public static void ABC_FreeURIInfo(tABC_BitcoinURIInfo pInfo) {
    coreJNI.ABC_FreeURIInfo(tABC_BitcoinURIInfo.getCPtr(pInfo), pInfo);
  }

  public static double ABC_SatoshiToBitcoin(SWIGTYPE_p_int64_t satoshi) {
    return coreJNI.ABC_SatoshiToBitcoin(SWIGTYPE_p_int64_t.getCPtr(satoshi));
  }

  public static SWIGTYPE_p_int64_t ABC_BitcoinToSatoshi(double bitcoin) {
    return new SWIGTYPE_p_int64_t(coreJNI.ABC_BitcoinToSatoshi(bitcoin), true);
  }

  public static tABC_CC ABC_SatoshiToCurrency(SWIGTYPE_p_int64_t satoshi, SWIGTYPE_p_double pCurrency, int currencyNum, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_SatoshiToCurrency(SWIGTYPE_p_int64_t.getCPtr(satoshi), SWIGTYPE_p_double.getCPtr(pCurrency), currencyNum, tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_CurrencyToSatoshi(double currency, int currencyNum, SWIGTYPE_p_int64_t pSatoshi, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_CurrencyToSatoshi(currency, currencyNum, SWIGTYPE_p_int64_t.getCPtr(pSatoshi), tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_CreateReceiveRequest(String szUserName, String szPassword, String szWalletUUID, tABC_TxDetails pDetails, SWIGTYPE_p_p_char pszRequestID, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_CreateReceiveRequest(szUserName, szPassword, szWalletUUID, tABC_TxDetails.getCPtr(pDetails), pDetails, SWIGTYPE_p_p_char.getCPtr(pszRequestID), tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_ModifyReceiveRequest(String szUserName, String szPassword, String szWalletUUID, String szRequestID, tABC_TxDetails pDetails, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_ModifyReceiveRequest(szUserName, szPassword, szWalletUUID, szRequestID, tABC_TxDetails.getCPtr(pDetails), pDetails, tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_FinalizeReceiveRequest(String szUserName, String szPassword, String szWalletUUID, String szRequestID, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_FinalizeReceiveRequest(szUserName, szPassword, szWalletUUID, szRequestID, tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_CancelReceiveRequest(String szUserName, String szPassword, String szWalletUUID, String szRequestID, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_CancelReceiveRequest(szUserName, szPassword, szWalletUUID, szRequestID, tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_GenerateRequestQRCode(String szUserName, String szPassword, String szWalletUUID, String szRequestID, SWIGTYPE_p_p_unsigned_char paData, SWIGTYPE_p_unsigned_int pWidth, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_GenerateRequestQRCode(szUserName, szPassword, szWalletUUID, szRequestID, SWIGTYPE_p_p_unsigned_char.getCPtr(paData), SWIGTYPE_p_unsigned_int.getCPtr(pWidth), tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_InitiateSendRequest(String szUserName, String szPassword, String szWalletUUID, String szDestAddress, tABC_TxDetails pDetails, SWIGTYPE_p_f_p_q_const__struct_sABC_RequestResults__void fRequestCallback, SWIGTYPE_p_void pData, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_InitiateSendRequest(szUserName, szPassword, szWalletUUID, szDestAddress, tABC_TxDetails.getCPtr(pDetails), pDetails, SWIGTYPE_p_f_p_q_const__struct_sABC_RequestResults__void.getCPtr(fRequestCallback), SWIGTYPE_p_void.getCPtr(pData), tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_GetTransaction(String szUserName, String szPassword, String szWalletUUID, String szID, SWIGTYPE_p_p_sABC_TxInfo ppTransaction, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_GetTransaction(szUserName, szPassword, szWalletUUID, szID, SWIGTYPE_p_p_sABC_TxInfo.getCPtr(ppTransaction), tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_GetTransactions(String szUserName, String szPassword, String szWalletUUID, SWIGTYPE_p_p_p_sABC_TxInfo paTransactions, SWIGTYPE_p_unsigned_int pCount, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_GetTransactions(szUserName, szPassword, szWalletUUID, SWIGTYPE_p_p_p_sABC_TxInfo.getCPtr(paTransactions), SWIGTYPE_p_unsigned_int.getCPtr(pCount), tABC_Error.getCPtr(pError), pError));
  }

  public static void ABC_FreeTransaction(tABC_TxInfo pTransaction) {
    coreJNI.ABC_FreeTransaction(tABC_TxInfo.getCPtr(pTransaction), pTransaction);
  }

  public static void ABC_FreeTransactions(SWIGTYPE_p_p_sABC_TxInfo aTransactions, long count) {
    coreJNI.ABC_FreeTransactions(SWIGTYPE_p_p_sABC_TxInfo.getCPtr(aTransactions), count);
  }

  public static tABC_CC ABC_SetTransactionDetails(String szUserName, String szPassword, String szWalletUUID, String szID, tABC_TxDetails pDetails, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_SetTransactionDetails(szUserName, szPassword, szWalletUUID, szID, tABC_TxDetails.getCPtr(pDetails), pDetails, tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_GetTransactionDetails(String szUserName, String szPassword, String szWalletUUID, String szID, SWIGTYPE_p_p_sABC_TxDetails ppDetails, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_GetTransactionDetails(szUserName, szPassword, szWalletUUID, szID, SWIGTYPE_p_p_sABC_TxDetails.getCPtr(ppDetails), tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_GetRequestAddress(String szUserName, String szPassword, String szWalletUUID, String szRequestID, SWIGTYPE_p_p_char pszAddress, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_GetRequestAddress(szUserName, szPassword, szWalletUUID, szRequestID, SWIGTYPE_p_p_char.getCPtr(pszAddress), tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_GetPendingRequests(String szUserName, String szPassword, String szWalletUUID, SWIGTYPE_p_p_p_sABC_RequestInfo paRequests, SWIGTYPE_p_unsigned_int pCount, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_GetPendingRequests(szUserName, szPassword, szWalletUUID, SWIGTYPE_p_p_p_sABC_RequestInfo.getCPtr(paRequests), SWIGTYPE_p_unsigned_int.getCPtr(pCount), tABC_Error.getCPtr(pError), pError));
  }

  public static void ABC_FreeRequests(SWIGTYPE_p_p_sABC_RequestInfo aRequests, long count) {
    coreJNI.ABC_FreeRequests(SWIGTYPE_p_p_sABC_RequestInfo.getCPtr(aRequests), count);
  }

  public static tABC_CC ABC_DuplicateTxDetails(SWIGTYPE_p_p_sABC_TxDetails ppNewDetails, tABC_TxDetails pOldDetails, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_DuplicateTxDetails(SWIGTYPE_p_p_sABC_TxDetails.getCPtr(ppNewDetails), tABC_TxDetails.getCPtr(pOldDetails), pOldDetails, tABC_Error.getCPtr(pError), pError));
  }

  public static void ABC_FreeTxDetails(tABC_TxDetails pDetails) {
    coreJNI.ABC_FreeTxDetails(tABC_TxDetails.getCPtr(pDetails), pDetails);
  }

  public static tABC_CC ABC_CheckPassword(String szPassword, SWIGTYPE_p_double pSecondsToCrack, SWIGTYPE_p_p_p_sABC_PasswordRule paRules, SWIGTYPE_p_unsigned_int pCountRules, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_CheckPassword(szPassword, SWIGTYPE_p_double.getCPtr(pSecondsToCrack), SWIGTYPE_p_p_p_sABC_PasswordRule.getCPtr(paRules), SWIGTYPE_p_unsigned_int.getCPtr(pCountRules), tABC_Error.getCPtr(pError), pError));
  }

  public static void ABC_FreePasswordRuleArray(SWIGTYPE_p_p_sABC_PasswordRule aRules, long nCount) {
    coreJNI.ABC_FreePasswordRuleArray(SWIGTYPE_p_p_sABC_PasswordRule.getCPtr(aRules), nCount);
  }

  public static tABC_CC ABC_LoadAccountSettings(String szUserName, String szPassword, SWIGTYPE_p_p_sABC_AccountSettings ppSettings, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_LoadAccountSettings(szUserName, szPassword, SWIGTYPE_p_p_sABC_AccountSettings.getCPtr(ppSettings), tABC_Error.getCPtr(pError), pError));
  }

  public static tABC_CC ABC_UpdateAccountSettings(String szUserName, String szPassword, tABC_AccountSettings pSettings, tABC_Error pError) {
    return tABC_CC.swigToEnum(coreJNI.ABC_UpdateAccountSettings(szUserName, szPassword, tABC_AccountSettings.getCPtr(pSettings), pSettings, tABC_Error.getCPtr(pError), pError));
  }

  public static void ABC_FreeAccountSettings(tABC_AccountSettings pSettings) {
    coreJNI.ABC_FreeAccountSettings(tABC_AccountSettings.getCPtr(pSettings), pSettings);
  }

}
