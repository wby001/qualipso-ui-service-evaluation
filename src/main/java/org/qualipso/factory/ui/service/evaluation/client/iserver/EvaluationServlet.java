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
package org.qualipso.factory.ui.service.evaluation.client.iserver;

import com.google.gwt.rpc.client.RpcService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Interface of the server part for the Git service.
 * 
 * @author Jerome Blanchard <jayblanc@gmail.com>
 * @date 29 january 2010
 */
@RemoteServiceRelativePath("evaluation")
public interface EvaluationServlet extends RpcService {
	
//	public void createGITRepository(String path, String name, String description) throws EvaluationServletException;
//	
//	public GitRepository readGITRepository(String path) throws EvaluationServletException;
//	
//	public void updateGITRepository(String path, String name, String description) throws EvaluationServletException;
//	
//	public void deleteGITRepository(String path) throws EvaluationServletException;
//	
//	public String[] listGITRepositoryBranches(String path) throws EvaluationServletException;
//	
//	public boolean checkIfPathIsFree(String path) throws EvaluationServletException;

}
