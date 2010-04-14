package org.qualipso.factory.ui.service.evaluation.server;

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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qualipso.factory.Factory;
import org.qualipso.factory.browser.BrowserService;
import org.qualipso.factory.ui.service.evaluation.client.iserver.EvaluationServlet;
import org.qualipso.factory.ui.service.evaluation.client.iserver.EvaluationServletException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.google.gwt.core.client.GWT;
import com.google.gwt.rpc.server.RpcServlet;

@SuppressWarnings("serial")
public class EvaluationServletImpl extends RpcServlet implements EvaluationServlet {
	
	private static Log logger = LogFactory.getLog(EvaluationServletImpl.class);
	//private GITService gitService;
	private BrowserService browserService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
		//	gitService = (GITService) Factory.findService(GITService.SERVICE_NAME);
			browserService = (BrowserService) Factory.findService(BrowserService.SERVICE_NAME);
		} catch (Exception e) {
			logger.error("unable to get services", e);
			throw new ServletException(e);
		}
	}
	
	/*
	@Override
	public void createGITRepository(String path, String name, String description) throws EvaluationServletException {
		logger.debug("createGITRepository called in the servlet...");
		try {
			gitService.createGITRepository(path, name, description);
		} catch (Exception e) {
			logger.debug("unable to create git repository", e);
			throw new EvaluationServletException(e);
		} 
	}

	@Override
	public GitRepository readGITRepository(String path) throws EvaluationServletException {
		logger.debug("readGITRepository called in the servlet...");
		try {
			GITRepository repository = gitService.readGITRepository(path);
			GitRepository lrepository = new GitRepository();
			lrepository.setName(repository.getName());
			lrepository.setDescription(repository.getDescription());
			return lrepository;
		} catch (Exception e) {
			logger.debug("unable to read git repository", e);
			throw new EvaluationServletException(e);
		}
	}

	@Override
	public void updateGITRepository(String path, String name, String description) throws EvaluationServletException {
		logger.debug("updateGITRepository called in the servlet...");
		try {
			gitService.updateGITRepository(path, name, description);
		} catch (Exception e) {
			logger.debug("unable to update git repository", e);
			throw new EvaluationServletException(e);
		}
	}

	@Override
	public void deleteGITRepository(String path) throws EvaluationServletException {
		logger.debug("deleteGITRepository called in the servlet...");
		try {
			gitService.deleteGITRepository(path);
		} catch (Exception e) {
			logger.debug("unable to delete git repository", e);
			throw new EvaluationServletException(e);
		}
	}

	@Override
	public String[] listGITRepositoryBranches(String path) throws EvaluationServletException {
		logger.debug("listGITRepositoryBranches called in the servlet...");
		try {
			String[] branches = gitService.listGITRepositoryBranches(path);
			return branches;
		} catch (Exception e) {
			logger.debug("unable to list git repository branches", e);
			throw new EvaluationServletException(e);
		}
	}

// TODO - CB - just so that it compiles
//	@Override
//	public String[][] browseGITRepository(String path, String branche, String folder) throws EvaluationServletException {
//		logger.debug("browseGITRepository called in the servlet...");
//		try {
//			String[][] content = gitService.browseGITRepository(path, branche, folder);
//			return content;
//		} catch (Exception e) {
//			logger.debug("unable to browse git repository", e);
//			throw new EvaluationServletException(e);
//		}
//	}
	
	@Override
	public boolean checkIfPathIsFree(String path) throws EvaluationServletException {
		logger.debug("checkIfPathIsFree called in the servlet...");
		try {
			boolean exists = browserService.exists(path);
			return !exists;
		} catch (Exception e) {
			logger.debug("unable to check if path is free", e);
			throw new EvaluationServletException(e);
		} 
	} */

} 
