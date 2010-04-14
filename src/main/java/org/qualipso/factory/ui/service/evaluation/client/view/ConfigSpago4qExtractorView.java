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

public class ConfigSpago4qExtractorView extends Composite {

	private static CreateGQMViewUiBinder uiBinder = GWT.create(CreateGQMViewUiBinder.class);

	interface CreateGQMViewUiBinder extends UiBinder<Widget, ConfigSpago4qExtractorView> {
	}
	private EvaluationPresenter presenter;
	@UiField
	EvaluationResources resources;
	@UiField
	Label projectNameLabel;
	@UiField
	TextBox projectNameTextBox;
	@UiField
	Label projectVersionLabel;
	@UiField
	TextBox projectVersionTextBox;
	@UiField
	Label releaseLabel;
	@UiField
	TextBox releaseTextBox;
	@UiField
	Label revisionLabel;
	@UiField
	TextBox revisionTextBox;
	@UiField
	Label repositoryTypeLabel;
	@UiField
	ListBox repositoryTypeListBox;
	@UiField
	Label repositoryPathLabel;
	@UiField
	TextBox repositoryPathTextBox;
	@UiField
	Label repositoryUsernameLabel;
	@UiField
	TextBox repositoryUsernameTextBox;
	@UiField
	Label repositoryPasswordLabel;
	@UiField
	TextBox repositoryPasswordTextBox;
	@UiField
	Label analysisTimeframeBeginLabel;
	@UiField
	TextBox analysisTimeframeBeginTextBox;
	@UiField
	Label analysisTimeframeEndLabel;
	@UiField
	TextBox analysisTimeframeEndTextBox;
	@UiField
	Label minorReleasePatternLabel;
	@UiField
	TextBox minorReleasePatternTextBox;
	@UiField
	Label majorReleasePatternLabel;
	@UiField
	TextBox majorReleasePatternTextBox;
	@UiField
	Label cvsConnectionProtocolLabel;
	@UiField
	ListBox cvsConnectionProtocolListBox;
	@UiField
	Label buildTypeLabel;
	@UiField
	ListBox buildTypeListBox;
	@UiField
	Label testReportPathLabel;
	@UiField
	TextBox testReportPathTextBox;
	@UiField
	Label jupiterReviewPathLabel;
	@UiField
	TextBox jupiterReviewPathTextBox;
	@UiField
	Button submitButton;
	@UiField
	Button cancelButton;
	@UiField
	FlowPanel mainPanel;
	@UiField
	FlowPanel buttonPanel;
	@UiField
	FlowPanel gqmResultPanel;

	public ConfigSpago4qExtractorView(EvaluationPresenter presenter) {
		initWidget(uiBinder.createAndBindUi(this));
		initConfigSpago4qExtractorView();
		this.presenter = presenter;
		GWT.log("over create GQM view",null);
	}
	public void initConfigSpago4qExtractorView(){
		repositoryTypeListBox.addItem("cvs","CVS");
		repositoryTypeListBox.addItem("git","GIT");
		cvsConnectionProtocolListBox.addItem("pserver","pserver");
		cvsConnectionProtocolListBox.addItem("extssh","extssh");
		cvsConnectionProtocolListBox.addItem("pserverssh","pserverssh");
		buildTypeListBox.addItem("ant", "Ant");
		buildTypeListBox.addItem("maven", "Maven");
	}

	@UiHandler("submitButton")
	void onSubmitClick(ClickEvent e) {
		Window.alert("Hello! submit");
//		presenter.checkIfDone = true;
		//presenter.loadDisplayEvaluationView(null);
//		Frame frame= new Frame();
//		frame.setUrl("http://localhost:8080/SpagoBI//servlet/AdapterHTTP?NEW_SESSION=true&ACTION_NAME=EXECUTE_DOCUMENT_ACTION&user_id=biuser&OBJECT_ID=19&PARAMETERS=ParKpiResources%3D19%26ParKpiDate%3D05%2F02%2F2010%26behaviour%3Ddisplay%26register_values%3Dfalse&ROLE=%2Fspagobi%2Fuser&TOOLBAR_VISIBLE=false&SLIDERS_VISIBLE=true");
//		frame.setStyleName(resources.style().gwtframe());
//		frame.setHeight("500px");
//		mainPanel.clear();
//		buttonPanel.clear();
//		gqmResultPanel.add(frame);
		
	}
	@UiHandler("cancelButton")
	void onCancelClick(ClickEvent e){
		presenter.loadDisplayEvaluationView(null);
	}

}
