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
package org.acegisecurity;

/* Used by:
authorize-project
blueocean-rest-impl
branch-api
build-failure-analyzer
build-pipeline-plugin
build-token-root
categorized-view
cloudbees-folder
credentials
depgraph-view
deployment-sphere
docker-slaves
docker-traceability
DotCi
dry-run
favorite-view
hp-application-automation-tools-plugin
ivy
jenkins-multijob-plugin
jobConfigHistory
jobtemplates
junit
mac
matrix-project
maven-plugin
metrics
next-build-number
node-sharing-orchestrator
ownership
parameterized-trigger
periodicbackup
pipeline-maven
pipeline-model-definition
pipeline-restful-api
plugin-util-api
project-inheritance
promoted-builds
pubsub-light
purge-job-history
reqtify
scm-sync-configuration
slave-squatter
svnmerge
usemango-runner
workflow-cps
workflow-durable-task-step
 */
/**
 * Thrown if an {@link Authentication} object does not hold a required authority.
 *
 * @author Ben Alex
 * @version $Id: AccessDeniedException.java 1496 2006-05-23 13:38:33Z benalex $
 */
public class AccessDeniedException extends AcegiSecurityException {
    //~ Constructors ===================================================================================================

    /**
     * Constructs an <code>AccessDeniedException</code> with the specified
     * message.
     *
     * @param msg the detail message
     */
    public AccessDeniedException(String msg) {
        super(msg);
    }

    /**
     * Constructs an <code>AccessDeniedException</code> with the specified
     * message and root cause.
     *
     * @param msg the detail message
     * @param t   root cause
     */
    public AccessDeniedException(String msg, Throwable t) {
        super(msg, t);
    }
}
