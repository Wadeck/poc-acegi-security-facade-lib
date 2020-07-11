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

import java.io.Serializable;
import java.security.Principal;
/* Used by:
active-directory
alauda-devops-credentials-provider
amazon-ecr
artifactory
assembla-auth
atlassian-bitbucket-server-integration
authorize-project
aws-secrets-manager-credentials-provider
azure-ad
azure-keyvault
batch-task
bitbucket-oauth
block-same-builds
blueocean-jwt
blueocean-pipeline-api-impl
blueocean-pipeline-scm-api
blueocean-rest-impl
branch-api
build-failure-analyzer
cas-plugin
claim
cloudbees-folder
coding-webhook
compound-slaves
concurrent-login-plugin
copyartifact
createjobadvanced
credentials
crowd2
deployer-framework
distfork
docker-slaves
DotCi
favorite
gerrit-code-review
gerrit-trigger
git-server
github-oauth
gitlab-oauth
google-container-registry-auth
google-login
google-source-plugin
greenballs
hp-application-automation-tools-plugin
ibm-continuous-release
instant-messaging
jira-steps
job-fan-in
jobConfigHistory
jwt-support
kerberos-sso
keycloak
kubernetes
kubernetes-credentials-provider
ldap
m2release
matrix-auth
microdocs-integration
monitoring
NegotiateSSO
nodejs
oic-auth
openid
openshift-login
openstack-cloud
ownership
package-drone
parameterized-trigger
pipeline-input-step
pipeline-maven
project-inheritance
promoted-builds
pubsub-light
pwauth
remote-terminal-access
reverse-proxy-auth-plugin
saml
script-security
scriptler
shelve-project-plugin
skype-notifier
splunk-devops
sse-gateway
ssh-steps
ssh2easy
stashNotifier
statistics-gatherer
strict-crumb-issuer
sumologic-publisher
support-core
team-views
teamconcert-git
thinBackup
tuleap-oauth
typetalk
urbancode-velocity
url-auth-sso
view-job-filters
windows-azure-storage
workflow-api
workflow-cps
workflow-durable-task-step
workflow-job
workflow-multibranch
workflow-step-api
wso2id-oauth
wwpass-plugin
 */
/**
 * Represents an authentication request.
 *
 * <p>
 * An <code>Authentication</code> object is not considered authenticated until
 * it is processed by an {@link AuthenticationManager}.
 * </p>
 *
 * <p>
 * Stored in a request {@link org.acegisecurity.context.SecurityContext}.
 * </p>
 *
 * @author Ben Alex
 * @version $Id: Authentication.java 1784 2007-02-24 21:00:24Z luke_t $
 */
public interface Authentication extends Principal, Serializable {
    /**
     * Set by an <code>AuthenticationManager</code> to indicate the authorities that the principal has been
     * granted. Note that classes should not rely on this value as being valid unless it has been set by a trusted
     * <code>AuthenticationManager</code>.<p>Implementations should ensure that modifications to the returned
     * array do not affect the state of the Authentication object (e.g. by returning an array copy).</p>
     *
     * @return the authorities granted to the principal, or <code>null</code> if authentication has not been completed
     */
    GrantedAuthority[] getAuthorities();

    /**
     * The credentials that prove the principal is correct. This is usually a password, but could be anything
     * relevant to the <code>AuthenticationManager</code>. Callers are expected to populate the credentials.
     *
     * @return the credentials that prove the identity of the <code>Principal</code>
     */
    Object getCredentials();

    /**
     * Stores additional details about the authentication request. These might be an IP address, certificate
     * serial number etc.
     *
     * @return additional details about the authentication request, or <code>null</code> if not used
     */
    Object getDetails();

    /**
     * The identity of the principal being authenticated. This is usually a username. Callers are expected to
     * populate the principal.
     *
     * @return the <code>Principal</code> being authenticated
     */
    Object getPrincipal();

    /**
     * Used to indicate to <code>AbstractSecurityInterceptor</code> whether it should present the
     * authentication token to the <code>AuthenticationManager</code>. Typically an <code>AuthenticationManager</code>
     * (or, more often, one of its <code>AuthenticationProvider</code>s) will return an immutable authentication token
     * after successful authentication, in which case that token can safely return <code>true</code> to this method.
     * Returning <code>true</code> will improve performance, as calling the <code>AuthenticationManager</code> for
     * every request will no longer be necessary.<p>For security reasons, implementations of this interface
     * should be very careful about returning <code>true</code> to this method unless they are either immutable, or
     * have some way of ensuring the properties have not been changed since original creation.</p>
     *
     * @return true if the token has been authenticated and the <code>AbstractSecurityInterceptor</code> does not need
     *         to represent the token for re-authentication to the <code>AuthenticationManager</code>
     */
    boolean isAuthenticated();

    /**
     * See {@link #isAuthenticated()} for a full description.<p>Implementations should <b>always</b> allow this
     * method to be called with a <code>false</code> parameter, as this is used by various classes to specify the
     * authentication token should not be trusted. If an implementation wishes to reject an invocation with a
     * <code>true</code> parameter (which would indicate the authentication token is trusted - a potential security
     * risk) the implementation should throw an {@link IllegalArgumentException}.</p>
     *
     * @param isAuthenticated <code>true</code> if the token should be trusted (which may result in an exception) or
     *        <code>false</code> if the token should not be trusted
     *
     * @throws IllegalArgumentException if an attempt to make the authentication token trusted (by passing
     *         <code>true</code> as the argument) is rejected due to the implementation being immutable or
     *         implementing its own alternative approach to {@link #isAuthenticated()}
     */
    void setAuthenticated(boolean isAuthenticated)
            throws IllegalArgumentException;
}
