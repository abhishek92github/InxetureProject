package com.companytest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.companytest.intity.CallCenterPeakDetector;
import com.companytest.intity.CallRecord;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CallCenterPeakProjectTest {
	
	@Autowired
	private CallCenterPeakDetector callCenterPeakDetector;

    @Test
    public void testFindPeakConcurrentCalls() {
        List<CallRecord> callRecords = new ArrayList<>();
        callRecords.add(new CallRecord(1385718405, 1385718491));
        callRecords.add(new CallRecord(1385718407, 1385718409));
        callRecords.add(new CallRecord(1385718408, 1385718452));
        callRecords.add(new CallRecord(1385718408, 1385718464));
        callRecords.add(new CallRecord(1385718413, 1385718452));

        int peakCalls = callCenterPeakDetector.findPeakConcurrentCalls(callRecords);
        assertEquals(5, peakCalls);
    }

}
