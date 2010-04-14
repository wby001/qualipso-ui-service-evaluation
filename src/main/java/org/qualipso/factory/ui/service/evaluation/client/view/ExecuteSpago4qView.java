package org.qualipso.factory.ui.service.evaluation.client.view;

import org.qualipso.factory.ui.service.evaluation.client.presenter.EvaluationPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class ExecuteSpago4qView extends Composite {

	private static ExecuteSpago4qViewUiBinder uiBinder = GWT
			.create(ExecuteSpago4qViewUiBinder.class);

	interface ExecuteSpago4qViewUiBinder extends
			UiBinder<Widget, ExecuteSpago4qView> {
	}
	EvaluationPresenter presenter;
	@UiField
	Label chooseDocumentLabel;
	@UiField
	ListBox chooseDocumentListBox;
	@UiField
	Button goOnButton;
	@UiField
	FlowPanel resultPanel;

	public ExecuteSpago4qView(EvaluationPresenter presenter) {
		initWidget(uiBinder.createAndBindUi(this));
		this.presenter = presenter;
		initExecuteSpago4qView();
	}
	private void initExecuteSpago4qView() {
		chooseDocumentListBox.addItem("A5-GQM","A5-GQM");
		chooseDocumentListBox.addItem("OMM-Jupiter","OMM-Jupiter");
		
	}
	@UiHandler("goOnButton")
	public void onGoOnButtonClick(ClickEvent e){
		int index = chooseDocumentListBox.getSelectedIndex();
		switch(index){
		case 0:
			presenter.loadExecuteA5GQMView(null);
			break;
		case 1:
			presenter.loadExecuteOMMJupiterView(null);
			break;
		}

//		resultPanel.clear();
//		Frame frame= new Frame();
//		frame.setUrl("http://localhost:8080/SpagoBISDK/execution.jsp");
//		frame.setSize("1024px", "500px");
//		GWT.log("before add frame",null);
//		resultPanel.add(frame);
//		resultPanel.setHeight("500px");
	}


}
