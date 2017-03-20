package com.silab.dms.controllers.dto;

import com.silab.dms.model.Document;
import com.silab.dms.model.DocumentType;
import com.silab.dms.model.PrimitiveProcess;

public class ActivityInfo {

	private String activityName;
	private DocumentType inputDocument;
	private DocumentType outputDocument;
	private PrimitiveProcess process;
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public DocumentType getInputDocument() {
		return inputDocument;
	}
	public void setInputDocument(DocumentType inputDocument) {
		this.inputDocument = inputDocument;
	}
	public DocumentType getOutputDocument() {
		return outputDocument;
	}
	public void setOutputDocument(DocumentType outputDocument) {
		this.outputDocument = outputDocument;
	}
	public PrimitiveProcess getProcess() {
		return process;
	}
	public void setProcess(PrimitiveProcess process) {
		this.process = process;
	}
	
	
}
