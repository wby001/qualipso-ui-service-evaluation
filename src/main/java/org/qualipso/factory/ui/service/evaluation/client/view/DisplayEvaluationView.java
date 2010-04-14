/*
 * Qualipso Factory UI
 * Copyright (C) 2006-2010 INRIA
 * http://www.inria.fr
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation. See the GNU
 * Lesser General Public License in LGPL.txt for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 *
 * Initial authors :
 *
 *  Jérôme Blanchard / INRIA
 * Christophe Bouthier / INRIA
 * Pascal Molli / Nancy Université
 * Gérald Oster / Nancy Université
 */
package org.qualipso.factory.ui.service.evaluation.client.view;

import java.util.Date;

import org.qualipso.factory.ui.service.evaluation.client.presenter.EvaluationPresenter;
import org.qualipso.factory.ui.service.evaluation.client.resources.EvaluationResources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SourcesTableEvents;
import com.google.gwt.user.client.ui.TableListener;
import com.google.gwt.user.client.ui.Widget;

public class DisplayEvaluationView extends Composite {

	interface DisplayEvaluationViewUiBinder extends
			UiBinder<Widget, DisplayEvaluationView> {
	}

	private static DisplayEvaluationViewUiBinder uiBinder = GWT
			.create(DisplayEvaluationViewUiBinder.class);

	private EvaluationPresenter presenter;
	private String projectName = null;
	private String projectRelease = null;
	// private int rowSelected = 0;
	private int columnSelected = 0;
	@UiField
	EvaluationResources resources;
	@UiField
	FlowPanel flowPanel;
	@UiField
	Label projectLabel;
	@UiField
	FlexTable projectFlexTable;
	@UiField
	Hyperlink goToGQMHyperlink;
	@UiField
	Hyperlink goToOMMHyperlink;
	@UiField
	Hyperlink gqmReportHyperlink;
	@UiField
	Hyperlink configParasForSEHyperlink;

	public DisplayEvaluationView(EvaluationPresenter presenter) {
		GWT.log("into display evaluation view", null);
		initWidget(uiBinder.createAndBindUi(this));
		resources.style().ensureInjected();
		this.presenter = presenter;
		initEvaluationView();
	}

	public void setPath(String currentPath) {
		// TODO Auto-generated method stub
	}

	@SuppressWarnings("deprecation")
	public void initEvaluationView() {
		// String dataStr = "Sun Apr 11 14:17:08 CST 2010";
		GWT.log("set project list", null);
		projectFlexTable.setCellPadding(3);

		projectFlexTable.setText(0, 0, "Project_name");
		projectFlexTable.setText(0, 1, "Release");
		projectFlexTable.setText(0, 2, "URL");
		projectFlexTable.getRowFormatter().setStyleName(0,
				resources.style().flextabletitle());
		// projectFlexTable.setText(0, 3, "Last date of GQM evaluation");
		// projectFlexTable.setText(0, 4, "Last date of OMM evaluation");

		projectFlexTable.setText(1, 0, "Qualipso");
		projectFlexTable.setText(1, 1, "1.0");
		projectFlexTable.setText(1, 2, "http://www.qualipso.org");
		// projectFlexTable.setText(1, 3, dataStr);
		// projectFlexTable.setText(1, 4, dataStr);

		projectFlexTable.setText(2, 0, "Jboss");
		projectFlexTable.setText(2, 1, "5.1");
		projectFlexTable.setText(2, 2, "http://....");
		// projectFlexTable.setText(2, 3, dataStr);
		// projectFlexTable.setText(2, 4, dataStr);

		projectFlexTable.setText(3, 0, "Eclipse");
		projectFlexTable.setText(3, 1, "3.5");
		projectFlexTable.setText(3, 2, "http://....");
		// projectFlexTable.setText(3, 3, dataStr);
		// projectFlexTable.setText(3, 4, dataStr);

		// -----------------update the date of the evaluation in
		// flextable--------------
		// if (presenter.checkIfDone == true && presenter.projectIndex != 0) {
		// projectFlexTable.setText(presenter.projectIndex, 3, getDate());
		// presenter.checkIfDone = false;
		// presenter.projectIndex = 0;
		// }

		projectFlexTable.addTableListener(new TableListener() {
			@Override
			public void onCellClicked(final SourcesTableEvents arg0,
					final int arg1, final int arg2) {
				if (arg1 != 0) {
					System.out.println("getText is "
							+ projectFlexTable.getText(arg1, 0));
					projectName = projectFlexTable.getText(arg1, 0);
					// projectRelease = projectFlexTable.getText(arg1, 1);
					presenter.projectIndex = arg1;
					for (int i = 1; i < 4; i++) {
						projectFlexTable.getRowFormatter().removeStyleName(i,
								resources.style().flexrowactive());
					}
					projectFlexTable.getRowFormatter().setStyleName(arg1,
							resources.style().flexrowactive());
				} else {
					System.out.println("000");
				}
			}
		});

		configParasForSEHyperlink.addClickListener(new ClickListener() {
			public void onClick(Widget arg0) {
				presenter.loadConfigSpago4qExtractorView(null);
			}
		});
		goToGQMHyperlink.addClickListener(new ClickListener() {
			@Override
			public void onClick(Widget arg0) {
				presenter.loadExecuteSpago4qView(null);
			}
		});
		gqmReportHyperlink.addClickListener(new ClickListener() {
			@Override
			public void onClick(Widget arg0) {
				Window.open(GWT.getHostPageBaseURL() + "A5-GQM.pdf", "", "");
			}
		});
		goToOMMHyperlink.addClickListener(new ClickListener() {
			@Override
			public void onClick(Widget arg0) {
				// TODO Auto-generated method stub
				GWT.log("into omm");
				flowPanel.clear();
				Frame frame = new Frame();
				frame.setStyleName(resources.style().gwtframe());
				frame.setUrl("http://qualipso.case.unibz.it/omm/index.html");
				flowPanel.add(frame);
				flowPanel.setHeight("700px");
			}
		});
	}

	public String getDate() {
		Date date = new Date();
		String dateStr = date.toString();
		return dateStr;
	}

}
