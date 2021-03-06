/*
 * Copyright 2014 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.gwt.site.demo.gsss.grid.examples;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.site.demo.gsss.grid.resources.GridResources;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class Examples implements IsWidget {
    @UiTemplate("Example1.ui.xml")
    interface Example1Binder extends UiBinder<Widget, Examples> {
    }

    @UiTemplate("Example2.ui.xml")
    interface Example2Binder extends UiBinder<Widget, Examples> {
    }

    private static Example1Binder example1Binder = GWT.create(Example1Binder.class);
    private static Example2Binder example2Binder = GWT.create(Example2Binder.class);

    private final Widget widget;

    @UiField
    GridResources resources;

    protected Examples(UiBinder<Widget, Examples> binder) {
        widget = binder.createAndBindUi(this);

        resources.style().ensureInjected();
        resources.grid().ensureInjected();
        resources.gridSettings().ensureInjected();
    }

    @Override
    public Widget asWidget() {
        return widget;
    }

    public static IsWidget createExample1() {
        return new Examples(example1Binder);
    }

    public static IsWidget createExample2() {
        return new Examples(example2Binder);
    }
}
