package com.companytest.intity;

import org.springframework.stereotype.Component;

@Component
public class CallRecord {
    private int start;
    private int end;

    public CallRecord() {
     
    }
    public CallRecord(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

    
}
