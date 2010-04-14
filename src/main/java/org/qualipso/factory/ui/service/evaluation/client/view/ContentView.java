package org.qualipso.factory.ui.service.evaluation.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class ContentView extends Composite {

	private static ContentViewUiBinder uiBinder = GWT
			.create(ContentViewUiBinder.class);

	interface ContentViewUiBinder extends UiBinder<Widget, ContentView> {
	}
@UiField
SimplePanel contentPanel;

protected Widget currentView = null;

public ContentView() {
    initWidget(uiBinder.createAndBindUi(this));
}

public void changeContentView(final Widget view) {
    assert view != null;
    
    if (currentView != null) {
        contentPanel.remove(currentView);
    }
    currentView = view;
    contentPanel.add(view);
}

}
