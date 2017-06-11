/*****************************************************************************
 * Copyright (c) 2013, theborakompanioni (http://www.example.org)
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
 ****************************************************************************/
package rbac.thymeleaf.shiro.processor.attribute;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.attr.AbstractConditionalVisibilityAttrProcessor;

import rbac.thymeleaf.shiro.dialect.ShiroFacade;

import static rbac.thymeleaf.shiro.processor.AttributeUtils.getRawValue;

public class HasRoleAttrProcessor extends AbstractConditionalVisibilityAttrProcessor {

    public static HasRoleAttrProcessor create() {
        return new HasRoleAttrProcessor();
    }

    private static final String ATTRIBUTE_NAME = "hasRole";
    private static final int PRECEDENCE = 300;

    protected HasRoleAttrProcessor() {
        super(ATTRIBUTE_NAME);
    }

    @Override
    public int getPrecedence() {
        return PRECEDENCE;
    }

    @Override
    public boolean isVisible(final Arguments arguments, final Element element, final String attributeName) {
        String role = getRawValue(element, attributeName);

        return ShiroFacade.hasRole(role);
    }
}