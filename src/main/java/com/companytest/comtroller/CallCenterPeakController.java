package com.companytest.comtroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.companytest.intity.CallCenterPeakDetector;
import com.companytest.intity.CallRecord;

import java.util.List;

@RestController
public class CallCenterPeakController {
	
	@Autowired
	private CallCenterPeakDetector detector ;

    @GetMapping("/peak")
    public String findPeakConcurrentCalls() {
        String filename = "C:\\Users\\Dell\\Desktop\\Interview_Practical\\call_log.txt";
        
        List<CallRecord> callRecords = detector.readCallLogFromFile(filename);

        int peakCalls = detector.findPeakConcurrentCalls(callRecords);

        return "The peak for this call log is " + peakCalls + " simultaneous calls.";
    }
}
