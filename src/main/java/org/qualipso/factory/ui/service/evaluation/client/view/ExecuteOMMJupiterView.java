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

public class ExecuteOMMJupiterView extends Composite {

	private static ExecuteDocumentViewUiBinder uiBinder = GWT
			.create(ExecuteDocumentViewUiBinder.class);

	interface ExecuteDocumentViewUiBinder extends
			UiBinder<Widget, ExecuteOMMJupiterView> {
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
	// @UiField
	// FlowPanel mainPanel;
	@UiField
	FlowPanel resultPanel;

	public ExecuteOMMJupiterView(EvaluationPresenter presenter) {
		initWidget(uiBinder.createAndBindUi(this));
		this.presenter = presenter;
		initExecuteOMMJupiterView();
	}

	private void initExecuteOMMJupiterView() {
		resourcesListBox.addItem("PRJ-1", "PRJ-1");
		regiserValuesListBox.addItem("False", "False");
		behaviourListBox.addItem("Display", "Display");
	}

	@UiHandler("executeButton")
	public void onExecuteButtonClick(ClickEvent e) {
		String url = getUrl();
		if (url == "") {
			Window.alert("Something is worng");
		} else {
			resultPanel.clear();
			Frame frame = (Frame) presenter.createFrame(url);
			resultPanel.add(frame);
		}
	}

	private String getUrl() {
		String url = "";
		String baseUrl = "http://localhost:8080/SpagoBI//servlet/AdapterHTTP?NEW_SESSION=true&ACTION_NAME=EXECUTE_DOCUMENT_ACTION&user_id=biuser";
		String tailUrl = "behaviour%3Ddisplay%26register_values%3Dfalse&ROLE=%2Fspagobi%2Fuser&TOOLBAR_VISIBLE=false&SLIDERS_VISIBLE=true";
		String Object_ID = "19";
		String ParKpiResources = "19";
		String ParKpiDate = dateTextBox.getText();
		if (!ParKpiDate.equals("")) {
			String month = dateTextBox.getText().substring(0, 2);
			String day = dateTextBox.getText().substring(3, 5);
			String year = dateTextBox.getText().substring(6);
			String behaviour = "Display";
			String register_values = "False";
			url = baseUrl + "&" + "Object_ID=" + Object_ID + "&"
					+ "PARAMETERS=ParKpiResources%3D" + ParKpiResources
					+ "%26ParKpiDate%3D" + month + "%2F" + day + "%2f" + year
					+ "%26" + tailUrl;
		}
		return url;
	}

}
