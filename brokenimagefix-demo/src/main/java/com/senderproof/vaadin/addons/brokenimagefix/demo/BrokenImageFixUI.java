/**
 * Licensed under the Apache License,Version2.0(the"License");you may not
 * use this file except in compliance with the License.You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,software
 * distributed under the License is distributed on an"AS IS"BASIS,WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND,either express or implied.See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.senderproof.vaadin.addons.brokenimagefix.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Image;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.senderproof.vaadin.addons.brokenimagefix.BrokenImageFix;

import javax.servlet.annotation.WebServlet;

/**
 * Demo-UI to show the functionality of the addon.
 *
 * @author Marcel Hartwig, senderproof GmbH
 * @version 0.0.1
 */
@Theme("demotheme")
@Widgetset("com.senderproof.vaadin.addons.brokenimagefix.demo.DemoWidgetSet")
public class BrokenImageFixUI extends UI {

    /**
     * VaadinServlet for the DemoUI.<br>
     *
     * @author Marcel Hartwig, senderproof GmbH
     * @version 0.0.1
     */
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = BrokenImageFixUI.class)
    public static class MyUIServlet extends VaadinServlet {

    }

    /**
     * Build the UI for the client.
     */
    @Override
    protected void init(VaadinRequest request) {

        // VerticalLayout, which holds two images. One of them is missing and will be replaced with a default image.
        final VerticalLayout rootLayout = new VerticalLayout();
        // explicitly adding the ID to the layout, so that the client side JavaScript can find the container.
        rootLayout.setId("container");
        rootLayout.setMargin(true);
        setContent(rootLayout);

        final VerticalLayout imageContainer1 = new VerticalLayout();
        imageContainer1.setWidth(150, Unit.PIXELS);

        final Image image = new Image();
        // This image doesn't exist
        image.setSource(new ExternalResource("https://vaadin.com/vaadin-theme/images/vaadin/vaadin-logo-missing.svg"));
        image.setWidth(150, Unit.PIXELS);
        image.setHeight(150, Unit.PIXELS);
        imageContainer1.addComponent(image);

        rootLayout.addComponent(imageContainer1);

        final VerticalLayout imageContainer2 = new VerticalLayout();
        imageContainer2.setWidth(150, Unit.PIXELS);
        final Image image2 = new Image();
        // This image is available and will be shown
        image2.setSource(new ExternalResource("https://vaadin.com/vaadin-theme/images/vaadin/vaadin-logo.svg"));
        image2.setWidth(150, Unit.PIXELS);
        image2.setHeight(150, Unit.PIXELS);
        imageContainer2.addComponent(image2);
        rootLayout.addComponent(imageContainer2);

        // extend the container
        new BrokenImageFix().extend(rootLayout);
    }
}
