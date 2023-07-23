package com.companytest.intity;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class CallCenterPeakDetector {

    public int findPeakConcurrentCalls(List<CallRecord> callRecords) {
        int maxConcurrentCalls = 0;

        for (int i = 0; i < callRecords.size(); i++) {
            int currentConcurrentCalls = 1;

            for (int j = i + 1; j < callRecords.size(); j++) {
                if (callRecords.get(j).getStart() <= callRecords.get(i).getEnd()) {
                    currentConcurrentCalls++;
                } else {
                    break;
                }
            }

            maxConcurrentCalls = Math.max(maxConcurrentCalls, currentConcurrentCalls);
        }

        return maxConcurrentCalls;
    }

    public List<CallRecord> readCallLogFromFile(String filename) {
        List<CallRecord> callRecords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] timestamps = line.split(":");
                int start = Integer.parseInt(timestamps[0]);
                int end = Integer.parseInt(timestamps[1]);
                callRecords.add(new CallRecord(start, end));
            }
        } catch (IOException e) {
            System.err.println("Error reading the call log file: " + e.getMessage());
        }
        return callRecords;
    }
}
