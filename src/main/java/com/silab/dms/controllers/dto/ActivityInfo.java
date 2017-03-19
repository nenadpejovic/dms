package com.silab.dms.controllers.dto;

import com.silab.dms.model.Document;
import com.silab.dms.model.PrimitiveProcess;

public class ActivityInfo {

	private String activityName;
	private Document inputDocument;
	private Document outputDocument;
	private PrimitiveProcess process;
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public Document getInputDocument() {
		return inputDocument;
	}
	public void setInputDocument(Document inputDocument) {
		this.inputDocument = inputDocument;
	}
	public Document getOutputDocument() {
		return outputDocument;
	}
	public void setOutputDocument(Document outputDocument) {
		this.outputDocument = outputDocument;
	}
	public PrimitiveProcess getProcess() {
		return process;
	}
	public void setProcess(PrimitiveProcess process) {
		this.process = process;
	}
	
	
}
