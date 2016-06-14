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
package com.senderproof.vaadin.addons.brokenimagefix;

import com.vaadin.annotations.JavaScript;
import com.vaadin.server.AbstractJavaScriptExtension;
import com.vaadin.ui.AbstractLayout;

/**
 * Fix for broken images in browsers. If you use an {@link com.vaadin.ui.Image} with
 * an {@link com.vaadin.server.ExternalResource} in modern browsers and the image isn't available, a broken image is shown. Since there
 * is no built-in functionality to hide these images, there was the need to develop this feature.<br><br>
 * This JavaScript Extension checks the given container for missing images and hides those. Therefore a style class is added to the
 * surrounding container of the image. By default, the image itself is hidden and a background image is set to the surrounding
 * container. This way the user is able to tell that there is an image, which isn't ready. CSS can be customized.<br><br>
 * "is-broken" is the CSS class, which will be added to the surrounding containers of the missing images.<br><br>
 * The server side part has to extend the container, where the possibly missing images are located.<p>
 * <code>
 * VerticalLayout layout = new VerticalLayout();<br>
 * layout.setId("container");<br>
 * new BrokenImageFix().extend(layout, layout.getId());
 * </code></p>
 * This JavaScript Extension relies on jQuery (<a href="https://jquery.com/">https://jquery.com/</a>) and
 * imagesLoaded (<a href="http://imagesloaded.desandro.com/">http://imagesloaded.desandro.com/</a>).
 *
 * @author Marcel Hartwig, senderproof GmbH
 * @version 0.0.1
 */
@JavaScript({ "jquery_min.js", "broken-image-fix.js", "imagesloaded.js" })
public class BrokenImageFix extends AbstractJavaScriptExtension {

    /**
     * This method extends the layout and calls the client side JavaScript, so that the broken images wil be hidden.
     * @param layout layout layout to be extended
     */
    public void extend(final AbstractLayout layout) {
        super.extend(layout);
        this.fixBrokenImages(layout.getId());
    }

    /**
     * Calls the client side JavaScript in order to fix broken images.
     * @param layoutId ID of the container containing the possibly missing images.
     */
    private void fixBrokenImages(final String layoutId) {
        this.callFunction("fixBrokenImages", layoutId);
    }

}
