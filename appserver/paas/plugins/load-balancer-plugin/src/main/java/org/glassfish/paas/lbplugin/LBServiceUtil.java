/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2011 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package org.glassfish.paas.lbplugin;

import org.glassfish.hk2.scopes.Singleton;
import org.glassfish.paas.orchestrator.config.Services;
import org.glassfish.paas.orchestrator.provisioning.CloudRegistryEntry;
import org.glassfish.paas.orchestrator.provisioning.cli.ServiceType;
import org.glassfish.paas.orchestrator.provisioning.cli.ServiceUtil;
import org.jvnet.hk2.annotations.Inject;
import org.jvnet.hk2.annotations.Scoped;
import org.jvnet.hk2.annotations.Service;

@Service
@Scoped(Singleton.class)
public class LBServiceUtil {

    @Inject
    private ServiceUtil serviceUtil;

    public CloudRegistryEntry retrieveCloudEntry(String serviceName, String appName, ServiceType type) {
        return serviceUtil.retrieveCloudEntry(serviceName, appName, type);
    }

    public boolean isServiceAlreadyConfigured(String serviceName, String appName, ServiceType type) {
        return serviceUtil.isServiceAlreadyConfigured(serviceName, appName, type);
    }

    public boolean isValidService(String serviceName, String appName, ServiceType type) {
        return serviceUtil.isValidService(serviceName, appName, type);
    }

    public String getIPAddress(String serviceName, String appName, ServiceType type) {
        return serviceUtil.getIPAddress(serviceName, appName, type);
    }

    public void registerLBInfo(CloudRegistryEntry entry) {
        serviceUtil.registerCloudEntry(entry, null, "LOAD_BALANCER");
    }

/*
    public void closeDBObjects(Connection con, Statement stmt, ResultSet rs) {
        serviceUtil.closeDBObjects(con, stmt, rs);
    }
*/

    public void updateState(String serviceName, String appName, String state, ServiceType type) {
        serviceUtil.updateState(serviceName, appName, state, type);
    }

    public Services getServices(){
        return serviceUtil.getServices();
    }
}
