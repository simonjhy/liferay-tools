/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package manifest.first.hook.test;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;

/**
 * @author Raymond Augé
 */
public class StrutsPortletAction_One extends BaseStrutsPortletAction {

	@Override
	public void processAction(
			StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		System.out.println(this + " says: Hello World!");

		originalStrutsPortletAction.processAction(
			portletConfig, actionRequest, actionResponse);
	}

	@Override
	public String render(
			StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {

		System.out.println(toString() + " says: Hello World!");

		return originalStrutsPortletAction.render(
			portletConfig, renderRequest, renderResponse);
	}

	/**
	 * This is just part of the OSGi DS lifecycle. It's not part of the struts
	 * action feature.
	 */
	public void activate() {
		System.out.println(this + " activated!");
	}

	/**
	 * This is just part of the OSGi DS lifecycle. It's not part of the struts
	 * action feature.
	 */
	public void deactivate() {
		System.out.println(this + " deactivated!");
	}

}