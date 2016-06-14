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

/**
 * JavaScript class for extending the vaadin functionality. This way it is possible to fix broken images in browsers.
 * It is checked whether the images are present or not. If an image isn't available, a CSS class will be added to the
 * parent element of the image (an image in vaadin is always wrapped by a div container).
 */
window.com_senderproof_vaadin_addons_brokenimagefix_BrokenImageFix = function() {

    //noinspection JSUnusedGlobalSymbols
    /**
     * JavaScript methode, which is called through vaadin
     * @param options name of the container, which holds the possibly broken images.
     */
    this.fixBrokenImages = function(options) {
        // we are using the functionality of a JavaScript library (http://imagesloaded.desandro.com/), to check, whether the images are present or not.
        $('#' + options).imagesLoaded().progress(function(instance, image) {
            if (!image.isLoaded) {
                // Image couldn't be loaded, so we add the CSS class to the parent of the image
                var $item = $( image.img ).parent();
                $item.addClass("is-broken");
            }
        });
    };

};
