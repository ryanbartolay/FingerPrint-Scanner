package com.ryan.runtime;

import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPDataListener;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusListener;

public class Main {
	public static void main(String[] args) {
		DPFPCapture global = DPFPGlobal.getCaptureFactory().createCapture();
		
		global.addDataListener(new DPFPDataListener() {
			
			@Override
			public void dataAcquired(DPFPDataEvent data) {
				System.out.println(data.getSample());
			}
		});
		
		global.addReaderStatusListener(new DPFPReaderStatusListener() {
			
			@Override
			public void readerDisconnected(DPFPReaderStatusEvent status) {
				System.out.println("reader disconnected");
			}
			
			@Override
			public void readerConnected(DPFPReaderStatusEvent status) {
				System.out.println("reader connected");
				
			}
		});
		
		global.startCapture();
	}
}
