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
package org.qualipso.factory.ui.service.evaluation.client.presenter;

import org.qualipso.factory.ui.service.evaluation.client.iserver.EvaluationServlet;
import org.qualipso.factory.ui.service.evaluation.client.iserver.EvaluationServletAsync;
import org.qualipso.factory.ui.service.evaluation.client.view.ConfigSpago4qExtractorView;
import org.qualipso.factory.ui.service.evaluation.client.view.ContentView;
import org.qualipso.factory.ui.service.evaluation.client.view.DisplayEvaluationView;
import org.qualipso.factory.ui.service.evaluation.client.view.ExecuteA5GQMView;
import org.qualipso.factory.ui.service.evaluation.client.view.ExecuteOMMJupiterView;
import org.qualipso.factory.ui.service.evaluation.client.view.ExecuteSpago4qView;
import org.qualipso.factory.ui.shared.OpenParts.client.OPBinder;
import org.qualipso.factory.ui.shared.OpenParts.client.OPParams;
import org.qualipso.factory.ui.shared.OpenParts.client.OPShell;
import org.qualipso.factory.ui.shared.OpenParts.client.annotations.OPMandatoryParams;
import org.qualipso.factory.ui.shared.OpenParts.client.annotations.OPServiceName;
import org.qualipso.factory.ui.shared.OpenParts.client.annotations.OPViewFactory;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.Widget;

@OPServiceName("evaluation")
public class EvaluationPresenter implements EntryPoint {

	public interface EvaluationBinder extends OPBinder<EvaluationPresenter> {
	}

	public final static EvaluationBinder binder = GWT
			.create(EvaluationBinder.class);

	private final EvaluationServletAsync evaluationServlet = GWT
			.create(EvaluationServlet.class);

	public DisplayEvaluationView displayView;
	protected ConfigSpago4qExtractorView configSpago4qExtractorView;
	protected ContentView contentView;
	protected ExecuteSpago4qView executeSpago4qView;
	protected ExecuteOMMJupiterView ommJupiterView;
	protected ExecuteA5GQMView executeA5GQMView;

	private String currentPath = "/";
	public boolean checkIfDone = false;
	public int projectIndex = 0;

	/**
	 * Entry point, method called when the module is loaded. Create the tree.
	 * 
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	@Override
	public void onModuleLoad() {
		GWT.log("Loaded Evaluation ok", null);
		binder.bindPart(this);
		GWT.log("after bindPart", null);
		contentView = new ContentView();
		binder.notifyLoadingCompleted();
		GWT.log("after notifyloadingcompleted", null);
	}

	@OPViewFactory(resourceName = "evaluation", actionName = OPShell.ACTION_DISPLAY)
	@OPMandatoryParams("path")
	public Widget loadDisplayEvaluationView(OPParams params) {
		GWT.log("into load displaly evaluation view", null);
		displayView = new DisplayEvaluationView(this);
		GWT.log("after new display evaluation view", null);
		// currentPath = params.getParamValue("path");
		contentView.changeContentView(displayView);
		// displayView.setPath(currentPath);
		return contentView;
	}

	@OPViewFactory(resourceName = "evaluation", actionName = OPShell.ACTION_CREATE)
	@OPMandatoryParams("path")
	public Widget loadConfigSpago4qExtractorView(OPParams params) {
		GWT.log("into load create GQM view", null);
		configSpago4qExtractorView = new ConfigSpago4qExtractorView(this);
		// currentPath = params.getParamValue("path");
		contentView.changeContentView(configSpago4qExtractorView);
		return contentView;
	}

	public Widget loadExecuteSpago4qView(OPParams params) {
		executeSpago4qView = new ExecuteSpago4qView(this);
		contentView.changeContentView(executeSpago4qView);
		return contentView;
	}

	public Widget loadExecuteOMMJupiterView(OPParams params) {
		ommJupiterView = new ExecuteOMMJupiterView(this);
		contentView.changeContentView(ommJupiterView);
		return contentView;
	}

	public Widget loadExecuteA5GQMView(OPParams params) {
		executeA5GQMView = new ExecuteA5GQMView(this);
		contentView.changeContentView(executeA5GQMView);
		return contentView;

	}

	public Widget createFrame(String url) {
		Frame frame = new Frame();
		frame.setUrl(url);
		GWT.log("set 100%",null);
		//frame.setSize("100%x", "100%");
		frame.setWidth("100%");
		frame.setHeight("500px");
		GWT.log("set 100%",null);
		return frame;
	}

}
