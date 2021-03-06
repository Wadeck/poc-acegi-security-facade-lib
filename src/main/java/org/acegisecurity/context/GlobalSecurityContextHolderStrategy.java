/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.acegisecurity.context;

import org.springframework.util.Assert;


/**
 * A <code>static</code> field-based implementation of {@link
 * org.acegisecurity.context.SecurityContextHolderStrategy}.<p>This means that all instances in the JVM share the
 * same <code>SecurityContext</code>. This is generally useful with rich clients, such as Swing.</p>
 *
 * @author Ben Alex
 * @version $Id: SecurityContextHolder.java 1324 2006-02-12 06:29:53Z benalex $
 */
public class GlobalSecurityContextHolderStrategy implements SecurityContextHolderStrategy {
    //~ Static fields/initializers =====================================================================================

    private static SecurityContext contextHolder;

    //~ Methods ========================================================================================================

    public void clearContext() {
        contextHolder = null;
    }

    public SecurityContext getContext() {
        if (contextHolder == null) {
            contextHolder = new SecurityContextImpl();
        }

        return contextHolder;
    }

    public void setContext(SecurityContext context) {
        Assert.notNull(context, "Only non-null SecurityContext instances are permitted");
        contextHolder = context;
    }
}
