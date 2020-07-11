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

import org.acegisecurity.Authentication;

import java.io.Serializable;

/* Used by:
assembla-auth
azure-ad
backup
bitbucket-oauth
blueocean-jwt
cas-plugin
coding-webhook
crowd2
DotCi
elasticbox
extended-choice-parameter
ghprb
gitbucket
github-oauth
gitlab-oauth
google-login
ibm-continuous-release
jclouds-jenkins
jwt-support
kerberos-sso
keycloak
NegotiateSSO
oic-auth
openid
openshift-login
periodicbackup
promoted-builds
reverse-proxy-auth-plugin
saml
subversion
teamconcert-git
thinBackup
tuleap-oauth
urbancode-velocity
url-auth-sso
wso2id-oauth
wwpass-plugin
xpdev
 */
/**
 * Interface defining the minimum security information associated with the
 * current thread of execution.
 *
 * <p>
 * The security context is stored in a {@link SecurityContextHolder}.
 * </p>
 *
 * @author Ben Alex
 * @version $Id: SecurityContext.java 1784 2007-02-24 21:00:24Z luke_t $
 */
public interface SecurityContext extends Serializable {
    /**
     * Obtains the currently authenticated principal, or an authentication request token.
     *
     * @return the <code>Authentication</code> or <code>null</code> if no authentication information is available
     */
    Authentication getAuthentication();

    /**
     * Changes the currently authenticated principal, or removes the authentication information.
     *
     * @param authentication the new <code>Authentication</code> token, or <code>null</code> if no further
     *                       authentication information should be stored
     */
    void setAuthentication(Authentication authentication);
}
