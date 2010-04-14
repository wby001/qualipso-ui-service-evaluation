package org.qualipso.factory.ui.service.evaluation.client.view;

import org.qualipso.factory.ui.service.evaluation.client.presenter.EvaluationPresenter;
import org.qualipso.factory.ui.service.evaluation.client.resources.EvaluationResources;

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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ExecuteA5GQMView extends Composite {

	private static ExecuteA5GQMViewUiBinder uiBinder = GWT
			.create(ExecuteA5GQMViewUiBinder.class);

	interface ExecuteA5GQMViewUiBinder extends
			UiBinder<Widget, ExecuteA5GQMView> {
	}
	private EvaluationPresenter presenter;
	public EvaluationResources resources;
	@UiField
	Label resourcesLabel;
	@UiField
	ListBox resourcesListBox;
	@UiField
	Label dateLabel;
	@UiField
	TextBox dateTextBox;
	@UiField
	Label regiserValuesLabel;
	@UiField
	ListBox regiserValuesListBox;
	@UiField
	Label behaviourLabel;
	@UiField
	ListBox behaviourListBox;
	@UiField
	Button executeButton;
	@UiField
	FlowPanel resultPanel;

	public ExecuteA5GQMView(EvaluationPresenter presenter) {
		initWidget(uiBinder.createAndBindUi(this));
		this.presenter = presenter;
		initExecuteA5GQMView();
	}

	private void initExecuteA5GQMView() {
		resourcesListBox.addItem("PMD", "PMD");
		regiserValuesListBox.addItem("False", "False");
		behaviourListBox.addItem("Display", "Display");
	}

	@UiHandler("executeButton")
	public void onExecuteButtonClick(ClickEvent e) {
		//String url = "http://localhost:8080/SpagoBISDK/execution.jsp";
		String url = "http://localhost:8080/SpagoBISDK/documentsList.jsp";
		if (url == "") {
			Window.alert("Something is worng");
		} else {
			resultPanel.clear();
			Frame frame = (Frame) presenter.createFrame(url);
			resultPanel.add(frame);
		}
	}

}
