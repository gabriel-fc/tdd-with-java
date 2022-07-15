package sis.studentinfo;

import java.util.*;
import com.jimbob.ach.*;

import static org.junit.Assert.assertTrue;

class MockAch implements Ach {
    public AchResponse issueDebit(
            AchCredentials credentials, AchTransactionData data) {
        assertTrue(
                data.account.equals(AccountTest.ACCOUNT_NUMBER));
        assertTrue(data.aba.equals(AccountTest.ABA));
        AchResponse response = new AchResponse();
        response.timestamp = new Date();
        response.traceCode = "1";
        response.status = AchStatus.SUCCESS;
        return response;
    }
    public AchResponse markTransactionAsNSF(AchCredentials credentials,
                                            AchTransactionData data,
                                            String traceCode) {
        return null;
    }
    public AchResponse refundTransaction(AchCredentials credentials,
                                         AchTransactionData data,
                                         String traceCode) {
        return null;
    }
    public AchResponse issueCredit(AchCredentials credentials,
                                   AchTransactionData data) {
        return null;
    }
    public AchResponse voidSameDayTransaction(
            AchCredentials credentials,
            AchTransactionData data,
            String traceCode) {
        return null;
    }
    public AchResponse queryTransactionStatus(AchCredentials credentials,
AchTransactionData data, String traceCode) {
        return null;
    }
}
