# BrokenImageFix for Vaadin

Fix for broken images in browsers. If you use an com.vaadin.ui.Image with an com.vaadin.server.ExternalResource in modern browsers and the image isn't available, a broken image is shown. Since there is no built-in functionality to hide these images, there was the need to develop this feature.

This JavaScript Extension checks the given container for missing images and hides those. Therefore a style class is added to the surrounding container of the image. By default, the image itself is hidden and a background image is set to the surrounding container. This way the user is able to tell that there is an image, which isn't ready. CSS can be customized.

"is-broken" is the CSS class, which will be added to the surrounding containers of the missing images.

The server side part has to extend the container, where the possibly missing images are located.

## Use the renderer

Add this dependency to your pom

    <dependency>
        <groupId>com.senderproof.vaadin</groupId>
        <artifactId>broken-image-fix</artifactId>
        <version>ENTER VERSION HERE</version>
    </dependency>

then recompile the widgetset.

# Code Example
```java
VerticalLayout layout = new VerticalLayout();
layout.setId("container");
Image image = new Image();
image.setSource(new ExternalResource("https://vaadin.com/vaadin-theme/images/vaadin/vaadin-logo-missing.svg"));
layout.addComponent(image);
new BrokenImageFix().extend(layout, layout.getId());
```

## Download release

Official releases of this add-on are available at Vaadin Directory. For Maven instructions, download and reviews, go to http://vaadin.com/addon/brokenimagefix

## Building and running demo

git clone https://github.com/mhartwig/brokenimagefix
mvn clean install
cd brokenimagefix-demo
mvn jetty:run

To see the demo, navigate to http://localhost:8080/

## Issue tracking

The issues for this add-on are tracked on its github.com page. All bug reports and feature requests are appreciated.

## License & Author

Add-on is distributed under Apache License 2.0. For license terms, see LICENSE.txt.
